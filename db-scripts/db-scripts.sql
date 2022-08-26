CREATE DATABASE dssdb;

USE dssdb;

CREATE TABLE admin (
  admin_id int NOT NULL AUTO_INCREMENT,
  admin_name varchar(255) NOT NULL,
  admin_password varchar(255) NOT NULL,
  admin_email_id varchar(255) NOT NULL,
  admin_username varchar(255) NOT NULL,
  PRIMARY KEY (admin_id)
);
CREATE TABLE movies (
  movie_id int NOT NULL AUTO_INCREMENT,
  movie_cost int NOT NULL,
  movie_title varchar(255) NOT NULL,
  movie_year int NOT NULL,
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
  customer_id int NOT NULL,
  PRIMARY KEY (review_id),
  FOREIGN KEY (movie_id) REFERENCES movies(movie_id)
);

-- INSERT
INSERT INTO admin VALUES( 1, 'username', 'password');

INSERT INTO actors
(actor_id, first_name, last_name, gender, age)VALUES
(19, 'Nelson', 'Toh', 'm', 13),
(26, 'Daniel', 'Radcliffe', 'm', 33),
(27, 'Emma', 'Watson', 'f', 32),
(28, 'Fiona', 'Shaw', 'f', 64),
(29, 'Richard', 'Harris', 'm', 72),
(30, 'Tom', 'Felton', 'm', 34),
(31, 'Elijah', 'Wood', 'm', 41),
(32, 'Viggo', 'Mortensen', 'm', 63),
(33, 'Sean', 'Astin', 'm', 51),
(34, 'Ian', 'McKellen', 'm', 83);

