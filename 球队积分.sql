# Write your MySQL query statement below

select
    t1.team_id,
    t1.team_name,
    t1.num_points+t2.num_points as num_points
from
(
    select
        team_id,
        team_name,
            sum(if(m1.host_goals>m1.guest_goals,3,if(m1.host_goals=m1.guest_goals,1,0)))
            -- sum(if(m2.guest_goals>m2.host_goals,3,if(m2.host_goals>m2.guest_goals,0,1)))
        as num_points
    from
        Teams as t
    left join
        Matches as m1
    on
        t.team_id=m1.host_team
    group by
        t.team_id
) as t1
inner join
(
    select
        team_id,
        team_name,
            sum(if(m2.guest_goals>m2.host_goals,3,if(m2.host_goals=m2.guest_goals,1,0)))
        as num_points
    from
        Teams as t
    left join
        Matches as m2
    on
        t.team_id=m2.guest_team
    group by
        t.team_id
) as t2
on
    t1.team_id=t2.team_id
order by
    num_points desc,
    team_id asc


