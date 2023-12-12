#!/usr/bin/env bash

#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies
export BASE_CP=base.app.sharedboardapp/target/base.app.sharedboardapp-1.4.0-SNAPSHOT.jar:base.app.sharedboardapp/target/dependency/*;

#REM call the java VM, e.g,
java -cp $BASE_CP eapli.base.app.sharedboardapp.TCPClient 10.9.24.44 8080
