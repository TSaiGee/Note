---
typora-root-url: images
typora-copy-images-to: images
---

# Java语言特点

#### 简单

语法和c语言类似,去掉了指针,有自动的内存分配和回收机制

#### 面向对象

Java是一个面向对象开发的语言

#### 跨平台

安装有JVM的设备都可以运行Java程序

#### 分布式

Java语言支持Internet应用的开发，提供了各类网络编程用类库

#### 安全

网络安全防范机制（类classloader）和安全管理机制(securitymanager),让Java应用可以设置安全哨兵

#### 健壮

Java是强类型机制,异常处理,垃圾回收,抛弃指针与安全管理机制让Java更健壮

#### 解释型语言

Java是解释型的语言

#### 高性能

随着jit技术发展,Java速度接近Ｃ

#### 多线程

Java支持多线程同时执行,并提供了多线程之间的同步机制

#### 动态

Java程序需要的类可以动态载入运行环境,也可以通过网络载入,有利于软件的升级

# Java技术包含的工具

#### 编译器
#### 解释器
####文档生成工具
####类文件打包等

# JDK安装

[Java官网](https://www.oracle.com/java/technologies/javase-downloads.html) 选择jdk8下载(本教程使用的是JDK8),运行安装程序,记录jdk的安装目录.

####配置环境变量

win+s,搜索高级系统设置

> ![1608514698500](/1608514698500.png) 

打开,选择环境变量,点击path,编辑

>![1608514799297](/1608514799297.png) 

然后新建,获得刚刚安装的Java的jdk目录下的bin目录地址

> ![1608514978777](/1608514978777.png) 

粘贴到新建

> ![1608515007174](/1608515007174.png) 

然后确定

####验证JDK安装

再次在cmd下输入

```cmd
java -version
```

若显示Java版本号,证明JDK安装成功过

> ![1608531920662](/1608531920662.png)

# 运行第一条Java程序

在某一磁盘根目录下新建文本文档,打开后输入如下代码:(在根目录下新建是为了方便查找)

> ```java
> public class HelloWorld{
>     public static void main(String[] args){
>         System.out.println("Hello World");
>     }
> }
> ```

然后另存为HelloWorld.java文件

运行cmd,切换至刚才新建文件所在的磁盘,切换到D盘，则输入：

> ```cmd
> D:
> ```

然后输入

> ```cmd
> javac HelloWorld.java
> ```

编译Java文件,然后文件夹下会生成名为HelloWorld.class的文件,在cmd输入

> ```cmd
> java HelloWorld
> ```

在控制台会输出"Hello World"字样,程序运行成功.

但是使用终端运行Java文件程序效率较低,因此我们会使用集成开发环境开发Java,如Eclipse.