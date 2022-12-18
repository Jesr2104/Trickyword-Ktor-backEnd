package com.example.utilities

import com.example.models.TrickyWord
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

// function to convert from Array to JsonString
fun getJsonStringFromArray(objectList: ArrayList<TrickyWord>): String {
    return Gson().toJson(objectList)
}

// function to convert from JsonString to Array
fun getArrayFromJsonString(jsonString: String): ArrayList<TrickyWord> {
    val arrayListType = object : TypeToken<ArrayList<TrickyWord>>() {}.type
    return Gson().fromJson(jsonString, arrayListType)
}

// function to get all the word from the specific book
fun filterBooks(jsonString: String, bookNumber: Int): String {
    val newFilterList: ArrayList<TrickyWord> = arrayListOf()
    val booksList = getArrayFromJsonString(jsonString)

    booksList.forEach {
        if (it.nBook == bookNumber) {
            newFilterList.add(it)
        }
    }
    return getJsonStringFromArray(newFilterList)
}

// function to sort by book
fun sortByBooks(jsonString: String): String {
    val booksList = getArrayFromJsonString(jsonString)

    booksList.sortBy { it.nBook }
    return getJsonStringFromArray(booksList)
}