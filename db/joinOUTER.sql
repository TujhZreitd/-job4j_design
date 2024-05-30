create table departaments(
	id serial primary key,
	name varchar(255)
);

create table employees(
	id serial primary key,
	name varchar(255),
	departament_id int references departaments(id)
);

insert into departaments(name) values('IT');
insert into departaments(name) values('Sales');
insert into departaments(name) values('Admin');
insert into departaments(name) values('Reserve');
insert into employees(name, departament_id)
values('Alex', 1);
insert into employees(name, departament_id)
values('Egor', 3);
insert into employees(name, departament_id)
values('Maria', 2);
insert into employees(name, departament_id)
values('Anton', 1);
insert into employees(name, departament_id)
values('Anna', 1);
insert into employees(name, departament_id)
values('Nikita', null);

select * from departaments d
left join employees e
on d.id = e.departament_id;

select * from departaments d
right join employees e
on d.id = e.departament_id;

select * from departaments d
full join employees e
on d.id = e.departament_id;

select * from departaments d
cross join employees e;

select * from departaments d
left join employees e
on d.id = e.departament_id
where e.departament_id is null;


select d.name, e.name
from departaments d
left join employees e
on d.id = e.departament_id;

select d.name, e.name
from employees e
right join departaments d
on e.departament_id = d.id;










create table teens(
	id serial primary key,
	name varchar(255),
	gender varchar(255)
);

insert into teens(name, gender)
values('Vasya', 'm');
insert into teens(name, gender)
values('Alex', 'm');
insert into teens(name, gender)
values('Anton', 'm');
insert into teens(name, gender)
values('Maria', 'w');
insert into teens(name, gender)
values('Anna', 'w');
insert into teens(name, gender)
values('Lisa', 'w');

select concat(t1.name, ' ', t2.name) as "Pair"
from teens t1
cross join teens t2
where t1.gender != t2.gender and t1.gender = 'm'
order by "Pair";