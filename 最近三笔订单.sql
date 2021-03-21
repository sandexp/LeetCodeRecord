# Write your MySQL query statement below

-- 用户分组 降序排列日期 取得top 3 数据集排序
select
    t.customer_name,
    t.customer_id,
    t.order_id,
    t.order_date
from
(
    select
        c.`name` as customer_name,
        o.customer_id,
        o.order_id,
        o.order_date,
        row_number() over(partition by o.customer_id order by o.order_date desc) as ranknum
    from
        orders as o
    inner join
        customers as c
    on
        o.customer_id=c.customer_id
) as t
where
    t.ranknum<=3
order by
    t.customer_name asc,
    t.customer_id asc,
    t.order_date desc