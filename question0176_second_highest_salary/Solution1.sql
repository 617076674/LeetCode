-- 执行用时：178ms，击败27.61%。消耗内存：0B，击败100.00%。
SELECT
    (SELECT
        DISTINCT Employee.Salary
    FROM
        Employee
    ORDER BY
        Salary DESC
    LIMIT 1, 1)
AS  SecondHighestSalary