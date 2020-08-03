create database j2
go

use j2
go

create table tbEmployee (
	id varchar(5) primary key, 
	fullname varchar(30), 
	gender bit default 1 not null, 
	salary int check (salary >100)
); 
go

insert tbEmployee values
('E0001','Nguyen Song Toan',1,2000),
('E0002','Duong Vu',1,2300),
('E0003','Dang Hoang Thuy',0,3400),
('E0004','Nguyen Le Sang',1,4000),
('E0005','Trinh Y Nhu',0,2700)
go