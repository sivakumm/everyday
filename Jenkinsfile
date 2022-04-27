pipeline {
    agent any

    stages {
        stage ('Build') {
            steps {
                withGradle {
                    sh 'pwd'
                    sh 'cd backend'
                    sh './gradlew build'
                    sh 'pwd'
                }
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
