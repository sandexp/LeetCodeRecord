# Write your MySQL query statement below

select
    distinct c.customer_id
from
    Customer as c
inner join
(
    select
        cc.customer_id,
        count(distinct product_key) as c
    from
        Customer as cc
    group by
        customer_id
    having
        c = (select count(1) as cnt from Product)
) as t2
on
    c.customer_id=t2.customer_id
