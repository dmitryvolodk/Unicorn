USE TrackIt;

SELECT *
FROM Worker;

SELECT *
FROM Worker
ORDER BY LastName;

-- Sort descending by LastName.
SELECT *
FROM Worker
ORDER BY LastName DESC;

-- Sort ascending by LastName.
SELECT *
FROM Worker
ORDER BY LastName ASC;

-- Soring is not different in JOIN queries.
SELECT
	w.FirstName,
    w.LastName,
    p.Name ProjectName
FROM Worker w
INNER JOIN ProjectWorker pw ON w.WorkerId = pw.WorkerId
INNER JOIN Project p ON pw.ProjectId = p.ProjectId
ORDER BY w.LastName ASC;

-- Soring multiple columns.
SELECT
	w.FirstName,
    w.LastName,
    p.Name ProjectName
FROM Worker w
INNER JOIN ProjectWorker pw ON w.WorkerId = pw.WorkerId
INNER JOIN Project p ON pw.ProjectId = p.ProjectId
ORDER BY w.LastName DESC, p.Name ASC;

-- Handling NULL
SELECT
    t.Title,
    s.Name StatusName
FROM Task t
LEFT OUTER JOIN TaskStatus s ON t.TaskStatusId = s.TaskStatusId
ORDER BY s.Name ASC;

-- Results are sorted non-null to null, then by TaskStatus.Name.
-- That puts NULL values last.
SELECT
    t.Title,
    s.Name StatusName
FROM Task t
LEFT OUTER JOIN TaskStatus s ON t.TaskStatusId = s.TaskStatusId
ORDER BY ISNULL(s.Name), s.Name ASC;

-- LIMIT clause
SELECT *
FROM Worker
ORDER BY LastName ASC
LIMIT 2, 10;

-- Offset 10 rows and grab 10
SELECT *
FROM Worker
ORDER BY LastName DESC
LIMIT 10, 10;

-- Offset 200 rows and grab 10
SELECT *
FROM Worker
ORDER BY LastName DESC
LIMIT 200, 10;

-- Skip the first 100 records and show the next 25.
SELECT
    w.FirstName,
    w.LastName,
    p.Name ProjectName
FROM Worker w
INNER JOIN ProjectWorker pw ON w.WorkerId = pw.WorkerId
INNER JOIN Project p ON pw.ProjectId = p.ProjectId
ORDER BY w.LastName DESC, p.Name ASC
LIMIT 100, 25;