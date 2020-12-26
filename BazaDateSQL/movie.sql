drop database if exists movie;
create database movie;
use movie;

create table actors(
id int Primary key auto_increment not null,
name varchar(15) not null,
surname varchar(15) not null,
gender varchar(10) not null);

insert into actors(
name,surname,gender)
value 
('Tom','Hardy','Male');

insert into actors(
name,surname,gender)
value
('Nickolas','Cage','Male');

insert into actors
(name,surname,gender)
value
('Will','Smith','Male');

insert into actors
(name,surname,gender)
value
('Angelina','Jolie','Female');

insert into actors
(name,surname,gender)
value
('Julia','Roberts','Female');

create table directors(
id int Primary key auto_increment not null,
name varchar(10) not null,
surname varchar(20) not null);

insert into directors
(name,surname)
value
('Aaron','Russo');

insert into directors
(name,surname)
value
('Ben','Affleck');

insert into directors
(name,surname)
value
('Alan','Alda');

create table movies(
id int Primary key auto_increment not null,
title varchar(20) not null unique,
year_made int not null,
duration int not null,
language_made varchar(15) not null,
release_country varchar (15) not null,
gender varchar(10) not null,
directors_id int not null,
constraint fk_movies_directors
foreign key (directors_id)
references directors(id));

insert into movies
(title,year_made,duration,language_made,release_country,gender,directors_id)
value
('Joker',2019,122,'english','USA','comedie',1);

insert into movies
(title,year_made,duration,language_made,release_country,gender,directors_id)
value
('Batman Begins',2005,140,'english','USA','action',2);

insert into movies
(title,year_made,duration,language_made,release_country,gender,directors_id)
value
('Gladiator',2000,165,'english','USA','adventure',3);

insert into movies
(title,year_made,duration,language_made,release_country,gender,directors_id)
value
('The Departed',2006,151,'english','Romania','crime',2);

insert into movies
(title,year_made,duration,language_made,release_country,gender,directors_id)
value
('The Sandman',2020,115,'english','USA','horror',3);

insert into movies
(title,year_made,duration,language_made,release_country,gender,directors_id)
value
('Casino',1995,178,'english','England','drama',1);


create table genres(
id int Primary key auto_increment not null,
name varchar(20) not null,
vision_type varchar(10) not null);

insert into genres
(name,vision_type)
value
('Immortals','3D');

insert into genres
(name,vision_type)
value
('Superman','3D');

insert into genres
(name,vision_type)
value
('The Town', '2D');

insert into genres
(name,vision_type)
value
('Miami Beach','4K');

insert into genres
(name,vision_type)
value
('The Police','4K');

create table reviewers(
id int primary key auto_increment not null,
name varchar(10) not null,
surname varchar(20) not null,
age int not null);

insert into reviewers
(name,surname,age)
value
('Alex','Ciprian',26);

insert into reviewers
(name,surname,age)
value
('Constantin','George',30);

insert into reviewers
(name,surname,age)
value
('Condurache','Marius',65);

insert into reviewers
(name,surname,age)
value
('Vlad','Maria',17);

insert into reviewers
(name,surname,age)
value
('Terzi','Laura',21);

insert into reviewers
(name,surname,age)
value
('Frana','Bogdan',16);

create table ratings(
id int primary key auto_increment not null,
stars int not null,
reviewers_id int not null,
constraint fk_ratings_reviewers
foreign key(reviewers_id)
references reviewers(id),
movies_id int not null,
constraint fk_ratings_movies
foreign key (movies_id)
references movies(id),
Constraint unique_reviewers -- definim un constraint unuic pentru coloanele reviewers di si movies id
Unique(reviewers_id,movies_id)
);

-- insert into ratings
-- values
-- (3,2,1);
 
insert into ratings
(stars,reviewers_id,movies_id)
value
(3,2,1);

insert into ratings
(stars,reviewers_id,movies_id)
value
(5,1,2);

insert into ratings
(stars,reviewers_id,movies_id)
value
(4,4,1);

insert into ratings
(stars,reviewers_id,movies_id)
value
(2,3,4);

insert into ratings
(stars,reviewers_id,movies_id)
value
(3,5,5);

insert into ratings
(stars,reviewers_id,movies_id)
value
(5,6,2);



create table casts(
id int primary key auto_increment not null,
movies_id  int not null,
Constraint fk_casts_movies
Foreign key (movies_id)
References movies(id),
rol varchar(15) not null,
actors_id int not null,
constraint fk_casts_actors
foreign key (actors_id)
references actors(id));

insert into casts
(movies_id,rol,actors_id)
value
(1,'Principale',1);

insert into casts
(movies_id,rol,actors_id)
value
(2,'Secondary',4);

insert into casts
(movies_id,rol,actors_id)
value
(3,'Principale',5);

insert into casts
(movies_id,rol,actors_id)
value
(4,'Principale',2);

insert into casts
(movies_id,rol,actors_id)
value
(5,'Principale',3);

select name,surname from actors
where gender='male';

select name,surname from actors
where gender='female';

select title from movies
where year_made>1990;

select title from movies
where gender='drama' or gender='comedie';

select title from movies
where release_country <> 'Romania';

select title from movies
where directors_id='Steven Spilberg';

select title from movies
where duration > 120;

select title from movies
where duration > 60 and duration<120;

select name,surname from reviewers
where age >18;

select name,surname from reviewers
where age<18;

select title,stars from ratings inner join movies on ratings.movies_id=movies.id
where stars >3;

SELECT title, stars FROM ratings INNER JOIN movies ON ratings.movies_id = movies.id
WHERE stars < 3;

SELECT 
    AVG(age)
FROM
    reviewers;

select avg(duration) from movies;

select title,name,surname from casts inner join movies on casts.movies_id=movies.id inner join actors on casts.actors_id=actors.id
where title ='Superman';

select title,name,surname, rol from casts inner join movies on casts.movies_id=movies.id inner join actors on casts.actors_id=actors.id
where name='Tom' and rol='principale';

select title from movies
where gender='Action';

select name,vision_type from genres 
where vision_type<> '3D';

select name,vision_type from genres
where vision_type ='2D';

select movies  from casts;
 


