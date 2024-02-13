package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;
import java.sql.Connection;

public class AssignmentAddHandler extends AbstractMenuHandler {

  private AssignmentDao assignmentDao;

  private DBConnectionPool connectionPool;

  public AssignmentAddHandler(DBConnectionPool connectionPool, AssignmentDao assignmentDao) {
    this.assignmentDao = assignmentDao;
    this.connectionPool = connectionPool;
  }

  @Override
  protected void action(Prompt prompt) {
    Connection con = null;
    try {
      Assignment assignment = new Assignment();
      assignment.setTitle(prompt.input("과제명? "));
      assignment.setContent(prompt.input("내용? "));
      assignment.setDeadline(prompt.inputDate("제출 마감일?(예: 2023-12-25) "));

      con = connectionPool.getConnection();
      con.setAutoCommit(false);
      assignmentDao.add(assignment);
      con.rollback();


    } catch (Exception e) {
      prompt.println("과제 입력 중 오류 발생!");
      prompt.println("다시 시도하시기 바랍니다.");
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
