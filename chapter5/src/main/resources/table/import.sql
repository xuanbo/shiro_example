drop database if exists shiro;
create database shiro;
use shiro;

-- ---------------
-- 用户表结构
-- ---------------
create table user (
  id int(11) PRIMARY KEY auto_increment,
  username varchar(100),
  password varchar(100),
  role_id int(11)
) charset=utf8 ENGINE=InnoDB;

-- ---------------
-- 用户表数据
-- ---------------
insert into user(id, username, password, role_id) values (1, "wang", "a117ae6557a2ae66b95218a041b179c9", 1);-- 123456
insert into user(id, username, password, role_id) values (2, "zhang", "6110ef3d7b853b61273b4172149ca38d", 2);-- 111111
insert into user(id, username, password, role_id) values (3, "li", "6110ef3d7b853b61273b4172149ca38d", null);-- 111111
insert into user(id, username, password, role_id) values (4, "chen", "6110ef3d7b853b61273b4172149ca38d", null);-- 111111


-- ---------------
-- 角色表结构
-- ---------------
create table role (
  id int(11) PRIMARY KEY auto_increment,
  name varchar(100),
  description varchar(255)
) charset=utf8 ENGINE=InnoDB;

-- ---------------
-- 角色表数据
-- ---------------
insert into role(id, name, description) values (1, 'admin', '管理员');
insert into role(id, name, description) values (2, 'teacher', '教师');


-- ---------------
-- 权限表结构
-- ---------------
create table permission (
  id int(11) PRIMARY KEY auto_increment,
  name varchar(100),
  role_id int(11),
  description varchar(255)
) charset=utf8 ENGINE=InnoDB;

-- ---------------
-- 权限表数据
-- ---------------
insert into permission(id, name, role_id, description) values (1, 'user:*', 1, '用户所有权限');
insert into permission(id, name, role_id, description) values (2, 'student:*', 1, '学生所有权限');
insert into permission(id, name, role_id, description) values (3, 'student:select', 2, '查询学生权限');