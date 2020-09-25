------

# Docker 

> Author：hailong.sha@sap.com

## 简介



## 1. Docker Image

### 获取镜像

docker pull ubuntu: 会从Docker Hub仓库拉取最新的镜像，其标签是latest

docker pull ubuntu:18.04：或拉取Tag为18.04的Ubuntu镜像

### 查看镜像

docker image ls/docker images：

docker tag ubuntu:latest myubuntu:200808：添加一个新的镜像myubuntu:200808，这个镜像的id和ubuntu:latest是一样的，他们其实指向了同一个文件，只是tag的别名不同而已。

docker inspect ubuntu:18.04

docker history ubuntu:18.04

### 查找镜像

docker search nginx

docker search -f=is-official=true nginx

### 删除/清理镜像

docker image rm/docker rmi [IMAGE...]：IMAGE可以是标签或者id

docker rmi myubuntu:200808

docker rmi 2eb2d388e1a2

docker image prune：可以清理系统中遗留的一些临时性镜像文件和没有使用的镜像

### 创建镜像

先启动一个镜像，并在里面新建一个txt文件

docker run -it ubuntu:18.04 /bin/bash

root@dfdf6b426e24:/# touch hello.txt
root@dfdf6b426e24:/# exit

记住这个容器的id是dfdf6b426e24，然后使用以下命令提交即可：

docker commit -m "Add a new file" -a "hailong.sha@sap.com" dfdf6b426e24 mytest:1.1

### 载入/载出镜像

docker save -o kafka.tar saas-docker-pvg.pvgl.sap.corp/bizx/kafka:2.11-1.1.0

载入镜像

docker load -i kafka.tar

or

docker load < kafka.tar

### 上传镜像

docker push user/user:latest

## 2. Docker Container

Docker容器主要的命令有create，start，run，wait，logs

docker create/start

```shell
 $  docker create -it ubuntu:latest
ac5623fb8e929ea9f57ec2cf4298a18056dff5940b5bf8b160a23b2508ce4b06
```

create的容器处于停止状态，docker ps是看不到的，要使用docker ps -a才能看到，使用docker start才能启动这个容器

> docker ps -a
> CONTAINER ID        IMAGE                                                 COMMAND                  CREATED             STATUS              PORTS                    NAMES
> ac5623fb8e92        ubuntu:latest                                         "/bin/bash"              19 seconds ago      Created                                      great_volhard

使用**docker start ac**就可以启动这个docker容器了，ac是容器IDac5623fb8e92的简写。

docker [container] run 

新建并启动容器，等价于先执行docker [container] create，再执行docker [container] start命令。 

相关参数：

-d：表示以守护态运行

-i：打开标准输入

-t：分配一个伪终端

查看容器输出：

docker [container] logs containerId

停止容器

暂停容器：docker [container] pause containerName

暂停恢复：docker [container] unpause containerName

终止容器：docker [container] stop containerId，处于终止状态的容器可以通过docker [container] start来重新启动。

进入容器：docker [container] exec -it containerId /bin/bash

删除容器：docker [container] rm containerId

导入容器：

docker export -o /home/C5294803/Document/myubuntu_18.tar containerId

Or

docker export containerId >  /home/C5294803/Document/myubuntu_18.tar

导出容器：

docker import myubuntu_18.tar - test/ubuntu:18.04

查看容器：

docker container inspect containerName

复制文件

docker container cp bookmarks_2020_08_11.html sapubuntu:/root/

将当前目录下的bookmarks_2020_08_11.html拷贝到sapubuntu容器的/root/目录下。

查看变更

docker container diff

查看端口映射

docker container port containerName



