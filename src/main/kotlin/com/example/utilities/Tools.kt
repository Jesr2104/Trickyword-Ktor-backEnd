package com.example.utilities

import com.example.models.ActiveBooks
import com.example.models.TrickyWord
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

// function to convert from Array to JsonString TrickyWord
fun getJsonStringFromArray(objectList: ArrayList<TrickyWord>): String {
    return Gson().toJson(objectList)
}

// function to convert from JsonString to Array TrickyWord
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
    booksList.sortBy { it.nLesson }
    return getJsonStringFromArray(booksList)
}

//function to gel all the actives books
fun getActiveBooks(jsonString: String): String {
    val activeBooksList: ArrayList<ActiveBooks> = arrayListOf()
    val arrayListType = object : TypeToken<ArrayList<ActiveBooks>>() {}.type
    val list: ArrayList<ActiveBooks> = Gson().fromJson(jsonString, arrayListType)

    list.forEach {
        if (it.active){
            activeBooksList.add(it)
        }
    }
    return Gson().toJson(activeBooksList)
}