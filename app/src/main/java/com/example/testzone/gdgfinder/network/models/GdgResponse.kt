package com.example.testzone.gdgfinder.network.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GdgResponse(
    @Json(name = "filters_") val filters: Filter,
    @Json(name ="data") val chapters: List<GdgChapter>
) : Parcelable