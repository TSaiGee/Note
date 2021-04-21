---
typora-root-url: images
typora-copy-images-to: images
---

# 简介

## 企业级开发

+ **数据库**：关系型数据库（Oracle，Mysql）/  非关系型数据库（Redis缓存数据库）

  > 增删改查等

+ **Java SE**

+ **前端**（H5，CSS3，ES6，框架等）

  > 学习做一个页面

+ **Java EE** 

+ **框架** 

+ **项目** 

+ **Linux / 实施相关** 



## Git技术

> git是一个开源的分布式版本控制软件

![](/13614469-122ef2c843d4edb7.webp)

+ **worksapce** ：工作区  ，编写代码的位置
+ **Index** ：暂存区，暂时存储代码
+ **Repository** ：仓库区，本地代码存储区域
+ **Remote** ：远程仓库，代码云仓库（GitHub，Gitee）

### 新建远程仓库

注册登录Gitee，新建仓库

> ![1607326743910](/1607326743910.png)

> ![1607327099490](/1607327099490.png)

### Git安装

#### 下载官方[Git]([Git - Downloads (git-scm.com)](https://git-scm.com/downloads) )安装

除图下所示需选择第一个，其他都选择默认设置 

> ![1607327802610](/1607327802610.png)[]()

安装成功

> ![1607327863516](/1607327863516.png)

#### 配置Git

##### 全局配置

第一次使用git需要配置邮箱账户

```bash
git config --global user.name "TSaiGee"
git config --global user.email "tsaigee@163.com"
```

##### 关联远程仓库 

###### 建立本地仓库并关联远程仓库

```bash
#建立名为java_study的文件夹
mkdir java-study
#加载该文件夹
cd java-study
#初始化本地库
git init
touch README.md
#add到本地暂存区index
git add README.md
#commit到本地库repository
git commit -m "first commit"
#关联到命名为origin的远程仓库remote
git remote add origin https://gitee.com/TSaiGee/java-study.git
#推送到被命名为origin的远程库的master分支
git push -u origin master
```

###### 直接克隆远程仓库到本地

```bash
#克隆远程仓库到本地，克隆完成后本地会出现一个和远程仓库同名的文件夹
git clone 仓库地址
```

如果无法上传到远程库，则需要先关联远程库

```bash
git remote add origin https://xxxxx
```

##### 从远程仓库下载文件到本地

```bash
#链接远程仓库
git remote add origin 仓库地址
#下载文件到本地
git pull origin master
```

#####　总结

+ 配置远程仓库 **重点** 

  > 可以新建本地仓库并关联远程仓库  git remote add 名字 地址
  >
  > 或直接克隆远程仓库到本地             git clone  地址

  

+ 本地工作区编辑

+ add到暂存区

+ commit提交到本地仓库

+ push到远程仓库

+ pull从远程仓库下载