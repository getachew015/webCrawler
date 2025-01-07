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
	                sh "mvn sonar:sonar -Dsonar.token='sqa_da7a7697fe6297338835173e837c1c69037b25f4'"
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
