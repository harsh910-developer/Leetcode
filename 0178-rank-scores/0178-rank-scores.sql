# Write your MySQL query statement below
Select s1.score, count(s2.score) As 'rank'
from scores s1,
(Select Distinct score from scores) s2
where s1.score <= s2.score
group by s1.id
order by s1.score desc