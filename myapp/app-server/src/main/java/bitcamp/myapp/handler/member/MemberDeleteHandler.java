package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;
import java.sql.Connection;

public class MemberDeleteHandler extends AbstractMenuHandler {

  private MemberDao memberDao;
  private DBConnectionPool connectionPool;

  public MemberDeleteHandler(DBConnectionPool connectionPool, MemberDao memberDao) {
    this.memberDao = memberDao;
    this.connectionPool = connectionPool;
  }

  @Override
  protected void action(Prompt prompt) {
    Connection con = null;
    try {
      con = connectionPool.getConnection();
      int no = prompt.inputInt("번호? ");
      if (memberDao.delete(no) == -1) {
        prompt.printf("회원 번호가 유효하지 않습니다!");
      } else {
        prompt.println("회원을 삭제했습니다.");
      }
    } catch (Exception e) {
      prompt.println("삭제 오류!");
    } finally {
      connectionPool.returnConnection(con);
    }
  }
}
