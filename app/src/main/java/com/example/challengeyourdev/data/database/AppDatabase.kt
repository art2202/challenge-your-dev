package com.example.challengeyourdev.data.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.challengeyourdev.core.App


abstract class AppDatabase : RoomDatabase() {


    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase (): AppDatabase? {
            if (this.INSTANCE != null) {
                return this.INSTANCE
            } else {
                synchronized(this) {
                    val instance = Room.databaseBuilder(
                        App.instance,
                        AppDatabase::class.java,
                        "your-dev-challenge")
                        .build()
                    this.INSTANCE = instance
                    return instance
                }
            }
        }
    }
}