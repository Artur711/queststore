
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
INSERT INTO Quests (name, description, quest_type_id, quest_value) values ('1st Quest','Hello Wolrd',1,50);
INSERT INTO Quests (name, description, quest_type_id, quest_value) values ('2nd Quest','Hang Man',1,50);

---Add Items_types
INSERT INTO Items_types (name_of_item_type) values ('SOLO');
INSERT INTO Items_types (name_of_item_type) values ('DUO');

---Add Items
INSERT INTO Items (name, description, price) values ('1st Item','Badge',100);

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




