create table members(
  member_no int primary key auto_increment,
  email varchar(255) not null,
  name varchar(255) not null,
  password varchar(100) not null,
  created_date datetime null default now()
);

select * from members;

select * from members where member_no=2;

drop table members;

delete from members where member_no=2;

update members set email='a@a', name='홍길동', password='abc' where member_no='2';

insert into members(email, name, password) values('a@a', '이순신', sha2('aaa', 256));

update members set email='aa@aa', name='홍길동', password=sha2('abcde',256) where member_no=1;