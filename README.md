# Project Title : Grocery Management System

### Module - 1 (Stock Employee Details) 

#### Stock Employee Details
```sql
create table stock_employee(
emp_id int not null,
emp_name varchar2(45),
emp_address varchar2(45) not null,
emp_mobile_no number(10) not null,
emp_password varchar2(20) not null,
);
```

#### Adding Employee's Details
```sql
insert into stock_employee values(100,'rajesh','tiruttani',9874563210,'Rajesh1234#');
insert into stock_employee values(101,'lavanya','chennai',9274563210,'Lavanya123@');
insert into stock_employee values(102,'nelliyarasan','chennai',8874563210,'Nelliyarasan12$');
insert into stock_employee values(103,'elumalai','chennai',6874563210,'Elumalai234%');
```

#### Display Stock Employee Details
```sql
select * from stock_employee;
```

#### Update Password
```sql
update stock_employee set password='rajesh@.12' where admin_mobile_no = 9874563210 ;
```


### Module - 2 (Grocery's Stock)

#### Grocery_Product_List
```sql
create table grocery (
product_id int primary key,
product_name varchar2(45) not null, 
category varchar2(23) not null, 
price number(8,2) not null, 
available_quantity int
);
```

#### Add Groceries
```sql
insert into grocery(product_id,product_name,category,price,available_quantity)values (201,'bengal gram(250g)','cereals and pulses',80,30);
insert into grocery(product_id,product_name,category,price,available_quantity)values (202,'green gram(250g)','cereals and pulses',70,30);
insert into grocery(product_id,product_name,category,price,available_quantity)values (203,'corn flour(250g)','flours',40,30);
insert into grocery(product_id,product_name,category,price,available_quantity)values (204,'onion (1kg)','vegetables',110,40);
insert into grocery(product_id,product_name,category,price,available_quantity)values (205,'apple (1kg)','fruits',80,10);
insert into grocery(product_id,product_name,category,price,available_quantity)values (206,'cloves (10g)','spices',30,40);
insert into grocery(product_id,product_name,category,price,available_quantity)values (207,'almond','dry fruits',30,60);
insert into grocery(product_id,product_name,category,price,available_quantity)values (208,'semolina (250g)','miscellaneous',50,30);
```

#### Display Grocery List
```sql
select * from grocery;
```

#### To Remove Grocery:
```sql
delete from grocery where product_id=104;
```

#### To Update Grocery Item:
```sql
update grocery set price = 50 where product_id= 105;
update grocery set  available_quantity = 55 where product_id = 106;
```


### Module - 3 (Customer Details)

#### Login For Customers
```sql
create table grocery_customers (
cus_id int primary key, 
cus_name varchar2(45) not null,
cus_address varchar2(45) not null,
cus_mobile_no number not null,
cus_password varchar2(20) not null,
cus_status varchar2(22) default 'ACTIVE',
check(status in ('ACTIVE','INACTIVE'))
);
```

#### Adding Customer's Details
```sql
insert into grocery_customers(cus_id,cus_name,cus_address,cus_mobile_no,cus_password) values(301,'raj',1234567890,'Grocer123@');
insert into grocery_customers(cus_id,cus_name,cus_address,cus_mobile_no,cus_password) values(300,'rajesh',8465528191,'sanjay123');
insert into grocery_customers(cus_id,cus_name,cus_address,cus_mobile_no,cus_password) values(302,'ram',1234567890,'mani123');
insert into grocery_customers(cus_id,cus_name,cus_address,cus_mobile_no,cus_password) values(303,'ramesh',1234567890,'karthi123');
insert into grocery_customers(cus_id,cus_name,cus_address,cus_mobile_no,cus_password) values(304,'raju',1234567890,'vigne123');
```

#### Display Customer's Details
```sql
select * form grocery_customers;
```

#### Inactive The Customer
```sql
update grocery_customers set cus_status='INACTIVE' where cus_id=301;
```

#### Update Password From Customer
```sql
update grocery_customers set cus_password='Welcome#6' where cus_mobile_no=1234567890;
```


### Module - 4 (Customer Cart)

#### Customer's Items Details
```sql
create table customer_items (
cus_id int primary key ,
product_id int not null,   
price number(8,2) not null ,
quantity number,
gst_price number,
net_price number,
purchase_time timestamp default systimestamp,
constraint cus_fk1 foreign key (cus_id) references grocery_customers(cus_id),
constraint cus_fk2 foreign key (product_id) references grocery(product_id),
constraint cus_ck check (price > 0)
);
```

#### Add Customer's Items
```sql
insert into customer_items(cus_id,product_id,price,quantity,gst_price,net_price) values (300,205,80,1.5,14.4,134.4);
insert into customer_items(cus_id,product_id,price,quantity,gst_price,net_price) values (301,206,30,1,5.4,35.4);
insert into customer_items(cus_id,product_id,price,quantity,gst_price,net_price) values (302,208,50,1.5,13.5,88.5);
insert into customer_items(cus_id,product_id,price,quantity,gst_price,net_price) values (303,207,30,3,16.2,106.2);
```

#### Display Customer's Items
```sql
select cus_id,product_id,name,price,quantity,gst_price,net_price,purchase_time from customer_items;
```

#### Display Purchase History Customers
```sql
select cus_id,sum(price) price,sum(gst_price) total_gst,sum(net_price) grant_total from customer_items group by cus_id order by sum(net_price) desc;
```
