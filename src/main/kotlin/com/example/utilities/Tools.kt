package com.example.utilities

import com.example.models.ActiveBooks
import com.example.models.TrickyWord
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

// function to convert from Array to JsonString TrickyWord using generic type
fun <T> getJsonStringFromArray(objectList: ArrayList<T>): String {
    return Gson().toJson(objectList)
}

// function to convert from JsonString to Array TrickyWord using generic type
inline fun <reified T> getArrayFromJsonString(jsonString: String): ArrayList<T> {
    val arrayListType = object : TypeToken<ArrayList<T>>() {}.type
    return Gson().fromJson(jsonString, arrayListType)
}

// function to get all the word from the specific book
fun filterBooks(jsonString: String, bookNumber: Int): String {
    val newFilterList: ArrayList<TrickyWord> = arrayListOf()
    val booksList = getArrayFromJsonString<TrickyWord>(jsonString)

    booksList.forEach {
        if (it.nBook == bookNumber) {
            newFilterList.add(it)
        }
    }
    return getJsonStringFromArray(newFilterList)
}

// function to sort by book
fun sortByBooks(jsonString: String): String {
    val booksList = getArrayFromJsonString<TrickyWord>(jsonString)

    booksList.sortBy { it.nBook }
    booksList.sortBy { it.nLesson }
    return getJsonStringFromArray(booksList)
}

//function to gel all the actives books
fun getActiveBooks(jsonString: String): String {
    val activeBooksList: ArrayList<ActiveBooks> = arrayListOf()
    val list = getArrayFromJsonString<ActiveBooks>(jsonString)

    list.forEach {
        if (it.active){
            activeBooksList.add(it)
        }
    }
    return getJsonStringFromArray(activeBooksList)
}