
--- Add Users_types
INSERT INTO Users_types (user_type_name) values ('CODECOOLER');
INSERT INTO Users_types (user_type_name) values ('MENTOR');
INSERT INTO Users_types (user_type_name) values ('ADMIN');


---Add Users
INSERT INTO Users (first_name, last_name, email, password, user_type, phone) values ('MARIUSZ','PUDZIANOWSKI', 'pudzian@gmial.com', '1234m',1,1234567);
INSERT INTO Users (first_name, last_name, email, password, user_type, phone) values ('MARIUSZ','KALAMAGA', 'kala@gmial.com', '1234k',1,1234567);
INSERT INTO Users (first_name, last_name, email, password, user_type, phone) values ('MARIUSZ','KOLONKO', 'max@gmial.com', '1234mk',2,1234567);
INSERT INTO Users (first_name, last_name, email, password, user_type, phone) values ('MARIUSZ','WACH', 'wachu@gmial.com', '1234w',3,1234567);


---Add Level of experience (LOE)
INSERT INTO LOE (max_value) values (100);

---Add Codecoolers (Probably its a good idea to add codecoolers simultaneously when adding User with user_type codecoolers)
INSERT INTO Codecoolers (user_id) values (1);
INSERT INTO Codecoolers (user_id) values (2);

---Add Clasrooms
INSERT INTO Classrooms (name) values ('AK Soldiers');
INSERT INTO Classrooms (name) values ('Rest of the world');

---Add Teams
INSERT INTO Teams (team_name) values ('AK-Team');
INSERT INTO Teams (team_name) values ('A-Team');

---Add Quest_types
INSERT INTO Quest_types (name_of_quest_type) values ('MAGIC');

---Add Quests
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('Passing a Checkpoint','Passing a checkpoint.',1,'photo/img/logo-quests/road/logo-road2.jpg',100);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('Spot a major mistake','Spot a major mistake in the assignment.',1,'photo/img/logo-quests/mistake/logo-mistake2.jpg',500);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('Screening process','Taking part in the student screening process.',1,'photo/img/logo-quests/mix/logo-mix6.jpg',50);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('Workshop','Organizing a workshop for other students.',1,'photo/img/logo-quests/mix/logo-mix4.jpg',100);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('Attend 1 months','Attend 1 months without being late.',1,'photo/img/logo-quests/mix/logo-mix3.jpg',400);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('Set up a SMART goal','Set up a SMART goal accepted by a mentor, then achieve it.',1,'photo/img/logo-quests/mix/logo-mix7.jpg',300);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('Do a presentation','Do a presentation on a meet-up.',1,'photo/img/logo-quests/mix/logo-mix1.jpg',900);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('Promising child','Beat the mentor in the discussion.',1,'photo/img/logo-quests/mix/logo-mix5.jpg',404);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('PA - pass','You did it you crazy son of a ... , you did it',1,'photo/img/logo-quests/dinosaur/logo-dinosaur1.jpg',1);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('Complete background materials','Its aint much but its honest work',1,'photo/img/logo-quests/work/logo-work1.jpg',1);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('King of Ping Pong','Win against a mentor in ping pong.',1,'photo/img/logo-quests/pingpong/logo-ping1.jpg',404);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('Kahoot specialist','Win the Kahoot quiz.',1,'photo/img/logo-items/game/logo-game3.jpg',300);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('Help hand','Help another student (not on your team) with the project or assignment.',1,'photo/img/logo-quests/help/logo-help1.jpg',500);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('DRAGON LORE','[Almost impossible] Pass your PA on the FIRST TRY.',1,'photo/img/logo-quests/legend/logo-legend1.jpg',999);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('Call me LEGEND','Complete the course, and be LEGEND!',1,'photo/img/logo-quests/legend/logo-legend4.jpg',99999);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('Rise like a PHOENIX','Pass PA in the fourth attempt and rise like a PHOENIX from the ashes...',1,'photo/img/logo-quests/phoenix/logo-rise2.jpg',1500);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('Two-week assignment','Finishing two-week assignment - 100 cc per person for the team and they decide on how to share it.',2,'photo/img/logo-quests/work/logo-work3.jpg',100);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('Complete project','Complete team project.',2,'photo/img/logo-quests/road/logo-road2.jpg',500);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('Taking part in screening process','Taking part in the student screening process.',2,'photo/img/logo-quests/mix/logo-mix6.jpg',50);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('Organizing a workshop','Organizing a workshop as team for other students.',2,'photo/img/logo-quests/mix/logo-mix4.jpg',100);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('The best project','Students choose the best project of the week. Selected team scores.',2,'photo/img/logo-quests/mix/logo-mix9.jpg',400);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('ERD & UML','Create ERD and UML for the project.',2,'photo/img/logo-quests/mix/logo-mix8.jpg',250);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('Learn something new','Its aint much but its honest work',2,'photo/img/logo-quests/work/logo-work1.jpg',1);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('Ping-Pong Duo MASTERS','Win against a mentor duo in ping pong.',2,'photo/img/logo-quests/pingpong/logo-ping2.jpg',404);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('DAO design pattern','Implement DAO pattern in your projects.',2,'photo/img/logo-quests/base/logo-base3.jpg',800);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('MVC design pattern','Implement MVC pattern in your projects.',2,'photo/img/logo-quests/pattern/logo-model1.jpg',250);
INSERT INTO Quests (name, description, quest_type_id, img, quest_value) values ('Social souls','Organize an evening of board games.',2,'photo/img/logo-items/game/logo-game4.jpg',250);






---Add Items_types
INSERT INTO Items_types (name_of_item_type) values ('SOLO');
INSERT INTO Items_types (name_of_item_type) values ('DUO');

---Add Items
INSERT INTO Items (name, description, price, img, item_type_id) values ('Private mentoring','Mentor joins a students for private mentoring.',1000,'photo/img/logo-items/mentor/logo-mentor1.jpg',2);
INSERT INTO Items (name, description, price, img, item_type_id) values ('Extend deadline','Extend SI week assignment deadline by one day.',500,'photo/img/logo-items/time/logo-time2.jpg',2);
INSERT INTO Items (name, description, price, img, item_type_id) values ('60 min workshop','60 min workshop by a mentor(s) of the chosen topic.',100,'photo/img/logo-items/workshop/logo-workshop3.jpg',2);
INSERT INTO Items (name, description, price, img, item_type_id) values ('Mentor time','Mentor joins a students team for a one hour.',1000,'photo/img/logo-items/meet/logo-meet6.jpg',2);
INSERT INTO Items (name, description, price, img, item_type_id) values ('Extra material','Extra material for the current topic.',1000,'photo/img/logo-items/treasure/logo-treasure4.jpg',2);
INSERT INTO Items (name, description, price, img, item_type_id) values ('Funny time :)','All mentors should dress up as pirates (or just funny) for the day.',500,'photo/img/logo-items/funny/logo-funny3.jpg',2);
INSERT INTO Items (name, description, price, img, item_type_id) values ('King time','The whole course goes to an off-school program instead for a day.',30000,'photo/img/logo-items/king/logo-king3.jpg',2);
INSERT INTO Items (name, description, price, img, item_type_id) values ('Coffee break','You might as well take a team coffee break.',250,'photo/img/logo-items/coffee/logo-coffee3.jpg',2);
INSERT INTO Items (name, description, price, img, item_type_id) values ('Kahoot time','You might as well take a kahoot game.',300,'photo/img/logo-items/game/logo-game1.jpg',2);
INSERT INTO Items (name, description, price, img, item_type_id) values ('Project - free pass','Everyone dreams of it, only few can have it.',999999,'photo/img/logo-items/exam/logo-exam3.jpg',2);
INSERT INTO Items (name, description, price, img, item_type_id) values ('Clean code excuse','Clean code excuse free of bad comments from mentors side.',555,'photo/img/logo-items/exit/logo-exit3.jpg',2);


---Add Codecoolers to Classrooms
INSERT INTO Users_classrooms (user_id, class_id) values (1,1);	---Pudzianowski to AK class
INSERT INTO Users_classrooms (user_id, class_id) values (2,1);	---Kalamaga to AK class


---Add Codecoolers to team
INSERT INTO Codecoolers_teams (team_id, codecooler_id) values (1,2);  ---Add Kalamaga to AK team

---Add Item to Codecoolers
INSERT INTO Codecooler_item (item_id, codecooler_id) values (1,1); --- Add 1st Item to Pudzianowski

---Queries 
SELECT users.first_name, users.last_name FROM USERS INNER JOIN CODECOOLERS ON CODECOOLERS.USER_ID = USERS.USER_ID INNER JOIN LOE ON LOE.LOE_ID = CODECOOLERS.LOE_ID WHERE CODECOOLERS.LOE_ID =1;


SELECT USERS.LAST_NAME, CLASSROOMS.NAME FROM USERS INNER JOIN USERS_CLASSROOMS ON USERS_CLASSROOMS.USER_ID = USERS.USER_ID INNER JOIN CLASSROOMS ON CLASSROOMS.CLASS_ID = USERS_CLASSROOMS.CLASS_ID WHERE CLASSROOMS.CLASS_ID =1;




