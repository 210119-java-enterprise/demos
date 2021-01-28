-- Joins
select * from "Artist";
select * from "Album";


-- INNER JOIN with an ON clause (on used to define two columns you are doing the join on)
-- (also a natural join because using same column name (albumid)
select alb."AlbumId", alb."Title", art."Name" as artist
from "Album" alb -- finds the table identifier before resolving the select clause! 
join "Artist" art -- keyword inner is always implied if nothing specified
on alb."ArtistId" = art."ArtistId";

--Natural inner join 
--2 tables being joined share a column with exact same name
select alb."AlbumId", alb."Title", art."Name" as artist
from "Album" alb -- finds the table identifier before resolving the select clause! 
join "Artist" art -- keyword inner is always implied if nothing specified
using ("ArtistId");

-- self join (joins on another record within the same table) - joining a table with itself **
select e1."FirstName", e1."LastName", e1."Title", e2."FirstName", e2."LastName", e2."Title" 
from "Employee" e1
join "Employee" e2
on e1."ReportsTo" = e2."EmployeeId"; -- using reports to becuase thats the column we want to join on 

-- multi-table joins
select t."Name" as track_name, alb."Title" as album_title, art."Name" as artist_name
from "Track" t
join "Album" alb 
using ("AlbumId")
join "Artist" art 
using ("ArtistId")
order by artist_name;

/*
	Set operations - union on results between queries basically 
		- union
		- union all
		- intersect
		- except
		
	Rules for using with multiple queries 
		- result sets from each query must have the same number of selected columns
		- each respective column in the queries must be compatable with eachother (typewise)
*/

create table sizes (
	id serial constraint "sizes_pk" primary key, 
	size varchar
);

create table colors (
	id serial constraint "colors_pk" primary key, 
	color varchar
);
insert into sizes(size)
	values ('S'), ('M'), ('L'), ('XL'), ('XXL');
	
insert into colors(color)
values ('red'), ('orange'), ('yellow'), ('green'), ('blue'), ('indigo'), ('violet');

-- cross joining the two tables will create 35 entries as they each have 7 and 5 (7*5)
select * from sizes; --5
select * from colors; --7

select * from sizes cross join colors;

select s.size, c.color from sizes s cross join colors c;

select s.size, c.color from sizes s, colors c;

/* 
	inner - full right left
	outer - full right left
	self
	cross
	
	
	theta joins (when your on clause uses arbitrary comparison <, >, etc)
		equi joins (theta joins that use equality op =)
			natural join (both tables have a column with same name) USING keyword
*/

/*
	subqueries 
	also called nested queries
	kind of a way around joins
	subquery in from clause
*/
select some_name.*
from (
	select * from "Genre" where "Name" like 'R%' 
	) as some_name
where some_name."GenreId" > 6;

-- subquery in a where clause
select * from "Employee" 
where "HireDate" in
	(
		select "HireDate"
		from "Employee"
		order by "HireDate" 
		limit 5
	);
-- IN is for checking to see if a value is included within a result set of other values
-- IS is for checking one value probably ? 

/* 
 * Views
 * 
 * 		when we execute a query we generate a result set. that result set can then be used as a base for executing other queries
 * 		views are basically saved result sets that have a name that can be referenced and they act as a sort of 'virtual table'
 */
create table demo_customers( id serial, fn varchar(25), ln varchar(25));

insert into demo_customers (fn, ln) values ('wezley', 'singleton'), ('Nick', 'jurczak'), ('mehrab', 'rahman'); 

select * from demo_customers where id>=2;

create view view_demo_customers as select * from demo_customers where id>=2;

select * from view_demo_customers vdc;

insert into demo_customers (fn, ln) values('steven', 'kelsey');

insert into view_demo_customers (fn, ln) values ('tevin', 'chester');

	