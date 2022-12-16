package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class TrickyWord(
    val uid: String,
    val idTrickyWord: String,
    val trickyWord: String,
    val type: Int,
    val nLesson: Int,
    val nBook: Int,
    val difficulty: Int,
    val questions: ArrayList<Questions>
)