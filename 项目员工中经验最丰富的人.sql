# Write your MySQL query statement below

select
    pp.project_id,
    ee.employee_id
from
    employee as ee
inner join
    project as pp
on
    ee.employee_id=pp.employee_id
inner join
(
    select
        project_id,
        max(e.experience_years) as experience_years
    from
        employee as e
    inner join
        project as p
    on
        e.employee_id=p.employee_id
    group by
        p.project_id
) as t
on
    pp.project_id=t.project_id
where
    ee.experience_years=t.experience_years