# Write your MySQL query statement below
select
    a.id,
    a.cnt as num
from
(
    select
        tt.id,
        tt.cnt,
        dense_rank() over(order by cnt desc) as ranknum
    from
    (
        select
            t.id as id,
            sum(cnt) as cnt
        from
        (
            select
                t1.id as id,
                count(1) as cnt
            from
                request_accepted as r1
            inner join
            (
                select
                    distinct requester_id as id
                from
                    request_accepted
            ) as t1
            on
                r1.requester_id=t1.id
            group by
                r1.requester_id

            union all

            select
                t2.id as id,
                count(1) as cnt
            from
                request_accepted as r2
            inner join
            (
                select
                    distinct accepter_id as id
                from
                    request_accepted
            ) as t2
            on
                r2.accepter_id=t2.id
            group by
                r2.accepter_id
        ) as t
        group by
            t.id
    ) as tt
) as a
where
    a.ranknum=1
