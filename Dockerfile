# # -------------------------------------------------------------------
# #              Script to set the Dockerfile
# # -------------------------------------------------------------------
FROM gradle:7-jdk11 AS build

RUN echo "Step 1...Done"
# -------------------------------------------------------------------
# Configure de system on the container and do
# the copy of it and move it as a workdir.
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

RUN echo "Step 2...Done"
# -------------------------------------------------------------------
# Create the shadowJar and create a route to it.
RUN gradle buildFatJar

RUN echo "Step 3...Done"
# -------------------------------------------------------------------
# Specifies the Parent Image from which you are building is openjdk
FROM openjdk:11

RUN echo "Step 4...Done"
# -------------------------------------------------------------------
# expose the port from when you going to be listen
EXPOSE 80:8080

RUN echo "Step 5...Done"
# -------------------------------------------------------------------
# crate a copy of the server and save it with the
# new name on the root directory. don't user a internal route to avoid
# error o problem to find the file . jar
COPY --from=build /home/gradle/src/build/libs/*.jar trickywords-server.jar

RUN echo "Step 6...Done"
# -------------------------------------------------------------------
# set the entrypoint of the server it this case the file to
# run the the server
ENTRYPOINT ["java","-jar","trickywords-server.jar"]