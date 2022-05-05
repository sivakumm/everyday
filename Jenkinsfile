pipeline {
    agent any

    tools {
        gradle 'Gradle-7.4.2'
        nodejs 'NodeJs'
    }

    stages {
        stage ('Build and Test Frontend') {
            steps {
                sh 'npm -v'
                sh 'node -v'
                sh './gradlew :frontend:clean'
                sh './gradlew :frontend:build'
                sh './gradlew :frontend:test'
            }
        }

        stage ('Build and Test Backend') {
            steps {
                withGradle() {
                    sh './gradlew :backend:clean'
                    sh './gradlew :backend:build'
                    sh './gradlew :backend:test'
                }
            }
        }

        stage ('Create Docker Image') {
            steps {
                script {
                    final String branchNameLowerCase = BRANCH_NAME.toLowerCase();
                    IMAGE_NAME = "everyday_${branchNameLowerCase}_webapp"
                    IMAGE_TAG = "1.${BRANCH_NAME.split('-')[1]}.${BUILD_NUMBER}";
                }

                sh 'docker-compose build --no-cache --pull webapp'
            }
        }

        stage ('Deploy') {
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }

            environment {
                DOCKERHUB_CREDENTIALS = credentials('docker-hub-access')
            }

            steps {
                sh "docker image tag ${IMAGE_NAME} ${DOCKERHUB_CREDENTIALS_USR}/everyday:${IMAGE_TAG}"
                sh "docker image tag ${IMAGE_NAME} ${DOCKERHUB_CREDENTIALS_USR}/everyday:latest"

                sh "echo ${DOCKERHUB_CREDENTIALS_PSW} | docker login -u ${DOCKERHUB_CREDENTIALS_USR} --password-stdin"

                sh "docker push ${DOCKERHUB_CREDENTIALS_USR}/everyday:${IMAGE_TAG}"
                sh "docker push ${DOCKERHUB_CREDENTIALS_USR}/everyday:latest"

                sh "docker rmi ${DOCKERHUB_CREDENTIALS_USR}/everyday:${IMAGE_TAG}"
                sh "docker rmi ${DOCKERHUB_CREDENTIALS_USR}/everyday:latest"
            }
        }
    }

    post {
        always {
            sh "docker logout"
            script {
                try {
                    sh "docker rmi ${IMAGE_NAME}"
                } catch (err) {
                    echo err.getMessage()
                }
            }
        }
    }
}
