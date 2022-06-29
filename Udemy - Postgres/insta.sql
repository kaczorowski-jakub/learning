create table users (
	id SERIAL PRIMARY KEY,
	username VARCHAR(50)
);

insert into users (username)
values ('monahan93'),('pferre'),('test'),('nothing19');

select * from users;