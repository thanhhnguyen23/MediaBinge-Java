/*Create default users*/
SELECT * FROM MB_users;
INSERT INTO MB_users values(1, 'firstuser', 1234, 'Omar', 'Jamal', 1);
INSERT INTO MB_users values(2,'twouser', 1234, 'Omar', 'Jamal', 2);
INSERT INTO MB_users values(3, 'threeuser', 1234, 'Omar', 'Jamal', 2);
INSERT INTO MB_users values(4, '4user', 1234, 'Omar', 'Jamal', 3);

INSERT INTO MB_profile values(1, 'Lord of the Rings', 'Lord of the Rings',null, 2);
INSERT INTO MB_profile values(2, 'Lord of the Rings', '',null, 1);
INSERT INTO MB_profile values(3, null, 'LotR',null, 3);
INSERT INTO MB_profile values(4, null, null,null,4);
select * from MB_profile;

Select * from MB_posts;

INSERT INTO MB_posts values (1, 1, 1, 'movies movies movies am I right?', sysdate());
INSERT INTO MB_posts values (2, 2, 2, 'and books! boy do i like books...', sysdate());

INSERT INTO MB_responses values (1, 2, 3, 'I think books sucks!', sysdate(), null);
select * from MB_responses;