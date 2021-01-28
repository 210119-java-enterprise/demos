/*
	serial = starts at value of 1 and increments when adding lines
	varchar = characters
	numeric = numbers with decimal
	date = date
	int = integer (no decimal)
	
	Departments 
		- id serial (auto incrementing)
		- name varchar
		- monthly_budget numeric
	Employees
		- id serial
		- first_name varchar
		- last_name varchar
		- birthdate date
		- monthly_income numeric
		- department_id int
		- hire_date date (with a default)
		- job_title varchar
		- email varchar
	Products
		- id serial
		- name varchar
		- price numeric
*/

drop table if exists products;
drop table if exists employees;
drop table if exsits departments;

create table departments (
	id serial constraint department_pk primary key, 
	name varchar(25) unique not null,
	monthly_budget numeric(8, 2) -- first # is precision (number of digits in whole number); second # is scale (the number of decimal places)
);

create table employees (
	id serial, 
	first_name varchar(25) not null,
	last_name varchar(25) not null,
	birthdate date not null,
	monthly_income numeric(7, 2),
	department_id int,
	hire_date date default current_date,
	job_title varchar(25),
	email varchar(320), 
	
	constraint employee_pk primary key (id),
	constraint employee_department_fk foreign key (department_id) references departments
);

create table products (
	id serial,
	name varchar(50) not null,
	price numeric(7,2) default 0,
	expiration_date date not null
);

alter table products
add constraint product_pk primary key (id);

-- no need to commit the above statments, ddl statemetns are implicitly commited
-- add values to the departments table
insert into departments (name, monthly_budget) values ('Accounting', 20000), ('Marketing', 15000), ('IT', 30000), ('Human Resources', 25000), ('Customer Service', 2000), ('Regulatory Affairs', 5000);

insert into employees (first_name, last_name, birthdate, monthly_income, department_id, hire_date, job_title, email) 
values 
	('JOHN', 'SMITH', date '1995-01-01', 4000.00, 1, date '2015-03-28', 'AC_ACCOUNT', 'JSMITH'), 
	('JAMES', 'BOSH', date '1992-02-15', 3500.00, 2, date '2014-07-01', 'MK_REP', 'JBOSH'),
	('LUISA', 'JACKSON', date '1970-03-08', 4500.00, 3, date '2013-08-29', 'IT_PROG', 'LJACKSON'),
	('STUART', 'GARCIA', date '1965-04-12', 2000.00, 4, date '2010-02-15', 'HR_REP', 'SGARCIA'),
	('JUSTIN', 'BLACK', date '1990-05-16', 2550.00, 1, date '2015-05-02', 'AC_ACCOUNT', 'JBLACK'),
	('ANGIE', 'CROOD', date '1998-06-22', 1500.00, 1, date '2015-07-01', 'AC_ACCOUNT', 'ACROOD'),
	('CHARLES', 'DEAN', date '1973-06-08', 2250.00, 3, date '2002-03-01', 'IT_PROG', 'CDEAN'),
	('EDDIE', 'FARREL', date '1980-07-28', 3000.00, 1, date '2009-04-20', 'AC_ACCOUNT', 'EFARREL'),
	('GEORGE', 'HAYES', date '1982-08-03', 2500.00, 2, date '2012-09-22', 'MK_REP', 'GHAYES'),
	('IGOR', 'OSBOURNE', date '1987-09-11', 6000.00, 3, date '2014-11-14', 'IT_PROG', 'IKEYS'),
	('LUKE', 'MINT', date '1985-10-19', 5000.00, 4, date '2011-01-08', 'HR_REP', 'LMINT'),
	('NIGEL', 'OAKS', date '1997-11-05', 4750.00, 4, date '2014-10-01', 'HR_REP', 'NOAKS'),
	('LUKE', 'GREEN', date '1995-02-05', 4750.00, 4, date '2015-09-01', 'HR_REP', 'LGREEN');
insert into products (name, price, expiration_date) 
values 
	('Aspirin', 5.00, date '2020-12-31'),
	('Penicillin', 10.00, date '2019-04-30'),
	('Insulin', 25.00, date '2018-05-31'),
	('Acetaminophen', 5.00, date '2019-01-31'),
	('Amoxicillin', 8.00, date '2018-07-31');

--commit; 				-- used to save where we are and update records for db basically 
--delete from products; -- deletes without where delets all records from table
--rollback; 			-- rollback can bring you back to the previous save/commit
						-- rolling back to a SAVEPOINT and then rolling back again will bring you to previous commit
						-- cant rollback past last commit
						
select name, price, 'test', name, (price - (price * .3)) as discount from products; -- uses a column alias and a lot of cool things
						-- only one savepoint at a time

select * from products where expiration_date < '01-APR-2019'; -- date string w/o date keyword - still works on other formats

select * from products where (id < 5 or name = 'ten' and price > 10) and (price > 1 or expiration_date = '2018-04-30'); -- super convoluted but valid

select distinct department_id from employees; -- removes duplicate entries

/*
 * Scalar functions
 * 
 * 	Scalar function, aka single-row/value function, return a value for
 *  every row that is processed in a query. 
 * 
 * 	WORK ON ONE PIECE OF DATA AT A TIME VS AGGREGATE FUNCTIONS WORK ON GROUPS
 * 
 *  Types:
 * 		- Numeric functions (https://www.postgresql.org/docs/11/functions-math.html)
 * 		- Character functions (https://www.postgresql.org/docs/11/functions-string.html)
 * 		- Date functions (https://www.postgresql.org/docs/11/functions-datetime.html)
 */

select substring('test', 1, 3); -- inclusive range index 1 based
select abs(-11); -- 11
select substring(name, 1, 1)
from departments; -- gives first letter from department name
select floor(2.678); -- gives 2 rouds to lower integer (floor, ceiling round)
select length('wezley'); -- gives length
select first_name, last_name, age(current_date, birthdate) as current_age from employees;

/*
 * Aggregate functions
 * 
 * 		Operations which can be performed on a group of records in order to
 * 		provide a single value/result.
 */

select min(price) as min_price, max(price), avg(price), sum(price) from products;
select count(name) from products; -- aggregate because it goes through the name collumn to count them - doesnt just look at one name - also doesnt count null
--insert into products (price, expiration_date) values (5, )
alter table products add abbr_name varchar(4);
update products set abbr_name = substring(name, 1, 4) where id < 4;
select * from products;

/*
 * GROUP BY -- VS ORDER BY BIG
 * 
 * 
 * 		This clause divides records returned from a SELECT statement into groups. With each group,
 * 		we can apply some aggregate function to calculate some value for that group.
 */

select * from employees;
select department_id, count(department_id) as employee_count
from employees group by department_id order by department_id;

/*
 * HAVING clause
 * 		
 * 		Allows developers to pick out particular rows where some aggregate function's returned value
 * 		meets some condition.
 * 
 * 		syntax breakdown:
 * 			SELECT ...
 * 			FROM ...
 * 			WHERE ...
 * 			GROUP BY ...
 * 			HAVING ...
 * 			ORDER BY ...
 */
/*
 * Retrieve only departments whose smallest salary is less than 2000/month or 
 * the highest salary is greater than 4000/month. Display results in descending
 * order by salary.
 */
select department_id, min(monthly_income) as minIncome, max(monthly_income) as max_income
from employees
group by department_id
	having
		min(monthly_income) < 2000
		or
		max(montly_income) > 4000
order by min_income desc;

select department_id from employees where (monthly_income < 2000) or (monthly_income > 4000) order by monthly_income;

select * from employees;











