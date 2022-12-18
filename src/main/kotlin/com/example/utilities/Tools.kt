package com.example.utilities

import com.example.models.TrickyWord
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun filterBooks(booksList: Array<TrickyWord>, bookNumber: Int): ArrayList<TrickyWord> {
    val newFilterList: ArrayList<TrickyWord> = arrayListOf()

    booksList.forEach {
        val update = it
        update.trickyWord += ".Jesr $bookNumber"
        newFilterList.add(update)

        println(update.trickyWord)
    }
    return newFilterList
}

fun AtoB(jsonString: String): Array<TrickyWord> {

    val newGson = Gson()
    val arrayTutorialType = object : TypeToken<Array<TrickyWord>>() {}.type

    val thisK =
        "[\"-NEarewVGJyff6rxfVKf\":{\"difficult\":\"1\",\"idTrickyWord\":\"d5abb1b5-be7a-4dfb-9dd8-33bb719c61c3\",\"nLesson\":\"115\",\"nbook\":\"7\",\"questions\":{\"-NEarewXbUwPl68D9PSR\":{\"correctAnswer\":\"not completely\",\"optiona\":\"completely\",\"optionb\":\"party related\",\"optionc\":\"something funny\",\"question\":\"What is the meaning of Partly?\"},\"-NEarewYCKZDnd0DviCJ\":{\"correctAnswer\":\"partially\",\"optiona\":\"half\",\"optionb\":\"complete\",\"optionc\":\"party\",\"question\":\"synonym of partly?\"}},\"trickyWord\":\"Partly\",\"type\":\"3\",\"uid\":\"-NEarewVGJyff6rxfVKf\"},\"-NEasGJ_SfW4fmktEfIO\":{\"difficult\":\"1\",\"idTrickyWord\":\"14d8f9e4-e2a2-4847-89bf-046dc1d96ca5\",\"nLesson\":\"105\",\"nbook\":\"7\",\"questions\":{\"-NEasGJb1swiRloNIs6-\":{\"correctAnswer\":\"Solid\",\"optiona\":\"Hard\",\"optionb\":\"Liquied\",\"optionc\":\"Strong\",\"question\":\"opposites of liquid?\"}},\"trickyWord\":\"Liquid\",\"type\":\"2\",\"uid\":\"-NEasGJ_SfW4fmktEfIO\"},\"-NJW2ip3c6ndLZcALv_F\":{\"difficult\":\"1\",\"idTrickyWord\":\"9a82d4e9-92f1-491c-ad51-1555b6d48ba1\",\"nLesson\":\"112\",\"nbook\":\"8\",\"questions\":{\"-NJW2ip5yEuNDwhGNwzb\":{\"correctAnswer\":\"Partly\",\"optiona\":\"completly\",\"optionb\":\"fully\",\"optionc\":\"nothing\",\"question\":\"What is the antonym of totally\"}},\"trickyWord\":\"Totally\",\"type\":\"2\",\"uid\":\"-NJW2ip3c6ndLZcALv_F\"},\"-NJW3k7x4N7slMFAyCbH\":{\"difficult\":\"1\",\"idTrickyWord\":\"efcf1b0a-9fb5-4183-938f-101259dd01d9\",\"nLesson\":\"117\",\"nbook\":\"8\",\"questions\":{\"-NJW3k7yMjSwRvlNgJ9Q\":{\"correctAnswer\":\"feminine\",\"optiona\":\"girls\",\"optionb\":\"male\",\"optionc\":\"woman\",\"question\":\"What is the opposite of totally\"}},\"trickyWord\":\"Masculine\",\"type\":\"3\",\"uid\":\"-NJW3k7x4N7slMFAyCbH\"}]"
    println(jsonString)

    val tutorials: Array<TrickyWord> = newGson.fromJson(thisK, arrayTutorialType)

    //println(jsonString)

    return tutorials
}