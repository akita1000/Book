package com.example.book

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Book::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun bookDao(): BookDao
}
