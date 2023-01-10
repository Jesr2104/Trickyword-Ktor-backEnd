package com.example.utilities

fun getStringWeb(): String {
    return "<h3> Books </h3>" +

           "<table border=1>" +
            "  <tr>" +
            "    <th style='width: 200px;'>Route: </th>" +
            "    <th style='width: 300px;'>Explanation: </th>" +
            "  </tr>" +
            "  <tr>" +
            "    <td>/books</td>" +
            "    <td>Get all the books and their words</td>" +
            "  </tr>" +
            "  <tr>" +
            "    <td>/books/sort</td>" +
            "    <td>Get all the words order by books</td>" +
            "  </tr>" +
            "  <tr>" +
            "    <td>/books/{bookNumber}</td>" +
            "    <td>Get all the word from a specific book</td>" +
            "  </tr>" +
            "</table>" +

            "<h3> Words </h3>" +

            "<table border=1>" +
            "  <tr>" +
            "    <th style='width: 200px;'>Route: </th>" +
            "    <th style='width: 300px;'>Explanation: </th>" +
            "  </tr>" +
            "  <tr>" +
            "    <td>/words</td>" +
            "    <td>Get all the words from all books</td>" +
            "  </tr>" +
            "  <tr>" +
            "    <td>/words/sort</td>" +
            "    <td>Get all the words order by alphabetically</td>" +
            "  </tr>" +
            "  <tr>" +
            "    <td>/word/{word}</td>" +
            "    <td>Get a specific word</td>" +
            "  </tr>" +
            "</table>" +

            "<h3> Information </h3>" +

            "<table border=1>" +
            "  <tr>" +
            "    <th style='width: 200px;'>Route: </th>" +
            "    <th style='width: 300px;'>Explanation: </th>" +
            "  </tr>" +
            "  <tr>" +
            "    <td>/info/books</td>" +
            "    <td>Get all the information of the books</td>" +
            "  </tr>" +
            "  <tr>" +
            "    <td>/info/active-book</td>" +
            "    <td>Get all the active books</td>" +
            "  </tr>" +
            "  <tr>" +
            "    <td>/info/book/{bookNumber}</td>" +
            "    <td>Get information of a specific book</td>" +
            "  </tr>" +
            "</table>"
}