package com.androidstudy.movies.data.remote

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(
    val name: String,
    val url: String
) :Parcelable