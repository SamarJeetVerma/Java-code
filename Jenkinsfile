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
    
     stage('SonarQube Analysis') {
          steps {
            // Analyzing code.
                withSonarQubeEnv('Sonarqube-server-7.6'){
                   //sh "mvn sonar:sonar"
                   //sh "mvn sonar:sonar -Dsonar.projectKey=my-code-test-2 -Dsonar.host.url=http://54.162.209.11:9000 -Dsonar.login=f5c44e4b9c7d15abdd971822a723dafb0ed4a3dc"
                     
                   sh "mvn clean verify sonar:sonar -Dsonar.projectKey=my-code-test-1 -Dsonar.projectName='my-code-test-1' -Dsonar.host.url=http://localhost:9000 -Dsonar.token=sqp_d7248bf2e64a38dc66124d6eac926db89604e6c0"                   }
              }
            
          }
           
    
        stage ('Artifactory Configuration') {
             steps {
                 rtServer (
                     id: "artifactory",
                     url: "http://localhost:8082/artifactory",

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

    

        
       stage('Build docker image'){
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


        stage('Helm-deploy'){
            steps{
                script{
                        withKubeConfig(caCertificate: '', clusterName: 'samar5.k8s.local', contextName: 'samar5.k8s.local', credentialsId: 'kube-config-file', namespace: '', restrictKubeConfigAccess: false, serverUrl: '')
            {
                sh 'kubectl delete service my-app-1'
                sh 'helm uninstall my-app-1'
                sh 'helm install my-app-1 ./my-app-1'
                
                sh 'export NODE_PORT=$(kubectl get --namespace default -o jsonpath="{.spec.ports[0].nodePort}" services my-app-1)'
                sh 'export NODE_IP=$(kubectl get nodes --namespace default -o jsonpath="{.items[0].status.addresses[0].address}")'
                sh 'echo http://$NODE_IP:$NODE_PORT'
                
                sh 'kubectl delete service nginx'
                sh 'helm uninstall nginx'
                sh 'helm install nginx ./nginx'
                sh 'export NODE_PORT=$(kubectl get --namespace default -o jsonpath="{.spec.ports[0].nodePort}" services nginx)'
                sh 'export NODE_IP=$(kubectl get nodes --namespace default -o jsonpath="{.items[0].status.addresses[0].address}")'
                sh 'echo http://$NODE_IP:$NODE_PORT'
            }
                }
                }
            }
    }
}



