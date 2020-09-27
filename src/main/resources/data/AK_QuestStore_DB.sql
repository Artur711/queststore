DROP TABLE IF EXISTS Users_types CASCADE;
DROP TABLE IF EXISTS Users CASCADE;
DROP TABLE IF EXISTS Users_types CASCADE;
DROP TABLE IF EXISTS Codecoolers CASCADE;
DROP TABLE IF EXISTS Classrooms CASCADE;
DROP TABLE IF EXISTS Users_classrooms CASCADE;
DROP TABLE IF EXISTS Users_types CASCADE;
DROP TABLE IF EXISTS Teams CASCADE;
DROP TABLE IF EXISTS Codecoolers_teams CASCADE;
DROP TABLE IF EXISTS Quests CASCADE;
DROP TABLE IF EXISTS Codecoolers_quest CASCADE;
DROP TABLE IF EXISTS Items CASCADE;
DROP TABLE IF EXISTS Codecoolers_item CASCADE;
DROP TABLE IF EXISTS LOE CASCADE;
DROP TABLE IF EXISTS Quest_types CASCADE;
DROP TABLE IF EXISTS Items_types CASCADE;
DROP TABLE IF EXISTS Codecooler_item CASCADE;

CREATE TABLE Users_types(
			user_type_id serial PRIMARY KEY,
			user_type_name varchar(25) NOT NULL
);



CREATE TABLE Users(
			user_id SERIAL PRIMARY KEY,
			first_name varchar(25) NOT NULL,
			last_name varchar(25) NOT NULL,
			email varchar(25) NOT NULL,
			password varchar(25) NOT NULL,
			user_type int NOT NULL,
			phone int NOT NULL,
			profile_photo_url varchar(25),
			CONSTRAINT FK_user_type FOREIGN KEY(user_type) REFERENCES Users_types (user_type_id) ON DELETE CASCADE
			
);

CREATE TABLE Classrooms(
			class_id SERIAL PRIMARY KEY,
			name varchar(25) NOT NULL
);

CREATE TABLE Users_classrooms(
			user_class_id SERIAL PRIMARY KEY,
			user_id int NOT NULL,
			class_id int NOT NULL,
			CONSTRAINT FK_user_id FOREIGN KEY(user_id) REFERENCES Users (user_id) ON DELETE CASCADE,
			CONSTRAINT FK_class_id FOREIGN KEY(class_id) REFERENCES Classrooms (class_id) ON DELETE CASCADE

);

CREATE TABLE LOE(
			loe_id SERIAL PRIMARY KEY,
			max_value int NOT NULL
);

CREATE TABLE Codecoolers(
			codecooler_id SERIAL PRIMARY KEY,
			user_id int NOT NULL,
			loe_id int DEFAULT 1,
			codecool_coins int DEFAULT 0,
			CONSTRAINT FK_user_id FOREIGN KEY(user_id) REFERENCES Users (user_id) ON DELETE CASCADE,
			CONSTRAINT FK_loe_id FOREIGN KEY(loe_id) REFERENCES LOE (loe_id) ON DELETE CASCADE
);

CREATE TABLE Teams(
			team_id SERIAL PRIMARY KEY,
			team_name varchar(25) NOT NULL
);	

CREATE TABLE Codecoolers_teams(
			codecooler_team_id SERIAL PRIMARY KEY,
			team_id int NOT NULL,
			codecooler_id int NOT NULL,
			CONSTRAINT FK_team_id FOREIGN KEY (team_id) REFERENCES Codecoolers (codecooler_id) ON DELETE CASCADE,
			CONSTRAINT FK_codecooler_id FOREIGN KEY(codecooler_id) REFERENCES Teams (team_id) ON DELETE CASCADE
);

CREATE TABLE Quest_types(
			quest_id SERIAL PRIMARY KEY,
			name_of_quest_type varchar(100) NOT NULL
);

CREATE TABLE Quests(
			quest_id SERIAL PRIMARY KEY,
			name varchar(25) NOT NULL,
			description varchar(255) NOT NULL,
			quest_type_id int NOT NULL,
			quest_value int NOT NULL,
			CONSTRAINT FK_quest_type_id FOREIGN KEY(quest_type_id) REFERENCES Quest_types (quest_id) ON DELETE CASCADE
);

CREATE TABLE Codecoolers_quest(
			codecooler_quest_id SERIAL PRIMARY KEY,
			quest_id int NOT NULL,
			codecooler_id int NOT NULL,
			CONSTRAINT FK_quest_id FOREIGN KEY (quest_id) REFERENCES Quests (quest_id) ON DELETE CASCADE,
			CONSTRAINT FK_codecooler_id FOREIGN KEY(codecooler_id) REFERENCES Codecoolers (codecooler_id) ON DELETE CASCADE
);

CREATE TABLE Items_types(
			item_id SERIAL PRIMARY KEY,
			name_of_item_type varchar(100) NOT NULL
);

CREATE TABLE Items(
			item_id SERIAL PRIMARY KEY,
			name varchar(25) NOT NULL,
			description varchar(255) NOT NULL,
			price int NOT NULL,
			img varchar(255) NOT NULL,
			item_type_id int DEFAULT 1,
			CONSTRAINT FK_item_type_id FOREIGN KEY (item_type_id) REFERENCES Items_types (item_id) ON DELETE CASCADE
);

CREATE TABLE Codecooler_item(
			codecooler_item_id SERIAL PRIMARY KEY,
			item_id int NOT NULL,
			codecooler_id int NOT NULL,
			CONSTRAINT FK_item_id FOREIGN KEY(item_id) REFERENCES Items (item_id) ON DELETE CASCADE,
			CONSTRAINT FK_codecooler_id FOREIGN KEY(codecooler_id) REFERENCES Codecoolers (codecooler_id) ON DELETE CASCADE
);



