create table certification(
	id serial primary key,
	number int
);

create table product(
	id serial primary key,
	name varchar(255),
	certification_id int references certification(id) unique
);

insert into certification(number) values(0001);
insert into certification(number) values(0002);
insert into certification(number) values(0003);

insert into product(name, certification_id)
values('Phone1', 1);
insert into product(name, certification_id)
values('Phone2', 2);
insert into product(name, certification_id)
values('Phone3', 3);

select p.name, c.number
from product as p join certification as c on p.certification_id = c.id;

select p.name as Name_product, c.number as Id_number_product
from product as p join certification as c on p.certification_id = c.id;

select p.name as "Название продукта", c.number as "Индивидуальный номер продукта"
from product p join certification c on p.certification_id = c.id;


