package bitcamp.myapp;

import bitcamp.myapp.vo.Assignment;

public class AssignmentMenu {

  static final String ON_ASSIGNMENT_TITLE = "\n[ \033[1;31m과제\033[0m ]";
  static final String[] ON_ASSIGNMENT_MENU_ARR = new String[]{
      ON_ASSIGNMENT_TITLE,
      "1. 등록",
      "2. 조회",
      "3. 변경",
      "4. 삭제",
      "0. 이전"
  };
  static Assignment assignment = new Assignment();

  static void printMenu() {
    for (String i : ON_ASSIGNMENT_MENU_ARR) {
      System.out.println(i);
    }
  }

  static void execute() {
    printMenu();
    assignmentloop:
    while (true) {
      String num = Prompt.input("메뉴/과제> ");
      switch (num) {
        case "1":
          assignment.add();
          break;
        case "2":
          assignment.view();
          break;
        case "3":
          assignment.modify();
          break;
        case "4":
          assignment.delete();
          break;
        case "0":
          break assignmentloop;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("번호가 옳지 않습니다.");
      }
    }
  }
}
