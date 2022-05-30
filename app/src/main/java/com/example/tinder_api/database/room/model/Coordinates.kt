package com.example.tinder_api.database.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Coordinates(
    @PrimaryKey(autoGenerate = false)
    val latitude: String,
    val longitude: String
)