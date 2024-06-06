begin transaction;

declare
cursor_products_scroll
scroll
cursor for
select * from products;

FETCH LAST from cursor_products_scroll;
MOVE FORWARD 15 from cursor_products_scroll;
MOVE BACKWARD 7 from cursor_products_scroll;
MOVE BACKWARD 2 from cursor_products_scroll;
MOVE BACKWARD 1 from cursor_products_scroll;