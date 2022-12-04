pipeline {
    agent any
    parameters {
        gitParameter name: 'TAG',
                     type: 'PT_TAG',
                     defaultValue: 'v1.0.0'
    }
    environment{
        harborHost = '192.168.182.129:80'
        harborRepo = 'repo'
        harborUser = 'admin'
        harborPasswd = 'Harbor12345'
        //tag = "$params.TAG"
    }

    // 存放所有任务的合集
    stages {

        stage('拉取Git代码') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: "${TAG}"]], extensions: [], userRemoteConfigs: [[url: 'http://192.168.182.129:8929/root/blog']]])
            }
        }

        stage('构建代码') {
            steps {
                sh '/var/jenkins_home/maven/bin/mvn clean package -DskipTests'
            }
        }

        stage('制作自定义镜像并发布Harbor') {
            steps {
                sh '''mv ./target/*war ./docker
docker build -t ${JOB_NAME}:${TAG} docker/'''

                sh '''docker login -u ${harborUser} -p ${harborPasswd} ${harborHost}
                docker tag ${JOB_NAME}:${TAG} ${harborHost}/${harborRepo}/${JOB_NAME}:${TAG}
                docker push ${harborHost}/${harborRepo}/${JOB_NAME}:${TAG}'''
            }
        }
        
        stage('目标服务器拉取镜像并运行') {
            steps {
                echo "$harborHost" 
                echo "$harborRepo" 
                echo "$JOB_NAME" 
                echo "$TAG"
                echo "$host_port"
                echo "$container_port"
                sshPublisher(publishers: [sshPublisherDesc(configName: 'MY_VM', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: 'deploy.sh $harborHost $harborRepo $JOB_NAME $TAG $host_port $container_port', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])

                //sshPublisher(publishers: [sshPublisherDesc(configName: 'MY_VM', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: 'echo $TAG', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
            }
        }
    }
}
