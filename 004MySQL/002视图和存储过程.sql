create view productcustomers as
select cust_name,cust_contact,prod_id from customers,orders,orderitems
where customers.cust_id = orders.cust_id
	and orderitems.order_num = orders.order_num;
    
show create view productcustomers;


select concat(rtrim(vend_name),'(',rtrim(vend_country),')') from vendors order by vend_name;


create view vendorlocations as
select concat(rtrim(vend_name),'(',rtrim(vend_country),')') from vendors order by vend_name;


show create view vendorlocations;

select * from vendorlocations;

# 过滤cust_email不为空的数据
create view customeremaillist as
select cust_id,cust_name, cust_email from customers
where cust_email is not null;


show create view customeremaillist;

select * from customeremaillist where cust_id='10001';


# 创建一个存储过程
# 调用一个存储过程
call productpricing();


# 删除存储过程
drop procedure productpricing;

call productpricing(@pricelow,
					@pricehigh,
                    @priceaverage);

select @pricelow;
select @pricelow,@pricehigh,@priceaverage;


call ordertotal(20005,@total);

select @total;

call ordertotal(20009,@total);

select @total;

call ordertotalTest(20005,0,@total);
select @total;

call ordertotalTest(20005,1,@total);
select @total;
