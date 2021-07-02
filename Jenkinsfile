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
        stage('Run') {
            steps {
                sh "java -jar target/spring-boot-rest-api-tutorial-0.0.1-SNAPSHOT.jar &"
                echo "Project up on localhost"
            }
        }
        stage('BDD Test') {
            steps {
                echo "Testing"
                sh "mvn test"
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
