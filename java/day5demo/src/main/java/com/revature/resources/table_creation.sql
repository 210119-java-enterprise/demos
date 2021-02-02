drop table if exists app_users;
drop table if exists user_roles;

create table user_roles(
	role_id 	serial,
	role_name 	varchar(25) unique not null,
	
	constraint user_roles_PK primary key (role_id)
);

create table app_users(
	user_id 	serial,
	username	varchar(25) unique not null,
	password	varchar(25) not null,
	first_name	varchar(25) not null,
	last_name	varchar(25) not null,
	role_id		int not null,
	
	constraint app_users_PK primary key (user_id),
	constraint app_user_role_FK foreign key (role_id) references user_roles
);