pipeline {
    agent { 
		docker{
	 		image "maven:3.8.1-jdk-8"
	 		label "docker"	  	
		  }
	}
    stages {
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