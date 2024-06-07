CREATE TABLE customers
(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);

insert into customers(first_name, last_name, age, country)
values('Egor', 'Yakushev', 27, 'Russia');
insert into customers(first_name, last_name, age, country)
values('Diana', 'Ivanova', 30, 'Russia');
insert into customers(first_name, last_name, age, country)
values('Alex', 'Sidorov', 22, 'Ukraine');
insert into customers(first_name, last_name, age, country)
values('Maria', 'Antonova', 21, 'USA');
insert into customers(first_name, last_name, age, country)
values('Tanya', 'Vasilieva', 21, 'Canada');


select CONCAT(first_name, ' ', last_name) as nameClient
	from customers
	where age in (select MIN(age) from customers);

CREATE TABLE orders
(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);

insert into orders(amount, customer_id)
values(2, 1);
insert into orders(amount, customer_id)
values(3, 3);
insert into orders(amount, customer_id)
values(1, 4);

select * from customers
where id not in (select customer_id from orders);
