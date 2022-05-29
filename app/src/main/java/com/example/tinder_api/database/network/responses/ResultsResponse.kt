package com.example.tinder_api.database.network.responses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class ResultsResponse(
    val results: List<Results>,
    val info: Info
)