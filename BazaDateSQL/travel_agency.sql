drop database if exists travel_agency;
create database travel_agency;
use travel_agency;

create table continents(
id int not null primary key auto_increment,
name varchar(20) not null unique);

create table countries(
id int not null primary key auto_increment,
name varchar(20) not null unique,
continents_id int not null,
constraint countries_continents_fk
foreign key (continents_id)
references continents(id));

create table cities(
id int not null primary key auto_increment,
name varchar(20) not null ,
countries_id int not null,
constraint cities_countries_fk
foreign key (countries_id)
references countries(id));

create table airports(
id int not null primary key auto_increment,
name varchar(20) not null,
cities_id int not null,
constraint airports_cities_fk 
foreign key (cities_id)
references cities(id));

create table hotels(
id int not null primary key auto_increment,
name varchar(20) not null ,
star_rating varchar(20) not null,
description varchar(50) not null,
 cities_id int not null,
 constraint hotels_cities_fk
 foreign key (cities_id)
 references cities(id));
 
 create table rooms(
 id int not null primary key auto_increment,
 room_type varchar(20) not null,
 room_number int not null,
 extra_bed tinyint not null);
 
 create table trips(
 id int not null primary key auto_increment,
 departure varchar(20) not null,
 arrivel varchar(20) not null,
 return_date varchar(20) not null,
 day_number int not null,
 meal varchar(20) not null,
 adult_number int not null,
 adult_price int not null,
 kid_number int,
 kid_price int,
 promotion_discount int);
 
 create table clients(
 id int not null primary key auto_increment,
 name varchar(20) not null,
 surname varchar(20) not null,
 year_of_birth varchar(20) not null,
 address varchar(20) not null,
 phone_number int not null,
 email varchar(20) not null,
 user_name varchar(20) not null unique,
 password varchar(20) not null,
 log_in tinyint );
 
 create table admins(
 id int not null primary key auto_increment,
 admin_user varchar(20) not null unique,
 admin_password varchar(20) not null,
 log_in tinyint);
 
 -- M2M trip
 -- M2M clients
 create table purchase_trips(
 id int not null primary key auto_increment,
 amount int not null);
 
 create table purchase_trips_trips(
 id int not null primary key auto_increment,
 trips_id int not null,
 constraint purchase_trips_trips_fk foreign key (trips_id) references  trips(id),
 purchase_trips_id int not null,
constraint trips_purchase_trips_fk foreign key (purchase_trips_id) references purchase_trips(id));

create table clients_trips(
id int not null primary key auto_increment,
trips_id int not null,
constraint clients_trips_fk foreign key (trips_id) references trips(id),
clients_id int not null,
constraint trips_clients_fk foreign key (clients_id) references clients(id));

create table hotels_rooms(
id int not null primary key auto_increment,
hotels_id int not null ,
constraint rooms_hotels_fk foreign key (hotels_id) references hotels(id),
rooms_id int not null,
constraint hotels_rooms_fk foreign key (rooms_id) references rooms(id));