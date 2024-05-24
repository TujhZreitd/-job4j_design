create table employees(
	id serial primary key,
	name varchar(255),
	salary numeric(5,2),
	sex bool
);
insert into employees(name, salary, sex) values('Alex', '200.50', 'true');
update employees set salary = '300.99';
delete from employees;