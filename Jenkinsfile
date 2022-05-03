pipeline {
    agent any

    tools {
        gradle 'Gradle-7.4.2'
    }

    stages {
        stage ('Build and Test Frontend') {
            steps {
                withGradle() {
                    sh './gradlew :frontend:clean'
                    sh './gradlew :frontend:build'
                    sh './gradlew :frontend:test'
                }
            }
        }

        stage ('Copy Static Dependencies') {
            steps {
                withGradle() {
                    sh './gradlew copyStaticFiles'
                }
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
                sh 'docker-compose build --no-cache --pull'
            }
        }

        stage ('Deploy') {
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                echo 'Deployment...'
            }
        }
    }
}
