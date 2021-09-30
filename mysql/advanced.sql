CREATE TABLE `tbl_dept`(
`id` INT(11) not NULL auto_increment,
`deptName` VARCHAR(30) DEFAULT NULL,
`idAdd` VARCHAR(40) DEFAULT NULL,
PRIMARY KEY (`id`)

) ENGINE=INNODB auto_increment=1 DEFAULT CHARSET=utf8;
CREATE TABLE `tbl_emp`(
`id` INT(11) not NULL auto_increment,
`name` VARCHAR(20) DEFAULT NULL,
`deptId` INT(11) DEFAULT NULL,
PRIMARY KEY (`id`),
KEY `fk_dept_id` (`deptId`)
#CONSTRAINT `fk_dept_id` foreign key (`deptId`) REFERENCES `tbl.dept` (id)
) ENGINE=INNODB auto_increment=1 DEFAULT CHARSET=utf8;

INSERT INTO tbl_dept(deptName,idAdd) VALUES ('RD',11);
INSERT INTO tbl_dept(deptName,idAdd) VALUES ('HR',12);
INSERT INTO tbl_dept(deptName,idAdd) VALUES ('MK',13);
INSERT INTO tbl_dept(deptName,idAdd) VALUES ('MIS',14);
INSERT INTO tbl_dept(deptName,idAdd) VALUES ('FD',15);
 
INSERT INTO tbl_emp(`NAME`,deptId) VALUES ('z3',1);
INSERT INTO tbl_emp(`NAME`,deptId) VALUES ('z4',1);
INSERT INTO tbl_emp(`NAME`,deptId) VALUES ('z5',1);
INSERT INTO tbl_emp(`NAME`,deptId) VALUES ('w5',2);
INSERT INTO tbl_emp(`NAME`,deptId) VALUES ('w6',2);
INSERT INTO tbl_emp(`NAME`,deptId) VALUES ('s7',3);
INSERT INTO tbl_emp(`NAME`,deptId) VALUES ('s8',4);
INSERT INTO tbl_emp(`NAME`,deptId) VALUES ('s9',51);
SELECT * from tbl_dept
SELECT * from tbl_emp a INNER JOIN tbl_dept b on a.deptid = b.id
union
SELECT * from tbl_emp a left JOIN tbl_dept b on a.deptid = b.id where b.id is null
union
SELECT * from tbl_emp a right JOIN tbl_dept b on a.deptid = b.id where a.id is null

explain SELECT * from tbl_emp a  JOIN tbl_dept b 
	on a.deptid = b.id;
#show index from tbl_emp

#mysql优化
#建表
 CREATE TABLE t1(id INT(10) AUTO_INCREMENT,content  VARCHAR(100) NULL ,  PRIMARY KEY (id)); 
 CREATE TABLE t2(id INT(10) AUTO_INCREMENT,content  VARCHAR(100) NULL ,  PRIMARY KEY (id)); 
 CREATE TABLE t3(id INT(10) AUTO_INCREMENT,content  VARCHAR(100) NULL ,  PRIMARY KEY (id));
 CREATE TABLE t4(id INT(10) AUTO_INCREMENT,content  VARCHAR(100) NULL ,  PRIMARY KEY (id));  
 INSERT INTO t1(content) VALUES(CONCAT('t1_',FLOOR(1+RAND()*1000)));  
 INSERT INTO t2(content) VALUES(CONCAT('t2_',FLOOR(1+RAND()*1000)));   
 INSERT INTO t3(content) VALUES(CONCAT('t3_',FLOOR(1+RAND()*1000)));      
 INSERT INTO t4(content) VALUES(CONCAT('t4_',FLOOR(1+RAND()*1000)));
 alter table t1 add COLUMN other_column VARCHAR(100) NULL;
  alter table t1 add COLUMN col1 VARCHAR(100) NULL;
 alter table t1 add COLUMN col2 VARCHAR(100) NULL;
 alter table t1 add COLUMN col3 VARCHAR(100) NULL;
 CREATE index idx_col2_col3 on t1 (col2,col3);
  CREATE index idx_col1_col2_col3 on t1 (col1,col2,col3);

 desc t1;
#id相同，执行顺序由上至下
EXPLAIN select t2.* from t1,t2,t3
where t1.id = t2.id and t1.id = t3.id
and t1.content ='';

#id不同，如果是子查询，id的序号会递增，id值越大优先级越高，越先被执行
EXPLAIN select t2.* from t2 where id =(
	select id from t2 where id = (
		select t3.id from t3 where t3.content='')
	);
	
	#
explain select t2.* from 
(select t3.id from t3 where t3.content = '') s1, t2
where s1.id = t2.id; 
#   expalin的type
#const id是主键(primary key)，连接部分是常量1，通过索引一次就能找到，速度非常快
explain SELECT * from tbl_emp where id =1

#derived
#const
explain select *  from (select * from t3 where id= 1) a ;
#eq_ref
explain SELECT * from t1,t2 WHERE t1.id = t2.id;
explain SELECT * from t1 left join t2 on t1.id = t2.id WHERE t1.id = t2.id
#ref-----------------------------------START---------------------
create table user (
  id int primary key,
  `name` varchar(20)
)engine=innodb;

insert into user values(1,'ar414');
insert into user values(2,'zhangsan');
insert into user values(3,'lisi');
insert into user values(4,'wangwu');

create table user_balance (
  uid int,
  balance int,
  index(uid)
)engine=innodb;

insert into user_balance values(1,100);
insert into user_balance values(2,200);
insert into user_balance values(3,300);
insert into user_balance values(4,400);
insert into user_balance values(5,500);
#drop table `user`;
#drop table user_balance;
explain SELECT * from `user` left join user_balance on user.id = user_balance.uid;
#ref-----------------------------------END---------------------
#range----------------------------------START-------------------
create table `user` (
  id int primary key,
  `name` varchar(20)
)engine=innodb;

insert into `user` values(1,'ar414');
insert into `user` values(2,'zhangsan');
insert into `user` values(3,'lisi');
insert into `user` values(4,'wangwu');
insert into `user` values(5,'zhaoliu');
explain SELECT * from `user` where id between 1 and 4;
explain SELECT * from `user` where id in(1,2,3);
explain SELECT * from `user` where id >2;
#range----------------------------------END-------------------
#index
explain select count(1) from `user`;
explain select col2,col3 from t1;

#all 全表扫描
explain SELECT * from `user` where `name` = '';

explain SELECT id,deptId from tbl_emp
desc tbl_emp
#using filesort
explain select col2 from t1 where col1='ac' order by col3
explain select col2 from t1 where col1='ac' order by col2,col3
#using temporary
explain select col1 from t1 where col1 in ('ac','ab','bc') group by col2,col1
#优化
explain select col1 from t1 where col1 in ('ac','ab','bc') group by col1,col2
#覆盖索引
explain select col1,col2,col3 from t1
以下很少见
#using join buffer 使用了连接缓存
#impossible where
explain select col2 from t1 where col1='ac' and col1='acd';
