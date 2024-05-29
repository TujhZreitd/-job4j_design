create table type(
	id serial primary key,
	name varchar(255)
);

create table product(
	id serial primary key,
	name varchar(255),
	type_id int references type(id),
	expired_data date,
	price int
);

insert into type(name) values('Сыр');
insert into type(name) values('Молоко');
insert into type(name) values('Хлеб');

insert into product(name, type_id, expired_data, price)
values('Мороженое', 2, '2024-05-31', 250);
insert into product(name, type_id, expired_data, price)
values('Плавленный сыр', 1, '2024-05-20', 100);
insert into product(name, type_id, expired_data, price)
values('Сыр Моцарелла', 1, '2024-06-30', 500);
insert into product(name, type_id, expired_data, price)
values('Молоко цельное', 2, '2024-06-02', 150);
insert into product(name, type_id, expired_data, price)
values('Хлеб Бородинский', 3, '2024-06-01', 200);
insert into product(name, type_id, expired_data, price)
values('Хлеб ржаной', 3, '2024-05-24', 100);
insert into product(name, type_id, expired_data, price)
values('Мороженое особое', 2, '2024-06-29', 500);
insert into product(name, type_id, expired_data, price)
values('Хлеб ржаной', 3, '2024-06-01', 100);
insert into product(name, type_id, expired_data, price)
values('Хлеб ржаной', 3, '2024-06-01', 100);
insert into product(name, type_id, expired_data, price)
values('Хлеб ржаной', 3, '2024-06-01', 100);
insert into product(name, type_id, expired_data, price)
values('Хлеб ржаной', 3, '2024-06-01', 100);
insert into product(name, type_id, expired_data, price)
values('Хлеб ржаной', 3, '2024-06-01', 100);
insert into product(name, type_id, expired_data, price)
values('Хлеб ржаной', 3, '2024-06-01', 100);
insert into product(name, type_id, expired_data, price)
values('Хлеб ржаной', 3, '2024-06-01', 100);
insert into product(name, type_id, expired_data, price)
values('Хлеб ржаной', 3, '2024-06-01', 100);
insert into product(name, type_id, expired_data, price)
values('Хлеб ржаной', 3, '2024-06-01', 100);
insert into product(name, type_id, expired_data, price)
values('Хлеб ржаной', 3, '2024-06-01', 100);

select p.name
from product p
join type t on p.type_id = t.id and LOWER(t.name) = LOWER('СЫР')
group by p.name;

select name from product where LOWER(name) like LOWER('%мороженое%');

select name from product where expired_data < NOW();

select name from product
where price = (select MAX(price) from product);

select t.name, count(p.name)
from product p
join type t on p.type_id = t.id
group by t.name;

select p.name
from product p
join type t on p.type_id = t.id
and (LOWER(t.name) = LOWER('СЫР')
or LOWER(t.name) = LOWER('МОЛОКО'))
group by p.name;

select t.name
from type t
join product p on p.type_id = t.id
group by t.name
having COUNT(p.name) < 10;

select p.name, t.name
from product p
join type t on p.type_id = t.id;