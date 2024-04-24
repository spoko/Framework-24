pipeline {
    agent any

    tools {
        // Install the Maven version configured as "Maven363" and add it to the path.
        maven "Maven363"
    }

    stages {
        stage('Get the code and clean') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/spoko/Framework-24'

                sh 'mvn clean'
            }
        }

        stage('Running the Tests') {
            steps {
                // Run Maven on a Unix agent.
                sh 'mvn -Dmaven.test.failure.ignore=true clean package'
                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
    }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                always {
                    publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/surefire-reports/', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: '', useWrapperFileDirectly: true])
                    testNG()
                }
            }
}
