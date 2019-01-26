SELECT 
    Department.Name AS Department, 
    Employee.Name AS Employee, 
    Employee.Salary AS Salary 
FROM 
    Employee JOIN Department ON Employee.DepartmentId = Department.Id 
WHERE 
    (Employee.DepartmentId, Employee.Salary) 
    IN 
    (SELECT DepartmentId, MAX(Salary) FROM Employee GROUP BY DepartmentId);