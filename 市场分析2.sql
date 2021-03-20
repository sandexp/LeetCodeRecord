# Write your MySQL query statement below
select
    uu.user_id as seller_id,
    if(tt.`2nd_item_fav_brand` is null ,'no',tt.`2nd_item_fav_brand`) as `2nd_item_fav_brand`
from
    users as uu
left join
(
    select
        t.seller_id,
        if(t.favorite_brand=i.item_brand,'yes','no') as `2nd_item_fav_brand`
    from
    (
        select
            u.user_id as `seller_id`,
            o.item_id as item_id,
            u.favorite_brand as favorite_brand,
            row_number() over(partition by u.user_id order by o.order_date asc) as ranknum
        from
            users as u
        left join
            orders as o
        on
            u.user_id=o.seller_id
    ) as t
    inner join
        items as i
    on
        t.item_id=i.item_id
    where
        t.ranknum=2
) as tt
on
    uu.user_id=tt.seller_id
order by
    uu.user_id
asc