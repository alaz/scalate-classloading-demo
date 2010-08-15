#!/bin/sh

HOME="`dirname $0`"
CLASSPATH="lib/${project.artifactId}-${project.version}.jar"
#CLASSPATH="lib/${project.artifactId}-${project.version}.jar:lib/scalate-core-1.3-SNAPSHOT.jar:lib/scala-library-2.8.0.jar"

(cd "$HOME";
 exec java -classpath "$CLASSPATH" com.osinka.scalate.classloading.demo.app.CamelMain)
