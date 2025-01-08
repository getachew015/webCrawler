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
	                sh "mvn sonar:sonar -Dsonar.token=sqp_8b586ba1ad5ca1828e741d8159e1115ed64d1802"
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
