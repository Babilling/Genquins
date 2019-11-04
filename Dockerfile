FROM maven:3.6.2-jdk-8-slim

COPY . /genquins
COPY application.properties /

ENV CHALLONGE_USERNAME toto
ENV CHALLONGE_TOKEN 1
ENV CHALLONGE_PARENT_TOURNAMENT 1
ENV CHALLONGE_CHILDREN_TOURNAMENTS 1

USER 0

RUN cd /genquins &&\
    mvn install && \
    cp target/*.jar /genquins.jar && \
	sed -i "s|CHALLONGE_USERNAME|$CHALLONGE_USERNAME|g" /application.properties && \
	sed -i "s|CHALLONGE_TOKEN|$CHALLONGE_TOKEN|g" /application.properties && \
	sed -i "s|CHALLONGE_PARENT_TOURNAMENT|$CHALLONGE_PARENT_TOURNAMENT|g" /application.properties && \
	sed -i "s|CHALLONGE_CHILDREN_TOURNAMENTS|$CHALLONGE_CHILDREN_TOURNAMENTS|g" /application.properties && \
    rm -rf /genquins && \
    rm -rf /root/.m2


ENTRYPOINT ["java","-jar","/genquins.jar"]