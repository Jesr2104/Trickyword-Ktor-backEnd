package com.example.utilities

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.util.*
import io.ktor.utils.io.*

class HttpClient {
    companion object {
        private const val host = "https://trickyword-justjump-default-rtdb.europe-west1.firebasedatabase.app"
        private const val endPoint = "/TrickyWord_BooksLisDB.json"

        private val client = HttpClient(CIO)
    }

    suspend fun getClient(): HttpResponse {
        val response: HttpResponse = client.get(host + endPoint){
            setBody("Body content")
        }
        client.close()

        return response
    }
}
