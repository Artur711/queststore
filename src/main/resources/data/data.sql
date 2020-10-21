--- Add Users_types
INSERT INTO USER_TYPE (user_type_name) values ('CODECOOLER');
INSERT INTO USER_TYPE (user_type_name) values ('MENTOR');
INSERT INTO USER_TYPE (user_type_name) values ('ADMIN');


---Add Users
insert into USERS (EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, PHONE_NUMBER, PHOTO_URL, USER_TYPE) values ('pudzian@gmial.com', 'MARIUSZ','PUDZIANOWSKI',  '1234m', 123456789, '', 1);
insert into USERS (EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, PHONE_NUMBER, PHOTO_URL, USER_TYPE) values ('kala@gmial.com', 'MARIUSZ','KALAMAGA',  '1234k', 123456788, '', 1);
insert into USERS (EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, PHONE_NUMBER, PHOTO_URL, USER_TYPE) values ('max@gmial.com', 'MARIUSZ','KOLONKO',  '1234mk', 123456787, '', 2);
insert into USERS (EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, PHONE_NUMBER, PHOTO_URL, USER_TYPE) values ('zenek@gmial.com', 'ZENEK','MARTYNIUK',  '1234z', 123456786, '', 2);
insert into USERS (EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, PHONE_NUMBER, PHOTO_URL, USER_TYPE) values ('slawomir@gmial.com', 'SLAWOMIR','ZAPALA',  '1234s', 123456785, '', 2);
insert into USERS (EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, PHONE_NUMBER, PHOTO_URL, USER_TYPE) values ('wachu@gmial.com', 'MARIUSZ','WACH',  '1234w', 123456784, '', 3);


---Add Level of experience (LOE)
insert into EXPERIENCES (VALUE) VALUES (500);
insert into EXPERIENCES (VALUE) VALUES (1000);
insert into EXPERIENCES (VALUE) VALUES (1500);

---Add Codecoolers (Probably its a good idea to add codecoolers simultaneously when adding User with user_type codecoolers)
insert into CODE_COOLERS (CODE_COOLER_COINS, EXP, USER_ID) VALUES ( 0, 0, 1);
insert into CODE_COOLERS (CODE_COOLER_COINS, EXP, USER_ID) VALUES ( 0, 0, 2);

---Add Clasrooms
insert into CLASSROOMS (NAME) VALUES ('AK Soldiers');
insert into CLASSROOMS (NAME) VALUES ('Rest of the world');

---Add Teams
-- INSERT INTO Teams (team_name) values ('AK-Team');
-- INSERT INTO Teams (team_name) values ('A-Team');

---Add Items_types
insert into QUEST_TYPE (NAME) VALUES ('SOLO');
insert into QUEST_TYPE (NAME) VALUES ('DUO');

---Add Quests
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('Passing a Checkpoint','Passing a checkpoint.',1,'../photo/img/logo-quests/road/logo-road2.jpg',100);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('Spot a major mistake','Spot a major mistake in the assignment.',1,'../photo/img/logo-quests/mistake/logo-mistake2.jpg',500);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('Screening process','Taking part in the student screening process.',1,'../photo/img/logo-quests/mix/logo-mix6.jpg',50);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('Workshop','Organizing a workshop for other students.',1,'../photo/img/logo-quests/mix/logo-mix4.jpg',100);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('Attend 1 months','Attend 1 months without being late.',1,'../photo/img/logo-quests/mix/logo-mix3.jpg',400);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('Set up a SMART goal','Set up a SMART goal accepted by a mentor, then achieve it.',1,'../photo/img/logo-quests/mix/logo-mix7.jpg',300);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('Do a presentation','Do a presentation on a meet-up.',1,'../photo/img/logo-quests/mix/logo-mix1.jpg',900);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('Promising child','Beat the mentor in the discussion.',1,'../photo/img/logo-quests/mix/logo-mix5.jpg',404);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('PA - pass','You did it you crazy son of a ... , you did it',1,'../photo/img/logo-quests/dinosaur/logo-dinosaur1.jpg',1);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('Complete background materials','Its aint much but its honest work',1,'../photo/img/logo-quests/work/logo-work1.jpg',1);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('King of Ping Pong','Win against a mentor in ping pong.',1,'../photo/img/logo-quests/pingpong/logo-ping1.jpg',404);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('Kahoot specialist','Win the Kahoot quiz.',1,'../photo/img/logo-items/game/logo-game3.jpg',300);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('Help hand','Help another student (not on your team) with the project or assignment.',1,'../photo/img/logo-quests/help/logo-help1.jpg',500);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('DRAGON LORE','[Almost impossible] Pass your PA on the FIRST TRY.',1,'../photo/img/logo-quests/legend/logo-legend1.jpg',999);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('Call me LEGEND','Complete the course, and be LEGEND!',1,'../photo/img/logo-quests/legend/logo-legend4.jpg',99999);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('Rise like a PHOENIX','Pass PA in the fourth attempt and rise like a PHOENIX from the ashes...',1,'../photo/img/logo-quests/phoenix/logo-rise2.jpg',1500);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('Two-week assignment','Finishing two-week assignment - 100 cc per person for the team and they decide on how to share it.',2,'../photo/img/logo-quests/work/logo-work3.jpg',100);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('Complete project','Complete team project.',2,'../photo/img/logo-quests/road/logo-road2.jpg',500);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('Taking part in screening process','Taking part in the student screening process.',2,'../photo/img/logo-quests/mix/logo-mix6.jpg',50);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('Organizing workshop','Organizing a workshop as team for other students.',2,'../photo/img/logo-quests/mix/logo-mix4.jpg',100);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('The best project','Students choose the best project of the week. Selected team scores.',2,'../photo/img/logo-quests/mix/logo-mix9.jpg',400);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('ERD & UML','Create ERD and UML for the project.',2,'../photo/img/logo-quests/mix/logo-mix8.jpg',250);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('Learn something new','Its aint much but its honest work',2,'../photo/img/logo-quests/work/logo-work1.jpg',1);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('Ping-Pong MASTERS','Win against a mentor duo in ping pong.',2,'../photo/img/logo-quests/pingpong/logo-ping2.jpg',404);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('DAO design pattern','Implement DAO pattern in your projects.',2,'../photo/img/logo-quests/base/logo-base3.jpg',800);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('MVC design pattern','Implement MVC pattern in your projects.',2,'../photo/img/logo-quests/pattern/logo-model1.jpg',250);
INSERT INTO Quests (NAME, DESCRIPTION, QUEST_TYPE_ID, IMG,  QUEST_VALUE) values ('Social souls','Organize an evening of board games.',2,'../photo/img/logo-items/game/logo-game4.jpg',250);

---Add Items_types
insert into ITEMS_TYPE (NAME) VALUES ('SOLO');
insert into ITEMS_TYPE (NAME) VALUES ('DUO');

---Add Items
insert into ITEMS (NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) VALUES ('Private mentoring','Mentor joins a students for private mentoring.',1000,'../photo/img/logo-items/mentor/logo-mentor1.jpg', 2);
INSERT INTO Items (NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values ('Extend deadline','Extend SI week assignment deadline by one day.',500,'../photo/img/logo-items/time/logo-time2.jpg',2);
INSERT INTO Items (NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values ('60 min workshop','60 min workshop by a mentor(s) of the chosen topic.',100,'../photo/img/logo-items/workshop/logo-workshop3.jpg',2);
INSERT INTO Items (NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values ('Mentor time','Mentor joins a students team for a one hour.',1000,'../photo/img/logo-items/meet/logo-meet6.jpg',2);
INSERT INTO Items (NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values ('Extra material','Extra material for the current topic.',1000,'../photo/img/logo-items/treasure/logo-treasure4.jpg',2);
INSERT INTO Items (NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values ('Funny time :)','All mentors should dress up as pirates (or just funny) for the day.',500,'../photo/img/logo-items/funny/logo-funny3.jpg',2);
INSERT INTO Items (NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values ('King time','The whole course goes to an off-school program instead for a day.',30000,'../photo/img/logo-items/king/logo-king3.jpg',2);
INSERT INTO Items (NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values ('Coffee break','You might as well take a team coffee break.',250,'../photo/img/logo-items/coffee/logo-coffee3.jpg',2);
INSERT INTO Items (NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values ('Kahoot time','You might as well take a kahoot game.',300,'../photo/img/logo-items/game/logo-game1.jpg',2);
INSERT INTO Items (NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values ('Project - free pass','Everyone dreams of it, only few can have it.',999999,'../photo/img/logo-items/exam/logo-exam3.jpg',2);
INSERT INTO Items (NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values ('Clean code excuse','Clean code excuse free of bad comments from mentors side.',555,'../photo/img/logo-items/exit/logo-exit3.jpg',2);
INSERT INTO Items (NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values ('Day in home office','You can spend a day in home office.',500,'../photo/img/logo-items/castle/logo-castle2.jpg',1);
INSERT INTO Items (NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values ('Private mentoring','Mentor joins a student for private mentoring.',700,'../photo/img/logo-items/mentor/logo-mentor1.jpg',1);
INSERT INTO Items (NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values ('Additional term','Take one more chance to pass PA.',500,'../photo/img/logo-items/time/logo-time3.jpg',1);
INSERT INTO Items (NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values ('Mentor time','Mentor joins a student for a one hour.',1000,'../photo/img/logo-items/meet/logo-meet1.jpg',1);
INSERT INTO Items (NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values ('Extra material','Extra material for the current topic.',1000,'../photo/img/logo-items/treasure/logo-treasure4.jpg',1);
INSERT INTO Items (NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values ('Funny time :)','All mentors should dress up as pirates (or just funny) for the day.',500,'../photo/img/logo-items/funny/logo-funny3.jpg',1);
INSERT INTO Items (NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values ('King time','The whole course goes to an off-school program instead for a day.',5000,'../photo/img/logo-items/king/logo-king3.jpg',1);
INSERT INTO Items (NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values ('Coffee break','You might as well take a coffee break.',30000,'../photo/img/logo-items/coffee/logo-coffee3.jpg',1);
INSERT INTO Items (NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values ('Kahoot time','You might as well take a kahoot game.',150,'../photo/img/logo-items/game/logo-game1.jpg',1);
INSERT INTO Items (NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values ('PA - free pass','Everyone dreams of it, only the chosen one can have it.',999999,'../photo/img/logo-items/exam/logo-exam3.jpg',1);
INSERT INTO Items (NAME, DESCRIPTION, PRICE, IMG, ITEM_TYPE_ID) values ('Attendance excuse','Attendance excuse free of bad comments from mentor.',150,'../photo/img/logo-items/exit/logo-exit3.jpg',1);


---Add Codecoolers to Classrooms
INSERT INTO CLASSROOMS_USERS (class_id , user_id) values (1,1);	---Pudzianowski to AK class
INSERT INTO CLASSROOMS_USERS (class_id , user_id) values (1,2);	---Kalamaga to AK class
-- INSERT INTO Users_classrooms (user_id, class_id) values (2,1);	---Kalamaga to AK class


---Add Codecoolers to team
-- INSERT INTO Codecoolers_teams (team_id, codecooler_id) values (1,2);  ---Add Kalamaga to AK team

---Add Item to Codecoolers
insert into CODE_COOLER_ITEMS (CODE_COOLER_ITEM_ID, CODE_COOLER_ID, ITEM_ID, NAME, USED) VALUES (1, 1, 1, 'Private mentoring', 'NO');

---Add Quest to Codecoolers
-- INSERT INTO Codecoolers_quest (quest_id, codecooler_id) values (1,1); --- Add 1st Quest to Pudzianowski





