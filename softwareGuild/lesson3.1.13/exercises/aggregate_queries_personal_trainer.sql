USE PersonalTrainer;

-- Use an aggregate to count the number of Clients.
-- 500 rows
SELECT
	COUNT(Client.ClientId) NumberOfClients
FROM Client;

-- Use an aggregate to count Client.BirthDate.
-- The number is different than total Clients. Why?
-- 463 rows
SELECT
	COUNT(Client.Birthdate) NumberOfBirthDates
FROM Client;

-- Group Clients by City and count them.
-- Order by the number of Clients desc.
-- 20 rows
SELECT
	Client.City,
	COUNT(Client.ClientId) NumberOfClients
FROM Client
GROUP BY Client.City
ORDER BY COUNT(Client.ClientId);

-- Calculate a total per invoice using only the InvoiceLineItem table.
-- Group by InvoiceId.
-- You'll need an expression for the line item total: Price * Quantity.
-- Aggregate per group using SUM().
-- 1000 rows
SELECT
	InvoiceLineItem.InvoiceId,
    SUM(InvoiceLineItem.Price * InvoiceLineItem.Quantity) TotalPerInvoice
FROM InvoiceLineItem
GROUP BY InvoiceLineItem.InvoiceId;

-- Calculate a total per invoice using only the InvoiceLineItem table.
-- (See above.)
-- Only include totals greater than $500.00.
-- Order from lowest total to highest.
-- 234 rows
SELECT
	InvoiceLineItem.InvoiceId,
    SUM(InvoiceLineItem.Price * InvoiceLineItem.Quantity) TotalPerInvoice
FROM InvoiceLineItem
GROUP BY InvoiceLineItem.InvoiceId
HAVING SUM(InvoiceLineItem.Price * InvoiceLineItem.Quantity) > 500
ORDER BY SUM(InvoiceLineItem.Price * InvoiceLineItem.Quantity) ASC;
	
-- Calculate the average line item total
-- grouped by InvoiceLineItem.Description.
-- 3 rows
SELECT
	InvoiceLineItem.Description,
    AVG(InvoiceLineItem.Price * InvoiceLineItem.Quantity) InvoiceAvgAmt
FROM InvoiceLineItem
GROUP BY InvoiceLineItem.Description;

-- Select ClientId, FirstName, and LastName from Client
-- for clients who have *paid* over $1000 total.
-- Paid is Invoice.InvoiceStatus = 2.
-- Order by LastName, then FirstName.
-- 146 rows
SELECT
	Client.ClientId,
    Client.FirstName,
    Client.LastName
FROM Client
INNER JOIN Invoice ON Client.ClientId = Invoice.ClientId
INNER JOIN InvoiceLineItem ON Invoice.InvoiceId = InvoiceLineItem.InvoiceId
WHERE Invoice.InvoiceStatus = 2
GROUP BY Client.ClientId
HAVING SUM(InvoiceLineItem.Price * InvoiceLineItem.Quantity) > 1000
ORDER BY Client.LastName, Client.FirstName;

-- Count exercises by category.
-- Group by ExerciseCategory.Name.
-- Order by exercise count descending.
-- 13 rows
SELECT
	ExerciseCategory.Name,
    COUNT(Exercise.ExerciseId) ExercisesCount
FROM ExerciseCategory
INNER JOIN Exercise ON ExerciseCategory.ExerciseCategoryId = Exercise.ExerciseCategoryId
GROUP BY ExerciseCategory.Name
ORDER BY COUNT(Exercise.ExerciseId) desc;    

-- Select Exercise.Name along with the minimum, maximum,
-- and average ExerciseInstance.Sets.
-- Order by Exercise.Name.
-- 64 rows
SELECT
	Exercise.Name ExerciseName,
    MIN(ExerciseInstance.Sets) MinSets,
    MAX(ExerciseInstance.Sets) MaxSets,
	AVG(ExerciseInstance.Sets) AvgSets
FROM Exercise
INNER JOIN ExerciseInstance ON Exercise.ExerciseId = ExerciseInstance.ExerciseId
GROUP BY Exercise.ExerciseId, Exercise.Name
ORDER BY Exercise.Name;

-- Find the minimum and maximum Client.BirthDate
-- per Workout.
-- 26 rows
-- Sample: 
-- WorkoutName, EarliestBirthDate, LatestBirthDate
-- '3, 2, 1... Yoga!', '1928-04-28', '1993-02-07'
SELECT
	Workout.Name WorkoutName,
    MIN(Client.BirthDate) EarliestBirthDate,
	MAX(Client.BirthDate) LatestBirthDate
FROM Client
INNER JOIN ClientWorkout ON Client.ClientId = ClientWorkout.ClientId
INNER JOIN Workout ON ClientWorkout.WorkoutId = Workout.WorkoutId
GROUP BY Workout.WorkoutId, Workout.Name;

-- Count client goals.
-- Be careful not to exclude rows for clients without goals.
-- 500 rows total
-- 50 rows with no goals
SELECT
	CONCAT(Client.FirstName, Client.LastName),
    IFNULL(COUNT(Goal.GoalId), 0) GoalName
FROM Client
LEFT OUTER JOIN ClientGoal ON Client.ClientId = ClientGoal.ClientId
LEFT OUTER JOIN Goal ON ClientGoal.GoalId = Goal.GoalId
GROUP BY Client.ClientId
ORDER BY COUNT(Goal.GoalId);
    
-- Select Exercise.Name, Unit.Name, 
-- and minimum and maximum ExerciseInstanceUnitValue.Value
-- for all exercises with a configured ExerciseInstanceUnitValue.
-- Order by Exercise.Name, then Unit.Name.
-- 82 rows
SELECT
	Exercise.Name ExerciseName,
    Unit.Name UnitName,
    MIN(ExerciseInstanceUnitValue.Value) MinUnitValue,
    MAX(ExerciseInstanceUnitValue.Value) MaxUnitValue
FROM Exercise
INNER JOIN ExerciseInstance ON Exercise.ExerciseId = ExerciseInstance.ExerciseId
INNER JOIN ExerciseInstanceUnitValue ON ExerciseInstance.ExerciseInstanceId = ExerciseInstanceUnitValue.ExerciseInstanceId
INNER JOIN Unit ON ExerciseInstanceUnitValue.UnitId = Unit.UnitId
GROUP BY Exercise.ExerciseId, Exercise.Name, Unit.UnitId
ORDER BY Exercise.Name, Unit.Name;

-- Modify the query above to include ExerciseCategory.Name.
-- Order by ExerciseCategory.Name, then Exercise.Name, then Unit.Name.
-- 82 rows
SELECT
	Exercise.Name ExerciseName,
    ExerciseCategory.Name ExerciseCategoryName,
    Unit.Name UnitName,
    MIN(ExerciseInstanceUnitValue.Value) MinUnitValue,
    MAX(ExerciseInstanceUnitValue.Value) MaxUnitValue
FROM ExerciseCategory
INNER JOIN Exercise ON ExerciseCategory.ExerciseCategoryId = Exercise.ExerciseCategoryId
INNER JOIN ExerciseInstance ON Exercise.ExerciseId = ExerciseInstance.ExerciseId
INNER JOIN ExerciseInstanceUnitValue ON ExerciseInstance.ExerciseInstanceId = ExerciseInstanceUnitValue.ExerciseInstanceId
INNER JOIN Unit ON ExerciseInstanceUnitValue.UnitId = Unit.UnitId
GROUP BY Exercise.ExerciseId, Exercise.Name, Unit.UnitId
ORDER BY ExerciseCategory.Name, Exercise.Name, Unit.Name;

-- Select the minimum and maximum age in years for
-- each Level.
-- To calculate age in years, use the MySQL function DATEDIFF.
-- 4 rows
SELECT 
	Level.Name LevelName,
    MIN(DATEDIFF (CURDATE(), Client.BirthDate) / 365) MinAge,
    MAX(DATEDIFF (CURDATE(), Client.BirthDate) / 365) MaxAge
FROM Level
INNER JOIN Workout ON Level.LevelId = Workout.LevelId
INNER JOIN ClientWorkout ON Workout.WorkoutId = ClientWorkout.WorkoutId
INNER JOIN Client ON ClientWorkout.ClientId = Client.ClientId
GROUP BY Level.Name;

-- Stretch Goal!
-- Count logins by email extension (.com, .net, .org, etc...).
-- Research SQL functions to isolate a very specific part of a string value.
-- 27 rows (27 unique email extensions)
SELECT
	SUBSTRING_INDEX(Login.EmailAddress, '.', -1),
    COUNT(EmailAddress)
FROM Login
GROUP BY SUBSTRING_INDEX(EmailAddress, '.', -1)
ORDER BY COUNT(EmailAddress) DESC;

-- Stretch Goal!
-- Match client goals to workout goals.
-- Select Client FirstName and LastName and Workout.Name for
-- all workouts that match at least 2 of a client's goals.
-- Order by the client's last name, then first name.
-- 139 rows
SELECT
	w.`Name` WorkoutName,
    CONCAT(c.FirstName, ' ', c.LastName) ClientName,
    COUNT(cg.GoalId)
FROM Client c
INNER JOIN ClientGoal cg ON c.ClientId = cg.ClientId
INNER JOIN WorkoutGoal wg ON cg.GoalId = wg.GoalId
INNER JOIN Workout w ON wg.WorkoutId = w.WorkoutId
GROUP BY w.WorkoutId, w.`Name`, c.ClientId, c.FirstName, c.LastName
HAVING COUNT(cg.GoalId) > 1
ORDER BY c.LastName, c.FirstName;