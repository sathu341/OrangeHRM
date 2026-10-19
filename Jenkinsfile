
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
