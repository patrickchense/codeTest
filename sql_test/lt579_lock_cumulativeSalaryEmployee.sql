select s.id, s.month, sum(s.salary) from Salary s
left join (select id, max(month) as mm from Salary group by id) s1 on s.id = s1.id where s.month < s1.mm order by id asc, month desc;

solution:
select e1.Id, max(e2.Month) as Month, sum(e2.Salary) as Salary
from Employee e1 join Employee e2 on (e1.Id = e2.ID and e2.Month between (e1.Month-3) and (e1.Month-1))
group by e1.Id, e1.Month
order by e1.ID, Month desc

https://leetcode.com/articles/find-cumulative-salary-of-an-employee/
SELECT
    E1.id,
    E1.month,
    (IFNULL(E1.salary, 0) + IFNULL(E2.salary, 0) + IFNULL(E3.salary, 0)) AS Salary
FROM
    (SELECT
        id, MAX(month) AS month
    FROM
        Employee
    GROUP BY id
    HAVING COUNT(*) > 1) AS maxmonth
        LEFT JOIN
    Employee E1 ON (maxmonth.id = E1.id
        AND maxmonth.month > E1.month)
        LEFT JOIN
    Employee E2 ON (E2.id = E1.id
        AND E2.month = E1.month - 1)
        LEFT JOIN
    Employee E3 ON (E3.id = E1.id
        AND E3.month = E1.month - 2)
ORDER BY id ASC , month DESC
;

太复杂了把。。。。首先理解题意是3个月连续，所以用了3次表连接，对于不存在的用了IFNULL， 然后统计最大月用了having