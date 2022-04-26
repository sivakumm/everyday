pipeline {
    agent any

    stages {
        stage ('Build') {
            steps {
                echo 'Building the application'
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
