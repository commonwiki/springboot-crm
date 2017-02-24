/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/2/23 19:50:24                           */
/*==============================================================*/


drop table if exists file;

drop table if exists student;

/*==============================================================*/
/* Table: file                                                  */
/*==============================================================*/
create table file
(
   id                   int not null auto_increment,
   name                 varchar(255) not null default '',
   type                 varchar(255) not null default '',
   path                 varchar(255) not null default '',
   size                 varchar(255) not null default '',
   flag                 tinyint(1) not null default 0,
   inserttime           timestamp not null default CURRENT_TIMESTAMP,
   primary key (id)
);

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student
(
   mobile               int not null auto_increment,
   name                 varchar(255) default NULL,
   mail                 varchar(255) default NULL,
   sex                  varchar(255) default NULL,
   education            varchar(255) default NULL,
   flag                 tinyint(1) default 0,
   stgatus              tinyint(1) default 0,
   inserttime           timestamp default CURRENT_TIMESTAMP,
   updatetime           datetime default NULL,
   primary key (mobile)
);

