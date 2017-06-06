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
        checkout scm
        sh 'mvn clean package'
      }
    }

    stage('Test') {
      agent {
        docker {
          image 'maven:3-alpine'
        }
      }
      steps {
        junit '**/target/*.xml'
      }
    }

    stage('Inspect') {
      agent {
        docker {
          image 'maven:3-alpine'
        }
      }
      steps {
        sh 'mvn sonar:sonar'
      }
    }
  }
} //End pipeline
