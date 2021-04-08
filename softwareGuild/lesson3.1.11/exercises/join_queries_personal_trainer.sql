USE PersonalTrainer;

-- Select all columns from ExerciseCategory and Exercise.
-- The tables should be joined on ExerciseCategoryId.
-- This query returns all Exercises and their associated ExerciseCategory.
-- 64 rows
SELECT *
FROM ExerciseCategory
INNER JOIN Exercise ON ExerciseCategory.ExerciseCategoryId = Exercise.ExerciseCategoryId;
    
-- Select ExerciseCategory.Name and Exercise.Name
-- where the ExerciseCategory does not have a ParentCategoryId (it is null).
-- Again, join the tables on their shared key (ExerciseCategoryId).
-- 9 rows
SELECT
	ExerciseCategory.Name,
    Exercise.Name
FROM ExerciseCategory
INNER JOIN Exercise ON ExerciseCategory.ExerciseCategoryId = Exercise.ExerciseCategoryId
WHERE ParentCategoryId IS NULL;

-- The query above is a little confusing. At first glance, it's hard to tell
-- which Name belongs to ExerciseCategory and which belongs to Exercise.
-- Rewrite the query using an aliases. 
-- Alias ExerciseCategory.Name as 'CategoryName'.
-- Alias Exercise.Name as 'ExerciseName'.
-- 9 rows
SELECT
	ExerciseCategory.Name CategoryName,
    Exercise.Name ExerciseName
FROM ExerciseCategory
INNER JOIN Exercise ON ExerciseCategory.ExerciseCategoryId = Exercise.ExerciseCategoryId
WHERE ParentCategoryId IS NULL;

-- Select FirstName, LastName, and BirthDate from Client
-- and EmailAddress from Login 
-- where Client.BirthDate is in the 1990s.
-- Join the tables by their key relationship. 
-- What is the primary-foreign key relationship?
-- 35 rows
SELECT
	`Client`.FirstName,
    `Client`.LastName,
    `Client`.BirthDate,
    Login.EmailAddress
FROM Login
INNER JOIN `Client` ON Login.ClientId = `Client`.ClientId
WHERE `Client`.BirthDate BETWEEN '1990-01-01' AND '1999-12-31';

-- Select Workout.Name, Client.FirstName, and Client.LastName
-- for Clients with LastNames starting with 'C'?
-- How are Clients and Workouts related?
-- 25 rows
SELECT
	Workout.`Name`,
    `Client`.FirstName,
    `Client`.LastName
FROM `Client`
INNER JOIN ClientWorkout ON `Client`.ClientId = ClientWorkout.ClientId
INNER JOIN Workout ON ClientWorkout.WorkoutId = Workout.WorkoutId
WHERE `Client`.LastName LIKE 'C%';

-- Select Names from Workouts and their Goals.
-- This is a many-to-many relationship with a bridge table.
-- Use aliases appropriately to avoid ambiguous columns in the result.
SELECT
	Workout.`Name` WorkoutName,
    Goal.`Name` GoalName
FROM Workout 
INNER JOIN WorkoutGoal ON Workout.WorkoutId = WorkoutGoal.WorkoutId
INNER JOIN Goal ON WorkoutGoal.GoalId = Goal.GoalId; 

-- Select FirstName and LastName from Client.
-- Select ClientId and EmailAddress from Login.
-- Join the tables, but make Login optional.
-- 500 rows
SELECT
	`Client`.FirstName,
    `Client`.LastName,
    Login.ClientId,
    Login.EmailAddress
FROM `Client`
LEFT OUTER JOIN Login ON `Client`.ClientId = Login.ClientId;

-- Using the query above as a foundation, select Clients
-- who do _not_ have a Login.
-- 200 rows
SELECT
	`Client`.FirstName,
    `Client`.LastName,
    Login.ClientId,
    Login.EmailAddress
FROM `Client`
LEFT OUTER JOIN Login ON `Client`.ClientId = Login.ClientId
WHERE Login.ClientId IS NULL;

-- Does the Client, Romeo Seaward, have a Login?
-- Decide using a single query.
-- nope :(
SELECT
	`Client`.FirstName,
    `Client`.LastName,
    Login.ClientId,
    Login.EmailAddress
FROM `Client`
LEFT OUTER JOIN Login ON `Client`.ClientId = Login.ClientId
WHERE Login.ClientId IS NULL AND `Client`.FirstName = 'Romeo' AND `Client`.LastName = 'Seaward';

-- Select ExerciseCategory.Name and its parent ExerciseCategory's Name.
-- This requires a self-join.
-- 12 rows
SELECT
	Parent.Name ParentName,
    Child.Name ChildName
FROM ExerciseCategory Parent
INNER JOIN ExerciseCategory Child ON Parent.ExerciseCategoryId = Child.ParentCategoryId;
    
-- Rewrite the query above so that every ExerciseCategory.Name is
-- included, even if it doesn't have a parent.
-- 16 rows
SELECT
	Parent.Name ParentName,
    Child.Name ChildName
FROM ExerciseCategory Parent
RIGHT OUTER JOIN ExerciseCategory Child ON Parent.ExerciseCategoryId = Child.ParentCategoryId;
    
-- Are there Clients who are not signed up for a Workout?
-- 50 rows
SELECT
	`Client`.FirstName,
    `Client`.LastName,
    ClientWorkout.ClientId
FROM `Client`
LEFT OUTER JOIN ClientWorkout ON `Client`.ClientId = ClientWorkout.ClientId
WHERE ClientWorkout.ClientId IS NULL;

-- Which Beginner-Level Workouts satisfy at least one of Shell Creane's Goals?
-- Goals are associated to Clients through ClientGoal.
-- Goals are associated to Workouts through WorkoutGoal.
-- 6 rows, 4 unique rows
SELECT
	Client.FirstName,
    Client.LastName,
    Goal.Name GoalName,
    Workout.Name WorkoutName,
    Level.Name LevelName
FROM Client
INNER JOIN ClientGoal ON Client.ClientId = ClientGoal.ClientId
INNER JOIN Goal ON ClientGoal.GoalId = Goal.GoalId
INNER JOIN WorkoutGoal ON Goal.GoalId = WorkoutGoal.GoalId
INNER JOIN Workout ON WorkoutGoal.WorkoutId = Workout.WorkoutId
INNER JOIN Level ON Workout.LevelId = Level.LevelId
WHERE Client.FirstName = 'Shell' AND Client.LastName = 'Creane' AND Level.Name = 'Beginner';

-- Select all Workouts. 
-- Join to the Goal, 'Core Strength', but make it optional.
-- You may have to look up the GoalId before writing the main query.
-- If you filter on Goal.Name in a WHERE clause, Workouts will be excluded.
-- Why?
-- 26 Workouts, 3 Goals
SELECT *
FROM Goal
WHERE Name = 'Core Strength';

SELECT
	Workout.Name WorkoutName,
    Goal.Name GoalName
FROM Workout
LEFT OUTER JOIN WorkoutGoal ON Workout.WorkoutId = WorkoutGoal.WorkoutId AND WorkoutGoal.GoalId = 10
LEFT OUTER JOIN Goal ON WorkoutGoal.GoalId = Goal.GoalId;

-- The relationship between Workouts and Exercises is... complicated.
-- Workout links to WorkoutDay (one day in a Workout routine)
-- which links to WorkoutDayExerciseInstance 
-- (Exercises can be repeated in a day so a bridge table is required) 
-- which links to ExerciseInstance 
-- (Exercises can be done with different weights, repetions,
-- laps, etc...) 
-- which finally links to Exercise.
-- Select Workout.Name and Exercise.Name for related Workouts and Exercises.
SELECT
	Workout.Name WorkoutName,
    Exercise.Name ExerciseName
FROM Workout
INNER JOIN WorkoutDay ON Workout.WorkoutId = WorkoutDay.WorkoutId
INNER JOIN WorkoutDayExerciseInstance ON WorkoutDay.WorkoutDayId = WorkoutDayExerciseInstance.WorkoutDayId 
	AND WorkoutDay.Sequence = WorkoutDayExerciseInstance.Sequence
INNER JOIN ExerciseInstance ON WorkoutDayExerciseInstance.ExerciseInstanceId = ExerciseInstance.ExerciseInstanceId
INNER JOIN Exercise ON ExerciseInstance.ExerciseId = Exercise.ExerciseId;
   
-- An ExerciseInstance is configured with ExerciseInstanceUnitValue.
-- It contains a Value and UnitId that links to Unit.
-- Example Unit/Value combos include 10 laps, 15 minutes, 200 pounds.
-- Select Exercise.Name, ExerciseInstanceUnitValue.Value, and Unit.Name
-- for the 'Plank' exercise. 
-- How many Planks are configured, which Units apply, and what 
-- are the configured Values?
-- 4 rows, 1 Unit, and 4 distinct Values
SELECT
	Exercise.Name ExerciseName,
    ExerciseInstanceUnitValue.Value,
    Unit.Name UnitName
FROM Exercise 
INNER JOIN ExerciseInstance ON Exercise.ExerciseId = ExerciseInstance.ExerciseId
INNER JOIN ExerciseInstanceUnitValue ON ExerciseInstance.ExerciseInstanceId = ExerciseInstanceUnitValue.ExerciseInstanceId
INNER JOIN Unit ON ExerciseInstanceUnitValue.UnitId = Unit.UnitId
WHERE Exercise.Name = 'Plank';