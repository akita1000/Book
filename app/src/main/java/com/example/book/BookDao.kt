package com.example.book

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface BookDao {
    @Insert(onConflict = REPLACE)
    suspend fun saveBook(book: Book)

    @Update()
    suspend fun updateBook(book: Book)

    @Delete()
    suspend fun deleteBook(book: Book)

    @Query("SELECT * FROM book")
    suspend fun getAllBook(): List<Book>
}