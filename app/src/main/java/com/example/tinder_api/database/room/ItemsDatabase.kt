package com.example.tinder_api.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tinder_api.database.room.dao.ResultDao
import com.example.tinder_api.database.room.model.*

@Database(entities = [
    Coordinates::class, Dob::class, Id::class, Info::class, Location::class,
    Login::class, Name::class, Picture::class, Registered::class, com.example.tinder_api.database.room.model.Result::class, Street::class, Timezone::class,], version = 1, exportSchema = false)

abstract class ItemsDatabase : RoomDatabase() {

    abstract val resultDao: ResultDao

    companion object {

        private lateinit var INSTANCE: ItemsDatabase

        fun getDatabase(context: Context): ItemsDatabase {
            synchronized(ItemsDatabase::class.java) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ItemsDatabase::class.java,
                        "videos").build()
                }
            }
            return INSTANCE
        }
    }
}