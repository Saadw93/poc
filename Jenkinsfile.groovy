pipeline {
    environment {
        PATH = '/opt/java/openjdk/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/tmp/apache-maven-3.9.7/bin:/tmp/docker-26.1.4/docker'
    }
agent any
stages {
    stage("Build") {
      steps {
        git url: 'https://github.com/seanpmaxwell/simple-spring-boot.git'
        withMaven {
          sh "ls -lart"
          sh "pwd"
        }
      }
    }
    stage('Build with Maven') {
      steps {

                  sh 'mvn -B -DskipTests clean package'
            }
        }
    stage('Docker Build') {
      agent any
      steps {
        sh 'docker build -t saadw/jenkinspoc:1 .'
      }
    }
        } 
 }