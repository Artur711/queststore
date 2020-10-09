--- Add Users_types
INSERT INTO USER_TYPE (USER_TYPE_ID, user_type_name) values (1, 'CODECOOLER');
INSERT INTO USER_TYPE (USER_TYPE_ID, user_type_name) values (2, 'MENTOR');
INSERT INTO USER_TYPE (USER_TYPE_ID, user_type_name) values (3, 'ADMIN');


---Add Users
insert into USERS (USER_ID, EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, PHONE_NUMBER, PHOTO_URL, USER_TYPE) values ( 100000001, 'pudzian@gmial.com', 'MARIUSZ','PUDZIANOWSKI',  '1234m', 123456789, '', 1);
insert into USERS (USER_ID, EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, PHONE_NUMBER, PHOTO_URL, USER_TYPE) values ( 100000002, 'kala@gmial.com', 'MARIUSZ','KALAMAGA',  '1234k', 123456788, '', 1);
insert into USERS (USER_ID, EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, PHONE_NUMBER, PHOTO_URL, USER_TYPE) values ( 100000003, 'max@gmial.com', 'MARIUSZ','KOLONKO',  '1234mk', 123456787, '', 2);
insert into USERS (USER_ID, EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, PHONE_NUMBER, PHOTO_URL, USER_TYPE) values ( 100000004, 'zenek@gmial.com', 'ZENEK','MARTYNIUK',  '1234z', 123456786, '', 2);
insert into USERS (USER_ID, EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, PHONE_NUMBER, PHOTO_URL, USER_TYPE) values ( 100000005, 'slawomir@gmial.com', 'SLAWOMIR','ZAPALA',  '1234m', 123456785, '', 2);
insert into USERS (USER_ID, EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, PHONE_NUMBER, PHOTO_URL, USER_TYPE) values ( 100000006, 'wachu@gmial.com', 'MARIUSZ','WACH',  '1234m', 123456784, '', 3);


---Add Level of experience (LOE)
insert into EXPERIENCES (LOE_ID, VALUE) VALUES (200000001, 500);
insert into EXPERIENCES (LOE_ID, VALUE) VALUES (200000002, 1000);
insert into EXPERIENCES (LOE_ID, VALUE) VALUES (200000003, 1500);

---Add Codecoolers (Probably its a good idea to add codecoolers simultaneously when adding User with user_type codecoolers)
insert into CODE_COOLERS (CODE_COOLER_COINS, EXP, USER_ID) VALUES ( 0, 0, 100000001);
insert into CODE_COOLERS (CODE_COOLER_COINS, EXP, USER_ID) VALUES ( 0, 0, 100000002);

---Add Clasrooms
insert into CLASSROOMS (CLASS_ID, NAME) VALUES (300000001, 'AK Soldiers');
insert into CLASSROOMS (CLASS_ID, NAME) VALUES (300000002, 'Rest of the world');

---Add Teams
-- INSERT INTO Teams (team_name) values ('AK-Team');
-- INSERT INTO Teams (team_name) values ('A-Team');

---Add Items_types
insert into QUEST_TYPE (QUEST_TYPE_ID, NAME) VALUES (1001, 'SOLO');
insert into QUEST_TYPE (QUEST_TYPE_ID, NAME) VALUES (1002, 'DUO');

---Add Quests
insert into QUESTS (QUEST_ID, DESCRIPTION, IMG, NAME, QUEST_TYPE_ID, QUEST_VALUE) VALUES (500000001,  'Passing a checkpoint.', '../photo/img/logo-quests/road/logo-road2.jpg', 'Passing a Checkpoint', 1001, 100);
insert into QUESTS (QUEST_ID, DESCRIPTION, IMG, NAME, QUEST_TYPE_ID, QUEST_VALUE) VALUES (500000002,  'Spot a major mistake in the assignment.', '../photo/img/logo-quests/mistake/logo-mistake2.jpg', 'Spot a major mistake', 1, 500);
insert into QUESTS (QUEST_ID, DESCRIPTION, IMG, NAME, QUEST_TYPE_ID, QUEST_VALUE) VALUES (500000003,  'Taking part in the student screening process.', '../photo/img/logo-quests/mix/logo-mix6.jpg', 'Screening process', 1, 50);
insert into QUESTS (QUEST_ID, DESCRIPTION, IMG, NAME, QUEST_TYPE_ID, QUEST_VALUE) VALUES (500000004,  'Organizing a workshop for other students.', '../photo/img/logo-quests/mix/logo-mix4.jpg', 'Workshop', 1001, 100);
insert into QUESTS (QUEST_ID, DESCRIPTION, IMG, NAME, QUEST_TYPE_ID, QUEST_VALUE) VALUES (500000006,  'Attend 1 months without being late.', '../photo/img/logo-quests/mix/logo-mix3.jpg', 'Attend 1 months', 1001, 400);
insert into QUESTS (QUEST_ID, DESCRIPTION, IMG, NAME, QUEST_TYPE_ID, QUEST_VALUE) VALUES (500000007,  'Set up a SMART goal accepted by a mentor, then achieve it.', '../photo/img/logo-quests/mix/logo-mix7.jpg', 'Set up a SMART goal', 1001, 300);
insert into QUESTS (QUEST_ID, DESCRIPTION, IMG, NAME, QUEST_TYPE_ID, QUEST_VALUE) VALUES (500000008,  'Do a presentation on a meet-up.', '../photo/img/logo-quests/mix/logo-mix1.jpg', 'Do a presentation', 1001, 900);
insert into QUESTS (QUEST_ID, DESCRIPTION, IMG, NAME, QUEST_TYPE_ID, QUEST_VALUE) VALUES (500000009,  'Beat the mentor in the discussion.', '../photo/img/logo-quests/mix/logo-mix5.jpg', 'Promising child', 1001, 404);
insert into QUESTS (QUEST_ID, DESCRIPTION, IMG, NAME, QUEST_TYPE_ID, QUEST_VALUE) VALUES (500000010,  'You did it .', '../photo/img/logo-quests/dinosaur/logo-dinosaur1.jpg', 'PA - pass', 1001, 5);
insert into QUESTS (QUEST_ID, DESCRIPTION, IMG, NAME, QUEST_TYPE_ID, QUEST_VALUE) VALUES (500000011,  'Its aint much but its honest work', '../photo/img/logo-quests/work/logo-work1.jpg', 'Complete background materials', 1001, 5);
insert into QUESTS (QUEST_ID, DESCRIPTION, IMG, NAME, QUEST_TYPE_ID, QUEST_VALUE) VALUES (500000012,  'Win against a mentor in ping pong.', '../photo/img/logo-quests/pingpong/logo-ping1.jpg', 'King of Ping Pong', 1001, 404);
insert into QUESTS (QUEST_ID, DESCRIPTION, IMG, NAME, QUEST_TYPE_ID, QUEST_VALUE) VALUES (500000013,  'Win the Kahoot quiz.', '../photo/img/logo-quests/game/logo-game3.jpg', 'Kahoot specialist', 1001, 300);
insert into QUESTS (QUEST_ID, DESCRIPTION, IMG, NAME, QUEST_TYPE_ID, QUEST_VALUE) VALUES (500000014,  'Help another student (not on your team) with the project or assignment.', '../photo/img/logo-quests/help/logo-help1.jpg', 'PA - pass', 1001, 500);
insert into QUESTS (QUEST_ID, NAME, DESCRIPTION, IMG, QUEST_TYPE_ID, QUEST_VALUE) VALUES (500000015,  'Help hand','Help another student (not on your team) with the project or assignment.', 1001,'../photo/img/logo-quests/help/logo-help1.jpg',500);
INSERT INTO Quests (QUEST_ID, NAME, DESCRIPTION, IMG, QUEST_TYPE_ID, QUEST_VALUE) values (500000015, 'DRAGON LORE','[Almost impossible] Pass your PA on the FIRST TRY.',1001,'../photo/img/logo-quests/legend/logo-legend1.jpg',999);
INSERT INTO Quests (QUEST_ID, NAME, DESCRIPTION, IMG, QUEST_TYPE_ID, QUEST_VALUE) values (500000015, 'Call me LEGEND','Complete the course, and be LEGEND!',1001,'../photo/img/logo-quests/legend/logo-legend4.jpg',99999);
INSERT INTO Quests (QUEST_ID, NAME, DESCRIPTION, IMG, QUEST_TYPE_ID, QUEST_VALUE) values (500000015, 'Rise like a PHOENIX','Pass PA in the fourth attempt and rise like a PHOENIX from the ashes...',1001,'../photo/img/logo-quests/phoenix/logo-rise2.jpg',1500);
INSERT INTO Quests (QUEST_ID, NAME, DESCRIPTION, IMG, QUEST_TYPE_ID, QUEST_VALUE) values (500000015, 'Two-week assignment','Finishing two-week assignment - 100 cc per person for the team and they decide on how to share it.',1002,'../photo/img/logo-quests/work/logo-work3.jpg',100);
INSERT INTO Quests (QUEST_ID, NAME, DESCRIPTION, IMG, QUEST_TYPE_ID, QUEST_VALUE) values (500000015, 'Complete project','Complete team project.',1002,'../photo/img/logo-quests/road/logo-road2.jpg',500);
INSERT INTO Quests (QUEST_ID, NAME, DESCRIPTION, IMG, QUEST_TYPE_ID, QUEST_VALUE) values (500000015, 'Taking part in screening process','Taking part in the student screening process.',1002,'../photo/img/logo-quests/mix/logo-mix6.jpg',50);
INSERT INTO Quests (QUEST_ID, NAME, DESCRIPTION, IMG, QUEST_TYPE_ID, QUEST_VALUE) values (500000015, 'Organizing workshop','Organizing a workshop as team for other students.',1002,'../photo/img/logo-quests/mix/logo-mix4.jpg',100);
INSERT INTO Quests (QUEST_ID, NAME, DESCRIPTION, IMG, QUEST_TYPE_ID, QUEST_VALUE) values (500000015, 'The best project','Students choose the best project of the week. Selected team scores.',1002,'../photo/img/logo-quests/mix/logo-mix9.jpg',400);
INSERT INTO Quests (QUEST_ID, NAME, DESCRIPTION, IMG, QUEST_TYPE_ID, QUEST_VALUE) values (500000015, 'ERD & UML','Create ERD and UML for the project.',1002,'../photo/img/logo-quests/mix/logo-mix8.jpg',250);
INSERT INTO Quests (QUEST_ID, NAME, DESCRIPTION, IMG, QUEST_TYPE_ID, QUEST_VALUE) values (500000015, 'Learn something new','Its aint much but its honest work',1002,'../photo/img/logo-quests/work/logo-work1.jpg',5);
INSERT INTO Quests (QUEST_ID, NAME, DESCRIPTION, IMG, QUEST_TYPE_ID, QUEST_VALUE) values (500000015, 'Ping-Pong MASTERS','Win against a mentor duo in ping pong.',1002,'../photo/img/logo-quests/pingpong/logo-ping2.jpg',404);
INSERT INTO Quests (QUEST_ID, NAME, DESCRIPTION, IMG, QUEST_TYPE_ID, QUEST_VALUE) values (500000015, 'DAO design pattern','Implement DAO pattern in your projects.',1002,'../photo/img/logo-quests/base/logo-base3.jpg',800);
INSERT INTO Quests (QUEST_ID, NAME, DESCRIPTION, IMG, QUEST_TYPE_ID, QUEST_VALUE) values (500000015, 'MVC design pattern','Implement MVC pattern in your projects.',1002,'../photo/img/logo-quests/pattern/logo-model1.jpg',250);
INSERT INTO Quests (QUEST_ID, NAME, DESCRIPTION, IMG, QUEST_TYPE_ID, QUEST_VALUE) values (500000015, 'Social souls','Organize an evening of board games.',1002,'../photo/img/logo-items/game/logo-game4.jpg',250);

---Add Items_types
insert into ITEMS_TYPE (ITEM_TYPE_ID, NAME) VALUES (5001, 'SOLO');
insert into ITEMS_TYPE (ITEM_TYPE_ID, NAME) VALUES (5002, 'DUO');

---Add Items
insert into ITEMS (ITEM_ID, NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) VALUES (600000001, 'Private mentoring','Mentor joins a students for private mentoring.',1000,'../photo/img/logo-items/mentor/logo-mentor1.jpg', 5002);
INSERT INTO Items (ITEM_ID, NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values (600000002, 'Extend deadline','Extend SI week assignment deadline by one day.',500,'../photo/img/logo-items/time/logo-time2.jpg',5002);
INSERT INTO Items (ITEM_ID, NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values (600000003, '60 min workshop','60 min workshop by a mentor(s) of the chosen topic.',100,'../photo/img/logo-items/workshop/logo-workshop3.jpg',5002);
INSERT INTO Items (ITEM_ID, NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values (600000004, 'Mentor time','Mentor joins a students team for a one hour.',1000,'../photo/img/logo-items/meet/logo-meet6.jpg',5002);
INSERT INTO Items (ITEM_ID, NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values (600000005, 'Extra material','Extra material for the current topic.',1000,'../photo/img/logo-items/treasure/logo-treasure4.jpg',5002);
INSERT INTO Items (ITEM_ID, NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values (600000006, 'Funny time :)','All mentors should dress up as pirates (or just funny) for the day.',500,'../photo/img/logo-items/funny/logo-funny3.jpg',5002);
INSERT INTO Items (ITEM_ID, NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values (600000007, 'King time','The whole course goes to an off-school program instead for a day.',30000,'../photo/img/logo-items/king/logo-king3.jpg',5002);
INSERT INTO Items (ITEM_ID, NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values (600000008, 'Coffee break','You might as well take a team coffee break.',250,'../photo/img/logo-items/coffee/logo-coffee3.jpg',5002);
INSERT INTO Items (ITEM_ID, NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values (600000009, 'Kahoot time','You might as well take a kahoot game.',300,'../photo/img/logo-items/game/logo-game1.jpg',5002);
INSERT INTO Items (ITEM_ID, NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values (600000010, 'Project - free pass','Everyone dreams of it, only few can have it.',999999,'../photo/img/logo-items/exam/logo-exam3.jpg',5002);
INSERT INTO Items (ITEM_ID, NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values (600000011, 'Clean code excuse','Clean code excuse free of bad comments from mentors side.',555,'../photo/img/logo-items/exit/logo-exit3.jpg',5002);
INSERT INTO Items (ITEM_ID, NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values (600000012,'Day in home office','You can spend a day in home office.',500,'../photo/img/logo-items/castle/logo-castle2.jpg',5001);
INSERT INTO Items (ITEM_ID, NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values (600000013, 'Private mentoring','Mentor joins a student for private mentoring.',700,'../photo/img/logo-items/mentor/logo-mentor1.jpg',5001);
INSERT INTO Items (ITEM_ID, NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values (600000014, 'Additional term','Take one more chance to pass PA.',500,'../photo/img/logo-items/time/logo-time3.jpg',5001);
INSERT INTO Items (ITEM_ID, NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values (600000015, 'Mentor time','Mentor joins a student for a one hour.',1000,'../photo/img/logo-items/meet/logo-meet1.jpg',5001);
INSERT INTO Items (ITEM_ID, NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values (600000016, 'Extra material','Extra material for the current topic.',1000,'../photo/img/logo-items/treasure/logo-treasure4.jpg',5001);
INSERT INTO Items (ITEM_ID, NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values (600000017, 'Funny time :)','All mentors should dress up as pirates (or just funny) for the day.',500,'../photo/img/logo-items/funny/logo-funny3.jpg',5001);
INSERT INTO Items (ITEM_ID, NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values (600000018, 'King time','The whole course goes to an off-school program instead for a day.',5000,'../photo/img/logo-items/king/logo-king3.jpg',5001);
INSERT INTO Items (ITEM_ID, NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values (600000019, 'Coffee break','You might as well take a coffee break.',30000,'../photo/img/logo-items/coffee/logo-coffee3.jpg',5001);
INSERT INTO Items (ITEM_ID, NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values (600000020,'Kahoot time','You might as well take a kahoot game.',150,'../photo/img/logo-items/game/logo-game1.jpg',5001);
INSERT INTO Items (ITEM_ID, NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values (600000021,'PA - free pass','Everyone dreams of it, only the chosen one can have it.',999999,'../photo/img/logo-items/exam/logo-exam3.jpg',5001);
INSERT INTO Items (ITEM_ID, NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values (600000022, 'Attendance excuse','Attendance excuse free of bad comments from mentor.',150,'../photo/img/logo-items/exit/logo-exit3.jpg',5001);


---Add Codecoolers to Classrooms
-- INSERT INTO Users_classrooms (user_id, class_id) values (1,1);	---Pudzianowski to AK class
-- INSERT INTO Users_classrooms (user_id, class_id) values (2,1);	---Kalamaga to AK class


---Add Codecoolers to team
-- INSERT INTO Codecoolers_teams (team_id, codecooler_id) values (1,2);  ---Add Kalamaga to AK team

---Add Item to Codecoolers
insert into CODE_COOLER_ITEMS (CODE_COOLER_ITEM_ID, CODE_COOLER_ID, ITEM_ID, USED) VALUES (1000000001, 100000001, 600000001, 'NO');

---Add Quest to Codecoolers
-- INSERT INTO Codecoolers_quest (quest_id, codecooler_id) values (1,1); --- Add 1st Quest to Pudzianowski





