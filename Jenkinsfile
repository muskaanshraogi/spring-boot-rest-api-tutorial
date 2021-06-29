pipeline {
    agent any

    tools { 
        maven "3.8.1"
        jdk "1.8.0_181"
    }

    stages {
        stage('Build') {
            steps {
                echo "Building"
                //bat "mvn package -DskipTests"
            }
        }
        stage('Testing') {
            steps {
                echo "Testing"
            }
        }
        stage('Deployment') {
            when {
                expression { env.BRANCH_NAME == 'main' }
            }
            steps {
                echo "Deploying"
            }
        }
    }
}
