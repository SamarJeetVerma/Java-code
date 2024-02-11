pipeline {
    agent any




    stages {
        stage('Clean Compile') {
            steps {
                
                // Clean and compile.
                sh "mvn clean compile"



           }
        }
        
        stage('Test') {
            steps {
                
                // Test Cases.
                sh "mvn test"



           }
        }
        
        stage('Install') {
            steps {
                
                
                sh "mvn install"



           }
        }
        
        /*stage('SonarQube Analysis') {
            steps {
                // Analyzing code.
                withSonarQubeEnv('sonar'){
                    sh "mvn sonar:sonar"
                    }
            }
        }
        stage ('Artifactory Configuration') {
            steps {
                rtServer (
                    id: "artifactory",
                    url: "http://192.168.56.103:8082/artifactory",



               )



               rtMavenResolver (
                    id: 'maven-resolver',
                    serverId: 'artifactory',
                    releaseRepo: 'libs-release',
                    snapshotRepo: 'libs-snapshot'
                )  
                 
                rtMavenDeployer (
                    id: 'maven-deployer',
                    serverId: 'artifactory',
                    releaseRepo: 'libs-release-local',
                    snapshotRepo: 'libs-snapshot-local'
                )
            }
        }
        
        stage('upload') {
           steps {
              script {
                 def server = Artifactory.server 'artifactory'
                 def uploadSpec = """{
                    "files": [{
                       "pattern": "/var/lib/jenkins/workspace/sonarqube-pipeline-1/target/SMVC.war",
                       "target": "project-libs-snapshot-local"
                    }]
                 }"""



                server.upload(uploadSpec)
               }
            }
        }*/
        
       stage('Build docker image'){
            steps{
                script{
                    sh 'sudo -n docker build -t smvc .'
                }
            }
        }
        
        stage('Publish to aws'){
            steps{
                script{
                    sh 'aws configure set aws_access_key_id AKIA4YIGYVHJTLQFFDOJ'
         
                    sh 'aws configure set aws_secret_access_key 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'
         
                    sh 'aws configure set default.region ap-northeast-1'
                    
                    sh 'aws ecr get-login-password --region ap-northeast-1 | docker login --username AWS --password-stdin 876724398547.dkr.ecr.ap-northeast-1.amazonaws.com'
                    
                    sh 'docker tag smvc:latest 876724398547.dkr.ecr.ap-northeast-1.amazonaws.com/jenkins_sam_aws:latest'
                    
                    sh 'docker push 876724398547.dkr.ecr.ap-northeast-1.amazonaws.com/jenkins_sam_aws:latest'
                }
            }
        }
        
        stage('aws'){
            steps{
                script{
                    
         
                    sh 'ssh "-o StrictHostKeyChecking=no" -i "/opt/sam.pem" ec2-user@35.77.97.76 aws ecr get-login-password --region ap-northeast-1 | docker login --username AWS --password-stdin 876724398547.dkr.ecr.ap-northeast-1.amazonaws.com '
                    
                    sh 'ssh "-o StrictHostKeyChecking=no" -i "/opt/sam.pem" ec2-user@35.77.97.76 docker pull 876724398547.dkr.ecr.ap-northeast-1.amazonaws.com/jenkins_sam_aws:latest'
                    
                    sh 'ssh "-o StrictHostKeyChecking=no" -i "/opt/sam.pem" ec2-user@35.77.97.76 docker run -p 8087:8080  876724398547.dkr.ecr.ap-northeast-1.amazonaws.com/jenkins_sam_aws:latest'
                }
            }
        }


       
}
}