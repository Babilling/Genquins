FROM maven:3.6.2-jdk-8-slim

COPY . /genquins
COPY application.properties /
COPY entrypoint.sh /

ENV CHALLONGE_USERNAME toto
ENV CHALLONGE_TOKEN 1
ENV CHALLONGE_PARENT_TOURNAMENT 1
ENV CHALLONGE_CHILDREN_TOURNAMENTS 1

USER 0

RUN cd /genquins &&\
    mvn install && \
    cp target/*.jar /genquins.jar && \
    rm -rf /genquins && \
    rm -rf /root/.m2 && \
	chmod 777 /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]