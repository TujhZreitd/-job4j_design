insert into fauna(name, avg_age, discovery_date)
values ('Black_cat', 15000, '1560-08-05');
insert into fauna(name, avg_age, discovery_date)
values('Red_dog', 25000, '1427-07-15');
insert into fauna(name, avg_age, discovery_date)
values('Blue_fish', 8000, '1955-01-21');
insert into fauna(name, avg_age, discovery_date)
values('Orange_bird', 9500, '1927-12-02');
insert into fauna(name, avg_age, discovery_date)
values('Little_mouse', 10000, '1999-07-07');

select * from fauna where name like '%fish%';

select * from fauna where avg_age > 10000 and avg_age < 21000;

select * from fauna where discovery_date is null;

select * from fauna where discovery_date < '01.01.1950';