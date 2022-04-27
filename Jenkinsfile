pipeline {
    agent any

    stages {
        stage ('Build') {
            steps {
                sh 'pwd'
                sh 'ls -l'
                sh './gradlew buildBackend'
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
