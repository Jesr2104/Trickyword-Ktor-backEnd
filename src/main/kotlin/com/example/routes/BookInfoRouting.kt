package com.example.routes

import com.example.utilities.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.runBlocking

fun Route.bookInfoRouting() = runBlocking {
    route("/info") {
        // function to get all the Book Information
        get("books") {
            call.respondText(HttpClient().getClientForBooksInfo())
        }

        // -> /bookInfo/active
        // get all the active books
        get("active-books") {
            call.respondText(getActiveBooks(HttpClient().getClientForBooksInfo()))
        }

        // -> /bookInfo/{word}
        // get a specific book information
        get("book/{bookNumber?}") {
            val bookNumber =
                call.parameters["bookNumber"]?.getBookNumber()
                    ?: return@get call.respondText(
                        text = "You need to insert the book to search",
                        status = HttpStatusCode.BadRequest
                    )

            call.respondText {
                getSpecificBookInformation(HttpClient().getClientForBooksInfo(), bookNumber) ?: "book not found.."
            }
        }
    }
}