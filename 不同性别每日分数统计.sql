# Write your MySQL query statement below
select
    s.gender,
    s.`day`,
    sum(t.part) as total
from
    Scores as s
inner join
(
    select
        gender,
        `day`,
        sum(score_points) as part
    from
        Scores
    group by
        gender,`day`
    order by
        gender,`day`
) as t
on
    s.gender=t.gender and s.`day`>=t.`day`
group by
    s.gender,s.`day`
order by
    s.gender,s.`day`