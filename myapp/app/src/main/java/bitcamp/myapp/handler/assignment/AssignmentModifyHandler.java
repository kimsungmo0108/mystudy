package bitcamp.myapp.handler.assignment;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

public class AssignmentModifyHandler implements MenuHandler {

  Prompt prompt;
  AssignmentRepository assignmentRepository;

  public AssignmentModifyHandler(Prompt prompt, AssignmentRepository assignmentRepository) {
    this.prompt = prompt;
    this.assignmentRepository = assignmentRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
    int index = this.prompt.inputInt("번호? ");
    Assignment oldassignment = this.assignmentRepository.get(index);
    if (oldassignment == null) {
      System.out.println("과제 번호가 유효하지 않습니다.");
      return;
    }

    Assignment assignment = new Assignment();
    assignment.title = this.prompt.input("과제명(%s)? ", oldassignment.title);
    assignment.content = this.prompt.input("내용(%s)? ", oldassignment.content);
    assignment.deadline = this.prompt.input("제출 마감일(%s)? ", oldassignment.deadline);

    this.assignmentRepository.set(index, assignment);
  }
}
