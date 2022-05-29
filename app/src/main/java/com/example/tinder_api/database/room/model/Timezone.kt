package com.example.tinder_api.database.room.model

import androidx.room.Entity

@Entity
data class Timezone(
    val description: String,
    val offset: String
)