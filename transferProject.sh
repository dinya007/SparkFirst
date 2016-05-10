#!/usr/bin/env bash

rm -r target

scp -P 51800 -r /Users/denis/Documents/Scala/SparkFirst/ s19421@remote.vdi.mipt.ru:~/Spark/Task1
