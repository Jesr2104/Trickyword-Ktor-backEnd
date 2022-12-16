package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Questions(
    val correctAnswer: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val question: String
)