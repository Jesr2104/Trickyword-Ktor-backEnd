package com.example.routes

import com.example.utilities.AtoB
import com.example.utilities.HttpClient
import com.example.utilities.getBookNumber
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun Route.booksRouting() = runBlocking {
    // function to get all the word of a specific book
    route("/books") {
        get("") {
            val request = HttpClient()
            val jsonString = request.getClientForBooks()
            call.respondText(jsonString)
        }

        get("{bookNumber?}") {
            val bookNumber =
                call.parameters["bookNumber"]?.getBookNumber()
                    ?: return@get call.respondText(
                        text = "",
                        status = HttpStatusCode.BadRequest
                    )

//            val new1 = Person(name = "1º", checked = true, list = arrayListOf(1, 1, 1, 1, 1))
//            val new2 = Person(name = "2º", checked = true, list = arrayListOf(2, 2, 2, 2, 2))
//            val new3 = Person(name = "3º", checked = true, list = arrayListOf(3, 3, 3, 3, 3))
//
//            val result = "[" + Gson().toJson(new1) + "," + Gson().toJson(new2) + "," + Gson().toJson(new3) + "]"
//            println(result)

            launch {
                val request = HttpClient()
                val jsonString = request.getClientForBooks()

                /*val testModel = Gson().fromJson(jsonString, WordList::class.java)
                for (item in testModel.wordList){
                    println(item)
                }*/

                //call.respondText(result)
                val result = AtoB(jsonString)
                println(result)

                /*println(result[0].trickyWord)
                println(result[1].trickyWord)
                println(result[2].trickyWord)*/

                //val a = filterBooks(tutorials, bookNumber)

                //println(a[0].trickyWord)
                //println(a[1].trickyWord)
                //println(a[2].trickyWord)

                call.respondText("bookSelected:")
            }
        }
    }
}