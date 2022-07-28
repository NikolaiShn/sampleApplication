CREATE DATABASE IF NOT EXISTS listing
CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE listing;

CREATE TABLE IF NOT EXISTS ListRecords (
id int PRIMARY KEY AUTO_INCREMENT,
some_number double NOT NULL,
some_text tinytext NOT NULL,
some_date timestamp NOT NULL,
image mediumblob NOT NULL
);

CREATE TABLE IF NOT EXISTS Roles(
id int PRIMARY KEY AUTO_INCREMENT,
role varchar(10) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS Users(
id int PRIMARY KEY AUTO_INCREMENT,
login varchar(50) UNIQUE NOT NULL,
password varchar(255) NOT NULL,
name varchar(255) NOT NULL,
last_name varchar(255) NOT NULL,
role_id int NOT NULL,
FOREIGN KEY (role_id) REFERENCES Roles(id)
);

INSERT INTO Roles(role) VALUES ("ROLE_ADMIN");
INSERT INTO Roles(role) VALUES ("ROLE_USER");

INSERT INTO Users(login, password, name, last_name, role_id) VALUES ("testuser", "$2a$12$OLhaHMa.GYk.2Bp3OI44S.q3m4JGhEHfdkujm0X1Iu9yhNrdWSkOe", "ivan", "pupkin", 2);
INSERT INTO Users(login, password, name, last_name, role_id) VALUES ("admin1", "$2a$12$OLhaHMa.GYk.2Bp3OI44S.q3m4JGhEHfdkujm0X1Iu9yhNrdWSkOe", "vitaly", "pupkin", 1);
INSERT INTO Users(login, password, name, last_name, role_id) VALUES ("admin2", "$2a$12$OLhaHMa.GYk.2Bp3OI44S.q3m4JGhEHfdkujm0X1Iu9yhNrdWSkOe", "kirill", "pupkin", 1);
INSERT INTO Users(login, password, name, last_name, role_id) VALUES ("admin3", "$2a$12$OLhaHMa.GYk.2Bp3OI44S.q3m4JGhEHfdkujm0X1Iu9yhNrdWSkOe", "artyom", "pupkin", 1);
INSERT INTO Users(login, password, name, last_name, role_id) VALUES ("admin4", "$2a$12$OLhaHMa.GYk.2Bp3OI44S.q3m4JGhEHfdkujm0X1Iu9yhNrdWSkOe", "artyom", "pupkin", 1);
INSERT INTO ListRecords(some_number, some_text, some_date, image) VALUES(24.0, "cars", '2022-07-28 12:40:00', LOAD_FILE('F:\testtask\pictures'))