package com.example.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.trickyWordRouting() {

    // function to get all the trickyWord from a specific book
    route("/trickyWords{bookNumber?}"){
        get {
            var bookNumber = call.parameters["bookNumber"] ?: return@get call.respondText(
                text = "",
                status = HttpStatusCode.BadRequest
            )
        }
    }
}