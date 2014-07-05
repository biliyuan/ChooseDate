create database ChooseDate;

use ChooseDate;

create table users
(
	id_user int(11) not null auto_increment primary key,
	mail varchar(50),
	user_name varchar(20),
	sex varchar(10),
	user_password varchar(20)
	
);

create table party
(
	id_party int(11) not null auto_increment  primary key,
	party_name varchar(20)
);

create table fun
(
	id_user int(11),
	id_party int(11)
);
create table choose
(
    id_party int(11),
    year1 varchar(4),
    month1 varchar(2),
    day1 varchar(2),
    choices int
);
insert into users(mail,user_name,sex,user_password) values("991609654@qq.com","毕里缘","f","199343");
insert into party(party_name) values("同学聚会");