package com.example.tinder_api.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.tinder_api.database.room.dao.ResultDao
import com.example.tinder_api.database.room.model.*
import com.example.tinder_api.database.room.typeConverter.ResultConverter

@Database(entities = [
    Coordinates::class, Dob::class, Id::class, Info::class, Location::class,
    Login::class, Name::class, Picture::class, Registered::class, Result::class, Street::class, Timezone::class,], version = 3, exportSchema = false)

@TypeConverters(ResultConverter::class)

    abstract class ItemsDatabase : RoomDatabase() {
    abstract val resultDao: ResultDao

    companion object {

        private lateinit var INSTANCE: ItemsDatabase

        fun getDatabase(context: Context): ItemsDatabase {
            synchronized(ItemsDatabase::class.java) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ItemsDatabase::class.java,
                        "items").allowMainThreadQueries().fallbackToDestructiveMigration().build()
                }
            }
            return INSTANCE
        }
    }
}