FROM openjdk:8-jdk-alpine

COPY target/*.jar genquins.jar

ENV CHALLONGE_USERNAME toto
ENV CHALLONGE_TOKEN 1
ENV CHALLONGE_TOURNAMENT 1

ENTRYPOINT ["java","-jar","/genquins.jar --challonge.username="${CHALLONGE_USERNAME}" --challonge.token="${CHALLONGE_TOKEN}" --challonge.tournament="${CHALLONGE_TOURNAMENT}""]