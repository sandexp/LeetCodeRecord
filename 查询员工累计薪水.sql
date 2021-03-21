# Write your MySQL query statement below

-- 窗口函数月份排名 查找2-4的记录,按照员工聚合,求总薪水,排序
select
    t.id,
    t.`month`,
    sum(t.salary) over(partition by t.id rows 2 PRECEDING) as salary
from
(
    select
        distinct e2.id,
        e2.`month`,
        e2.salary
    from
    -- 目标表
        employee as e1 
    inner join
        employee as e2
    on
        e1.id=e2.id and (e1.`month`>e2.`month` and e1.`month`<=e2.`month`+4)
) as t
order by
    id asc,
    `month` desc
