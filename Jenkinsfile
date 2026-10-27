
pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    environment {
        SONAR_URL = 'http://51.20.127.31:9000'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/cjcnkolhe/calculatorappwithsonarqubeapp.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean verify'
            }
        }

        stage('SonarQube Check') {
            steps {
                retry(3) {
                    sh '''
                        curl -fsS --connect-timeout 10 --max-time 20 \
                            "$SONAR_URL/api/system/status"
                    '''
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withCredentials([string(
                    credentialsId: 'sonar-token',
                    variable: 'SONAR_TOKEN'
                )]) {
                    sh '''
                        mvn org.sonarsource.scanner.maven:sonar-maven-plugin:5.8.0.7211:sonar \
                            -Dsonar.projectKey=my-project \
                            -Dsonar.projectName=my-project \
                            -Dsonar.host.url=$SONAR_URL \
                            -Dsonar.token=$SONAR_TOKEN
                    '''
                }
            }
        }
    }
}
