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

    stage('package') {
      steps {
        sh 'mvn package'
      }
    }

    stage('deploy') {
      steps {
        archiveArtifacts '**/target/*.jar'
      }
    }

  }
}