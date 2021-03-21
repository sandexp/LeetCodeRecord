# Write your MySQL query statement below

-- 窗口函数查找每条记录在当前产品下的排名(dense rank) 找到top 1,使用上述数据集进行排序

select
    t.product_name,
    t.product_id,
    t.order_id,
    t.order_date
from
(
    select
        p.product_name,
        p.product_id,
        o.order_id,
        o.order_date,
        dense_rank() over(partition by p.product_id order by order_date desc) as ranknum
    from
        products as p
    inner join
        orders as o
    on
        p.product_id=o.product_id
    inner join
        customers as c
    on
        c.customer_id=o.customer_id
) as t
where
    t.ranknum=1
order by
    t.product_name asc,
    t.product_id asc,
    t.order_id asc 