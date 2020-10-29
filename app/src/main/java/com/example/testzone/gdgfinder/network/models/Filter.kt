package com.example.testzone.gdgfinder.network.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Filter(
    @Json(name = "region") val regions: List<String>
) : Parcelable