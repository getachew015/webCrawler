pipeline {
    tools {
	    maven 'M3'
    }
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
        	steps {
	            withSonarQubeEnv('SonarQube') {
	                sh "mvn verify sonar:sonar -Dsonar.projectKey=crawler-api -Dsonar.projectName='crawler-api'"
	            }        	
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
