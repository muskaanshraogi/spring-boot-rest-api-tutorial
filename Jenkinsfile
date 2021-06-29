pipeline {
    agent any

    tools { 
        Maven
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
