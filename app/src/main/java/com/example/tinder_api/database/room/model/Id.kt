package com.example.tinder_api.database.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Id(
    @PrimaryKey(autoGenerate = false)
    val name: String,
    val value: String?
)