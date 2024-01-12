package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;

public class AssignmentModifyHandler extends AbstractMenuHandler {

  private AssignmentDao assignmentDao;


  public AssignmentModifyHandler(AssignmentDao assignmentDao, Prompt prompt) {
    super(prompt);
    this.assignmentDao = assignmentDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("번호? ");
      Assignment old = this.assignmentDao.findBy(no);

      Assignment assignment = new Assignment();
      assignment.setNo(old.getNo());
      assignment.setTitle(this.prompt.input("과제명(%s)? ", old.getTitle()));
      assignment.setContent(this.prompt.input("내용(%s)? ", old.getContent()));
      assignment.setDeadline(this.prompt.inputDate("제출 마감일(%s)? ", old.getDeadline()));

      this.assignmentDao.update(assignment);
    } catch (NumberFormatException e) {
      System.out.println("숫자를 입력하세요!");
    } catch (IndexOutOfBoundsException e) {
      System.out.println("과제 번호가 유효하지 않습니다.");
    } catch (IllegalArgumentException e) {
      System.out.println("과제 변경 중 오류 발생!");
      System.out.println("다시 시도하시기 바랍니다.");
    } catch (Exception e) {
      System.out.println("실행 오류!");
    }
  }
}
