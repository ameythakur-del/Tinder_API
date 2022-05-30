package com.example.tinder_api.database.room.typeConverter

import androidx.room.TypeConverter
import com.example.tinder_api.database.room.model.Result
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*


class ResultConverter {
    @TypeConverter
    fun stringToListServer(data: String?): List<Result?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object :
            TypeToken<List<Result?>?>() {}.type
        return Gson().fromJson<List<Result?>>(data, listType)
    }

    @TypeConverter
    fun listServerToString(someObjects: List<Result?>?): String? {
        return Gson().toJson(someObjects)
    }
}