# Write your MySQL query statement below
select
    t.business_id
from
(

    select
        e1.business_id,
        count(1) as cnt
    from
        `events` as e1
    inner join
    (
        select
            event_type,
            avg(occurences) as avg_ocur 
        from
            `events`
        group by
            event_type
    ) as e2
    on
        e1.event_type=e2.event_type
    inner join
    (
        select
            business_id,
            count(distinct event_type) as num
        from
            `events`
        group by
            business_id
    ) as e3
    on
        e1.business_id=e3.business_id
    where
        e3.num>=2
    and
        e1.occurences>e2.avg_ocur
    group by
        e1.business_id
) as t
where
    t.cnt>=2