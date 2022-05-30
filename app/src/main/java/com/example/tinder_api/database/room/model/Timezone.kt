package com.example.tinder_api.database.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Timezone(
    @PrimaryKey(autoGenerate = false)
    val description: String,
    val offset: String
)