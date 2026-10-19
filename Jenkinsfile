
pipeline {
    agent any

    options {
        timestamps()
    }

    stages {
        stage('Checkout GitHub Code') {
            steps {
                echo 'GitHub code downloaded successfully'
            }
        }

        stage('Check Java and Maven') {
            steps {
                bat 'java -version'
                bat '"C:\\tool\\apache-maven-3.9.16\\bin\\mvn.cmd" -version'
            }
        }

        stage('Run Selenium TestNG Tests') {
            steps {
                bat '"C:\\tool\\apache-maven-3.9.16\\bin\\mvn.cmd" -B clean test'
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
            echo 'Build and Selenium tests completed successfully!'
        }

        failure {
            echo 'Build failed. Check the Console Output.'
        }
    }
}
