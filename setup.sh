#!/bin/bash
mkdir -p gradle/wrapper
cd gradle/wrapper
echo "Downloading gradle-wrapper.jar..."
# Try primary source
if ! wget -q https://services.gradle.org/distributions/gradle-7.6-bin.zip -O gradle.zip 2>/dev/null; then
  echo "Primary source failed, trying backup..."
  wget -q https://repo1.maven.org/maven2/org/gradle/gradle-wrapper/7.6/gradle-wrapper-7.6.jar -O gradle-wrapper.jar
else
  unzip -q gradle.zip
  mv gradle-7.6/lib/gradle-wrapper.jar .
  rm -rf gradle.zip gradle-7.6
fi
cd ../..
echo "Done! gradle-wrapper.jar is in gradle/wrapper/"
