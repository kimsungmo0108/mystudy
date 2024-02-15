select board_no, title, writer, created_date from boards where category=? order by board_no desc

select
  b.board_no,
  b.title,
  b.writer,
  b.created_date,
  count(file_no) file_count
from
  boards b leftr outer join board_files bf on b.board_no = bf.board_no
where
  b.category=1
group by
  board_no
order
  by board_no desc;

select
  b.board_no,
  b.title,
  b.content,
  b.writer,
  b.created_date,
  bf.file_path,
  count(file_path) file_count
from
  boards b left outer join board_files bf on b.board_no=bf.board_no
where
  b.category=1 and bf.board_no=1;

  select * from boards where board_no=1;