pipeline {
    agent any

    tools {
        jdk 'jdk-17'
    }

    stages {
        stage ('build') {
            steps {
                echo 'Building the application'
            }
        }

        stage ('test') {
            steps {
                echo 'Testing the application'
            }
        }

        stage ('deploy') {
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
