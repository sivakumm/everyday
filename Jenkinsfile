pipeline {
    agent any

    tools {
        gradle 'Gradle-7.4.2'
    }

    stages {
        stage ('Build and Test Backend') {
            steps {
                echo 'Backend build and testing...'
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
