--- Add Users_types
INSERT INTO USER_TYPE (user_type_id,user_type_name) values (1,'CODECOOLER');


---Add Users
insert into USERS (User_id,EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, PHONE_NUMBER, PHOTO_URL, USER_TYPE) values (1,'pudzian@gmial.com', 'MARIUSZ','PUDZIANOWSKI',  '1234m', 123456789, '', 1);

---Add Codecoolers (Probably its a good idea to add codecoolers simultaneously when adding User with user_type codecoolers)
insert into CODE_COOLERS (CODE_COOLER_COINS, EXP, USER_ID) VALUES ( 0, 0, 1);
