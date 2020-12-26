use school;

create table if not exists adress(
id int primary key not null auto_increment,
city varchar(20) not null ,
street varchar(20) not null);

delete from students where year_of_birth >1;

alter table students drop foreign key fk_students_adress;

alter table students drop column adress_id;

alter table students
add column adress_id int not null unique,
add constraint fk_students_adress foreign key(adress_id) references adress(id);

select* from students;


delete from teachers where age > 1;

alter table teachers drop foreign key fk_teachers_adress;

alter table teachers drop column adress_id;

 
alter table teachers
add column adress_id int not null unique,
add constraint fk_teachers_adress foreign key(adress_id) references adress(id);


use school;

create table if not exists identificator(
id int primary key not null auto_increment,
number varchar(15) not null);

delete from students where year_of_birth>1000;



alter table students
add column identificator_id int not null unique,
add constraint fk_students_identificator foreign key(identificator_id) references identificator(id);

delete from teachers where age>1;

alter table teachers
add column identificator_id int not null unique,
add constraint fk_teachers_identificator foreign key(identificator_id) references identificator(id);

use school;
delete from students where year_of_birth >1;

create table if not exists classes
(id int not null primary key auto_increment,
name varchar(20) not null);

alter table students 
add column classes_id int not null,
add constraint fk_students_classes foreign key(classes_id) references classes(id);





