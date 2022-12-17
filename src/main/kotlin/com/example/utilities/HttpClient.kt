package com.example.utilities

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

class HttpClient {
    companion object {
        private const val host = "https://trickyword-justjump-default-rtdb.europe-west1.firebasedatabase.app"
        private const val endPoint = "/TrickyWord_BooksLisDB.json"

        private val client = HttpClient(CIO)
    }

    suspend fun getClient() = runBlocking {
        val httpResponse: HttpResponse = client.get(host + endPoint)
        val stringBody: String = httpResponse.body()
        client.close()

        return@runBlocking stringBody
    }
}
