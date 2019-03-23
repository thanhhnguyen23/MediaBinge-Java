-- *******************************************
-- database creation
-- *******************************************
-- CREATE DATABASE mediabinge;
use mediabinge;

-- *******************************************
-- table creation
-- *******************************************
CREATE TABLE MB_topics (
	topic_id INT PRIMARY KEY AUTO_INCREMENT,
    topic VARCHAR(15) NOT NULL
); -- runs

select * from MB_topics;

CREATE TABLE MB_users(
	user_id INT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(50) NOT NULL UNIQUE,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL
); -- runs

select * from MB_users;

CREATE TABLE MB_profile(
	MB_profile INT PRIMARY KEY AUTO_INCREMENT,
	favorite_movies VARCHAR(255),
	favorite_tv_shows VARCHAR(255),
	user_id INT,

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
	date_posted TIMESTAMP,

	CONSTRAINT user_post_id_fk
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

	CONSTRAINT user_response_id_fk
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
insert into MB_topics values (1, 'movies');
insert into MB_topics values (2, 'tv shows');
insert into MB_topics values (3, 'books');