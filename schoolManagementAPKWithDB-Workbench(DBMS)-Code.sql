create database schoolManagementAPK_1;
use schoolManagementAPK_1;
create table admindetails(
 id int primary key auto_increment,
 email varchar(20) unique not null,
 password varchar(20) not null check (length(password)>=6),
 name varchar(20) not null,
 city varchar(20));
 
 desc admindetails;
 
 insert into admindetails (email,password,name,city,mobile) values ('a@g','123456','Harsh','Surat','1234567890');
 
 alter table admindetails 
 add column mobile varchar(20) not null check (length(mobile)>=6);
 use schoolmanagementAPK_1;
 drop table admindetails;
 create table admindetails(
 adminId int primary key auto_increment,
 email varchar(20) unique not null,
 password varchar(20) not null check( length(password) >= 6),
 department varchar(20)  not null,
 hourlyRate int not null,
 hoursWorked int not null
 );
 insert into admindetails(email,password,department,hourlyRate,hoursWorked) values("a@gmail.com","123456","IT","200","8");
 use schoolmanagementAPK_1;
 desc student_details;
 use schoolmanagementAPK_1;
 create table subbjects(name varchar(20),fees int);
drop table subbjects;
 create table subjects(name varchar(20),fees int);
 insert into subjects(name,fees) values("Maths",12000),("Science",15000),("Social Science",13000),("English",10000),("Hindi",8000);
 use schoolmanagementAPK_1;
 drop table student_details;
 create table if not exists student_details(student_id int auto_increment primary key not null ,email  varchar(20) unique not null,password varchar(20) not null,age int not null,address varchar(30) not null,gradeLevel varchar(20) not null,subjects varchar(20) not null,feespaid int not null);
 drop table student_details;
 create table student_details(student_id int auto_increment primary key not null ,email varchar(20) unique not null,password varchar(20) not null,age int not null,address varchar(30) not null,gradeLevel varchar(20) not null,subjects varchar(20) not null,feespaid int not null);
 SET SQL_SAFE_UPDATES = 0;
 delete from tutor_details where specialization="IT";
 delete from tutor_details where specialization="python";
 create table EnrollCourse(student_id int auto_increment primary key not null ,subjects_id int not null);
 use schoolmanagementAPK_1;
 drop table EnrollCourse;
  create table EnrollCourse(SrNo int auto_increment  primary key not null,student_id int not null ,subjects_name varchar(20) not null);
