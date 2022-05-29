package com.example.tinder_api.database.model

import androidx.room.Entity

@Entity
data class Timezone(
    val description: String,
    val offset: String
)