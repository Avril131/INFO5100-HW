#!/bin/bash

cd "$(dirname "$0")"

mvn clean compile -q

echo "Starting first chat window..."
mvn exec:java -Dexec.mainClass="com.example.App" &

sleep 2

echo "Starting second chat window..."
mvn exec:java -Dexec.mainClass="com.example.App" &

echo "Two windows started. Please login with different accounts to test chat."
