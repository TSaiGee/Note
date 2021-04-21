---
typora-root-url: images
typora-copy-images-to: images
---

# MySQL8.0.21安装教程

### 配置环境变量

[获取Mysql8.0.21免安装绿色版](https://pan.baidu.com/s/1uaCmx4_PN37KkFRwj4dSfA) 有提取码的话就是TSai

解压到本地指定的文件夹，复制解压后的bin目录，配置环境变量

![1607408852385](/1607408852385.png)

点击path，编辑，新建，将刚才复制的目录粘贴来

![1607408795116](/1607408795116.png)

![1607408874345](/1607408874345.png)

确认关闭即可

### 建立配置文件

在解压完的mysql8.0.21文件夹下新建一个mysql.ini文件和一个名为data的文件夹

![1607409042889](/1607409042889.png)

打开mysql.in，粘贴以下代码，**注意两个位置** 

```bash
[mysql]
 
# 设置mysql客户端默认字符编码形式
 
default-character-set=utf8mb4
 
[mysqld]
 
#设置端口号，默认3306
 
port = 3306
 
# 设置mysql的安装目录,注意此目录为解压完的bin目录，每个人都不一样！！！！！！！！
 
basedir=D:\mysql-8.0.21-winx64\bin
 
# 设置mysql数据库的数据存放目录，也就是刚才新建的data文件夹位置！！！！！！！
 
datadir=D:\mysql-8.0.21-winx64\data
 
# 设置最大连接数
 
max_connections=200
 
# 允许连接失败的次数
 
max_connect_errors=10
 
# 服务端使用的字符集默认为utf8mb4
 
character-set-server=utf8mb4
 
# 创建新表时将使用的默认存储引擎
 
default-storage-engine=INNODB
 
# 默认使用“mysql_native_password”插件认证
 
#mysql_native_password
 
default_authentication_plugin=mysql_native_password
 
[client]
 
# 设置mysql客户端连接服务端时默认使用的端口
 
port=3306
 
default-character-set=utf8mb4
```

粘贴完毕保存关闭即可

### 命令提示符配置

win10 按win+s 输入命令提示符并以管理员身份运行

![1607409222726](/1607409222726.png)

进入cmd后输入mysql -install

![1607409394276](/1607409394276.png)

如下图提示则说明已经安装过mysql，可以选择卸载重装或者用已经安装过的mysql

重新打开一个cmd窗口，输入

```bash
#查看名为mysql的服务
sc query mysql
```

![1607409635712](/1607409635712.png)

输入

```bash
#删除已经安装过的mysql服务
sc delete mysql
```

![1607409687373](/1607409687373.png)

然后重新执行安装，输入

```bash
mysqld -install
```

![1607409772517](/1607409772517.png)

如图所示则安装成功，若提示

![1607409808811](/1607409808811.png)

则需要安装visual studio运行库,下载地址如下，选择对应版本下载后无脑安装即可

[x64](https://aka.ms/vs/16/release/vc_redist.x64.exe)   	 [x86](https://aka.ms/vs/16/release/vc_redist.x86.exe)

安装完成过重新以管理员身份打开cmd，输入mysqld -install即可安装成功

![1607409772517](/1607409772517.png)

而后输入

```bash
#初始化
mysqld --initialize-insecure --user=mysql
```

![1607410025420](/1607410025420.png)

再输入

```bash
#启动数据库
net start mysql
```

![1607410201604](/1607410201604.png)

输入

```bash
mysql -u root -p
```

![1607410226328](/1607410226328.png)

这时候直接回车，出现下图

![1607410275811](/1607410275811.png)

此时输入

```bash
#修改root密码为password，如需设置其他密码，更改password即可
alter user user() identified by "password";
```

密码修改成功会显示下图

![1607410372554](/1607410372554.png)

而后输入

```bash
#退出mysql
exit
```

### 重启MySQL

输入

```bash
#停止mysql服务
net stop mysql
#启动mysql服务
net start mysql
#root用户登录
mysql -u root -p
#输入刚才设置的密码，我设置的是password，输入即可进入mysql
```

运行效果如图所示

![1607410585986](/1607410585986.png)

以上，mysql安装成功

### 注意

+ 配置环境变量，注意bin的目录

+ 配置mysql.ini时，注意修改bin和data的目录

+ 其他没啥难的，代码直接复制就行，自己敲别输入错了

+ 设置完成的mysql是开机自启动的，若设置开机默认不启动，按照以下设置。

  > ![1607476399101](/1607476399101.png)

  > ![1607476412681](/1607476412681.png)>>

  > ![1607476423199](/1607476423199.png)

  > ![1607476454487](/1607476454487.png)

# navicat安装

下载[文件](https://pan.baidu.com/s/1iYJshHcdbeH-Ys0Pm4uvZw)到本地，有提取码的话输入TSai，解压后安装navicat到指定目录，安装完毕后点击破解程序，选择到navicat安装的目录，选择可执行文件进行破解。

 ![1607477631662](/1607477631662.png)