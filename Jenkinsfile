
pipeline {
    agent any

    options {
        timestamps()
    }

    stages {
        stage('Checkout GitHub Code') {
            steps {
                checkout scm
                echo 'GitHub code downloaded successfully'
            }
        }

        stage('Check Java and Maven') {
            steps {
                bat 'java -version'
                bat 'mvn -version'
            }
        }

        stage('Run Selenium TestNG Tests') {
            steps {
                bat 'mvn -B clean test'
            }
        }
    }

    post {
        always {
            junit(
                testResults: '**/target/surefire-reports/*.xml',
                allowEmptyResults: true
            )
        }

        success {
            echo 'OrangeHRM automation completed successfully'
        }

        failure {
            echo 'Build or Selenium tests failed. Check Console Output.'
        }
    }
}
