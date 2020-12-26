drop database if exists library;

create database library;

use library;

create table sections(
id int not null primary key auto_increment,
name varchar(40) not null);

create table authors(
id int not null primary key auto_increment,
name varchar(40) not null,
surname varchar(40) not null);


create table books(
id int not null primary key auto_increment,
title varchar(40) not null,
volum_number int not null,
gender varchar(40) not null,
borrowed tinyint,
free_book tinyint,
authors_id int not null unique, 
constraint fk_books_authors
foreign key (authors_id)
references authors(id),
sections_id int not null,
constraint fk_books_sections 
foreign key (sections_id) 
references sections(id));


create table persons(
id int not null primary key auto_increment,
name varchar(40) not null,
surname varchar(40) not null,
address varchar(40) not null,
year_of_birth int not null);

drop table persons_books;
create table if not exists persons_books(
id int not null primary key auto_increment,
persons_id int not null,
constraint fk_persons_books foreign key (books_id) references books(id),
books_id int not null,
constraint fk_books_persons foreign key (persons_id) references persons(id));

drop table persons_sections;
create table if not exists persons_sections(
id int not null primary key auto_increment,
persons_id int not null,
constraint fk_persons_sections foreign key (sections_id) references sections(id),
sections_id int not null,
constraint fk_sections_persons foreign key (persons_id) references persons(id));

drop table authors_persons;
create table if not exists authors_persons(
id int not null primary key auto_increment,
authors_id int not null,
constraint fk_authors_persons foreign key (persons_id) references persons(id),
persons_id int not null,
constraint fk_persons_authors foreign key (authors_id) references authors(id));

drop table sections_authors;
create table if not exists sections_authors(
id int not null primary key auto_increment,
sections_id int not null,
constraint fk_sections_authors foreign key (authors_id) references authors(id),
authors_id int not null,
constraint fk_authors_sections foreign key (sections_id) references sections(id));
