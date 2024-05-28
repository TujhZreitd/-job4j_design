create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices (id),
    people_id int references people (id)
);

insert into devices(name, price) values('IPhone6', 4599.9);
insert into devices(name, price) values('IPhone7', 5699.8);
insert into devices(name, price) values('IPhone8', 7999.5);
insert into devices(name, price) values('IPhoneX', 10355.4);
insert into devices(name, price) values('Xiaomi', 2999.5);
insert into devices(name, price) values('Xiaomi+', 3600.7);

insert into people(name) values('Alex');
insert into people(name) values('Anton');
insert into people(name) values('Egor');
insert into people(name) values('Anna');
insert into people(name) values('Mariya');

insert into devices_people(device_id, people_id) values(1, 1);
insert into devices_people(device_id, people_id) values(4, 1);
insert into devices_people(device_id, people_id) values(2, 2);
insert into devices_people(device_id, people_id) values(6, 2);
insert into devices_people(device_id, people_id) values(4, 3);
insert into devices_people(device_id, people_id) values(6, 3);
insert into devices_people(device_id, people_id) values(3, 3);
insert into devices_people(device_id, people_id) values(5, 4);
insert into devices_people(device_id, people_id) values(3, 4);
insert into devices_people(device_id, people_id) values(1, 5);
insert into devices_people(device_id, people_id) values(2, 5);

select avg(price) from devices;

select p.name, avg(d.price)
from devices_people dp
join devices d on dp.device_id = d.id
join people p on dp.people_id = p.id
group by p.name;

select p.name, avg(d.price)
from devices_people dp
join devices d on dp.device_id = d.id
join people p on dp.people_id = p.id
group by p.name
having avg(d.price) > 5000;