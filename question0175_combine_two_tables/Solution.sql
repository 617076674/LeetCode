-- 执行用时：307ms，击败8.54%。消耗内存：0B，击败100.00%。
SELECT
    Person.FirstName, Person.LastName, Address.City, Address.State
FROM
    Person
LEFT JOIN
    Address
ON
    Person.PersonId = Address.PersonId