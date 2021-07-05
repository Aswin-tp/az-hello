pipeline {
    agent any
     tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
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
