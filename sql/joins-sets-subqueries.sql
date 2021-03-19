-- Joins

/*
 * Join Types
 * 		- INNER (more inclusive of the results from both tables)
 * 			+ FULL
 * 			+ RIGHT
 * 			+ LEFT
 * 
 * 		- OUTER (more exclusive of the results from both tables)
 * 			+ FULL
 * 			+ RIGHT
 * 			+ LEFT
 * 		
 * 		- SELF
 * 
 * 		- CROSS
 * 
 * -----------------------------
 * 
 * 		- Theta Joins (when your ON clause uses an arbitrary comparison <, >, >=, <= etc
 *  		- Equi Joins (theta joins that uses the equality operator (=)
 * 				- Natural join (the join occurs on a column whose name is shared between both tables - lets us do USING)
 */

select * 
from "Artist";

select *
from "Album";

select *
from "Employee";

-- INNER JOIN with an ON clause
select alb."AlbumId", alb."Title", art."Name" as artist
from "Album" alb
join "Artist" art
on alb."ArtistId" = art."ArtistId";

-- the keyword INNER is always implied if join type no other is specified
select alb."AlbumId", alb."Title", art."Name" as artist
from "Album" alb
inner join "Artist" art
on alb."ArtistId" = art."ArtistId";

-- Natural inner join
-- the two tables being joined share a column with the exact same name
select alb."AlbumId", alb."Title", art."Name" as artist
from "Album" alb
join "Artist" art
using ("ArtistId");

-- Self join (joins on another record within the same table)
select e1."FirstName", e1."LastName", e1."Title", e2."FirstName", e2."LastName", e2."Title"
from "Employee" e1
join "Employee" e2
on e1."ReportsTo" = e2."EmployeeId";

-- Multi-table joins
select 
	t."Name" as track_name, 
	alb."Title" as album_title, 
	art."Name" as artist_name
from "Track" t
join "Album" alb
using ("AlbumId")
join "Artist" art
using ("ArtistId")
order by artist_name;

create table sizes (
	id serial constraint "sizes_pk" primary key,
	size varchar
);

create table colors (
	id serial constraint "colors_pk" primary key,
	color varchar
);

insert into sizes (size)
values
	('S'), ('M'), ('L'), ('XL'), ('XXL');

insert into colors (color) 
values
	('red'), ('orange'), ('yellow'), ('green'), ('blue'), ('indigo'), ('violet');

select *
from sizes;

select *
from colors;

select s.size, c.color
from sizes s
cross join colors c;

-- gross way to do joins is to not use the join clause at all
select s.size, c.color
from sizes s, colors c;


-- Subqueries
-- Also called "nested queries"
-- Can be used in: column selector list, from clause, and where clause

-- subquery in a from clause
select some_name.*
from (
	select *
	from "Genre"
	where "Name" like 'R%' -- LIKE is case-sensitve!
	) as some_name
where some_name."GenreId" > 6;

-- subquery in a where clause
select *
from "Employee"
where "HireDate" in -- IN is for checking to see if a value is included within a result set of other values
	(
		select "HireDate"
		from "Employee"
		order by "HireDate" 
		limit 5 -- limits the result set to 5 records
	);

/*
 * Views
 * 
 * 		When we execute a query, we generate a result set.
 * 		Sometimes we may frequently use that result set as 
 * 		a base for executing other queries.
 * 
 * 		Views are basically just saved result sets that have
 * 		a name that can be references and they act as a sort 
 * 		of "virtual table" - not a real table.
 */
create table demo_customers(
	id serial,
	fn varchar(25),
	ln varchar(25)
);

insert into demo_customers (fn, ln)
values ('Wezley', 'Singleton'), ('Nick', 'Jurczak'), ('Mehrab', 'Rahman');

select *
from demo_customers
where id >= 2;

create view view_demo_customers as
select *
from demo_customers
where id >= 2;

select *
from view_demo_customers vdc;

insert into demo_customers (fn, ln)
values ('Steven', 'Kelsey');

insert into view_demo_customers (fn, ln)
values ('Trevin', 'Chester');

-- try to break the view by adding a record with an id <= 2
insert into view_demo_customers
values (0, 'Trevin', 'Chester');

select *
from demo_customers;


/*
 * Set Operations
 * 		- UNION
 * 		- UNION ALL
 * 		- INTERSECT
 * 		- EXCEPT
 * 
 * Rules for using set operators with multiple queries:
 * 		1. The result sets from each composite query MUST have the same number of selected columns
 * 		2. Each respective column in each query must be compatible with each other
 */


