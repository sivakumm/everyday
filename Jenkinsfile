pipeline {
    agent any

    tools {
        gradle 'Gradle-7.4.2'
    }

    stages {
        stage ('Build') {
            steps {
                sh './gradlew -v'
            }
        }

        stage ('Test') {
            steps {
                echo 'Testing the application'
            }
        }

        stage ('Deploy') {
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                echo 'Deploying the application'
            }
        }
    }
}
