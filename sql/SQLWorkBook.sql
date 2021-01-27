-- 2.1 Select

--select all records from Employee
select * from "Employee";

-- select all records from Employee where the last name is King
select * from "Employee" where "LastName" = 'King';

-- Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from "Employee" where "FirstName" = 'Andrew' and "ReportsTo" is null;

-- 2.2 Order By

-- Select all albums in album table and sort result set in descending order
select * from "Album" order by "AlbumId" desc;

-- Select first name from customer and sort result set in ascending order
select "FirstName" from "Customer" order by "FirstName" asc;

-- 2.3 Insert Into

-- insert two new records into Genre table
insert into "Genre" values(26,'insertValue1'), (27,'isertValue2');

-- insert two new records into Employee table

insert into "Employee" values(9,'value1','inserted','IT Staff',1,Current_timestamp ,CURRENT_TIMESTAMP,'123 madeUpLane','Calgary', 'AB', 'Canada', 'T2k 1N0','+1 (403) 000-0000','+1 (403) 111-1111','dummy1@chinookcorp.com'),
(10,'value2','inserted','IT Staff',1,Current_date ,CURRENT_TIMESTAMP,'1234 madeUpLane','Calgary', 'AB', 'Canada', 'T3k 2N1','+1 (403) 111-0000','+1 (403) 222-1111','dummy2@chinookcorp.com');

-- insert two new records into Customer table
insert into "Customer" values(60,'insert1','value1',null,'123 madeUpLane','New York','New York','UnitedStates'),(61,'insert2','value2',null,'1234 madeUpLane');
