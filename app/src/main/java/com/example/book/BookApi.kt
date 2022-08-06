package com.example.book

import retrofit2.Response
import retrofit2.http.*

interface BookApi {
    @GET("api/books")
    suspend fun getBook(): Response< List<Book>>

    @POST("api/books/create")
    suspend fun saveBook(@Body book: Book)

    @DELETE("api/books/{id}")
    suspend fun deleteBook(@Path("id") id: Int)
}