pipeline {
    agent any

    stages {
        stage ('Build') {
            steps {
                sh 'pwd'
                sh 'cd backend && ./gradle clean build'
                sh 'pwd'
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
