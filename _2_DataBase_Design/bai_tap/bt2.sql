drop database if exists bt2_bai2;
create database bt2_bai2;
use bt2_bai2;
create table customers(
customer_number int primary key,
customer_name varchar(50),
phone varchar(10),
address varchar(50)
);
create table product_line(
product_line_id int primary key,
describes varchar(100)
);
create table products(
product_code varchar(50),
product_name varchar(50),
supplier varchar(50),
quantity_of_stock int,
import_price int,
);