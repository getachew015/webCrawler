pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh "mvn -version"
                sh "mvn clean install"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Code Quality Check'){
        	withSonarQubeEnv('SonarQube') {
        		sh "mvn sonar:sonar"
        	}
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}