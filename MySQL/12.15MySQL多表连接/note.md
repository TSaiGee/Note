---
typora-root-url: images
typora-copy-images-to:images
---

# MySQL多表连接

#### 为什么使用多个表格

> 每个表的信息分类明确
>
> 方便修改数据
>
> 减少大量的数据冗余

#### 多表连接语法

> 本节所用数据库同前课，[git下载连接](https://gitee.com/TSaiGee/library.git)

```MySQL
-- 同名的字段,需要为每个表指定别名或加上前缀
-- 查询所有员工的姓名,部门编号,工作部门名称(dname)
SELECT ename AS 姓名,emp.deptno AS 部门编号,dname AS 部门名称  -- 为deptno加上了前缀
FROM emp,dept 

SELECT ename AS 姓名,e.deptno AS 部门编号,dname AS 部门名称
FROM emp ｅ,dept ｄ			-- 为每个表加上别名
```

> ![1607995696278](/1607995696278.png) 
>
> 结果如图,发现一个人名对应了多个部门,这是错误的.原因是我们没有指定查询条件,形成了笛卡尔积(交叉连接)

正确的查询方式

```MySQL
-- 当emp表的的deptno和dept的表deptno相等的时候才能够输出结果
SELECT ename AS 姓名,sal AS 薪资,dname AS 部门名称
FROM emp e, dept d				-- 起别名的方式
WHERE e.deptno = d.deptno;

SELECT ename AS 姓名,sal AS 薪资,dname AS 部门名称
FROM emp ,dept 
WHERE emp.deptno = dept.deptno;	
```

##### 自连接

> 表emp内的经理编号mgr对应一个员工编号empno,此时可以把emp当两张表,和多表查询类似

```mysql
-- 查询员工的经理的姓名
SELECT a.ename as 员工姓名,m.ename as 经理姓名
FROM emp a,emp m
WHERE a.mgr = m.empno;
```

#### 多表查询规范语法

> 交叉连接	CROSS JOIN...
>
> 自然连接	NATURAL JOIN...		两张表有同名同类型字段通过自然连接进行等值连
>
> > 如emp和dept表,都含有deptno,这两个表进行自然连接的时候会自动将deptno进行等值连接
> >
> > 可以使用using子句指定连接字段.如 :
> >
> > ```mysql
> > -- 指定用deptno字段连接
> > select ename,sal,dname from emp join dept using(deptno);
> > ```
>
> 内连接	(INNER) JOIN...ON...WHERE
>
> > ON用于连接条件,WHERE用与其他非链接条件，如
> >
> > ```MySQL
> > -- 查询部门20的员工姓名工资工资等级等信息
> > SELECT e.ename AS 员工姓名,e.sal AS 工资,dname AS 部门名称,grade AS 工资等级,m.ename AS 经理姓名
> > FROM emp e
> > JOIN emp m
> > ON e.mgr = m.empno
> > JOIN dept d
> > ON e.deptno = d.deptno 
> > JOIN salgrade
> > ON e.sal BETWEEN losal AND hisal 
> > WHERE e.deptno = 20
> > ```
> >
>
> 左连接	LEFT JOIN...
>
> > 左外连接.以左边的表为主表,能够显示主表的所有内容,如:
> >
> > ```MySQL
> > -- 查询所有员工对应的经理
> > SELECT e.ename AS 员工姓名,m.ename AS　经理姓名
> > FROM emp e
> > LEFT JOIN emp m
> > WHERE　e.mgr = m.empno;
> > ```
> >
>
> 右连接	RIGHT JOIN...
>
> > 同左连接,右连接是把右边的表作为主表格



#### 多表查询练习

```MySQL
-- 创建一个员工表和部门表的交叉连接
SELECT *
FROM emp
CROSS JOIN dept
-- ON emp.deptno = dept.deptno;

-- 使用自然连接,显示入职日期在80年5月1日后的员工姓名,部门名称,入职日期
SELECT ename AS 员工姓名,dname as 部门名称,hiredate AS 入职日期
FROM emp
NATURAL JOIN dept
WHERE hiredate > '1980-5-1';

-- 用using子句,显示工作在CHICAGA的员工姓名,部门名称,工作地点
SELECT ename AS 员工姓名,dname AS 部门名称,loc AS 工作地点
FROM emp
JOIN dept USING (deptno)
WHERE loc = 'CHICAGO';

-- 使用on子句显示在CHICAGO工作的员工姓名,部门名称,工作地点,薪资等级
SELECT ename as 员工姓名,dname AS 部门名称,loc AS 工作地点,grade AS 薪资等级
FROM emp
JOIN dept
ON emp.deptno = dept.deptno
JOIN salgrade
ON sal BETWEEN losal AND hisal
WHERE loc = 'CHICAGO';

-- 使用左连接,查询每个员工的姓名,经理姓名,没有经理的KING也要显示
SELECT e.ename AS 员工姓名,m.ename AS 经理姓名
FROM emp e
LEFT JOIN emp m
ON e.mgr = m.empno;

-- 使用右连接,查询每个员工的姓名,经理姓名,没有经理的KING也要显示
SELECT e.ename AS 员工姓名,m.ename AS 经理姓名
FROM emp m
RIGHT JOIN emp e
ON e.mgr = m.empno;

-- 显示KING和FORD管理的员工姓名及KING和FORD的经理名字
SELECT e.ename AS 员工姓名,m.ename AS 经理姓名,me.ename AS 经理的经理
FROM emp e
JOIN emp m
ON e.mgr = m.empno
LEFT JOIN emp me
ON m.mgr = me.empno
WHERE m.ename IN ('KING','SCOTT');
```



