-- DDL : Data Definition Language

-- 로그인
mysql -u study -p
Bitcamp!@#123

-- 데이터베이스 보기
show databases;

-- 테이블 고기
show tables;

-- 사용할 데이터베이스 지정
use studydb;

-- 테이블 생성
create table boards(
  board_no int primary key auto_increment,
  title varchar(255) not null,
  content text not null,
  writer varchar(30) not null,
  created_date datetime null default now()
);

-- 테이블 제거
drop table boards;

insert into boards(board_no, title, content, writer)
  values(1, '제목1', '내용1', '홍길동');
insert into boards(board_no, title, content, writer)
  values(2, '제목2', '내용2', '임꺽정');
insert into boards(board_no, title, content, writer)
  values(3, '제목3', '내용3', '유관순');
insert into boards(board_no, title, content, writer)
  values(4, '제목4', '내용4', '안중근');
insert into boards(board_no, title, content, writer)
  values(5, '제목5', '내용5', '윤봉길');

select * from boards;

select *
from boards
where board_no = 3;

update boards set
  title='okok',
  content='nono',
  writer='hoho'
where board_no = 3;

delete from boards where board_no=3;

alter table boards add column category int  not null;

update boards set category=1;

