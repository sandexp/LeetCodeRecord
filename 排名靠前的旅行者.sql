# Write your MySQL query statement below

select
    `name`,
    sum(if(r.`distance` is null,0,r.`distance`)) as `travelled_distance`
from
    rides as r
right join
    users as u
on
    r.user_id=u.id
group by
    r.user_id
order by
    travelled_distance desc,`name` asc