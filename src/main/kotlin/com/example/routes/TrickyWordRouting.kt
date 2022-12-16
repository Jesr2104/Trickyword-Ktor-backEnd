package com.example.routes

import com.example.utilities.getBookNumber
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.trickyWordRouting() {
    // function to get all the trickyWord from a specific book
    route("/trickyWords/{bookNumber?}") {
        get {
            val bookNumber =
                call.parameters["bookNumber"]?.getBookNumber()
                    ?: return@get call.respondText(
                        text = "",
                        status = HttpStatusCode.BadRequest
                    )

            call.respondText("bookNumber = $bookNumber")
        }
    }
}