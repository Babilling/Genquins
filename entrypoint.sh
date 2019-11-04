#!/bin/sh
sed -i "s|CHALLONGE_USERNAME|$CHALLONGE_USERNAME|g" /application.properties
sed -i "s|CHALLONGE_TOKEN|$CHALLONGE_TOKEN|g" /application.properties
sed -i "s|CHALLONGE_PARENT_TOURNAMENT|$CHALLONGE_PARENT_TOURNAMENT|g" /application.properties
sed -i "s|CHALLONGE_CHILDREN_TOURNAMENTS|$CHALLONGE_CHILDREN_TOURNAMENTS|g" /application.properties

java -jar genquins.jar