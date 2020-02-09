-- jdbc 入门
create database test_jdbc;
use test_jdbc;
create table user(
	id int primary key auto_increment,
	username varchar(20),
	password varchar(20),
	nickname varchar(20),
	age int
);
insert into user values (null,'aaa','123','小丽',34);
insert into user values (null,'bbb','123','大王',32);
insert into user values (null,'ccc','123','小明',28);
insert into user values (null,'ddd','123','大黄',21);