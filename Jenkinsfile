pipeline {
    agent any
    environment{
        harborHost = '192.168.182.129:80'
        harborRepo = 'repo'
        harborUser = 'admin'
        harborPasswd = 'Harbor12345'
    }

    // 存放所有任务的合集
    stages {

        stage('拉取Git代码') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'http://192.168.182.129:8929/root/blog']]])
            }
        }

        stage('构建代码') {
            steps {
                sh '/var/jenkins_home/maven/bin/mvn clean package -DskipTests'
            }
        }

        stage('制作自定义镜像并发布Harbor') {
            steps {
                sh '''cp ./target/*.jar ./docker/
                cd ./docker
                docker build -t ${JOB_NAME}:${tag} ./'''

                sh '''docker login -u ${harborUser} -p ${harborPasswd} ${harborHost}
                docker tag ${JOB_NAME}:${tag} ${harborHost}/${harborRepo}/${JOB_NAME}:${tag}
                docker push ${harborHost}/${harborRepo}/${JOB_NAME}:${tag}'''
            }
        }
        
        stage('目标服务器拉取镜像并运行') {
            steps {
                sshPublisher(publishers: [sshPublisherDesc(configName: 'MY_VM', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: 'deploy.sh $harborHost $harborRepo $JOB_NAME $host_port $container_port', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
            }
        }
    }
}
