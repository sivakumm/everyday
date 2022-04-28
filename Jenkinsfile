pipeline {
    agent any

    tools {
        gradle 'Gradle-home'
    }

    stages {
        stage ('Build and Test Backend') {
            steps {
                sh 'Backend build and testing...'
            }
        }

        stage ('Build and Test Frontend') {
            steps {
                echo 'Frontend build and testing...'
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
