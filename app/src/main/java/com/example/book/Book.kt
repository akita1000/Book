package com.example.book

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book(
    @PrimaryKey
    val id: Int = 0,
    val title: String,
    val author: String,
    val published: Int = 0,
    val description: String
)

