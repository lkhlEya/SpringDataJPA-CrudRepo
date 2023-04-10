pipeline {
    agent any

    stages {
        stage('Clone repository') {
            steps {
                git branch: 'developELA', url: 'https://github.com/lakhalEya/SpringDataJPA-CrudRepo.git'
            }
        }
        stage('Verify Maven and Java versions') {
            steps {
                sh 'mvn --version'
                sh 'java --version'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Unit tests') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        failure {
            mail to: 'lkhleya@gmail.com',
            subject: "Build failed in ${currentBuild.fullDisplayName}",
            body: "Something is broken with ${env.BUILD_URL}"
        }
        success {
            mail to: 'lkhleya@gmail.com',
            subject: "Build succeeded in ${currentBuild.fullDisplayName}",
            body: "Everything is working fine with ${env.BUILD_URL}"
        }
    }
}
