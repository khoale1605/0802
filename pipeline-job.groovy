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
                mail bcc: '', body: '''
                Dear all,

                This mail is sending with purpose is testing build pipeline job from our Jenkins Server.

                Best Regards.''', cc: 'ledangkhoa95@outlook.com.vn', from: '', replyTo: '', subject: 'Test build', to: 'dangkhoa22031995@gmail.com'               
            }
        }
    }
}
