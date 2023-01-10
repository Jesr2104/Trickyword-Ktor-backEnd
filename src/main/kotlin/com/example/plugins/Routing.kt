package com.example.plugins

import com.example.routes.bookInfoRouting
import com.example.routes.booksRouting
import com.example.routes.wordsRouting
import com.example.utilities.getStringWeb
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText(
                "Hello this the BackEnd-TrickyWord!" + getStringWeb(),
                ContentType.Text.Html
            )
        }
        bookInfoRouting()
        booksRouting()
        wordsRouting()
    }
}
