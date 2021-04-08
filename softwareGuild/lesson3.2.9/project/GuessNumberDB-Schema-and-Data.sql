DROP DATABASE IF EXISTS guessnumberDB;
CREATE DATABASE guessnumberDB;

USE guessnumberDB;

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

INSERT INTO guessnumbergame (answer, finished) VALUES
	(9867, false),
    (6749, false),
    (6489, true),
    (9867, false),
    (6374, false),
    (5486, false);
    
INSERT INTO guessnumberround (`round`, gameid, guess, `time`, result) VALUES
	(1,1,4235,"01:39:54","e:0:p:0"),
	(2,1,5324,"01:11:54","e:0:p:0"),
	(3,1,5869,"01:41:31","e:2:p:1"),
	(4,1,7869,"01:11:53","e:2:p:2"),
	(1,2,5238,"11:45:42","e:0:p:0"),
	(1,3,6489,"12:50:43","e:4:p:0"),
    (1,4,4582,"08:22:39","e:0:p:1"),
    (1,5,7485,"14:52:23","e:0:p:0"),
    (1,6,6597,"15:11:31","e:0:p:0");
    









    