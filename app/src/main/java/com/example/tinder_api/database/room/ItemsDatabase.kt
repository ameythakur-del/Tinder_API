package com.example.tinder_api.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tinder_api.database.room.dao.ResultDao
import com.example.tinder_api.database.room.model.*

@Database(entities = [
    Coordinates::class, Dob::class, Id::class, Info::class, Item::class, Location::class,
    Login::class, Name::class, Picture::class, Registered::class, com.example.tinder_api.database.room.model.Result::class, Street::class, Timezone::class,], version = 1, exportSchema = false)

abstract class ItemsDatabase : RoomDatabase() {

    abstract val resultDao: ResultDao

    companion object {

        @Volatile
        private var INSTANCE: ItemsDatabase? = null

        fun getInstance(context: Context): ItemsDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ItemsDatabase::class.java,
                        "items_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}