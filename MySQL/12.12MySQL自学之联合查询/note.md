---
typora-root-url: images
typora-copy-images-to: images
---

# MySQL连接

#### JOIN:

>- **INNER JOIN（内连接,或等值连接）**：获取两个表中字段匹配关系的记录。
>- **LEFT JOIN（左连接）：**获取左表所有记录，即使右表没有对应匹配的记录。
>- **RIGHT JOIN（右连接）：** 与 LEFT JOIN 相反，用于获取右表所有记录，即使左表没有对应匹配的记录。

##### INNER JOIN:

> ![1607762346580](/1607762346580.png) 

#####LEFT JOIN:

##### RIGHT JOIN:



# MySQL正则表达式

regexp

> ![1607763413199](/1607763413199.png) 

```bash
#查找姓名为a开头的员工信息
SELECT *
FROM emp
WHERE ename REGEXP '^a';
```

# MySQL事务

#### begin 开始

#### rollback 回滚 

可以设置回滚保留点,混滚到指定时间

####commit 提交

原子性,一致性,隔离性,永久性



锁lock

create 默认会提交