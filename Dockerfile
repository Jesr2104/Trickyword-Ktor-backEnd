# FROM openjdk:11-slim as build
#
# RUN echo "Step 1...Done"
# # -------------------------------------------------------------------
# # Configure de system on the container and do
# # the copy of it on the server image.
#
# WORKDIR /src
# COPY . /src
#
# RUN apt-get update
# RUN apt-get install -y dos2unix
# RUN dos2unix gradlew
#
# RUN echo "Step 2...Done"
# # -------------------------------------------------------------------
# # Create the shadowJar and create a route to it.
#
# RUN bash gradlew shadowJar
# ARG JARFILE=build/libs/*-all.jar
#
# RUN echo "Step 3...Done"
# # -------------------------------------------------------------------
# # crate a copy of the server and save it with the
# # new name on the root directory. don't user a internal route to avoid
# # error o problem to find the file . jar
#
# COPY ${JARFILE} trickyWords-Server.jar
#
# RUN echo "Step 4...Done"
# # -------------------------------------------------------------------
# # expose the port from when you going to be listen
#
# EXPOSE 8080
#
# RUN echo "Step 5...Done"
# # -------------------------------------------------------------------
# # set the entrypoint of the server it this case the file to
# # run the the server
#
# ENTRYPOINT ["java","-jar","trickyWords-Server.jar"]
# --no-daemon

FROM gradle:7-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle buildFatJar
# RUN gradlew shadowJar

FROM openjdk:11
EXPOSE 80:8080
# RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar ktor-sample.jar
ENTRYPOINT ["java","-jar","ktor-sample.jar"]

