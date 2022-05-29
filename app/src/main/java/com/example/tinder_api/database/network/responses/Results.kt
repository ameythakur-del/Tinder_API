package com.example.tinder_api.database.network.responses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class Results(
    val gender: String,
    val name: Name,
    val location: Location,
    val email: String,
    val login: Login,
    val dob: Dob,
    val cell: String,
    val id: Id,
    val nat: String,
    val phone: String,
    val picture: Picture,
    val registered: Registered
)