pipeline {
    agent any
    tools {
        maven 'mvn'
        jdk 'jdk'
    }
    stages {
        stage ('Build Stage') {
            steps {
                withMaven(maven : 'mvn') {
                    bat 'mvn clean install'
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
        stage ('Email Notification') {
            steps {
                mail bcc: '', body: '''
                Dear all. 
                The new deployment for BRI TEST env was done.

                Thank you.''', cc: '', from: '', replyTo: '', subject: 'BRI TEST - Deployment Successfully ', to: 'ledangkhoa95@outlook.com.vn'
            }  
        }
    }
}
