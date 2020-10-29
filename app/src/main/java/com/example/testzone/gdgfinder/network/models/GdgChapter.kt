package com.example.testzone.gdgfinder.network.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GdgChapter(
    @Json(name = "chapter_name") val name: String,
    @Json(name = "cityarea") val city: String,
    val country: String,
    val region: String,
    val website: String,
    val geo: LatLong
) : Parcelable

//"chapter_name": "GDG Bordj Bou-Arréridj",
//"cityarea": "Burj Bu Arririj",
//"country": "Algeria",
//"region": "Africa",
//"website": "https://www.meetup.com/GDG-BBA",
//"geo": {
//    "lat": 36.06000137,
//    "lng": 4.630000114
//}