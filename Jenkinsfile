pipeline {
    agent any
    
    tools {
        maven 'maven_tool'
    }
    stages {
        stage('CheckOut') {
            steps {
                echo 'Checking Out..'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install -f WebCrawler/pom.xml'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
