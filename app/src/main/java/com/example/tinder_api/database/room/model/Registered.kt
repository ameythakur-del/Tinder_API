package com.example.tinder_api.database.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Registered(
    @PrimaryKey(autoGenerate = false)

    val age: Int,
    val date: String
)