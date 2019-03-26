-- *******************************************
-- database creation
-- *******************************************
-- CREATE DATABASE mediabinge;
use MediaBinge;

/******DROP TABLE SCRIPT*/
DROP TABLE MB_responses;
DROP TABLE MB_posts;
DROP TABLE MB_topics;
DROP TABLE MB_profile;
DROP TABLE MB_users;
DROP TABLE MB_roles;


-- *******************************************
-- table creation
-- *******************************************
CREATE TABLE MB_topics (
	topic_id INT PRIMARY KEY,
    topic VARCHAR(15) NOT NULL
); -- runs

CREATE TABLE MB_roles (
	role_id INT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(15) NOT NULL
);

CREATE TABLE MB_users(
	user_id INT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(50) NOT NULL UNIQUE,
	password VARCHAR(50) NOT NULL,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50),
	role_id INT,
	
	CONSTRAINT user_role_fk
	FOREIGN KEY (role_id)
	REFERENCES MB_roles (role_id)
); -- runs

select * from MB_users;

CREATE TABLE MB_profile(
	profile_id INT PRIMARY KEY AUTO_INCREMENT,
	favorite_books VARCHAR(255),
	favorite_movies VARCHAR(255),
    favorite_tv_shows VARCHAR(255),
	user_id INT UNIQUE,

	CONSTRAINT user_id_fk
	FOREIGN KEY  (user_id)
	REFERENCES MB_users (user_id)
); -- runs

select * from MB_profile;

CREATE TABLE MB_posts(
	post_id INT PRIMARY KEY AUTO_INCREMENT,
	user_id INT,
	topic_id INT,
	post_text VARCHAR(255) NOT NULL,
	/*--something to reference api call maybe another table???*/
	date_posted TIMESTAMP,

	CONSTRAINT post_user_id_fk
	FOREIGN KEY (user_id)
	REFERENCES MB_users(user_id),

	CONSTRAINT topic_id_fk
	FOREIGN KEY (topic_id)
	REFERENCES MB_topics(topic_id)
); -- runs

select * from MB_posts;

CREATE TABLE MB_responses(
	response_id INT PRIMARY KEY AUTO_INCREMENT,
	post_id INT,
	user_id INT,
	response_text VARCHAR(255) NOT NULL,
    date_posted TIMESTAMP,
	api_call VARCHAR(50),
    
	CONSTRAINT response_user_id_fk
	FOREIGN KEY (user_id)
	REFERENCES MB_users(user_id),

	CONSTRAINT post_id_fk
	FOREIGN KEY (post_id)
	REFERENCES MB_posts (post_id)
); -- runs

select * from MB_responses;

-- ***********************************************
-- insert values into MB_topics
-- ***********************************************
insert into MB_topics values (1, 'movies/tv');
insert into MB_topics values (2, 'books');

select * from MB_topics;

insert into MB_roles values (1, 'ADMIN');
insert into MB_roles values (2, 'USER');
insert into MB_roles values (3, 'BLOCKED');

select * from MB_roles;