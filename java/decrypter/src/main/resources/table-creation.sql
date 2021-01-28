create table user_roles (
	role_id		serial,
	role_name	varchar(25) unique not null,
	constraint user_roles_pk
	primary key (role_id)
);
create table app_users (
	user_id		serial,
	username	varchar unique not null,
	password	varchar	not null,
	first_name	varchar not null,
	last_name	varchar not null,
	role_id		int not null,
	constraint app_users_pk
	primary key (user_id),
	constraint app_user_role_fk
	foreign key (role_id)
	references user_roles
);