drop database if exists bt1_bai2;
create database bt1_bai2;
use bt1_bai2;
create table customers(
customer_number int primary key,
full_name varchar(50),
address varchar (50),
email varchar (50),
phone varchar(50)
);
create table accounts(
account_number int primary key,
customer_number int not null,
account_type varchar(50),
date_open date,
balance int,
foreign key(customer_number )
references customers(customer_number)
);
create table transactions(
tran_number int primary key,
account_number int not null,
tran_date date,
amounts int,
descriptions varchar(50),
foreign key(account_number )
references accounts(account_number)
);
