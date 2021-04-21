# 知识点总结

##### MySQL安装

##### MySQL建立数据库

##### MySQL约束

> 主键,唯一键,非空外键

##### MySQL建表

> 列名,数据类型,约束,备注

##### MySQL查询

>简单查询
>
>条件查询 where
>
>模糊查询 like
>
>排序查询 order by
>
>分组查询 group by
>
>分页查询 limit (索引,长度)
>
>空值查询 ifnull(column,0),is null,is not null

##### MySQL删除

> delete from table_name where ......

##### MySQL修改 

> update table_name set column = new_value where ......

##### MySQL函数

######数值函数

> ceil(5.5) 				向上取整		6
>
> floor(5.5) 			向下取整		= 5
>
> round(9.5454,2) 		四舍五入		= 9.55
>
> truncate(9.5454,2)	截断		= 9.54
>
> mod(5,2)			取余		= 1
>
> format(6000,2)		格式化数值6000,小数点后取2位	= 6,000.00

######字符串函数

>**concat('hello','world')	连接字符串	= 'hello world'**
>
>char_length('你好')	字符个数		= 2
>
>length('你好')			字节长度		= 6
>
>lower() | lcase()		转换字符串为小写
>
>upper() | ucase()		转换字符串为大写
>
>lpad('he',2,'z') | rpad()左填充|右填充= zzhe
>
>**trim() | ltrim() | rtrim()去空格 | 去左边空格 | 去右边空格**
>
>repeat()				重复生成字符串
>
>substring() | substr()	截取字符串
>
>replace('hello','l','p')	替换字符串	= heppo

###### 日期函数

> curdate()			获取当前日期
>
> curtime()			获取当前时间(只有时分秒)
>
> now()				curdate() & curtime()
>
> timediff(a,b)			返回a,b两个时间的时间差(a,b的时分秒要写全)
>
> datediff(a,b)			返回两个日期的差值
>
> date_add(now(),interval 3 year)	在当前之间加上三年
>
> date_sub()			同上,减去...
>
> extract(time from now() 从now()中提取time(),now()和time()可以换成其他属性
>
> date_format(date,format) 格式化日期时间%H:24小时 / %h:12小时;%Y:四位数年份 / %y:二位数年份
>
> time_format(time,format) 格式化时间
>
> timestampdiff(unit,a,b) 求时间间隔unit=year|month|day|hour等
>
> 

###### 函数练习

> ```mysql
> 
> -- 查名字前三位
> SELECT SUBSTRING(ename,1,3),LEFT(ename,3),ename
> FROM emp;
> -- 查名字正好是五位
> SELECT ename
> FROM emp
> WHERE CHAR_LENGTH(ename) = 5;
> -- 查首字母大写其他字母小写,名字长度
> SELECT CONCAT(UPPER(LEFT(ename,1)),LOWER(SUBSTR(ename FROM 2))) as ename,CHAR_LENGTH(ename)
> from emp
> -- 查员工名字中含有大A和小a字母的
> SELECT ename 
> FROM emp
> WHERE
> ename like '%A%' OR ename like '%a%';
> -- 查部门编号10/20,入职如期晚于81年5月1日,姓名中含有大写A的员工姓名及姓名长度
> SELECT ename,CHAR_LENGTH(ename)
> FROM emp
> WHERE BINARY deptno IN (10,20) and hiredate > '1981-5-1' AND ename like '%A';
> -- 员工姓名,用a替换A
> SELECT ename,REPLACE(ename,'A','a')
> FROM emp;
> -- 生成一个身份码,不足用*补齐,分别是10位员工编号,10位姓名,10位工资
> SELECT CONCAT(RPAD(empno,10,'*'),RPAD(ename,10,'*'),LPAD(sal,10,'*')) as IdCode
> FROM emp
> ```

