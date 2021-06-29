pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat "mvn package -DskipTests"
            }
        }
        stage('Testing') {
            steps {
                echo "Testing"
            }
        }
        if(env.BRANCH_NAME == 'main') {
            stage('Deployment') {
                steps {
                    echo "Deploying"
                }
            }
        }
    }
}