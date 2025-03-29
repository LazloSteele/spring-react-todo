INSERT INTO todoitemreactdb.todoitem (id, taskname, createdOn, urgency, importance) VALUES
(1, 'Wash the dishes', '2025-03-29', 1, 3),
(2, 'Walk the frog', '2025-03-29', 1, 2),
(3, 'Write a sick app', '2025-03-29', 0, 0),
(4, 'Go to the park', '2025-03-22', 3, 0)
ON DUPLICATE KEY UPDATE
taskname = VALUES(taskname),
createdOn = VALUES(createdOn),
urgency = VALUES(urgency),
importance = VALUES(importance);