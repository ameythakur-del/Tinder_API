package com.example.tinder_api.database.room.model

import androidx.room.Entity

@Entity
data class Registered(
    val age: Int,
    val date: String
)