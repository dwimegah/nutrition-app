package com.belajar.submissionbeginnerandroid

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(
    val name: String,
    val description: String,
    val photo: String,
    val category: String,
    val nutrition: String
) : Parcelable