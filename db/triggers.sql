create
or replace function tax()
returns trigger as
$$
	BEGIN
		update products
		set price = price + price * 0.2
		where id = (select id from inserted);
		return NEW;
	END;
$$
LANGUAGE 'plpgsql';

create trigger tax_trigger
after insert
on products
referencing new table as inserted
for each statement
execute procedure tax();


create
or replace function tax1()
returns trigger as
$$
	BEGIN
		NEW.price = NEW.price + NEW.price * 0.2;
	RETURN NEW;
	END;
$$
LANGUAGE 'plpgsql';

create trigger tax_trigger_before
before insert
on products
for each row
execute procedure tax1();


create
or replace function insert_history_func()
returns trigger as
$$
	BEGIN
	insert into history_of_price(name, price, date)
	values(NEW.name, NEW.price, NOW());
	RETURN NEW;
	END;
$$
LANGUAGE 'plpgsql';

create trigger insert_history
after insert
on products
for each row
execute procedure insert_history_func();