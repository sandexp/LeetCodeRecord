# Write your MySQL query statement below

select
    if(a.accept_rate is null,0.00,a.accept_rate) as accept_rate
from
(

    select
        round(
            (
                select
                    count(1)
                from
                (
                    select
                        distinct requester_id,accepter_id
                    from
                        RequestAccepted
                ) as t2
            )/
            (
                (
                    select
                        count(1)
                    from
                    (
                        select
                            distinct sender_id,send_to_id
                        from
                            FriendRequest
                    ) as t1
                )
            ),2
        )
    as accept_rate 
) as a