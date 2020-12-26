drop database if exists it_company;

create database it_company;
 
 use it_company;
 
 create table if not exists departments(
id int not null primary key auto_increment,
department_name varchar(30) not null,
department_floor int not null,
employees_number int not null,
department_manager_name varchar(10) not null
);
 
create table if not exists employees(
id int not null Primary key auto_increment,
name varchar(15) not null,
surname varchar(15) not null,
address varchar(20) not null,
age int not null,
department_name varchar(30) not null,
employees_function varchar(30) not null
);

create table if not exists products(
id int not null primary key auto_increment,
product_name varchar(30) not null,
product_version int not null,
clients_number int not null,
product_price int not null
);
