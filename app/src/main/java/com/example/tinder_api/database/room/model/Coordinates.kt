package com.example.tinder_api.database.room.model

import androidx.room.Entity

@Entity
data class Coordinates(
    val latitude: String,
    val longitude: String
)