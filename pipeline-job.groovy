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
                Dear all,

                This email is sent for purpose test build pipeline job from our Jenkins local.

                Best Regards.''', cc: 'khoadang.le2@dxc.com, dangkhoa22031995@gmail.com', from: '', replyTo: '', subject: 'Build Test', to: 'ledangkhoa95@outlook.com.vn'
            }   
        }   
    }
}
