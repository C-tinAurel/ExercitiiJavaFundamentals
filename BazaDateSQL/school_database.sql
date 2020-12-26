use school;

create table if not exists students_teachers(
id int primary key not null auto_increment,
students_id int not null,
constraint fk_students_teachers foreign key (students_id) references students(id),
teachers_id int not null,
constraint fk_teachers_students foreign key (teachers_id) references teachers(id));

create table if not exists teachers_classes(
id int not null primary key auto_increment,
teachers_id int not null,
constraint fk_teachers_classes foreign key (teachers_id) references teachers(id),
classes_id int not null,
constraint fk_classes_teachers foreign key (classes_id) references classes(id));

