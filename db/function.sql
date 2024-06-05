create
or replace procedure delete_data(u_id integer)
language 'plpgsql'
as $$
	BEGIN
		delete from products where id = u_id and count = 0;
	END;
$$;

create
or replace function f_delete_data(i_id integer)
returns void
language 'plpgsql'
as
$$
begin
delete from products where id = i_id and count = 0;
end;
$$;