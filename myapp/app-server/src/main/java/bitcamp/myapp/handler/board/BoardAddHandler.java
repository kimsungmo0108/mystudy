package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;
import java.sql.Connection;

public class BoardAddHandler extends AbstractMenuHandler {

  DBConnectionPool connectionPool;
  private BoardDao boardDao;

  public BoardAddHandler(DBConnectionPool connectionPool, BoardDao boardDao) {
    this.boardDao = boardDao;
    this.connectionPool = connectionPool;
  }

  @Override
  protected void action(Prompt prompt) {
    Board board = new Board();
    board.setTitle(prompt.input("제목? "));
    board.setContent(prompt.input("내용? "));
    board.setWriter(prompt.input("작성자? "));

    Connection con = null;
    try {
      con = connectionPool.getConnection();
      con.setAutoCommit(false);

      boardDao.add(board);
      boardDao.add(board);

      Thread.sleep(10000);

      boardDao.add(board);

      con.commit();
    } catch (Exception e) {
      try {
        con.rollback();
      } catch (Exception e2) {
      }
    } finally {
      try {
        // Connection은 다른 작업할 때 다시 사용해야 하기 때문에 원래 상태로 되돌린다.
        con.setAutoCommit(true);
      } catch (Exception e2) {
      }
      connectionPool.returnConnection(con);
    }
  }
}
