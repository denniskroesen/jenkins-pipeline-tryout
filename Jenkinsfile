pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
    }
  }
  
  stages {
    stage('Compile') {
      steps {
        checkout scm
        sh 'mvn clean package'
      }
    }

    stage('Test') {
      steps {
        checkout scm
        junit '**/target/*.xml'
      }
    }

    stage('Inspect') {
      steps {
        sh 'mvn sonar:sonar'
      }
    }
  }
} //End pipeline
