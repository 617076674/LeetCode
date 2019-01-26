SELECT 
    t1.Name AS Department, t2.Name AS Employee, t2.Salary AS Salary 
FROM
    Employee AS t2 JOIN Department AS t1 ON t2.DepartmentId = t1.Id
WHERE
    (SELECT 
        COUNT(DISTINCT Salary) 
     FROM 
        Employee AS t3 
     WHERE 
        t3.Salary > t2.Salary AND t3.DepartmentId = t2.DepartmentId) < 3;