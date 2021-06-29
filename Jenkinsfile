pipeline {
    agent any

    tools { 
        maven "Maven 3.8.1"
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
