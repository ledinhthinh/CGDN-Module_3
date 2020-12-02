drop database if exists btvn;
create database btvn;
use btvn;
create table categories(
 id Int not null primary key,
 `name` varchar(50),
 `description` varchar(500)
);
insert into categories values(2,"thinh","fsfdsdf"),(3,"thinh","fsfdsdf");
create table suppliers(
id int not null primary key,
`name` varchar(100),
`email` varchar(50),
`phoneNumber` varchar(50),
`address` varchar(100)
 );
 insert into suppliers values(1,"thinh","abc@aaa.com","00000000","quang nam"),(2,"thinh","abc@aaa.com","00000000","quang nam");
 create table customer(
 id varchar(50) not null primary key,
 `firstName` varchar(50),
 `lastName` varchar(50),
 `phoneNumber` varchar(50),
 `address` varchar(500),
 `email` varchar(50),
 `birthday` date
 );
-- insert into customer values(1,"le","thinh","0000000","quang nam","abc@abc.com",);--
create table employees(
id varchar(50) not null primary key,
 `firstName` varchar(50),
 `lastName` varchar(50),
 `phoneNumber` varchar(50),
 `address` varchar(500),
 `email` varchar(50),
 `birthday` date
);
create table products(
id int not null primary key,
`name` varchar(50),
`umageUrl` varchar(1000),
price int ,
discount int,
stock int,
categoryId int,
supplierId int,
`description` varchar(4000)
);
create table orders(
id int not null primary key,
CreatedDate datetime,
ShippedDate datetime,
`status` varchar(50),
`Description` varchar(4000),
ShippingAddress varchar(500),
ShippingCity varchar(50),
PaymentType varchar(20),
CustomerId varchar(50),
EmployeeId varchar(50)
);
create table OrderDetails(
id int not null primary key,
OrderId int,
ProductId int ,
Quantity int );