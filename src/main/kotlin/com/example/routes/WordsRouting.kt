package com.example.routes

import com.example.utilities.HttpClient
import com.example.utilities.getSpecificWord
import com.example.utilities.sortByWordAlphabetically
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.runBlocking

fun Route.wordsRouting() = runBlocking {
    route("/words") {
        // function to get all the words
        get("") {
            call.respondText(HttpClient().getClientForWordOnBooks())
        }

        // -> /Words/sort
        // function to get que word order by alphabetically
        get("sort") {
            call.respondText(sortByWordAlphabetically(HttpClient().getClientForWordOnBooks()))
        }

        // -> /words/{word}
        // function to get the specific word
        get("{word?}") {
            val word =
                call.parameters["word"]
                    ?: return@get call.respondText(
                        text = "You need to insert the word to search",
                        status = HttpStatusCode.BadRequest
                    )

            call.respondText {
                getSpecificWord(HttpClient().getClientForWordOnBooks(), word) ?: "word not found.."
            }
        }
    }
}