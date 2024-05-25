create table usernames(
	id serial primary key,
	name varchar(255)
);

create table users(
	id serial primary key,
	name varchar(255),
	usernames_id int references usernames(id)
);