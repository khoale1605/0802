pipeline {
    agent any
    tools {
        maven 'mvn'
        jdk 'jdk'
    }
    stages {
        stage ('Build Stage') {
            steps {
                build "Build Stage"
                }
            }
        }
        stage ('Test Stage') {
            steps {
                withMaven(maven : 'mvn') {
                    bat 'mvn clean install'
                }
            }
        }
        stage ('Deployment Stage') {
            steps {
                withMaven(maven : 'mvn') {
                    bat 'mvn clean install'
                }
            }
        }
        stage('Msg Notification') {
            steps {                                
                build "msg-notification"               
            }
        }
    }
}
