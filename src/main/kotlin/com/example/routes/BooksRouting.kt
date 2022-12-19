package com.example.routes

import com.example.utilities.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun Route.booksRouting() = runBlocking {
    route("/books") {
        // function to get all the books
        get("") {
            call.respondText(HttpClient().getClientForWordOnBooks())
        }

        // -> /books/active
        // function to get the list of active books
        get("active"){
            call.respondText(getActiveBooks(HttpClient().getClientForActiveBooks()))
        }

        // -> /books/sort
        // function to get all the word order by books
        get("sort"){
            call.respondText(sortByBooks(HttpClient().getClientForWordOnBooks()))
        }

        // -> /books/{bookNumber}
        // function to get all the word of a specific book
        get("{bookNumber?}") {
            val bookNumber =
                call.parameters["bookNumber"]?.getBookNumber()
                    ?: return@get call.respondText(
                        text = "You need to insert the number of the book",
                        status = HttpStatusCode.BadRequest
                    )
            launch {
                call.respondText(filterBooks(HttpClient().getClientForWordOnBooks(), bookNumber))
            }
        }
    }
}