------

# Gradle

> Author：hailong.sha@sap.com

## 简介

DSL：

## 1. 常用命令

```groovy
task helloWorld{
    doLast {
        println('hello world')
    }
}
```

等价于：

```groovy
task helloWorld << {
    println('hello world')
}
```

任务可以缩写，比如gradle helloWorld可以缩写成gradle hW。

gradle properties可以查看所有的默认属性值。

更改属性值：

```groovy
sourceSets {
    main{
        java{
            srcDirs = ['src'] // 用不同的列表代替约定的源代码
        }
    }
}
buildDir = 'out' // 改变项目输出属性（默认是build文件夹）到out目录
```

包装器：

需要第一次使用gradle wrapper运行一次，后面使用gradlew或者gradlew.bat

使用属性：

```groovy
ext {
    junitVersion = '5.6.2' // definition 1
}
setDescription("Here is description")
project.ext.projExtValue = 'my value' // definition 2
task helloWorld{
    doLast {
        println 'Description is ' + project.getDescription()
        println "The value from ext properties is: $project.junitVersion" // output 5.6.2
        println "The value from project.ext properties is: $projExtValue" // output my value
        println "The value from gradle.properties is: $keyfromproperties" // keyfromproperties is defined at gradle.properties
    }
}
```

### Task

action是再task中合适的地方放置的构建逻辑，Task接口提供了两个相关的方法来声明task的动作：doFirst(Closure)和doLast(Closure)。

```groovy
task printVersion(group: 'myac', description: 'This is my first description') {
    doFirst {
        println 'Here is the first action'
    }
    doLast {
        println "The current version is: $version"
    }
}
```

## 依赖缓存

Maven仓库依赖和flat依赖

```groovy
repositories {
    flatDir {
        dirs 'libs'
    }
    mavenLocal()
    maven { url "http://nexusext.wdf.sap.corp:8081/nexus/content/groups/build.releases.3rd-party" }
    mavenCentral()
}
```

排除依赖

```groovy
dependencies {
    compile ("org.elasticsearch.plugin:mapper-attachments:2.4.4"){
        exclude group:"org.bouncycastle", module:"bcprov-jdk15on"
    }
}
```

## 多项目构建

### Setting文件