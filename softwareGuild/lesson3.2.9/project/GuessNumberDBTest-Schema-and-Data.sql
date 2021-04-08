DROP DATABASE IF EXISTS guessnumberDBtest;
CREATE DATABASE guessnumberDBtest;

USE guessnumberDBtest;

CREATE TABLE guessnumbergame(
	gameid INT PRIMARY KEY AUTO_INCREMENT,
    answer INT NOT NULL,
    finished BOOLEAN DEFAULT false);

CREATE TABLE guessnumberround(
	roundid INT PRIMARY KEY AUTO_INCREMENT,
    `round` INT NOT NULL,
    gameid INT NOT NULL,
    guess INT NOT NULL,
    `time` VARCHAR(15) NOT NULL,
    result VARCHAR(10) NOT NULL,
	FOREIGN KEY (gameid) REFERENCES guessnumbergame(gameid));