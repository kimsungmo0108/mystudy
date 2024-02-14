package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import bitcamp.util.TransactionManager;

public class BoardAddHandler extends AbstractMenuHandler {

  private TransactionManager txManager;
  private BoardDao boardDao;

  public BoardAddHandler(TransactionManager txManager, BoardDao boardDao) {
    this.boardDao = boardDao;
    this.txManager = txManager;
  }

  @Override
  protected void action(Prompt prompt) {
    try {
      Board board = new Board();
      board.setTitle(prompt.input("제목? "));
      board.setContent(prompt.input("내용? "));
      board.setWriter(prompt.input("작성자? "));

      txManager.startTransaction();

      boardDao.add(board);
      boardDao.add(board);
      boardDao.add(board);

      txManager.commit();
    } catch (Exception e) {
      try {
        txManager.rollback();
      } catch (Exception e2) {
        prompt.println("게시글 입력 중 오류 발생!");
      }
    }
  }
}
