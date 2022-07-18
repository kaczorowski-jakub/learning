CREATE TABLE cities (
	name VARCHAR(50),
	country VARCHAR(50),
	population INTEGER,
	area INTEGER
); 

INSERT INTO cities (name, country, population, area)
VALUES ('Tokyo', 'Japan', 38505000, 8223);

INSERT INTO cities (name, country, population, area)
VALUES 
('Delhi', 'India', 28125000, 2240),
('Shanghai', 'China', 22125000, 4015),
('Sao Paulo', 'Brazil', 20935000, 2043);

select * from cities;
select name, population from cities;
select name, population/area as population_density from cities;

--this does the same thing
select name || ', ' || country as location from cities;
select CONCAT(name,', ', country) as location from cities;

select UPPER(name), LOWER(country) from cities;

-- WHERE
select name, area from cities where area > 4000;
select name, area from cities where area between 2200 and 9000;
select * from cities where name in ('Delhi', 'Shanghai');
select * from cities where name not in ('Delhi', 'Shanghai');
select * from cities where name not in ('Delhi', 'Shanghai') and area > 2200;

-- WHERE + Calculation
select * from cities where population / area > 6000;

-- UPDATE
update cities set population = 39505000 where name = 'Tokyo';

-- DELETE
delete from cities where name = 'Tokyo';