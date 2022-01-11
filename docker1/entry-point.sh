#!/usr/bin/env bash

echo
echo "Using Java Version"
java -version

exec java $JAVA_OPTS  -jar /app/*.jar $@