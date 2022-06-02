package com.example.tinder_api.database.room.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Location(
    @PrimaryKey(autoGenerate = false)
    val city: String,

    @Embedded
    val coordinates: Coordinates,
    val country: String,
    val postcode: String,
    val state: String,

    @Embedded(prefix = "Street_")
    val street: Street,

    @Embedded
    val timezone: Timezone
)