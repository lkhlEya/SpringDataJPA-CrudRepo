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
        /*stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }*/
        stage('Clean') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('Compile') {
            steps {
                sh 'mvn compile'
            }
        }

        stage('Sonar') {
          steps {
            sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar -Dsonar.host.url=http://http://192.168.33.10/:9000"
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
