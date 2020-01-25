package com.segal.movieslist.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

data class MovieModel(
    val name: String,
    @DrawableRes val imageRes: Int,
    val overview: String?,
    val youtubeId: String,
    val releaseDate: String
) : Serializable