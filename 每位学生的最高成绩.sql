# Write your MySQL query statement below
select
    e.student_id,
    e.course_id,
    e.grade
from
(
    select
        student_id,
        course_id,
        grade,
        row_number() over(partition by student_id order by grade desc,course_id asc) as ranknum
    from
        enrollments 
) as e
where
    e.ranknum=1
order by
    e.student_id
asc
