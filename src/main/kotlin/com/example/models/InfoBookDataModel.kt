package com.example.models

data class InfoBookDataModel(
    val ISBN: String,
    val bookName: String,
    val bookNumber: Int,
    val difficulty: String,
    val nLesson: Int,
    val rangeLesson: String,
    val image: String,
    val active: Boolean,
)