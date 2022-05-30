package com.example.tinder_api.database.room.typeConverter

import androidx.room.TypeConverter
import com.example.tinder_api.database.room.model.Result
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*


class ResultConverter {

    @TypeConverter // note this annotation
    fun fromOptionValuesList(optionValues: List<Result>?): String? {
        if (optionValues == null) {
            return null
        }
        val gson = Gson()
        val type = object :
            TypeToken<List<Result>?>() {}.type
        return gson.toJson(optionValues, type)
    }

    @TypeConverter // note this annotation
    fun toOptionValuesList(optionValuesString: String?): List<Result?>? {
        if (optionValuesString == null) {
            return null
        }
        val gson = Gson()
        val type = object :
            TypeToken<List<Result?>?>() {}.type
        return gson.fromJson(optionValuesString, type)
    }
}