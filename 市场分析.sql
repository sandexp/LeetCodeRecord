# Write your MySQL query statement below

select
    u.user_id as buyer_id,
    u.join_date as join_date,
    sum(if(o.order_date is null,0,if(date_format(o.order_date,"%Y")='2019',1,0))) as orders_in_2019
from
    users as u
left join
    orders as o
on
    u.user_id=o.buyer_id
group by
    u.user_id
order by
    u.user_id
asc