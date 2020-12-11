drop database if exists travel_agency;

create database travel_agency;

use travel_agency;

create table continents(
id int not null primary key auto_increment,
name varchar(20) not null 
);

create table countries(
id int not null primary key auto_increment,
name varchar(30) not null ,
continents_id int not null,
constraint fk_countries_continents
foreign key (continents_id)
references continents(id)
);

create table cities(
id int not null primary key auto_increment,
name varchar(20) not null,
countries_id int not null,
constraint fk_cities_countries
foreign key (countries_id)
references countries(id)
);

create table airports(
id int not null primary key auto_increment,
name varchar(30) not null,
cities_id int,
constraint fk_airports_cities
foreign key (cities_id)
references cities(id)
);

create table flights(
id int not null primary key auto_increment,
flight_date varchar(30) not null,
flight_hour varchar(30) not null,
flight_to varchar(20) not null,
price double not null,
available_seats int not null,
airports_id int not null,
constraint fk_flights_airports
foreign key (airports_id)
references airports(id)
);

create table hotels(
id int not null primary key auto_increment,
name varchar(30) not null,
stars int not null,
description varchar(100) not null,
cities_id int not null,
constraint fk_hotels_citites
foreign key (cities_id)
references cities(id)
);

create table rooms(
id int not null primary key auto_increment,
type varchar(20) not null,
number_available int not null,
extra_bed tinyint
);

create table rooms_hotels(
id int not null primary key auto_increment,
rooms_id int not null,
constraint fk_rooms_hotels
foreign key (rooms_id)
references rooms(id),
hotels_id int not null,
constraint fk_hotels_rooms
foreign key (hotels_id)
references hotels(id)
);


create table trips(
id int not null primary key auto_increment,
name varchar(40)not null,
airports_id int,
constraint fk_trips_airports
foreign key (airports_id)
references airports(id),
hotels_id int not null,
constraint fk_trips_hotels
foreign key (hotels_id)
references hotels(id), 
departure_date varchar(30) not null,
return_date varchar(30) not null,
number_days int not null,
meal_type varchar(20),
adult_price double not null,
kid_price double not null,
promoted tinyint,
adult_number int not null,
kids_number int,
available_stock int not null
);

create table clients(
id int not null primary key auto_increment,
name varchar(20) not null,
surname varchar(20) not null,
year_of_birth int not null,
address varchar(100) not null,
phone_number int not null
);

create table users(
id int not null primary key auto_increment,
user_name varchar(30) not null unique,
email varchar(30) not null,
password varchar(30) not null,
logged_in tinyint not null,
admin_role tinyint,
clients_id int not null unique,
constraint fk_users_clients
foreign key (clients_id)
references clients(id)
);

create table purchases(
id int not null primary key auto_increment,
amount double not null,
trips_id int not null,
constraint fk_purchases_trips
foreign key (trips_id)
references trips(id)
);

create table clients_purchases(
id int not null primary key auto_increment,
client_id int,
constraint fk_clients_purchases
foreign key(client_id)
references clients(id),
purchase_id int,
constraint fk_purchases_clients
foreign key(purchase_id)
references purchases(id)
);
