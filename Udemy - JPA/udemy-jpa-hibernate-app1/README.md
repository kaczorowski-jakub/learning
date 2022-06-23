#General
JPA is a specification of Java Persistence API: it has interfaces defined and a description of what they do

Hibernate is a JPA Provider, but it also has its own Native API
To get access to Hibernate JPA as a provider we need to unwrap session and or session factory

##Queries
select * from passport

select * from customer

select * from actor

select * from movie

select * from movie_actor

select * from employee

select * from friend

select * from friend_nickname

select * from parent

select * from message order by id desc