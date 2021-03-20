# Write your MySQL query statement below

select
    tt.`month`,
    tt.country,
    sum(1) as trans_count,
    sum(if(tt.state='approved',1,0)) as approved_count,
    sum(tt.amount) as trans_total_amount,
    sum(if(tt.state='approved',tt.amount,0)) as approved_total_amount 
from
(
    select
        t.*,
        t1.`month`
    from
        transactions as t
    inner join
    (
        select
            id,
            DATE_FORMAT(trans_date,"%Y-%m") as `month`
        from
            transactions
    ) as t1
    on
        t.id=t1.id
) as tt
group by
    tt.`month`,tt.country