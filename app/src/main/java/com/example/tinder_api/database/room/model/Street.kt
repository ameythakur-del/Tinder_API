package com.example.tinder_api.database.room.model

import androidx.room.Entity

@Entity
data class Street(
    val name: String,
    val number: Int
)