
-- ***********************************************
-- creating tables
-- ***********************************************
CREATE TABLE MB_topics
(
    topic_id NUMBER,
    topic VARCHAR2(15) NOT NULL UNIQUE,--topic can be movies, books, tv shows talk to team about this to make sure this is ok
    CONSTRAINT mb_topics_pk
    PRIMARY KEY  (topic_id)
);
CREATE TABLE MB_users
(
    user_id NUMBER,
    username VARCHAR2(50) NOT NULL UNIQUE,
    first_name VARCHAR2(50) NOT NULL,
    last_name VARCHAR2(50) NOT NULL,
    password VARCHAR2(50) NOT NULL,
    
    CONSTRAINT mb_users_pk
    PRIMARY KEY (user_id)
    
);
CREATE TABLE MB_profile
(
    profile_id NUMBER,
    favorite_movies VARCHAR2(255), --use a simple varchar for the list of movies because we do not want the favorite movie list to be longer than~5 movies which does not necessitate another list for movies
    favorite_tv_shows VARCHAR2(255),
    favorite_books VARCHAR2(255),
    user_id  NUMBER,
    CONSTRAINT profile_id_pk
    PRIMARY KEY (profile_id),
    CONSTRAINT user_id_fk
    FOREIGN KEY (user_id)
    REFERENCES MB_users (user_id)
);
CREATE TABLE MB_posts
(
    post_id NUMBER,
    user_id NUMBER,
    topic_id NUMBER,
    text VARCHAR2(255) NOT NULL,
    date_posted TIMESTAMP,
    
    CONSTRAINT post_id_pk
    PRIMARY KEY (post_id),
    CONSTRAINT userPost_id_fk
    FOREIGN KEY (user_id)
    REFERENCES MB_users (user_id),
    CONSTRAINT topic_id_fk
    FOREIGN KEY (topic_id)
    REFERENCES MB_topics (topic_id)
    
);

CREATE TABLE MB_responses
(
    response_id NUMBER,
    post_id NUMBER,
    user_id NUMBER,
    text VARCHAR2(255) NOT NULL,
    
    CONSTRAINT response_id_pk
    PRIMARY KEY (response_id),
     CONSTRAINT userResponse_id_fk
    FOREIGN KEY (user_id)
    REFERENCES MB_users (user_id),
    CONSTRAINT post_id_fk
    FOREIGN KEY (post_id)
    REFERENCES MB_posts(post_id)
    

);

-- ***********************************************
-- insert values into MB_topics
-- ***********************************************
INSERT INTO MB_topics values(1, 'movies');
INSERT INTO MB_topics values(2, 'tv shows');
INSERT INTO MB_topics values(3, 'books');


-- ***********************************************
-- sequences
-- ***********************************************

CREATE SEQUENCE mb_user_pk_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START with 1;



CREATE SEQUENCE mb_post_pk_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT by 1
START with 1;

CREATE SEQUENCE mb_response_pk_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT by 1
START with 1;


CREATE SEQUENCE mb_profile_pk_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT by 1
START with 1;
