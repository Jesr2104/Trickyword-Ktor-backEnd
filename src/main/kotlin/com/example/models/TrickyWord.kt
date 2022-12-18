package com.example.models

data class TrickyWord(
    val idTrickyWord: String,
    var trickyWord: String,
    val type: Int,
    val nLesson: Int,
    val nBook: Int,
    val difficulty: Int,
    val questions: ArrayList<Questions>
)