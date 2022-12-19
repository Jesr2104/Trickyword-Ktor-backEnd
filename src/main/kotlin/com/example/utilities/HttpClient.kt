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
        private const val prettyPrint = "?print=pretty"
    }

    suspend fun getClientForBooks() = runBlocking {
        val endPoint = "/TrickyWord_BooksLisDB.json"
        val client = HttpClient(CIO)

        val httpResponse: HttpResponse = client.get(host + endPoint + prettyPrint)
        val stringBody: String = httpResponse.body()
        client.close()

        return@runBlocking stringBody
    }

    suspend fun getClientForActiveBooks() = runBlocking{
        val endPoint = "/ActiveBooks.json"
        val client = HttpClient(CIO)

        val httpResponse: HttpResponse = client.get(host + endPoint + prettyPrint)
        val stringBody: String = httpResponse.body()
        client.close()

        return@runBlocking stringBody
    }
}
