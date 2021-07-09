# Project Title : Grocery Management System

### Module - 1 (Grocery's Stock)

#### Grocery List
'''sql
create table grocery(item_id int primary key, name varchar2(45) not null , category varchar2(23) , price number(8,2) not null , quantity int);
'''
#### Add Groceries
'''sql
insert into grocery(item_id,name,category,price,quantity)values (101,'bengal gram(250g)','cereals and pulses',80,30);
insert into grocery(item_id,name,category,price,quantity)values (102,'green gram(250g)','cereals and pulses',70,30);
insert into grocery(item_id,name,category,price,quantity)values (103,'corn flour(250g)','flours',40,30);
insert into grocery(item_id,name,category,price,quantity)values (104,'onion (1kg)','vegetables',110,40);
insert into grocery(item_id,name,category,price,quantity)values (105,'apple (1kg)','fruits',80,10);
insert into grocery(item_id,name,category,price,quantity)values (106,'cloves (10g)','spices',30,40);
insert into grocery(item_id,name,category,price,quantity)values (107,'almond','dry fruits',30,60);
insert into grocery(item_id,name,category,price,quantity)values (108,'semolina (250g)','miscellaneous',50,30);
...
#### Display Grocery List
'''sql
select * from grocery;
'''
#### To Remove Grocery:
'''sql
delete grocery where id=104;
'''
#### To Update Grocery Item:
'''sql
update grocery set price = 50 where id= 105;
update grocery set  quantity = quantity *5 where id = 106;
'''

### Module - 2 (Customer Cart)

#### Customer's Items Details
'''sql
create table customer_items(customer_id int not null, customer_name varchar2(45) not null, item_id int , name varchar2(45) not null , category varchar2(23) , 
quantity number , price number(8,2) not null ,purchase_time timestamp default systimestamp);
'''
#### Add Customer's Items
'''sql
insert into customer_items(customer_id,customer_name,item_id,name,category,quantity,price) values (300,'rajesh',105,'apple (1kg)','fruits',1.5,80,14.4,134.4);
insert into customer_items(customer_id,customer_name,item_id,name,category,quantity,price) values (300,'rajesh',104,'onion (1kg)','vegetables',2,110);
insert into customer_items(customer_id,customer_name,item_id,name,category,quantity,price) values (301,'raj',106,'cloves(10kg)','spices',1,30);
insert into customer_items(customer_id,customer_name,item_id,name,category,quantity,price) values (302,'ram',108,'semolina(250g)','miscellaneous',1.5,50);
insert into customer_items(customer_id,customer_name,item_id,name,category,quantity,price) values (301,'raj',107,'almond','dry fruits',3,30);
insert into customer_items(customer_id,customer_name,item_id,name,category,quantity,price) values (303,'ramesh',110,'corn flour(250g)','flours',2,40);
'''
#### Display Customer's Items
'''sql
select customer_id,customer_name,item_id,name,category,quantity,price,(price*quantity)*(18/100) gst_price,
(((price*quantity)*(18/100))+price*quantity) net_price,purchase_time from customer_items;
'''

#### Delete customer_items:
'''sql
delete customer_name where id = 300;
'''

#### Update customer_items:
'''sql
update customer_items set gst_price = (price*quantity)*18/100;
update customer_items set net_price = (price*quantity)+gst_price;
'''

#### Display Purchase History For Each Customer
'''sql
select customer_id,sum(price*quantity) gross_total,sum((price*quantity)*(18/100)) total_gst,sum((((price*quantity)*(18/100))+price*quantity)) grant_total
from customer_items where customer_id=301 group by customer_id;
'''
### Module - 3 (Customer Login)

#### Login For Customers
'''sql
create table cus_login (customer_id int, customer_name varchar2(45),contact_num number,password varchar2(20));
'''

#### Adding Customer's Details
'''sql
insert into cus_login values(301,'raj',1234567890,'grocer123');
insert into cus_login values(300,'rajesh',1234567890,'sanjay123');
insert into cus_login values(302,'ram',1234567890,'mani123');
insert into cus_login values(303,'ramesh',1234567890,'karthi123');
insert into cus_login values(304,'raju',1234567890,'vigne123');
'''
#### Display Customer's Details
'''sql
select * form cus_login;
'''
#### Remove a Customer
'''sql
delete cus_login where customer_id=300;
'''
#### Update Password From Customer
'''sql
update cus_login set password='Welcome#6' where contact_num=1234567890;
'''
