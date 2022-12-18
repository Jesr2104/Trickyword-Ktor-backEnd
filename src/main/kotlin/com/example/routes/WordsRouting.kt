package com.example.routes

import io.ktor.server.routing.*
import kotlinx.coroutines.runBlocking

fun Route.wordsRouting() = runBlocking {
    route("/words"){

    }
}