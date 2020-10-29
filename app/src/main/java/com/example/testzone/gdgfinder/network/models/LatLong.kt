package com.example.testzone.gdgfinder.network.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LatLong(
    val lat: Double,
    @Json(name = "lng") val long: Double
) : Parcelable