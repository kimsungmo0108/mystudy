package bitcamp.myapp;

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


  static void printMenu() {
    for (String i : ON_ASSIGNMENT_MENU_ARR) {
      System.out.println(i);
    }
  }

  static void execute() {
    printMenu();
    AssignmentManagement a = new AssignmentManagement();
    assignmentloop:
    while (true) {
      String num = Prompt.input("메뉴/과제> ");
      switch (num) {
        case "1":
          a.add();
          break;
        case "2":
          a.view();
          break;
        case "3":
          a.modify();
          break;
        case "4":
          a.delete();
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
