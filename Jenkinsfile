
pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    environment {
        SONAR_HOST_URL = 'http://51.20.127.31:9000'
        SONAR_PROJECT_KEY = 'my-project'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/cjcnkolhe/calculatorappwithsonarqubeapp.git'
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn -B clean verify'
            }
        }

        stage('Check SonarQube') {
            steps {
                script {
                    def status = sh(
                        script: """
                            curl -sS --connect-timeout 5 --max-time 10 \
                              '${SONAR_HOST_URL}/api/system/status'
                        """,
                        returnStdout: true
                    ).trim()

                    if (!status.contains('"status":"UP"')) {
                        error "SonarQube is not UP. Check server ${SONAR_HOST_URL}"
                    }

                    echo 'SonarQube is reachable.'
                }
            }
        }

        stage('SonarQube Code Analysis') {
            steps {
                withCredentials([
                    string(
                        credentialsId: 'sonar-token',
                        variable: 'SONAR_TOKEN'
                    )
                ]) {
                    sh '''
                        mvn -B \
                          org.sonarsource.scanner.maven:sonar-maven-plugin:5.8.0.7211:sonar \
                          -Dsonar.projectKey="$SONAR_PROJECT_KEY" \
                          -Dsonar.projectName=my-project \
                          -Dsonar.host.url="$SONAR_HOST_URL" \
                          -Dsonar.token="$SONAR_TOKEN"
                    '''
                }
            }
        }
    }

}
