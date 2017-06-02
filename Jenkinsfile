pipeline {
  agent none
  
  stages {
    stage('Compile') {
      agent {
        docker {
          image 'maven:3-alpine'
        }
      }

      steps {
        sh 'mvn clean package'
      }
    }
  }
} //End pipeline
