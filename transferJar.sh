#!/usr/bin/env bash

sbt clean package
scp -P 51800 -r /Users/denis/Documents/Scala/SparkFirst/target/scala-2.11/sparkfirst_2.11-1.0.jar s19421@remote.vdi.mipt.ru:~/Spark/Task1
