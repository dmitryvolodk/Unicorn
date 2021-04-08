-- Drop the existing database, if it exists, so that the database could be rebuilt.
DROP DATABASE IF EXISTS HotelReservation;

CREATE DATABASE HotelReservation;

-- We are using correct database before we add schema
USE HotelReservation;

CREATE TABLE State (
	StateAbbr CHAR(2) NOT NULL PRIMARY KEY,
    Name VARCHAR(50) NOT NULL
);

CREATE TABLE Guest (
	GuestId INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Address VARCHAR(256) NULL,
    City VARCHAR(100) NULL,
    StateAbbr CHAR(2) NULL,
    PostalCode VARCHAR(10) NULL,
    Phone VARCHAR(15) NULL,
    FOREIGN KEY fk_Guest_State (StateAbbr)
		REFERENCES State(StateAbbr)
);

CREATE TABLE Reservation (
	ReservationId INT PRIMARY KEY AUTO_INCREMENT,
    GuestId INT NOT NULL,
    Adults INT NOT NULL,
    Children INT NULL,
    StartDate DATE NOT NULL,
    EndDate DATE NOT NULL,
    TotalCost DECIMAL(10,2) NOT NULL,
    FOREIGN KEY fk_Reservation_Guest (GuestId)
		REFERENCES Guest(GuestId)
);

CREATE TABLE Room (
	RoomId INT NOT NULL PRIMARY KEY,
    Type CHAR(50) NOT NULL,
    ADAAccessible CHAR(50) NOT NULL,
    StandardOccupancy INT NOT NULL,
    MaximumOccupancy INT NOT NULL,
    BasePrice DECIMAL(10,2) NOT NULL,
    ExtraPerson DECIMAL(10,2) NULL
);

CREATE TABLE ReservationRoom (
	ReservationId INT NOT NULL,
    RoomId INT NOT NULL,
    PRIMARY KEY pk_ReservationRoom (ReservationId, RoomId),
    FOREIGN KEY fk_ReservationRoom_Reservation (ReservationId)
		REFERENCES Reservation(ReservationId),
	FOREIGN KEY fk_ReservationRoom_Room (RoomId)
		REFERENCES Room(RoomId)
);

CREATE TABLE Amenity (
   	AmenityId INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(50) NOT NULL
);

CREATE TABLE RoomAmenity (
    RoomId INT NOT NULL,
	AmenityId INT NOT NULL,
    PRIMARY KEY pk_RoomAmenity (RoomId, AmenityId),
    FOREIGN KEY fk_RoomAmenity_Room (RoomId)
		REFERENCES Room(RoomId),
	FOREIGN KEY fk_RoomAmenity_Amenity (AmenityId)
		REFERENCES Amenity(AmenityId)
);