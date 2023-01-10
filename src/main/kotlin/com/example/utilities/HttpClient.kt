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

    // client for endpoint words and words
    suspend fun getClientForWordOnBooks() = runBlocking {
        val endPoint = "/TrickyWords_WordsDB.json"
        val client = HttpClient(CIO)

        val httpResponse: HttpResponse = client.get(host + endPoint + prettyPrint)
        val stringBody: String = httpResponse.body()
        client.close()

        return@runBlocking stringBody
    }

    // client for endpoint Books Information
    suspend fun getClientForBooksInfo() = runBlocking{
        val endPoint = "/Books_InfoDB.json"
        val client = HttpClient(CIO)

        val httpResponse: HttpResponse = client.get(host + endPoint + prettyPrint)
        val stringBody: String = httpResponse.body()
        client.close()

        return@runBlocking stringBody
    }
}
