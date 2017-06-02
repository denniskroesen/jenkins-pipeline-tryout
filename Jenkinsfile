/* Requires the Docker Pipeline plugin */
node('master') {
    checkout scm
    stage('Build') {
        docker.image('maven:3.3-jdk-8-alpine').inside {
            sh 'mvn --version'
        }
    }
}
