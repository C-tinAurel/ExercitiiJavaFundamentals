drop database if exists college;
 create database college;
 use college;
  
create table students(
id int not null primary key auto_increment,
name varchar(15) not null,
surname varchar(20) not null,
age int not null);

create table teachers(
id int not null primary key auto_increment,
name varchar(15) not null,
surname varchar(15) not null,
subject varchar(20) not null);
 


