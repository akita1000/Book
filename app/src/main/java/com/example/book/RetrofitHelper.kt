package com.example.book

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getBookApi() : BookApi {
        var retrofit = Retrofit.Builder()
            .baseUrl("https://spring-boot-mysql-server-part0.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var bookApi : BookApi = retrofit.create(BookApi::class.java)
        return bookApi
    }

}