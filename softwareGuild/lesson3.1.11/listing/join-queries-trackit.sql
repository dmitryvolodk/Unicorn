USE TrackIt;

SELECT *
FROM TaskStatus
WHERE IsResolved = 1;

-- TaskStatusIds are in order, so we can use BETWEEN.
-- If they were out of sequence, we might use an IN (id1, id2, idN).
SELECT *
FROM task
WHERE TaskStatusId BETWEEN 5 AND 8;

-- Now simplify the output by using  JOIN
SELECT
	Task.TaskId,
    Task.Title,
    TaskStatus.Name
FROM TaskStatus
INNER JOIN Task ON TaskStatus.TaskStatusId = Task.TaskStatusId
WHERE TaskStatus.IsResolved = 1;

SELECT
	Project.`Name`,
    Worker.Firstname,
    Worker.LastName
FROM Project
INNER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
INNER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
WHERE Project.ProjectId = 'game-goodboy';

-- To see who's working on each Task in the Who's a GOOD boy!?
SELECT
	Project.`Name`,
    Worker.FirstName,
    Worker.LastName,
    Task.Title
FROM Project
INNER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
INNER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
INNER JOIN Task ON ProjectWorker.ProjectId = Task.ProjectId
	AND ProjectWorker.WorkerId = Task.WorkerId
WHERE Project.ProjectId = 'game-goodboy';

-- Outer Join
-- 543 rows
SELECT *
FROM Task;

-- 532 rows only
SELECT *
FROM Task
INNER JOIN TaskStatus ON Task.TaskStatusId = TaskStatus.TaskStatusId;

-- To clarify - one more query
SELECT *
FROM task
WHERE TaskStatusId IS NULL;

-- To fix our Task query, we add a LEFT OUTER JOIN:
SELECT *
FROM task
LEFT OUTER JOIN TaskStatus ON Task.TaskStatusId = TaskStatus.TaskStatusId;

-- Replacing a NULL Vaue With IFNULL()
SELECT
	Task.TaskId,
    Task.Title,
    IFNULL(Task.TaskStatusId, 0) AS TaskStatusId,
    IFNULL(TaskStatus.`Name`, '[None]') AS StatusName
FROM Task
LEFT OUTER JOIN TaskStatus ON Task.TaskStatusId = TaskStatus.TaskStatusId;

-- Projects without workers invistigation
SELECT
	Project.Name ProjectName, -- An alias makes this more clear.
    Worker.FirstName,
    Worker.LastName
FROM Project
LEFT OUTER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
LEFT OUTER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId;

-- Filter missing relationships by detecting NULL
SELECT
	Project.Name ProjectName,
    Worker.FirstName,
    Worker.LastName
FROM Project
LEFT OUTER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
LEFT OUTER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
WHERE ProjectWorker.WorkerId IS NULL; -- Throws out projects with workers.

-- Simplify query: Projects without workers, we only need the bridge table to confirm.
SELECT
	Project.Name ProjectName
FROM Project
LEFT OUTER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
WHERE ProjectWorker.WorkerId IS NULL;
    
-- Workers without projects.
SELECT
	Worker.FirstName,
    Worker.LastName
From Worker
LEFT OUTER JOIN ProjectWorker ON Worker.WorkerId = ProjectWorker.WorkerId
WHERE ProjectWorker.ProjectId IS NULL;

-- Other version of workers without projects.
SELECT
    Project.Name ProjectName,
    Worker.FirstName,
    Worker.LastName
FROM Project
RIGHT OUTER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
RIGHT OUTER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
WHERE ProjectWorker.ProjectId IS NULL;
-- WHERE ProjectWorker.WorkerId IS NULL; // This works as well. Why?

-- Simplified other version
-- Workers without a project
SELECT
    Worker.FirstName,
    Worker.LastName
FROM ProjectWorker
RIGHT OUTER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
WHERE ProjectWorker.ProjectId IS NULL;

-- The same rezult with a different filter
SELECT
    Worker.FirstName,
    Worker.LastName
FROM ProjectWorker
RIGHT OUTER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
WHERE ProjectWorker.WorkerId IS NULL;

-- The query to put the important concept Worker first
SELECT
    Worker.FirstName,
    Worker.LastName
FROM Worker
LEFT OUTER JOIN ProjectWorker ON Worker.WorkerId = ProjectWorker.WorkerId
WHERE ProjectWorker.WorkerId IS NULL;

-- Let's JOIN a table to itself using aliases (for the columns and for the table)
SELECT 
	parent.TaskId ParentTaskId,
    child.TaskId ChildTaskId,
    CONCAT(parent.Title, ': ', child.Title) Title
FROM Task parent
INNER JOIN Task child ON parent.TaskId = child.ParentTaskId;

-- Cross JOIN
SELECT
	CONCAT(w.FirstName, ' ', w.LastName) WorkerName,
    p.Name ProjectName
FROM Worker w
CROSS JOIN Project p
WHERE w.WorkerId = 1 AND p.ProjectId NOT LIKE 'game-%';

