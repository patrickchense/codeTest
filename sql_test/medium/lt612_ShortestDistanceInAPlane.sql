https://leetcode.com/articles/shortest-distance-in-a-plane/
Table point_2d holds the coordinates (x,y) of some unique points (more than two) in a plane.


Write a query to find the shortest distance between these points rounded to 2 decimals.


| x  | y  |
|----|----|
| -1 | -1 |
| 0  | 0  |
| -1 | -2 |


The shortest distance is 1.00 from point (-1,-1) to (-1,2). So the output should be:


| shortest |
|----------|
| 1.00     |


Note: The longest distance among all the points are less than 10000.


-- 找到所有距离排序，取第一个
select d.ds from (select POW(d1.x - d2.x, 2) + POW(d1.y - d2.y, 2) as ds from distance d1 join distance d2 on d1.x != d2.x or d1.y != d2.y order by ds) d limit 1 offset 0;


-- solution 函数 SQRT是square root , POW
SELECT
    ROUND(SQRT(MIN((POW(p1.x - p2.x, 2) + POW(p1.y - p2.y, 2)))), 2) AS shortest
FROM
    point_2d p1
        JOIN
    point_2d p2 ON p1.x != p2.x OR p1.y != p2.y
;