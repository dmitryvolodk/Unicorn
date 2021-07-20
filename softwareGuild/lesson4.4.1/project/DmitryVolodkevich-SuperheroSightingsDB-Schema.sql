DROP DATABASE IF EXISTS superheroSightings;
CREATE DATABASE superheroSightings;

USE superheroSightings;

CREATE TABLE `organization`(
    organizationId INT PRIMARY KEY AUTO_INCREMENT,
    organizationName VARCHAR(100) NOT NULL,
    organizationDescription VARCHAR(256) NULL,
    organizationContactInfo VARCHAR(256) NULL
);

CREATE TABLE location(
    locationId INT PRIMARY KEY AUTO_INCREMENT,
    locationName VARCHAR(100) NOT NULL,
    locationDescription VARCHAR(256) NULL,
    locationAddress VARCHAR(256) NULL,
    latitude VARCHAR(50) NULL,
    longitude VARCHAR(50) NULL
);

CREATE TABLE superpower(
    superpowerId INT PRIMARY KEY AUTO_INCREMENT,
    superpowerName VARCHAR(100) NOT NULL
);

CREATE TABLE hero(
    heroId INT PRIMARY KEY AUTO_INCREMENT,
    heroName VARCHAR(50) NOT NULL,
    heroDescription VARCHAR(256) NULL,
    superpowerId INT NOT NULL,
    photoName VARCHAR(50) NULL,
    FOREIGN KEY (superpowerId) REFERENCES superpower(superpowerId)
);

CREATE TABLE hero_organization(
    heroId INT NOT NULL,
    organizationId INT NOT NULL,
    PRIMARY KEY(heroId, organizationId),
    FOREIGN KEY (heroId) REFERENCES hero(heroId),
    FOREIGN KEY (organizationId) REFERENCES `organization`(organizationId)
);

CREATE TABLE sighting(
    sightingId INT PRIMARY KEY AUTO_INCREMENT,
    locationId INT NOT NULL,
    heroId INT NOT NULL,
    `date` DATE NOT NULL,
    FOREIGN KEY (locationId) REFERENCES location(locationId),
    FOREIGN KEY (heroId) REFERENCES hero(heroId)
);