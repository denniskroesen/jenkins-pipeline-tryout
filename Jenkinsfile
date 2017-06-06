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
      steps {
        /* `make check` returns non-zero on test failures,
         * using `true` to allow the Pipeline to continue nonetheless
         */
        sh 'make check || true'
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
