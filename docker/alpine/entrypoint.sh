#!/usr/bin/env sh

echo "I am the entrypoint"

# pwd
ls -lA
cd /intersensorservice
pwd
ls -lA config
cp config/application.yml application.yml
ls -lA

java -Xmx2048m -jar intersensorservice.jar
