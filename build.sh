#!/bin/bash

BUILD_PATH="/home/ubuntu/admin"
UI_PATH="${BUILD_PATH}/frontend"
JAVA_PATH="${BUILD_PATH}/backend"
PUBLIC_PATH="/home/ubuntu/public"
USER_HOME="/home/ubuntu"

deploy_ui() {
 cd ${UI_PATH}
 npx yarn build
 rm -rf "${PUBLIC_PATH}/dist"
 mv ./dist "${PUBLIC_PATH}/"
}

deploy_java() {
  cd "${JAVA_PATH}"
  mvn clean package
  nohup java -Dspring.profiles.active=prod -jar target/whatsappbot-0.0.1-SNAPSHOT.jar >> "${USER_HOME}/server.log" &
}

deploy_build() {
    echo "[*] deploying backend..."
    deploy_java;
    echo "[*] deploying frontend..."
    deploy_ui;
}

init() {
        last_path=`pwd`;
        echo "[*] changing dir to ${BUILD_PATH}"
        cd ${BUILD_PATH}
        git pull
        if [[ "${1}" == "ui" ]]; then
                echo "[*] deploying ui..."
                deploy_ui;
        elif [[ "${1}" == "java" ]]; then
            echo "[*] deploying java..."
            deploy_java;
        else
           deploy_build;
        fi
        pwd "${last_path}"
}

init $1