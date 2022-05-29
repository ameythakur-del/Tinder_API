package com.example.tinder_api.database.model

import androidx.room.Entity

@Entity
data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)