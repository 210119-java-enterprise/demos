/*
	PL/pgSQL = Procedural Language extension of PostgreSQL
	
		- NOT A SUBLANGUAGE OF SQL!
		- Allows devs to create:
			- stored functions
			- stored procedures (since 11)
			- triggers
			- custom types
			
		- Adds procedural features to the normally declarative SQL scripts
			- loops
			- exception handling
			- if statements
			
*/


/*
	Stored Functions
	
		create [or replace] function [name] (params)
		returns [type]
		as '
			begin
				[logic]
			end
		'
		language plpgsql;
*/

create or replace function multiply(x numeric, y numeric)
returns numeric 
as '
	begin 
		return x * y;
	end
' 
language plpgsql;

select multiply(5, 4);

create or replace function multiply(x numeric, y numeric, z numeric)
returns numeric
as '
	begin
		return $1 * $2 * $3; -- another way to access params inside a fn
	end
'
language plpgsql;

select multiply(2, '42', 2); -- apparently Postgre can do a little type coercion

-- another function using dollarquotes! $$ $$
create or replace function get_last_track_info()
returns text
as $$

	declare 
		largest int;
		track_name text;
		result text;
	
	begin
		
		select max("TrackId")
		into largest
		from "Track";
	
		select "Name"
		into track_name
		from "Track"
		where "TrackId" = largest;
	
		result := largest || ' - ' || track_name;
	
		return result;
		
	end
$$ 
language plpgsql;

select get_last_track_info();

create or replace function get_all()
returns refcursor
as $$

	declare
		ref refcursor;
	
	begin

		open ref for
		select *
		from "Artist";
	
		return ref;
	
	end

$$ language plpgsql;

-- TODO: invoke function that returns a refcursor and iterate across it

/*
 *	Triggers
 *
 * 		create trigger [name]
 * 		[before|after|instead of] [insert|update|delete] on [table]
 * 		for each [row|statement]
 * 		execture function [function-name|procedure-name]
 *
 */

update colors
set color = 'blue' where id = 4;

create or replace function no_more_blues()
returns trigger
as $$
	
	begin 
		
		if (new.color = 'blue') then 
			return null;
		end if;
	
		return new;
		
	end
	
$$ language plpgsql;

create trigger no_blues
before insert or update on colors
for each row
execute function no_more_blues();

select * from colors;

insert into colors (color) values ('yellow');
insert into colors (color) values ('blue');
update colors set color = 'blue' where id = 1;

-- does the trigger fire off if we manipulate a view based on the table? :thinking_face:
-- it does fire off, preventing blue data from going in
create view view_colors as
select * from colors;

select * from view_colors;

insert into view_colors (color) values ('blue');



