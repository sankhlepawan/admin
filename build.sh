#!/bin/bash

BUILD_PATH="/home/ubuntu/admin"
UI_PATH="${BUILD_PATH}/frontend"
JAVA_PATH="${BUILD_PATH}/backend"
PUBLIC_PATH="/home/ubuntu/public"

deploy_ui() {
 cd ${UI_PATH}
 npx yarn build
 rm "${PUBLIC_PATH}/dist"
 mv ./dist "${PUBLIC_PATH}/"
}

deploy_java() {
  cd "${JAVA_PATH}"
  mvn clean package
  nohup java -Dspring.profiles.active=prod -jar target/whatsappbot-0.0.1-SNAPSHOT.jar >> server.log &
}

deploy_build() {
    deploy_java;
    deploy_ui;
}

init() {
        last_path=`pwd`;
        cd ${BUILD_PATH}
        git pull
        if [[ "${1}" != "ui" ]]; then
                echo "[*] deploying ui..."
                deploy_ui;
        elif [[ "${1}" == "java" ]]; then
            echo "[*] deploying java..."
            deploy_java
        else
           deploy_build
        fi
        pwd "${last_path}"
}

init $1