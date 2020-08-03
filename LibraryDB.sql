--0. tao database
create database LibraryDB
go

--1. open database
use LibraryDB
go

--2.tao bang user
create table Book
(
	BookId int identity(1,1) primary key,
	Title varchar(40),
	Author varchar(40),
	Edition int
)
