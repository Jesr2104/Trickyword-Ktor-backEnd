package com.example.models

data class TrickyWord(
    val uid: String,
    val idTrickyWord: String,
    var trickyWord: String,
    val type: Int,
    val nLesson: Int,
    val nbook: Int,
    val difficult: Int,
    val questions: ArrayList<Questions>
)