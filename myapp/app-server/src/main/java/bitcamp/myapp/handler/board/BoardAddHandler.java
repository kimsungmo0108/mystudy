package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import bitcamp.util.TransactionManager;
import java.util.ArrayList;

public class BoardAddHandler extends AbstractMenuHandler {

  private TransactionManager txManager;
  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;

  public BoardAddHandler(TransactionManager txManager, BoardDao boardDao,
      AttachedFileDao attachedFileDao) {
    this.boardDao = boardDao;
    this.txManager = txManager;
    this.attachedFileDao = attachedFileDao;
  }

  @Override
  protected void action(Prompt prompt) {
    Board board = new Board();
    board.setTitle(prompt.input("제목? "));
    board.setContent(prompt.input("내용? "));
    board.setWriter(prompt.input("작성자? "));

    ArrayList<AttachedFile> files = new ArrayList<>();
    while (true) {
      String filepath = prompt.input("파일?(종료는 그냥 엔터)");
      if (filepath.length() == 0) {
        break;
      }
      files.add(new AttachedFile().filePath(filepath));
    }

    try {
      txManager.startTransaction();

      boardDao.add(board);

      if (files.size() > 0) {
        // 첨부파일 객체에 게시글 번호 저장
        for (AttachedFile file : files) {
          file.setBoardNo(board.getNo());
        }
        attachedFileDao.addAll(files);
      }

      txManager.commit();
    } catch (Exception e) {
      prompt.println("게시글 입력 중 오류 발생!");
      try {
        txManager.rollback();
      } catch (Exception e2) {
      }
    }
  }
}
