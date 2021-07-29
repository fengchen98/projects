drop database if exists userdb;

create DATABASE if not exists userdb character set utf8;

use userdb;

drop table if exists userinfo;
create table `userinfo` (
	`id` INT PRIMARY KEY auto_increment,
	`name` varchar(60),
	`username` varchar(60) default 'bit',
	`password` varchar(60) default '123456',
	`sex` varchar(4),
	`age` int,
	`address` varchar(90),
	`qq` varchar (20),
	`email` varchar (30),
    `isadmin` int not null default 0
);

INSERT INTO userinfo VALUES(1,'超级管理员','admin','123','男',18,'成都','1262913815','admin@qq.com',1);
INSERT INTO userinfo VALUES(2,'张飞','zhangfei','123','男',18,'成都','1262913815','126@qq.com',0);
INSERT INTO userinfo VALUES(3,'关羽','guanyu','1234','男',18,'西安','1262913816','1262@qq.com',0);
INSERT INTO userinfo VALUES(4,'张三','zhangsan','1235','女',19,'西安','1262913817','1263@qq.com',0);
INSERT INTO userinfo VALUES(5,'李四','lisi','1236','男',20,'北京','1262913818','1264@qq.com',0);
INSERT INTO userinfo VALUES(6,'王五','wangwu','1237','女',21,'西安','1262913819','1265@qq.com',0);
INSERT INTO userinfo VALUES(7,'孙权','sunquan','1238','男',22,'上海','1262913814','1266@qq.com',0);
INSERT INTO userinfo VALUES(8,'孙悟空','sunwukong','1239','男',23,'西安','1262913813','1267@qq.com',0);
INSERT INTO userinfo VALUES(9,'猪八戒','zhubajie','1239','男',23,'上海','1262913813','1267@qq.com',0);