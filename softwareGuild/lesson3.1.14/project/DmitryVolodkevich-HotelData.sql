-- To make sure that we use correct database before we add data
USE HotelReservation;

INSERT INTO State (StateAbbr, Name) VALUES
	('MA', 'Massachusetts'),
    ('IA', 'Iowa'),
    ('AK', 'Alaska'),
    ('TX', 'Texas'),
    ('NJ', 'New Jersey'),
    ('MI', 'Michigan'),
    ('CO', 'Colorado'),
    ('IL', 'Illinois'),
    ('RI', 'Rhode Island'),
    ('NY', 'New York'),
    ('VA', 'Virginia'),
    ('PA', 'Pennsylvania');
    
INSERT INTO Guest (FirstName, LastName, Address, City, StateAbbr, PostalCode, Phone) VALUES
	('Dmitry','Volodkevich','2 Neal Way','Framingham','MA','01701','(617)230-2068'),
    ('Mack','Simmer','379 Old Shore Street','Council Bluffs','IA','51501','(291)553-0508'),
    ('Bettyann','Seery','750 Wintergree Dr.','Wasilla','AK','99654','(478)277-9632'),
    ('Duane','Cullison','9662 Foxrun Lane','Harlingen','TX','78552','(308)494-0198'),
    ('Karie','Yang','9378 W. Augusta Ave.','West Deptford','NJ','08096','(214)730-0298'),
    ('Aurore','Lipton','762 Wild Rose Street','Saginaw','MI','48601','(377)507-0974'),
    ('Zachery','Luechtefeld','7 Poplar Dr.','Arvada','CO','80003','(814)485-2615'),
    ('Jeremiah','Pendergrass','70 Oakwood St.','Zion','IL','60099','(279)491-0960'),
    ('Walter','Holaway','7556 Arrowhead St.','Cumberland','RI','02864','(446)396-6785'),
    ('Wilfred','Vise','77 West Surrey Street','Oswego','NY','13126','(834)727-1001'),
    ('Maritza','Tilton','939 Linda Rd.','Burke','VA','22015','(446)351-6860'),
    ('Joleen','Tison','87 Queen St.','Drexel Hill','PA','19026','(231)893-2755');
       
INSERT INTO Reservation (GuestId, Adults, Children, StartDate, EndDate, TotalCost) VALUES
	(2,1,NULL,'2023-02-02','2023-02-04',299.98), 
	(3,2,1,'2023-02-05','2023-02-10',999.95), 
	(4,2,NULL,'2023-02-22','2023-02-24',349.98), 
	(5,2,2,'2023-03-06','2023-03-07',199.99), 
	(1,1,1,'2023-03-17','2023-03-20',524.97), 
	(6,3,NULL,'2023-03-18','2023-03-23',924.95), 
	(7,2,2,'2023-03-29','2023-03-31',349.98), 
	(8,2,NULL,'2023-03-31','2023-04-05',874.95), 
	(9,1,NULL,'2023-04-09','2023-04-13',799.96), 
	(10,1,1,'2023-04-23','2023-04-24',174.99), 
	(11,2,4,'2023-05-30','2023-06-02',1199.97), 
	(12,2,NULL,'2023-06-10','2023-06-14',599.96), 
	(12,1,NULL,'2023-06-10','2023-06-14',599.96), 
	(6,3,NULL,'2023-06-17','2023-06-18',184.99), 
	(1,2,NULL,'2023-06-28','2023-07-02',699.96), 
	(9,3,1,'2023-07-13','2023-07-14',184.99), 
	(10,4,2,'2023-07-18','2023-07-21',1259.97), 
	(3,2,1,'2023-07-28','2023-07-29',199.99), 
	(3,1,NULL,'2023-08-30','2023-09-01',349.98), 
	(2,2,NULL,'2023-09-16','2023-09-17',149.99), 
	(5,2,2,'2023-09-13','2023-09-15',399.98), 
	(4,2,2,'2023-11-22','2023-11-25',1199.97), 
	(2,2,NULL,'2023-11-22','2023-11-25',449.97), 
	(2,2,2,'2023-11-22','2023-11-25',599.97), 
	(11,2,NULL,'2023-12-24','2023-12-28',699.96);

INSERT INTO Room (RoomId, Type, ADAAccessible, StandardOccupancy, MaximumOccupancy, BasePrice, ExtraPerson) VALUES
	(201,'Double','No',2,4,199.99,10.00), 
	(202,'Double','Yes',2,4,174.99,10.00), 
	(203,'Double','No',2,4,199.99,10.00), 
	(204,'Double','Yes',2,4,174.99,10.00), 
	(205,'Single','No',2,2,174.99,NULL), 
	(206,'Single','Yes',2,2,149.99,NULL), 
	(207,'Single','No',2,2,174.99,NULL), 
	(208,'Single','Yes',2,2,149.99,NULL), 
	(301,'Double','No',2,4,199.99,10.00), 
	(302,'Double','Yes',2,4,174.99,10.00), 
	(303,'Double','No',2,4,199.99,10.00), 
	(304,'Double','Yes',2,4,174.99,10.00), 
	(305,'Single','No',2,2,174.99,NULL), 
	(306,'Single','Yes',2,2,149.99,NULL), 
	(307,'Single','No',2,2,174.99,NULL), 
	(308,'Single','Yes',2,2,149.99,NULL), 
	(401,'Suite','Yes',3,8,399.99,20.00), 
	(402,'Suite','Yes',3,8,399.99,20.00); 
        
INSERT INTO ReservationRoom (ReservationId, RoomId) VALUES
	(1,308),
	(2,203),
	(3,305),
	(4,201),
	(5,307),
	(6,302),
	(7,202),
	(8,304),
	(9,301),
	(10,207),
	(11,401),
	(12,206),
	(13,208),
	(14,304),
	(15,205),
	(16,204),
	(17,401),
	(18,303),
	(19,305),
	(20,208),
	(21,203),
	(22,401),
	(23,206),
	(24,301),
	(25,302);
    
INSERT INTO Amenity (Name) VALUES
('Microwave'),
('Jacuzzi'),
('Refrigerator'),
('Oven');

INSERT INTO RoomAmenity (RoomId, AmenityId) VALUES
(201,1),
(201,2),
(202,3),
(203,1),
(203,2),
(204,3),
(205,1),
(205,2),
(205,3),
(206,1),
(206,3),
(207,1),
(207,2),
(207,3),
(208,1),
(208,3),
(301,1),
(301,2),
(302,3),
(303,1),
(303,2),
(304,3),
(305,1),
(305,2),
(305,3),
(306,1),
(306,3),
(307,1),
(307,2),
(307,3),
(308,1),
(308,3),
(401,1),
(401,3),
(401,4),
(402,1),
(402,3),
(402,4);

-- Deleting Jeremiah Pendergrass's information

-- 1.) Identify his reservation and guest IDs
SELECT
	CONCAT(Guest.FirstName, Guest.Lastname) GuestName,
    Guest.GuestId,
    Reservation.ReservationId
FROM Reservation
INNER JOIN Guest ON Reservation.GuestId = Guest.GuestId
WHERE Guest.FirstName = 'Jeremiah' AND Guest.LastName = 'Pendergrass';

-- 2.) Delete ReservationRoom record for the ReservationId 8
DELETE FROM ReservationRoom
WHERE ReservationID = 8;

-- 3.) Delete Reservation record for the GuestId 8
DELETE FROM Reservation
WHERE GuestID = 8;

-- 4.) Delete Guest record for the GuestId 8 (the last table to consider)
DELETE FROM Guest
WHERE GuestId = 8;