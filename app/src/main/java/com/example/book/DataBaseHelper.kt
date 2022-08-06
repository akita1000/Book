package com.example.book

import android.content.Context
import androidx.room.Room


object DataBaseHelper {
    @Volatile
    private var INSTANCE: AppDataBase? = null

    fun getDatabase(context: Context): AppDataBase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "note_database"
            )
                .build()
            INSTANCE = instance
            instance
        }
    }
}