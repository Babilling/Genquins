FROM maven:3.6.2-jdk-8-slim

COPY . /genquins

ENV CHALLONGE_USERNAME toto
ENV CHALLONGE_TOKEN 1
ENV CHALLONGE_PARENT_TOURNAMENT 1
ENV CHALLONGE_CHILDREN_TOURNAMENTS 1

RUN cd /genquins &&\
    mvn install && \
    cp target/*.jar /genquins.jar && \
    rm -rf /genquins && \
    rm -rf /root/.m2

CMD ["--challonge.username="${CHALLONGE_USERNAME}","--challonge.token="${CHALLONGE_TOKEN}","--challonge.parent.tournament="${CHALLONGE_PARENT_TOURNAMENT},"--challonge.child.tournaments="${CHALLONGE_CHILDREN_TOURNAMENTS}"]
ENTRYPOINT ["java","-jar","/genquins.jar"]