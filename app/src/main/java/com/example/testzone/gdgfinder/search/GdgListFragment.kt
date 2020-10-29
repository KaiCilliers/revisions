package com.example.testzone.gdgfinder.search

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.testzone.databinding.FragmentGdgListBinding
import com.example.testzone.gdgfinder.search.list.GdgClickListener
import com.example.testzone.gdgfinder.search.list.GdgListAdapter
import com.example.testzone.snackbar
import com.example.testzone.subscribe
import com.google.android.gms.location.*

private const val LOCATION_PERMISSION_REQUEST = 1

private const val LOCATION_PERMISSION = "android.permission.ACCESS_FINE_LOCATION"

class GdgListFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProviders.of(this).get(GdgListViewModel::class.java)
    }
    private val adapter by lazy {
        GdgListAdapter(GdgClickListener {
            val destination = Uri.parse(it.website)
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    destination
                )
            )
        })
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGdgListBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.rcGdgChapterList.adapter = adapter

        viewModel.showNeedLocation.subscribe(viewLifecycleOwner) {
            if(it) {
                snackbar(
                    "No location. Enable location in settings (hint: test with Maps) then check app permissions!",
                    binding.root
                )
            }
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestLastLocationOrStartLocationUpdates()
    }

    /**
     * Show the user a dialog asking for permission to use location.
     */
    private fun requestLocationPermission() {
        requestPermissions(arrayOf(LOCATION_PERMISSION), LOCATION_PERMISSION_REQUEST)
    }

    /**
     * Request the last location of this device, if known, otherwise start location updates.
     *
     * The last location is cached from the last application to request location.
     */
    private fun requestLastLocationOrStartLocationUpdates() {
        // if we don't have permission ask for it and wait until the user grants it
        if (ContextCompat.checkSelfPermission(requireContext(), LOCATION_PERMISSION) != PackageManager.PERMISSION_GRANTED) {
            requestLocationPermission()
            return
        }

        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())

        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            if (location == null) {
                startLocationUpdates(fusedLocationClient)
            } else {
                viewModel.onLocationUpdated(location)
            }
        }
    }

    /**
     * Start location updates, this will ask the operating system to figure out the devices location.
     */
    private fun startLocationUpdates(fusedLocationClient: FusedLocationProviderClient) {
        // if we don't have permission ask for it and wait until the user grants it
        if (ContextCompat.checkSelfPermission(requireContext(), LOCATION_PERMISSION) != PackageManager.PERMISSION_GRANTED) {
            requestLocationPermission()
            return
        }


        val request = LocationRequest().setPriority(LocationRequest.PRIORITY_LOW_POWER)
        val callback = object: LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                val location = locationResult?.lastLocation ?: return
                viewModel.onLocationUpdated(location)
            }
        }
        fusedLocationClient.requestLocationUpdates(request, callback, null)
    }

    /**
     * This will be called by Android when the user responds to the permission request.
     *
     * If granted, continue with the operation that the user gave us permission to do.
     */
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            LOCATION_PERMISSION_REQUEST -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    requestLastLocationOrStartLocationUpdates()
                }
            }
        }
    }
}