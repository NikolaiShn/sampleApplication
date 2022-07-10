CREATE DATABASE IF NOT EXISTS listing
CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE listing;

CREATE TABLE IF NOT EXISTS ListRecords (
id int PRIMARY KEY,
numbers double NOT NULL,
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

//insert