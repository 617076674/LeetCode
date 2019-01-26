SELECT 
    w1.Id 
FROM 
    Weather AS w1, Weather AS w2 
WHERE
    w1.Temperature > w2.Temperature AND TO_DAYS(w1.RecordDate) - TO_DAYS(w2.RecordDate) = 1;