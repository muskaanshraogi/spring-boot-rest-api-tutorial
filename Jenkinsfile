pipeline {
    agent any

    tools { 
        maven "Maven"
    }

    stages {
        stage('Build') {
            steps {
                echo "Building"
                sh "mvn package -DskipTests"
            }
        }
        stage('BDD Test') {
            steps {
                echo "Testing"
                sh "mvn test clean"
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
