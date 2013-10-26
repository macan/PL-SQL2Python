#!/bin/bash

java -jar -Xms256M -Xmx720M -XX:+UseParallelGC -XX:MinHeapFreeRatio=40 -XX:ParallelGCThreads=2 ./lib/antlrworks-1.4.jar pl2py.java
