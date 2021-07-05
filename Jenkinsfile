pipeline {
    agent any

    tools { 
        maven "Maven"
    }

    stages {
        stage('Build') {
            steps {
                echo "Building"
                bat "mvn package -DskipTests"
            }
        }
        stage('Run') {
            steps {
                bat "START /B java -jar target/spring-boot-rest-api-tutorial-0.0.1-SNAPSHOT.jar"
                echo "Project up on localhost"
            }
        }
        stage('BDD Test') {
            steps {
                echo "Testing"
                bat "mvn test"
            }
            post {
                always {
                    cucumber buildStatus: 'UNSTABLE',
                        reportTitle: 'My report',
                        fileIncludePattern: '**/*.json',
                        trendsLimit: 10,
                        classifications: [
                            [
                                'key': 'Browser',
                                'value': 'Firefox'
                            ]
                        ]
                }
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
