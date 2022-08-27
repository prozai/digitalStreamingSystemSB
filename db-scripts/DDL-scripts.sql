-- DDL SCRIPTS
CREATE DATABASE dssdb;
USE dssdb;
CREATE TABLE admin (
  admin_id int NOT NULL AUTO_INCREMENT,
  email varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  username varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  PRIMARY KEY (admin_id)
);
CREATE TABLE movies (
  movie_id int NOT NULL AUTO_INCREMENT,
  title varchar(255) NOT NULL,
  cost int NOT NULL,
  year int NOT NULL,
  actor_id int NOT NULL,
  PRIMARY KEY (movie_id),
  FOREIGN KEY (actor_id) REFERENCES actors(actor_id)
);
CREATE TABLE actors (
  actor_id int NOT NULL AUTO_INCREMENT,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  gender varchar(255) NOT NULL,
  age int NOT NULL,
  PRIMARY KEY (actor_id)
);
CREATE TABLE movie_review (
  review_id int NOT NULL AUTO_INCREMENT,
  date_posted varchar(255) NOT NULL,
  description varchar(255) NOT NULL,
  rating int NOT NULL,
  movie_id int NOT NULL,
  PRIMARY KEY (review_id),
  FOREIGN KEY (movie_id) REFERENCES movies(movie_id)
);

CREATE TABLE `files_upload` (
  `upload_id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(128) DEFAULT NULL,
  `file_data` longblob,
  PRIMARY KEY (`upload_id`)
)
