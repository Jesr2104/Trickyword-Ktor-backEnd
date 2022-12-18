package com.example.routes

import com.example.utilities.HttpClient
import com.example.utilities.filterBooks
import com.example.utilities.getBookNumber
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun Route.booksRouting() = runBlocking {
    route("/books") {
        // function to get all the word of a specific book
        get("") {
            val request = HttpClient()
            val jsonString = request.getClientForBooks()
            call.respondText(jsonString)
        }

        // function to get all the word order by books
        get("sort"){

            HttpClient().getClientForBooks()

            call.respondText("sort")
        }

        // function to get all the word of a specific book
        get("{bookNumber?}") {
            val bookNumber =
                call.parameters["bookNumber"]?.getBookNumber()
                    ?: return@get call.respondText(
                        text = "You need to insert the number of the book",
                        status = HttpStatusCode.BadRequest
                    )
            launch {
                call.respondText(filterBooks(HttpClient().getClientForBooks(), bookNumber))
            }
        }
    }
}