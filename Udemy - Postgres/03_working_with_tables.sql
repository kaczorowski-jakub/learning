drop table users;
create table users (
	id SERIAL PRIMARY KEY,
	username VARCHAR(50)
);

insert into users (username)
values ('monahan93'),('pferre'),('test'),('nothing19');

select * from users;

-- FOREIGN KEY
CREATE TABLE photos (
	id SERIAL PRIMARY KEY,
	url VARCHAR(200),
	user_id INTEGER REFERENCES users(id)
);

insert into photos (url, user_id)
values ('http://one.jpg',4);

insert into photos (url, user_id)
values ('http://two.jpg',1),('http://25.jpg',1),('http://43.jpg',1),('http://t34242wo.jpg',2),('http://432.jpg',3),
('http://1122.jpg',4);

select * from photos
select * from photos where user_id = 4
select url, username from photos p join users u on (p.user_id = u.id)

-- error
insert into photos (url, user_id)
values ('http://error.jpg',100);

-- null
insert into photos (url, user_id)
values ('http://error.jpg',NULL);

-- delete user related to photo
-- 		error: update or delete on table "users" violates foreign key constraint "photos_user_id_fkey" on table "photos"
delete from users where id=1;

-- on delete cascade
drop table photos;
CREATE TABLE photos (
id SERIAL PRIMARY KEY,
url VARCHAR(200),
user_id INTEGER REFERENCES users(id) on delete cascade
);
INSERT INTO photos (url, user_id)
VALUES
('http:/one.jpg', 4),
('http:/two.jpg', 1),
('http:/25.jpg', 1),
('http:/36.jpg', 1),
('http:/754.jpg', 2),
('http:/35.jpg', 3),
('http:/256.jpg', 4);
delete from users where id=1;
select * from photos

-- on delete set null
drop table photos;
CREATE TABLE photos (
id SERIAL PRIMARY KEY,
url VARCHAR(200),
user_id INTEGER REFERENCES users(id) on delete set null
);
INSERT INTO photos (url, user_id)
VALUES
('http:/one.jpg', 4),
('http:/two.jpg', 1),
('http:/25.jpg', 1),
('http:/36.jpg', 1),
('http:/754.jpg', 2),
('http:/35.jpg', 3),
('http:/256.jpg', 4);
delete from users where id=1;
select * from photos;