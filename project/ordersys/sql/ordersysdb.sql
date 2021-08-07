/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/7/31 11:52:12                           */
/*==============================================================*/

DROP database IF EXISTS `ordersysdb`;

create DATABASE `ordersysdb` CHARACTER SET utf8;

use  `ordersysdb`;

drop table if exists dish;

drop table if exists orderdetail;

drop table if exists orderinfo;

drop table if exists userinfo;

/*==============================================================*/
/* Table: dish                                                  */
/*==============================================================*/
create table dish
(
   id                   int not null auto_increment,
   name                 varchar(250) not null,
   price                decimal(0) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: orderdetail                                           */
/*==============================================================*/
create table orderdetail
(
   did                  int not null,
   oid                  int not null
);

/*==============================================================*/
/* Table: orderinfo                                             */
/*==============================================================*/
create table orderinfo
(
   id                   int not null auto_increment,
   uid                  int,
   createtime           datetime default now(),
   status               int comment '0=未完成；1=已完成',
   primary key (id)
);

/*==============================================================*/
/* Table: userinfo                                              */
/*==============================================================*/
create table userinfo
(
   id                   int not null auto_increment,
   username             varchar(250),
   password             varchar(50),
   isadmin              int comment '0=顾客;1=商家',
   primary key (id)
);


insert into userinfo(username,password,isadmin) values('admin','123456',1);
