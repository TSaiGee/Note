# 高级查询

> 本节所用数据库同前课，[git下载连接](https://gitee.com/TSaiGee/library.git)

## 分组函数

> SUM()		求和	
>
> AVG()		求均值
>
> MAX()		最大值
>
> MIN()		最小值
>
> COUNT()		计数
>
> GROUP BY ()	按字段分组

分组函数是不计算空值的

where 是组前条件,having是组后条件.具体用法如下:

```mysql
-- 查询每个部门的最大工资,并找出2900以上的部门且按照名称分组
SELECT MAX(sal),dname
FROM emp
JOIN dept
ON emp.deptno = dept.deptno
WHERE MAX(sal) > 2900
GROUP BY dname;
-- 上面这种写法是非法的,原因是WHERE是组前函数，不能在GROUP BY（）函数内调用,正确的操作是:
SELECT MAX(sal),dname
FROM emp
JOIN dept
ON emp.deptno = dept.deptno
GROUP BY dname
HAVING MAX(sal) > 2900;
```



## 子查询

### 单行子查询

> 什么是子查询,举个例子一看便知:
>
> ```mysql
> -- 查询与编号是7788的工作一样的人的名字
> select ename from emp
> where job = (select job from emp where empno = 7788)
> ```
>
> 子查询也被称为嵌套查询,如上的
>
> ```mysql
> select job from emp where empno = 7788
> ```
>
> 即为子查询,用于为主查询返回其需要的数据

### 多行子查询

> any  任意
>
> all	所有
>
> 当子查询得到的数据有多行时候,这时候主查询中的一个数据是无法与子查询得到的多行数据相比较的.此时用到all 和 any
>
> all 多用于 大于如:
>
> ```mysql
> where A　＞ all B 
> ```
>
> 上式中A为主查询数据，B为子查询得到的多行数据,此时where A＞all B,说明要求的是A>B中最大的数据,自己体会
>
> 相反,any多用于小于,求最小值

##MySQL事务

事务(我觉得叫事件更好理解一些),是一系列数据库操作的组合.我们之前对于数据库的操作是执行完SQL语句，数据库内的内容直接变化．实际上在开发中我们这样的操作是不合法的．我们需要先执行SQL语句，查看运行结果，无误后再把这一串代码提交到数据库，让数据库执行代码，从而修改数据．而上述的＇一串代码＇，就可以称之为事务．

### 事务的属性

+ 原子性 一个事务中的所有操作都必须执行完毕,否则事务会在错误时终止并回滚到操作前的状态
+ 隔离性 不同的事务执行是相互独立互不干扰的
+ 一致性 若事务执行成功,数据库的状态会得到正确的改变
+ 永久性 事务执行后的效果是永久存在的,无法更改的.

### 事务的操作 

+ COMMIT 	提交

+ ROLLBACK     回滚

+ SAVEPOINT   创建可以用于回滚的事务还原点


#### commit:提交事务,保存事务对于数据库的更改

#### rollback:撤销尚未保存到数据库的事务(commit之前)

#### savepoint: 创建回滚用的事务还原点,使事务恢复到该还原点的状态

```mysql
-- 创建一个还原点
savepoint sp1;
```

```mysql
-- 恢复事务到指定还原点
rollback to sp1;
```

#### release savepoint: 删除还原点 

```mysq
release savepoint sp1;
```



### MySQL视图

没啥用,就是将一个查询结果创建成一张图,视图是根据数据库最新内容显示的.

```mysql
-- 创建视图
create view view_bame
as
select column1,column2..
from table_name
where ...;

-- 删除视图
drop view view_name;
```



### MySQL索引

MySQL索引可以大大加快查询速度,但是过多的索引会导致增删改的运行速度下降,以及占用过多的内存,

#### 创建索引

```mysql
-- 创建表时指定
create table mytab(
eid,int not null,
ename,varhcar(255),not null
index(id));

-- 给已存在的表指定索引
create index on mytab(id);
```



#### 删除索引

```mysql
drop index on mytab(id);
```

