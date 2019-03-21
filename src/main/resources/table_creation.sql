DROP TABLE user_wishlists;
DROP TABLE user_favorites;
DROP TABLE users;
DROP TABLE user_roles;
DROP TABLE books;

DROP SEQUENCE user_pk_seq;
DROP SEQUENCE book_pk_seq;
DROP SEQUENCE user_role_pk_seq;

CREATE TABLE user_roles (
    role_id         NUMBER,
    role_name       VARCHAR2(25),
    
    CONSTRAINT pk_roles
    PRIMARY KEY (role_id)
);

CREATE TABLE users (
    user_id         NUMBER,
    username        VARCHAR2(25) UNIQUE NOT NULL,
    password        VARCHAR2(50) NOT NULL,
    first_name      VARCHAR2(25) NOT NULL,
    last_name       VARCHAR2(25) NOT NULL,
    role_id         NUMBER,
    
    CONSTRAINT pk_users
    PRIMARY KEY (user_id),
    
    CONSTRAINT fk_user_role
    FOREIGN KEY (role_id)
    REFERENCES user_roles (role_id)
);

CREATE TABLE books (
    book_id         NUMBER,
    isbn            VARCHAR2(15) UNIQUE NOT NULL,
    title           VARCHAR2(50) NOT NULL,
    author          VARCHAR2(50) NOT NULL,
    genre           VARCHAR2(25) NOT NULL,
    price           NUMBER(5, 2) NOT NULL,
    stock_count     NUMBER NOT NULL,
    
    CONSTRAINT pk_books
    PRIMARY KEY (book_id)
);

CREATE TABLE user_wishlists (
    user_id   NUMBER,
    book_id   NUMBER,
    
    CONSTRAINT pk_ck_user_wishlists
    PRIMARY KEY (user_id, book_id),
    
    CONSTRAINT fk_wishlist_user
    FOREIGN KEY (user_id)
    REFERENCES users (user_id),
    
    CONSTRAINT fk_wishlist_book
    FOREIGN KEY (book_id)
    REFERENCES books (book_id)
);

CREATE TABLE user_favorites (
    user_id   NUMBER,
    book_id   NUMBER,
    
    CONSTRAINT pk_ck_user_favorites
    PRIMARY KEY (user_id, book_id),
    
    CONSTRAINT fk_favorites_user
    FOREIGN KEY (user_id)
    REFERENCES users (user_id),
    
    CONSTRAINT fk_favorites_book
    FOREIGN KEY (book_id)
    REFERENCES books (book_id)
);

CREATE SEQUENCE user_pk_seq
MINVALUE 1
MAXVALUE 99999999
INCREMENT BY 1
START WITH 1;

CREATE SEQUENCE book_pk_seq
MINVALUE 1
MAXVALUE 99999999
INCREMENT BY 1
START WITH 1;

CREATE SEQUENCE user_role_pk_seq
MINVALUE 1
MAXVALUE 99999999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER user_pk_trigger
BEFORE INSERT ON users
FOR EACH ROW
BEGIN
    SELECT user_pk_seq.NEXTVAL
    INTO :new.user_id
    FROM dual;
END;
/

CREATE OR REPLACE TRIGGER book_pk_trigger
BEFORE INSERT ON books
FOR EACH ROW
BEGIN
    SELECT book_pk_seq.NEXTVAL
    INTO :new.book_id
    FROM dual;
END;
/

CREATE OR REPLACE TRIGGER user_roles_pk_trigger
BEFORE INSERT ON user_roles
FOR EACH ROW
BEGIN
    SELECT user_role_pk_seq.NEXTVAL
    INTO :new.role_id
    FROM dual;
END;
/

INSERT INTO user_roles VALUES (1, 'ADMIN');
INSERT INTO user_roles VALUES (2, 'DEV');
INSERT INTO user_roles VALUES (3, 'USER');
INSERT INTO user_roles VALUES (4, 'LOCKED');

INSERT INTO users VALUES (0, 'wsingleton', 'p4ssw0rd', 'Wezley', 'Singleton', 1);
INSERT INTO users VALUES (0, 'dmcbee', 'password', 'Dylan', 'McBee', 2);
INSERT INTO users VALUES (0, 'bkruppa', 'p4ssword', 'Blake', 'Kruppa', 2);
INSERT INTO users VALUES (0, 'skelsey', 'drowssap', 'Steven', 'Kelsey', 2);
INSERT INTO users VALUES (0, 'njurczak', 'dr0wss4p', 'Nickolas', 'Jurczak', 2);

INSERT INTO books VALUES (0, '978-1118974400', 'OCA Study Guide', 'Scott Selikoff', 'Technical', 59.99, 20);
INSERT INTO books VALUES (0, '978-2352245232', 'Dark Tower I: The Gunslinger', 'Steven King', 'Horror/Western/Fantasy', 9.99, 8);
INSERT INTO books VALUES (0, '978-8787924870', 'Autobiography of a Yogi', 'Paramhansa Yogananda', 'Non-Fiction', 19.99, 12);
INSERT INTO books VALUES (0, '978-3450023752', 'Deep Work', 'Cal Newport', 'Self-Help', 16.99, 305);
INSERT INTO books VALUES (0, '978-3450002342', 'The Upanishads', 'Eknath Easwaran', 'Religious/Spiritual', 8.99, 7);

INSERT INTO user_wishlists VALUES (1, 1);
INSERT INTO user_wishlists VALUES (1, 3);
INSERT INTO user_wishlists VALUES (1, 5);
INSERT INTO user_wishlists VALUES (2, 1);
INSERT INTO user_wishlists VALUES (2, 2);
INSERT INTO user_wishlists VALUES (2, 4);
INSERT INTO user_wishlists VALUES (3, 4);
INSERT INTO user_wishlists VALUES (3, 5);
INSERT INTO user_wishlists VALUES (4, 1);

COMMIT;

CREATE OR REPLACE PROCEDURE get_all_books
    (
        my_cursor OUT SYS_REFCURSOR
    )
IS
BEGIN
    OPEN my_cursor FOR
    SELECT *
    FROM books
    ORDER BY book_id;
END;
/

----------------------------------------------

SELECT * FROM users JOIN user_roles USING (role_id) WHERE username = 'wsingleton';