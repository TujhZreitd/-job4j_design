select name_author from(
	select a.name as name_author, count(a.name) as
	quantity_books
	from authors as a
	join books as b on a.id = b.author_id
	join orders o on b.id = o.book_id
	join students s on s.id = o.student_id
	group by (a.name))
where quantity_books = (select MAX(quantity_books) from(
	select a.name as name_author,
		count(a.name) as quantity_books
	from authors as a
	join books as b on a.id = b.author_id
	join orders o on b.id = o.book_id
	join students s on s.id = o.student_id
	group by (a.name)));