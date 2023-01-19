# Trickyword-Ktor-backEnd

This project is a backend written with Kotlin multiplanform using the Ktor tool. Ktor allows us to write and configure a backend server that can manage all HTTP responses and return information in JSON to be used as an API in our applications.

For the deployment of the server, docker has been used to create a server image and a container where the server is serving the Api in Fly.io

<img src="https://github.com/Jesr2104/Trickyword-Ktor-backEnd/blob/fccd15f6d5c7878c5b187235f710e425f284d4e5/back-end-Response.png" width="400">

## Getting Started

To get started, you will need to have the following installed on your machine:
- Kotlin
- Gradle

Clone the repository and navigate to the project directory. Run the command `gradle run` to start the server.

## Endpoints

The following endpoints are available in the API:
- `GET /words`: Retrieves a list of all words in the database
- `POST /words`: Adds a new word to the database
- `PUT /words/{id}`: Updates a word in the database
- `DELETE /words/{id}`: Deletes a word from the database

## Built With
- Kotlin
- Ktor
- Json

## License
This project is licensed under the [MIT License](LICENSE)

