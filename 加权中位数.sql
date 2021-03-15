# Write your MySQL query statement below

-- 一个数如果在正序和逆序中都超过一半,则在中位数范围内
select
    avg(t.`Number`) as median
from
(
    select
        `Number`,
        sum(Frequency) over(order by `Number` asc) as acc,
        sum(Frequency) over(order by `Number` desc) as dsc
    from
        Numbers
) as t,
(select sum(Frequency) as total from Numbers) as m
where
    t.acc>=m.total/2
and
    t.dsc>=m.total/2