package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import java.util.List;

public class BoardModifyHandler extends AbstractMenuHandler {

  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;


  public BoardModifyHandler(BoardDao boardDao, AttachedFileDao attachedFileDao) {
    this.boardDao = boardDao;
    this.attachedFileDao = attachedFileDao;
  }

  @Override
  protected void action(Prompt prompt) {
    try {

      int no = prompt.inputInt("번호? ");

      Board oldBoard = boardDao.findBy(no);
      if (oldBoard == null) {
        prompt.println("게시글 번호가 유효하지 않습니다.");
        return;
      }

      Board board = new Board();
      board.setNo(oldBoard.getNo());
      board.setTitle(prompt.input("제목(%s)? ", oldBoard.getTitle()));
      board.setContent(prompt.input("내용(%s)? ", oldBoard.getContent()));
      board.setWriter(prompt.input("작성자(%s)? ", oldBoard.getWriter()));

      prompt.printf("첨부파일\n");
      List<AttachedFile> files = attachedFileDao.findAllByBoardNo(no);
      for (AttachedFile f : files) {
        prompt.printf("%d. %s\n", f.getNo(), f.getFilePath());
      }

      if (prompt.inputBoolean("파일 변경(true/false) ")) {
        int scenario = prompt.inputInt("1. 추가\n2. 삭제\n번호? ");
        switch (scenario) {
          case 1:
            prompt.println("[추가]");
            while (true) {
              String filepath = prompt.input("파일?(종료는 그냥 엔터) ");
              if (filepath.length() == 0) {
                break;
              }
              AttachedFile file = new AttachedFile().boardNo(oldBoard.getNo()).filePath(filepath);
              attachedFileDao.add(file);
            }
            break;
          case 2:
            prompt.println("[삭제]");
            while (true) {
              int fileNo = prompt.inputInt("파일 번호? ");
              if (fileNo == 0) {
                break;
              }
              attachedFileDao.delete(fileNo);
            }
            break;
        }
      }
      board.setCreatedDate(oldBoard.getCreatedDate());
      board.setFiles(files);

      boardDao.update(board);
      prompt.println("게시글을 변경했습니다.");
    } catch (Exception e) {
      prompt.println("실행 오류!");
      e.printStackTrace();
    }
  }
}
