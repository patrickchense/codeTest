select name, sum (case when deposit > 0 then deposit else 0 END)  as deposit, sum( case when deposit <= 0 then -1* depoist else 0 END) as withdraw
  FROM transfer group by name


-- 不用case when 怎么办?
 select t.name, w.withdraw, d.deposit from transfer t
  left join (select name, abs(sum(deposit)) as withdraw from transfer where deposit <= 0 group by name) w
  on w.name = t.name left join   (select name, sum(deposit) as deposit from transfer where deposit > 0 group by name) d
  on d.name = t.name


