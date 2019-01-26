SELECT 
    w1.Id 
FROM 
    Weather AS w1, Weather AS w2 
WHERE
    w1.Temperature > w2.Temperature AND DATEDIFF(w1.RecordDate, w2.RecordDate) = 1;