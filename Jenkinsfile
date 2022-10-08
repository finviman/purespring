pipeline {
  agent {
    node {
      label 'test'
    }

  }
  stages {
    stage('compile') {
      steps {
        sh 'mvn compile'
      }
    }

    stage('test') {
      steps {
        sh 'mvn test'
      }
    }

  }
}