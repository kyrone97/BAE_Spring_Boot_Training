DROP TABLE IF EXISTS user CASCADE;

CREATE TABLE user(
	id INT AUTO_INCREMENT,
	firstname VARCHAR(255) NOT NULL,
	lastname VARCHAR(255) NOT NULL,
	username VARCHAR(255) NOT NULL,
	age INT NOT NULL,
	PRIMARY KEY(id)
	);