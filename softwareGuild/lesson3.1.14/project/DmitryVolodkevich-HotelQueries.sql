USE HotelReservation;

-- 1.) Return a list of reservations that end in July 2023,
-- include the guest name, the room number(s), and the reservation dates.
SELECT
	CONCAT(Guest.LastName, ', ', Guest.FirstName) GuestName,
    ReservationRoom.RoomId,
	Reservation.StartDate,
    Reservation.EndDate
FROM Guest
INNER JOIN Reservation ON Guest.GuestId = Reservation.GuestId
INNER JOIN ReservationRoom ON Reservation.ReservationId = ReservationRoom.ReservationId
WHERE Reservation.EndDate BETWEEN '2023-07-01' AND '2023-07-31'
ORDER BY Reservation.EndDate ASC;
-- Result:
-- GuestName			RoomId	StartDate	EndDate
-- Volodkevich, Dmitry	205		2023-06-28	2023-07-02
-- Holaway, Walter		204		2023-07-13	2023-07-14
-- Vise, Wilfred		401		2023-07-18	2023-07-21
-- Seery, Bettyann		303		2023-07-28	2023-07-29

-- -------------------------------------------------------------------

-- 2.) Returns a list of all reservations for rooms with a jacuzzi, 
-- displaying the guest's name, the room number, and the dates of the reservation.
SELECT
	CONCAT(Guest.LastName,', ',Guest.FirstName) GuestName,
    ReservationRoom.RoomId,
    Reservation.StartDate,
    Reservation.EndDate,
    Amenity.Name AmenityName
FROM Guest
INNER JOIN Reservation ON Guest.GuestId = Reservation.GuestId
INNER JOIN ReservationRoom ON Reservation.ReservationId = ReservationRoom.ReservationId
INNER JOIN RoomAmenity ON ReservationRoom.RoomId = RoomAmenity.RoomId
INNER JOIN Amenity ON RoomAmenity.AmenityId = Amenity.AmenityId
WHERE Amenity.Name = 'Jacuzzi';
-- Result:
-- GuestName 			RoomId 	StartDate 	EndDate 	AmenityName
-- Yang, Karie			201		2023-03-06	2023-03-07	Jacuzzi
-- Seery, Bettyann		203		2023-02-05	2023-02-10	Jacuzzi
-- Yang, Karie			203		2023-09-13	2023-09-15	Jacuzzi
-- Volodkevich, Dmitry	205		2023-06-28	2023-07-02	Jacuzzi
-- Vise, Wilfred		207		2023-04-23	2023-04-24	Jacuzzi
-- Holaway, Walter		301		2023-04-09	2023-04-13	Jacuzzi
-- Simmer, Mack			301		2023-11-22	2023-11-25	Jacuzzi
-- Seery, Bettyann		303		2023-07-28	2023-07-29	Jacuzzi
-- Cullison, Duane		305		2023-02-22	2023-02-24	Jacuzzi
-- Seery, Bettyann		305		2023-08-30	2023-09-01	Jacuzzi
-- Volodkevich, Dmitry	307		2023-03-17	2023-03-20	Jacuzzi

-- -------------------------------------------------------------------

-- 3.) Return all the rooms reserved for a specific guest, 
-- including the guest's name, the room(s) reserved, the starting date of the reservation, 
-- and how many people were included in the reservation. (Choose a guest's name from the existing data.)
SELECT
	CONCAT(Guest.LastName,', ',Guest.FirstName) GuestName,
    ReservationRoom.RoomId,
    Reservation.StartDate,
    (Reservation.Adults + IFNULL(Reservation.Children, 0)) PeapleInReservation
FROM Guest 
INNER JOIN Reservation ON Guest.GuestId = Reservation.GuestId
INNER JOIN ReservationRoom ON Reservation.ReservationId = ReservationRoom.ReservationId
WHERE Guest.GuestId = 2;
-- Result:
-- GuestName		RoomId	StartDate	PeapleInReservation
-- Simmer, Mack		308		2023-02-02	1
-- Simmer, Mack		208		2023-09-16	2
-- Simmer, Mack		206		2023-11-22	2
-- Simmer, Mack		301		2023-11-22	4

-- -------------------------------------------------------------------

-- 4.) Return a list of rooms, reservation ID, and per-room cost for each reservation. 
-- The results should include all rooms, whether or not there is a reservation associated with the room.
SELECT
	IFNULL(Reservation.ReservationId, 0) ReservationId,
    Room.RoomId,
    IFNULL(Reservation.TotalCost, 0) TotalCost
FROM Room
LEFT OUTER JOIN ReservationRoom ON Room.RoomId = ReservationRoom.RoomId
LEFT OUTER JOIN Reservation ON ReservationRoom.ReservationId = Reservation.ReservationId
ORDER BY ISNULL(Reservation.ReservationId), Reservation.ReservationId ASC;
-- Result:
-- ReservationId	RoomId	TotalCost
-- 1				308		299.98
-- 2				203		999.95
-- 3				305		349.98
-- 4				201		199.99
-- 5				307		524.97
-- 6				302		924.95
-- 7				202		349.98
-- 9				301		799.96
-- 10				207		174.99
-- 11				401		1199.97
-- 12				206		599.96
-- 13				208		599.96
-- 14				304		184.99
-- 15				205		699.96
-- 16				204		184.99
-- 17				401		1259.97
-- 18				303		199.99
-- 19				305		349.98
-- 20				208		149.99
-- 21				203		399.98
-- 22				401		1199.97
-- 23				206		449.97
-- 24				301		599.97
-- 25				302		699.96
-- 0				306		0.00
-- 0				402		0.00

-- -------------------------------------------------------------------

-- 5.) Return all the rooms accommodating at least three guests 
-- and that are reserved on any date in April 2023.
SELECT
	ReservationRoom.RoomId,
    (Reservation.Adults + IFNULL(Reservation.Children,0)) GuestsAmt,
    Reservation.StartDate,
    Reservation.EndDate
FROM Reservation
INNER JOIN ReservationRoom ON Reservation.ReservationId = ReservationRoom.ReservationId
WHERE (Reservation.Adults + IFNULL(Reservation.Children,0)) >= 3
	AND ((Reservation.StartDate BETWEEN '2023-04-01' AND '2023-04-30')
    OR (Reservation.EndDate BETWEEN '2023-04-01' AND '2023-04-30'));
-- Result:
-- There is no answer.

-- -------------------------------------------------------------------
	
-- 6.) Return a list of all guest names and the number of reservations per guest, 
-- sorted starting with the guest with the most reservations and then by the guest's name.
SELECT
	CONCAT(Guest.LastName,', ',Guest.FirstName) GuestName,
    COUNT(Reservation.ReservationId) ReservationsAmount
FROM Reservation
LEFT OUTER JOIN Guest ON Reservation.GuestId = Guest.GuestId
GROUP BY Guest.GuestId, Guest.LastName, Guest.FirstName
ORDER BY COUNT(Reservation.ReservationId) DESC, Guest.LastName;
-- Result:
-- GuestName			ReservationsAmount
-- Simmer, Mack			4
-- Seery, Bettyann		3
-- Cullison, Duane		2
-- Holaway, Walter		2
-- Lipton, Aurore		2
-- Tilton, Maritza		2
-- Tison, Joleen		2
-- Vise, Wilfred		2
-- Volodkevich, Dmitry	2
-- Yang, Karie			2
-- Luechtefeld, Zachery	1

-- -------------------------------------------------------------------

-- 7.) Display the name, address, and phone number of a guest based on their phone number. 
-- (Choose a phone number from the existing data.)
SELECT
	CONCAT(Guest.LastName,', ',Guest.FirstName) GuestName,
    Guest.Address,
    Guest.Phone
FROM Guest
WHERE Guest.Phone = '(834)727-1001';
-- Result:
-- GuestName		Address					Phone
-- Vise, Wilfred	77 West Surrey Street	(834)727-1001

	