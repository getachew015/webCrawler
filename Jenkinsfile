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
                echo 'Building..'
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
