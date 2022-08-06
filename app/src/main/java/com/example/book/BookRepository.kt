package com.example.book

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import retrofit2.Response
import retrofit2.http.*

class BookRepository (var bookDao: BookDao, var bookApi: BookApi){
    suspend fun saveBookToDB(book: Book){
        bookDao.saveBook(book)
    }
    suspend fun updateBookToDB(book: Book){
        bookDao.updateBook(book)
    }
    suspend fun deleteBookToDB(book: Book){
        bookDao.deleteBook(book)
    }
    suspend fun getAllBookToDB() : List <Book>{
      return bookDao.getAllBook()
    }

    suspend fun getBookApi(): Response<List<Book>> {
        return bookApi.getBook()
    }

    suspend fun saveBookApi(book: Book) {
        return bookApi.saveBook(book)
    }
    suspend fun deleteBookApi(id: Int) {
        return bookApi.deleteBook(id)
    }
}