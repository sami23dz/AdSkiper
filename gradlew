#!/bin/sh
set -e
PRG="$0"
while [ -h "$PRG" ]; do
    ls -ld "$PRG"
    link=`expr "$PRG" : '.*-> \(.*\)$'`
    if expr "$link" : '/.*' > /dev/null; then
        PRG="$link"
    else
        PRG=`dirname "$PRG"`"/$link"
    fi
done
SAVED="`pwd`"
cd "`dirname \"$PRG\"`/" > /dev/null
APP_HOME="`pwd -P`"
cd "$SAVED" > /dev/null
CLASSPATH="$APP_HOME/gradle/wrapper/gradle-wrapper.jar"
if [ ! -f "$CLASSPATH" ]; then
    echo "gradle-wrapper.jar not found. Run: bash setup.sh"
    exit 1
fi
if [ -z "$JAVA_HOME" ]; then
    JAVACMD="java"
else
    JAVACMD="$JAVA_HOME/bin/java"
fi
exec "$JAVACMD" -Xmx64m -Xms64m -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
