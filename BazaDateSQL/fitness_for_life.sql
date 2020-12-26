drop database if exists fitness_for_life;
create database fitness_for_life;
use fitness_for_life;


create table fitness_coachs(
id int not null primary key auto_increment,
name varchar(20) not null,
surname varchar(20) not null,
coach_workout varchar(30) not null);


create table subscriptions(
id int not null primary key auto_increment,
name varchar(20) not null,
price int not null,
begin_date varchar(20) not null,
end_date varchar(20) not null);

create table workouts(
id int not null primary key auto_increment,
name varchar(30) not null,
schedule varchar(20) not null,
day_workout varchar(20) not null,
subscriptions_id int not null,
constraint fk_workouts_subscriptions 
foreign key (subscriptions_id)
 references subscriptions(id));


create table costumers(
id int not null primary key auto_increment,
name varchar(20) not null,
surname varchar(20) not null,
age int not null);

create table accounts(
id int not null primary key auto_increment,
user_name varchar(20),
email varchar(20),
password varchar(20),
costumers_id int not null unique,
constraint fk_accounts_costumers foreign key (costumers_id) references costumers(id));

create table costumers_subscriptions(
id int not null primary key auto_increment,
costumers_id int not null,
constraint fk_costumers_subscriptions foreign key (subscriptions_id) references subscriptions(id),
subscriptions_id int not null,
constraint fk_subscriptions_costumers foreign key (costumers_id) references costumers(id)); 

create table fitness_coachs_workouts(
id int not null primary key auto_increment,
fitness_coachs_id int not null,
constraint fk_fitness_coachs_workouts foreign key (workouts_id) references workouts(id),
workouts_id int not null,
constraint fk_workouts_fitness_coachs foreign key(fitness_coachs_id) references fitness_coachs(id));



select * from workouts;
select * from fitness_coachs_workouts;
select * from fitness_coachs;
select * from costumers;