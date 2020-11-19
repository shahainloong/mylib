------

# IDE Configuration

## 1. IDEA

官网：https://www.jetbrains.com/

### 常用插件

SequenceDiagram:一键生成时序图
Maven Helper:分析Maven项目的相关依赖
EasyCode:一键帮你生成所需代码
SonarLint:帮你优化代码
Lombok:帮你简化代码
Git Commit Template:使用模板创建commit信息
leetcode editor :提供在线 Leetcode 刷题功能，比较方便我们刷题
RestfulToolkit—RESTful服务开发
Key Promoter X—快捷键
Alibaba Java Code Guidelines—阿里巴巴 Java 代码规范

GitToolBox--可以像eclipse一样在项目屁股后面显示git信息

jclasslib bytecode viewer--是一个可以可视化已编译Java类文件和所包含的字节码的工具。 另外，它还提供一个库，可以让开发人员读写Java类文件和字节码。

> GitHub地址：https://github.com/ingokegel/jclasslib

### 通用配置

Eclipse和IDEA调试ArrayList，HashMap等集合的时候想查看这些集合的详细内部情况，Eclipse和IDEA都做了视图优化的，所以看到的一般都是精简的结构，要完全看到需要做一下设置
IDEA：Settings--Build,Execution,Deploymeng--Debugger--Data Views--Java:
去掉Enable alternative view for Collection classes



### 实用技巧

日常重构技巧：https://blog.jetbrains.com/zh-hans/idea/2020/09/intellij-idea/



## 2. Spring Tool Suite

原来叫Spring Tool Suite 3，简称sts，后来升级成了Spring Tool 4。

> ```
> 下载地址：https://spring.io/tools
> ```

### 常用插件

### 通用配置

Eclipse和IDEA调试ArrayList，HashMap等集合的时候想查看这些集合的详细内部情况，Eclipse和IDEA都做了视图优化的，所以看到的一般都是精简的结构，要完全看到需要做一下设置
IDEA：Settings--Build,Execution,Deploymeng--Debugger--Data Views--Java:
去掉Enable alternative view for Collection classes
Eclipse:在Variables视图中右上角有个很小的按钮Show Logical Structure默认是选中的，再次单击一次就好

## 3. Chrome 插件

Postman

![sap_cp_pe_apply_account_for_rjp](./../images/chrome_extetion_postman.png)

Ghelper 

国内可以访问谷歌的插件，官网地址：https://ghelper.xyz/

下载zip包后解压缩出来，里面有使用说明

1.打开你的Chrome浏览器的 更多工具>扩展程序页面.
或者直接在网址输入: chrome://extensions/

2.这个页面点击 "添加已解压的扩展程序",如果没有，在右边有一个 “开发者模式” 开关，要打开.
3.选择本次下载包里的 ghelper_source 目录
4.确认后就行了.

登录Ghelper，采用46qq/c19登录，登陆后就可以使用谷歌浏览器了。



## 4. Java注释

在java的注释/***/中，所有的文字都是在一行显示的，因此需要一些HTML标签来美化下显示的内容。

| <p>标签                                                   | 表示换行                                                    |
| --------------------------------------------------------- | ----------------------------------------------------------- |
| <blockquote><pre> String str = "abc"; </pre></blockquote> | 居中显示，换行有效                                          |
| <tt>null</tt>                                             | 在注释用到其他的类名可以用该标签格式化,会使类名显示与众不同 |
| <ul><li>unordered list</li></ul>                          | 无序列表                                                    |
| <ol><li>ordered list</li></ol>                            | 含有数字123的有序列表                                       |
|                                                           |                                                             |

@Annotation标签

| @author  Echo Sha                                          | 显示作者                                                     |
| ---------------------------------------------------------- | ------------------------------------------------------------ |
| @see     java.lang.Object#toString()                       | 参考toString方法                                             |
| @since   JDK1.0                                            | 从哪个版本开始                                               |
| @param   loader the class loader to define the proxy class | 显示参数，loader是参数名，空格+参数说明                      |
| {@link java.lang.Character Character}                      | 链接跳转到Character类，java.lang.Character是类名，第二个Character是显示的文字 |
| {@code String}                                             |                                                              |

