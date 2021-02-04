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

create table flights(
id int not null primary key auto_increment,
flight_number varchar(50) not null,
flight_date_and_time_arriving varchar(50) not null,
flight_date_and_time_departure varchar(50) not null,
price int not null,
available_seats int not null,
airports_id int ,
constraint airports_flights_fk
foreign key (airports_id)
references airports(id));

create table hotels(
id int not null primary key auto_increment,
name varchar(20) not null ,
stars varchar(20) not null,
address varchar(50) not null,
description varchar(50) not null,
 cities_id int not null,
 constraint hotels_cities_fk
 foreign key (cities_id)
 references cities(id));
 
 create table rooms(
 id int not null primary key auto_increment,
 room_type varchar(20) not null,
 number_available int not null,
 extra_bed tinyint not null);
 
 create table trips(
 id int not null primary key auto_increment,
 airports_id int ,
 constraint airports_trips_fk
 foreign key (airports_id)
 references airports(id),
 hotels_id int not null,
 constraint hotels_trips_fk
 foreign key (hotels_id)
 references hotels(id),
 name varchar(30) not null,
 departure_date date not null,
 return_date date not null,
 check_in date not null,
 check_out date not null,
 number_days int not null,
 meal_type varchar(40) not null,
 adult_price double not null,
 kid_price double,
 promoted tinyint not null,
 adult_number int not null,
 kids_number int,
 available_stock int not null);
 
 create table clients(
 id int not null primary key auto_increment,
 name varchar(20) not null,
 surname varchar(20) not null,
 year_of_birth varchar(20) not null,
 address varchar(20) not null,
 phone_number int not null);
 
 create table users(
 id int not null primary key auto_increment,
 user_name varchar(20) not null unique,
 email varchar(50) not null,
 password varchar(1000) not null,
 logged_in tinyint,
 admin_role tinyint,
 clients_id int not null unique,
 constraint clients_users_fk
 foreign key (clients_id)
 references clients(id));
 

 create table purchase_trips(
 id int not null primary key auto_increment,
 amount int not null);
 
 create table purchase_trips_trips(
 id int not null primary key auto_increment,
 trips_id int not null,
 constraint purchase_trips_trips_fk foreign key (trips_id) references  trips(id),
 purchase_trips_id int not null,
constraint trips_purchase_trips_fk foreign key (purchase_trips_id) references purchase_trips(id));


create table hotels_rooms(
id int not null primary key auto_increment,
hotels_id int not null ,
constraint rooms_hotels_fk foreign key (hotels_id) references hotels(id),
rooms_id int not null,
constraint hotels_rooms_fk foreign key (rooms_id) references rooms(id));