---
typora-root-url: images
typora-copy-images-to: images
---

# MySQL约束

### 主键约束 Primary Key

保证记录唯一，**一张表必须有主键** 

该字段不能有空值，不能有重复的值，一张表仅有一个主键，一般自动生成（auto_increment）

```bash
create table student(
`id` BIGINT,
`name` varchar(255),
`gender` tinyint(1),
`birth` date,
`job` enum('班长','学委','文娱'),
`course` set('java','python','大数据','C#'),
#设置id字段为主键
PRIMARY KEY(id)
);

```



### 唯一键约束 Unique

该字段可以为空，不能有重复的值，一张表可以有多个唯一键

```bash
create table user_(
`id` BIGINT auto_increment,
`name` varchar(255),
`idCard` varchar(255),
PRIMARY KEY(`id`),
#定义idCard字段为唯一键，使不能为重复的值
UNIQUE(`idCard`),
)auto_increment = 100;

```



### 非空约束 NOT NULL

```bash
create table user_(
`id` BIGINT auto_increment,
#定义name字段的值不为空
`name` varchar(255) NOT NULL,
`idCard` varchar(255),
PRIMARY KEY(`id`),
UNIQUE(`idCard`),
)auto_increment = 100;

```

**unique + not null** 可以达到 定义字段的值 **不重复且不为空**的效果，类似主键但是并不是主键，使用较少



### 外键约束 Foreign Key

```bash
#新建两个表，学生&班级
create table student(
`id` bigint auto_increment,
`name` varchar(255) not null,
`cnum` int(4),
PRIMARY KEY(`id`)
);

create table `class` (
`id` int(4) auto_increment,
`cname` varchar(255) not null,
PRIMARY KEY(`id`)
);

#由表可知，student表中的cnum的取值范围取决于class表中的id，此时需要引入外键
#重新建立student表加入外键约束，student依赖于class，故先创建class，在创建student
create table student(
`id` bigint auto_increment,
`name` varchar(255) not null,
`cnum` int(4),
PRIMARY KEY(`id`),
#定义cnum为外键，连接到class表的id字段
#注意这两个字段的属性需要一致，且被连接的键应该为唯一键或主键
FOREIGN KEY(`cnum`) REFERENCES class (`id`)
);

create table class (
`id` int(4) auto_increment,
`cname` varchar(255) not null,
PRIMARY KEY(`id`)
);

#此时向class中插入数据
insert into class VALUES
(DEFAULT,'1班'),
(DEFAULT,'2班');

#限制了class中id的字段为1和2，此时若插入student中cnum的字段值非1或2，则会报错
insert into student VALUES
(DEFAULT,'bob',3),
(DEFAULT,'dily',2);
#报错
[Err] 1452 - Cannot add or update a child row: a foreign key constraint fails (`test`.`student`, CONSTRAINT `student_ibfk_1` FOREIGN KEY (`cnum`) REFERENCES `class` (`id`))
#此时修改3为1或2即可

```

（Oracle还有一个检查性约束）



# MySQL标准建表

```bash
#建表语法：列名 数据类型 约束 默认值 备注
CREATE TABLE `order`(
	`id` INT auto_increment,
	`orderid` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '订单号',
	`orderdate` datetime NOT NULL DEFAULT NOW() COMMENT '下单时间',
	`orderstate` INT NOT NULL DEFAULT 3 COMMENT '订单状态' COMMENT '1-未付款/2-已付款/3-未结算',
	PRIMARY KEY (`id`)
);
```

> ![1607587021953](/1607587021953.png) 
>
> 新建的空订单表



#  MySQL 插入数据

```bash
#单条插入
insert into `order` 
(id,orderid,orderdate,orderstate)#当所有字段都插入数据的时候可以省略该行，如下多条插入。
VALUES 
(DEFAULT,001,'2020-12-10 15:50:30',1);
#多条插入
insert into `order` 
VALUES 
(DEFAULT,002,DEFAULT,1),
(DEFAULT,003,DEFAULT,2),
(DEFAULT,004,DEFAULT,DEFAULT);
```

# MySQL查询

下面讲解mysql查询,首先按照下表新建数据库,数据表emp和数据表dept

表emp结构

> ![1607673105879](/1607673105879.png) 

表dept结构

> ![1607673175568](/1607673175568.png) 

两个表格的数据

> ![1607669380854](/1607669380854.png)

### 简单查询

```bash
#查询所有数据
select * from emp;
#等同于
select empno,ename,job,mgr,hiredate,,sal,comm,deptno from emp;

#查询指定列数据
select empno,ename from emp;

#表达式查询
select 字段&算式 from 表名;

#去重查询
select DISTINCT 字段 from 表名;
```

**注意null与任何值相加结果为空,股可以设置 ifnull(column,0),将为null的列值转化为0后进行运算**

### WHERE 条件查询 

```bash
select 列名 from 表名 where 条件；
#查询在部门20的员工信息
select * from emp 
where 
deptno = 20;
```

######between  ...  and ..

```bash
#查询月薪在5000-7000内的所有员工姓名 between ... and ...
select ename as 员工姓名 from emp
where 
sal BETWEEN 5000 and 7000;
```

###### in(... , ...)

```bash
#查询职位是clerk或者saleman的员工姓名 in (x,x)
SELECT ename as 员工姓名 from emp
where 
job in ('saleman','clerk');
```

###### like 模糊查询 

```bash
#%任意多个字符   /   _一个字符  模糊查询不能用于查询日期

#查询姓名以A开头的员工姓名
select ename as 员工姓名 from emp
where
ename like 'A%';

#查询姓名中含有A的员工姓名
select ename as 员工姓名 from emp
where
ename like '%A%';

#查询姓名以A结尾的员工姓名
select ename as 员工姓名 from emp
where
ename like '%A';

#查询姓名两位且第二位是L的员工姓名
select ename as 员工姓名 from emp
where
ename like '_L';

#查询姓名第二位是L的员工姓名
select ename as 员工姓名 from emp
where
ename like '_L%';

#查询姓名倒数第二位是L的员工姓名
select ename as 员工姓名 from emp
where
ename like '%L_';
```

###### is null 查询空值

```bash
#查询奖金为空的员工姓名
select ename,comm from emp
where comm IS NULL;
```

###### and / or /not

```bash
#查询20部门职位为clerk的员工的姓名  AND
select ename as 员工姓名 from emp
WHERE
deptno = 20
AND
job = 'clerk';
```

######order by  查询结果排序  

```bash
#查询员工姓名职位工资,并将结果按照工资升序排列
SELECT ename,job,sal from emp
ORDER BY sal;

#查询员工姓名职位工资,并将结果按照工资降序排列
SELECT ename,job,sal from emp
ORDER BY sal DESC;

#查询结果可以按照别名排序
SELECT ename,job,sal*12+IFNULL(comm,0) as 年薪 from emp
ORDER BY 年薪;

#可以按照多个列排序
#查询员工信息,按照部门升序,工资降序
SELECT * from emp 
order BY
deptno,
sal DESC;
```

######limit 分页

```bash
#查询从0行开始,长度为5的数据记录
SELECT * from emp
limit 0,5; 
```

##### union 联合select的结果

```bash
#查找dept和emp表中的deptno，并将其整理到一起且去重
SELECT deptno 
FROM emp
UNION #不想去重 使用 union all即可
SELECT deptno
FROM dept;
```

##### group by 分组

有一个登录记录表

> ![1607761129309](/1607761129309.png) 

```bash
#现在想查询每个人登录的总次数，则用到group by，查询signin，并按照名字分组
select name , SUM(signin) as 次数 
from employee_tb1
GROUP BY name;
```

> ![1607761252225](/1607761252225.png)  