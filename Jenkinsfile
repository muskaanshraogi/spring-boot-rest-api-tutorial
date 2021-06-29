pipeline {
    agent any

    tools { 
        maven "apache-maven-3.0.1"
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
