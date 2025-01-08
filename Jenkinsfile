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
	                sh "mvn sonar:sonar -Dsonar.token=sqp_1bc2b10691bebe80392c36832cad77061b3c4b1a"
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
