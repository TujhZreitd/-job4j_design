insert into roles(name) values('Admin');
insert into roles(name) values('User');
insert into rules(name) values('Read');
insert into rules(name) values('Write');
insert into rules(name) values('Delete');
insert into categories(name) values('Delete');
insert into states(state) values(true);
insert into states(state) values(false);


insert into users(name, roles_id) values('Alex', 1);
insert into users(name, roles_id) values('Anton', 2);

insert into roles_rules(roles_id, rules_id) values(1, 1);
insert into roles_rules(roles_id, rules_id) values(1, 2);
insert into roles_rules(roles_id, rules_id) values(1, 3);
insert into roles_rules(roles_id, rules_id) values(2, 1);
insert into roles_rules(roles_id, rules_id) values(2, 2);

insert into items(name, users_id, categories_id, states_id) values('Delete msg', 1, 1, 2);

insert into comments(name, items_id) values('Abuse words', 1);

insert into attachs(name, items_id) values('Screenshot', 1);

