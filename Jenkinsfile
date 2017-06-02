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
    stage('Inspect') {
      agent {
        docker {
          image 'sonarqube:6.3.1-alpine'
          args  '-p 9000:9000 -p 9092:9092'
        }
      }
      steps {
        sh 'mvn sonar:sonar'
      }
    }
  }
} //End pipeline
