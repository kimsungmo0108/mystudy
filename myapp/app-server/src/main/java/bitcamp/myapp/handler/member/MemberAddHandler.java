package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;
import java.sql.Connection;
import java.util.Date;

public class MemberAddHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  private DBConnectionPool connectionPool;

  public MemberAddHandler(DBConnectionPool connectionPool, MemberDao memberDao) {
    this.memberDao = memberDao;
    this.connectionPool = connectionPool;
  }

  @Override
  protected void action(Prompt prompt) {
    Member member = new Member();
    member.setEmail(prompt.input("이메일? "));
    member.setName(prompt.input("이름? "));
    member.setPassword(prompt.input("암호? "));
    member.setCreatedDate(new Date());
    Connection con = null;
    try {
      con = connectionPool.getConnection();
      con.setAutoCommit(false);
      memberDao.add(member);

    } catch (Exception e) {
      prompt.println("회원 입력 중 오류 발생!");
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
