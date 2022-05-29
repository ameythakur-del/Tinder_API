package com.example.tinder_api.database.room.model

import androidx.room.Embedded
import androidx.room.Entity

@Entity
data class Location(
    val city: String,

    @Embedded
    val coordinates: Coordinates,
    val country: String,
    val postcode: Any,
    val state: String,

    @Embedded
    val street: Street,
    val timezone: Timezone
)