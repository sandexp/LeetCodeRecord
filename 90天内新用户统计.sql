# Write your MySQL query statement below
select
    t2.login_date as `login_date`,
    count(distinct t2.user_id) as `user_count`
from
    traffic as t1
inner join
(
    select
        user_id,
        min(activity_date) as login_date
    from
        traffic
    where
        activity='login'
    group by
        user_id,activity
) as t2
on
    t1.activity_date=t2.login_date
where
    datediff('2019-06-30',t2.login_date)<=90
group by
    t2.login_date