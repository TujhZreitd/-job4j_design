create table car_bodies(
	id serial primary key,
	name varchar(255)
);

create table car_engines(
	id serial primary key,
	name varchar(255)
);

create table car_transmissions(
	id serial primary key,
	name varchar(255)
);

create table cars(
	id serial primary key,
	name varchar(255),
	body_id int references car_bodies(id),
	engine_id int references car_engines(id),
	transmission_id int references car_transmissions(id)
);

insert into car_bodies(name) values('Sedan');
insert into car_bodies(name) values('Hatchback');
insert into car_bodies(name) values('Pickup');

insert into car_engines(name) values('V6');
insert into car_engines(name) values('V8');

insert into car_transmissions(name) values('Auto');
insert into car_transmissions(name) values('Mechanical');

insert into cars(name, body_id, engine_id, transmission_id)
values('Ford Focus', 1, 2, 1);
insert into cars(name, body_id, engine_id, transmission_id)
values('VW Golf', 2, 2, 1);
insert into cars(name, body_id, engine_id, transmission_id)
values('Kia Picanto', 2, null, 1);

select c.name car_name,
	b.name body_name,
	e.name engine_name,
	t.name transmission_name
from cars c
left join car_bodies b on c.body_id = b.id
left join car_engines e on c.engine_id = e.id
left join car_transmissions t on c.transmission_id = t.id;

select b.name body_name
from car_bodies b
left join cars c
on b.id = c.body_id
where c.body_id is null;

select e.name engine_name
from car_engines e
left join cars c
on e.id = c.engine_id
where c.engine_id is null;

select t.name transmission_name
from car_transmissions t
left join cars c
on t.id = c.transmission_id
where c.transmission_id is null;