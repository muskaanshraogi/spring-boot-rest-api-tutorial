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
        }
        post {
            always {
                cucumber buildStatus: 'UNSTABLE',
                        failedFeaturesNumber: 1,
                        failedScenariosNumber: 1,
                        skippedStepsNumber: 1,
                        failedStepsNumber: 1,
                        classifications: [
                                [key: 'Commit', value: '<a href="${GERRIT_CHANGE_URL}">${GERRIT_PATCHSET_REVISION}</a>'],
                                [key: 'Submitter', value: '${GERRIT_PATCHSET_UPLOADER_NAME}']
                        ],
                        reportTitle: 'My report',
                        fileIncludePattern: '**/*cucumber-report.json',
                        sortingMethod: 'ALPHABETICAL',
                        trendsLimit: 100
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
