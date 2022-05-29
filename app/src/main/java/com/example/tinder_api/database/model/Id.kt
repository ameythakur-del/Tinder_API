package com.example.tinder_api.database.model

import androidx.room.Entity

@Entity
data class Id(
    val name: String,
    val value: String
)