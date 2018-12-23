select cust_name,cust_state,
	   (select count(*) from orders where orders.cust_id = customers.cust_id) as orders
from customers;


select customers.cust_name,customers.cust_id,
       count(orders.order_num) as num_ord
 from customers inner join orders
on customers.cust_id = orders.cust_id
group by customers.cust_id;



select customers.cust_name,customers.cust_id,
       count(orders.order_num) as num_ord
 from customers left outer join orders
on customers.cust_id = orders.cust_id
group by customers.cust_id;

desc productnotes;

#全文检索的案例
select note_text from productnotes where Match(note_text) Against('rabbit');

#全文检索案例二

#select note_text,Match(note_text) Against('rabbit') as rankfrom productnotes;

# 全文检索三
# 第一步：使用全文检索
select note_text from productnotes where Match(note_text) Against('anvils');
# 第二步：使用拓展
select note_text from productnotes where Mtch(note_text) Against('anvils' with Query expansion);

# 布尔文本搜索
select note_text from productnotes where match(note_text) against('heavy' IN BOOLEAN MODE);

# 包含heavy，但是不包含rope开头的词
select note_text from productnotes where match(note_text) against('heavy -rope*' in boolean mode);

# 同时包含 rabbit 和 bait的行
select note_text from productnotes where match(note_text) against('+rabbit +bait' in boolean mode);

# 包含 note_text或者包含 bait
select note_text from productnotes where match(note_text) against('rabbit bait' in boolean mode);

# 包含 "rabbit bait" 短语
select note_text from productnotes where match(note_text) against('"rabbit bait"' in boolean mode);

# rabbit 增加等级，carrot降低等级
select note_text from productnotes where match(note_text) against('rabbit carrot' in boolean mode);

# 搜素 safe 和combination 同时存在，并combination降低等级a
select note_text from productnotes where match(note_text) against('+safe +(<combination)' in boolean mode);

select last_insert_id();


select * from customers;

desc orders;

desc orderitems;
desc customers;

show tables;

select order_num from orders;