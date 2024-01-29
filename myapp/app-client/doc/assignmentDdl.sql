create table assignments(
  assignment_no int primary key auto_increment,
  title varchar(255) not null,
  content text not null,
  deadline date not null
);

select * from assignment;

insert into assignments(title, content, deadline) values('제목1','내용1','2024-01-01');

drop table assignments;

select *
from assignments
where assignment_no = 3;

update assignments set
  title='okok',
  content='nono',
  deadline='2023-01-01'
where assignment_no = 3;

delete from assignments where assignment_no=3;