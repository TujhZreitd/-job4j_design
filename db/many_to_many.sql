create table employees(
	id serial primary key,
	name varchar(255)
);

create table tasks(
	id serial primary key,
	name varchar(255)
);

create table employees_tasks(
	id serial primary key,
	employees_id int references employees(id),
	tasks_id int references tasks(id)
);