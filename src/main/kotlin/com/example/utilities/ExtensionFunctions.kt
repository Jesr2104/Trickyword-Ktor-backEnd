package com.example.utilities

// check if the books number is correct
fun String.getBookNumber(): Int? {
    if (this.toInt() in 13 downTo 1){
        return this.toInt()
    }
    return null
}