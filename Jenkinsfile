pipeline {
    agent any

    stages {
        stage ('Build') {
            steps {
                sh 'chmod +x ./gradlew'
                sh 'ls -l'
                sh './gradlew buildBackend --no-daemon'
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
