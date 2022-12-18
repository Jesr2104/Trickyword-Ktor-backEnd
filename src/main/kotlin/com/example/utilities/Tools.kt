package com.example.utilities

import com.example.models.TrickyWord
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun filterBooks(jsonString: String, bookNumber: Int): String {
    val newFilterList: ArrayList<TrickyWord> = arrayListOf()
    val booksList = getArrayFromJsonString(jsonString)

    booksList.forEach {
        if (it.nBook == bookNumber){
            newFilterList.add(it)
        }
    }
    return getJsonStringFromArray(newFilterList)
}

fun getJsonStringFromArray(objectList: ArrayList<TrickyWord>): String {
    return Gson().toJson(objectList)
}

fun getArrayFromJsonString(jsonString: String): ArrayList<TrickyWord> {
    val arrayListType = object : TypeToken<ArrayList<TrickyWord>>() {}.type
    return Gson().fromJson(jsonString, arrayListType)
}