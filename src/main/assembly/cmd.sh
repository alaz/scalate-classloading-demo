#!/bin/sh

HOME="`dirname $0`"
CLASSPATH="lib/scalate-classloading-demo-${project.version}.jar"

(cd "$HOME";
 exec java -classpath "$CLASSPATH" com.osinka.scalate.classloading.demo.app.CmdlineMain)
