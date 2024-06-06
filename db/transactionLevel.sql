create table student(
	id serial primary key,
	name text,
	age integer,
	faculty text
);

insert into student(name, age, faculty)
values('Alex', 20, 'Physical');
insert into student(name, age, faculty)
values('Egor', 22, 'Matematic');
insert into student(name, age, faculty)
values('Maria', 21, 'IT');

