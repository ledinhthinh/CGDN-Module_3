drop database if exists demo;
create database demo;
use demo;
create table Products(
Id int auto_increment primary key,
productCode varchar(50),
productName varchar(50),
productPrice varchar(50),
productAmount varchar(50),
productDescription varchar(50),
productStatus varchar(50)
);