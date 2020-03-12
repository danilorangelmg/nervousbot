package com.example.ktmovies.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Answers(
        var question: String = "",
        var answer: String = "") : Parcelable