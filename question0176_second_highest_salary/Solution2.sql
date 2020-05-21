-- 执行用时：223ms，击败13.05%。消耗内存：0B，击败100.00%。
SELECT
    IFNULL((SELECT
                DISTINCT Employee.Salary
            FROM Employee
            ORDER BY
                Salary DESC
            LIMIT 1, 1), NULL)
AS SecondHighestSalary