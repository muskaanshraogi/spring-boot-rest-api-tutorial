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
        stage('Deployment') {
            steps {
                if(env.BRANCH_NAME == 'main') {
                    echo "Deploying"
                }
            }
        }
    }
}
