package com.example.tinder_api.database.room.model

import androidx.room.*
import com.example.tinder_api.database.room.typeConverter.ResultConverter

@Entity(tableName = "Items")
data class Item constructor(
    @PrimaryKey(autoGenerate = false)
    @Embedded(prefix = "info_")
    val info: Info,

    @TypeConverters(ResultConverter::class)
    var results: List<Result>
)


