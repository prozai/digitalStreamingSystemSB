-- DML SCRIPTS

USE dssdb;

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

INSERT INTO movies
(movie_id, title , year, cost,  actor_id)VALUES
(1, "Lord Of the Rings: The Return of the King", 2003, 10, 32),
(2, "Lord Of the Rings: The Rings of Power", 2022, 10, 31),
(3, "Harry Potter and the Philosopher's Stone", 2001, 10, 26),
(4, "Harry Potter and the Chamber of Secrets", 2002, 10, 27),
(5, "Harry Potter and the Prisoner of Azkaban", 2004, 10, 28),
(6, "Harry Potter and the Goblet of Fire", 2005, 11, 29),
(7, "Harry Potter and the Order of the Phoenix", 2007, 11, 30),
(8, "Harry Potter and the Half-Blood Prince", 2009, 12, 30),
(9, "Harry Potter and the Deathly Hallows: Part 1", 2010, 12, 30),
(10, "Harry Potter And The Deathly Hallows II", 2011, 15, 26);

INSERT INTO movie_review
(review_id, date_posted, description, rating, movie_id)VALUES
();