pipeline {
    agent any
    
    
    tools {
        // Define Maven tool named 'Maven'
        jdk 'JAVA_HOME'
        maven 'Maven'
    }


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
                withSonarQubeEnv('Sonarqube-server-7.6'){
                   //sh "mvn sonar:sonar"
                   //sh "mvn sonar:sonar -Dsonar.projectKey=my-code-test-2 -Dsonar.host.url=http://54.162.209.11:9000 -Dsonar.login=f5c44e4b9c7d15abdd971822a723dafb0ed4a3dc"
                     }*/
              
            }
}
        
     /*   stage ('Artifactory Configuration') {
             steps {
                 rtServer (
                     id: "artifactory",
                     url: "http://54.145.109.98:8082/artifactory",

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
                        "pattern": "/var/lib/jenkins/workspace/Assignment-1/target/SMVC.war",
                        "target": "project-libs-snapshot-local"
                     }]
                  }"""



                 server.upload(uploadSpec)
                }
             }
         }

    }
} */
        
  /*     stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t smvc .'
                }
            }
        }

        stage('Aws_login'){
            steps {  
                script{
                  withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws_cred', 
                              accessKeyVariable: 'AWS_ACCESS_KEY_ID', 
                              secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) 
                    {
                    sh "aws configure set aws_access_key_id $AWS_ACCESS_KEY_ID"
                    sh "aws configure set aws_secret_access_key $AWS_SECRET_ACCESS_KEY"
                    sh "aws configure set region us-east-1"
                    sh "aws ecr get-login-password --region us-east-1 > ecr-login.txt"
                    sh "docker login --username AWS --password-stdin 876724398547.dkr.ecr.us-east-1.amazonaws.com < ecr-login.txt"
                     
                    }
                    
                sh 'true'
            }
        }
        }
        
        stage('Publish to aws'){
            steps{
                script{

                  //sh  'aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 876724398547.dkr.ecr.us-east-1.amazonaws.com'
                   sh 'docker tag smvc:latest 876724398547.dkr.ecr.us-east-1.amazonaws.com/jenkins-project:latest' 
                    
                   sh 'docker push 876724398547.dkr.ecr.us-east-1.amazonaws.com/jenkins-project:latest'
                }
            }
        }
}
}  */

//         stage('aws'){
//             steps{
//                 script{
                    
         
//                     sh 'ssh "-o StrictHostKeyChecking=no" -i "/opt/sam.pem" ec2-user@35.77.97.76 aws ecr get-login-password --region ap-northeast-1 | docker login --username AWS --password-stdin 876724398547.dkr.ecr.ap-northeast-1.amazonaws.com '
                    
//                     sh 'ssh "-o StrictHostKeyChecking=no" -i "/opt/sam.pem" ec2-user@35.77.97.76 docker pull 876724398547.dkr.ecr.ap-northeast-1.amazonaws.com/jenkins_sam_aws:latest'
                    
//                     sh 'ssh "-o StrictHostKeyChecking=no" -i "/opt/sam.pem" ec2-user@35.77.97.76 docker run -p 8087:8080  876724398547.dkr.ecr.ap-northeast-1.amazonaws.com/jenkins_sam_aws:latest'
//                 }
//             }
//         }


       
// }
// }

