#!/bin/bash

#mvn clean ipackage

java -cp "bahubali-core/target/bahubali-core-0.0.1-SNAPSHOT.jar:bahubali-classic/target/bahubali-classic-0.0.1-SNAPSHOT.jar:bahubali-thrones/target/bahubali-thrones-0.0.1-SNAPSHOT.jar:bahubali-build/target/bahubali-build-0.0.1-SNAPSHOT.jar" com.mavaze.puzzles.bahubali.EntryPoint
