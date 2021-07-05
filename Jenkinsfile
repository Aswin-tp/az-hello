pipeline {
    agent {
        docker {
            image 'maven'
            args '-v $HOME/.m2:/root/.m2'
        }
    }

    stages {
        stage('Build') {
            steps {
               script {
                   withSonarQubeEnv('sonarserver') {
                       sh "mvn sonar:sonar"
                   }
                   timeout(time :1,unit : 'HOURS') {
                       def qg = waitForQualityGate()
                       if (qg.status != 'OK') {
                           error  "error"
                       }
                   }
                   sh "mvn clean install"
               }
            }

            
        }
    }
}
