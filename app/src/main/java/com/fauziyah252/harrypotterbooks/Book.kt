package com.fauziyah252.harrypotterapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
    val number: Int,
    val title: String?,
    val originalTitle: String?,
    val releaseDate: String?,
    val description: String?,
    val pages: Int,
    val cover: String?,
    val index: Int
) : Parcelable