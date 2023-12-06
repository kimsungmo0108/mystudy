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
      "5. 목록",
      "0. 이전"
  };
  static Assignment[] assignments = new Assignment[3];
  static int length = 0;

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
          add();
          break;
        case "2":
          view();
          break;
        case "3":
          modify();
          break;
        case "4":
          delete();
          break;
        case "5":
          list();
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

  static void add() {
    System.out.println("과제 등록: ");

    if (length == assignments.length) {
      int oldSize = assignments.length;
      int newSize = oldSize + (oldSize / 2);
      // 이전 배열에 들어 있는 값을 새 배열에 복사
      Assignment[] arr = new Assignment[newSize];

      for (int i = 0; i < oldSize; i++) {
        arr[i] = assignments[i];
      }

      // 새 배열을 가리키도록 배열 레퍼런스를 변경
      assignments = arr;
    }

    Assignment assignment = new Assignment();
    assignment.title = Prompt.input("과제명? ");
    assignment.content = Prompt.input("내용? ");
    assignment.deadline = Prompt.input("제출 마감일? ");

    assignments[length++] = assignment;
  }

  static void view() {
    System.out.println("과제 조회: ");
    int index = Integer.parseInt(Prompt.input("번호: "));

    if (index < 0 || index >= length) {
      System.out.println("과제 번호가 유효하지 않습니다.");
      return;
    }
    Assignment assignment = assignments[index];

    System.out.printf("과제명: %s \n", assignment.title);
    System.out.printf("내용: %s \n", assignment.content);
    System.out.printf("제출 마감일: %s \n", assignment.deadline);
  }

  static void modify() {
    System.out.println("과제 변경: ");
    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
      System.out.println("과제 번호가 유효하지 않습니다.");
      return;
    }
    Assignment assignment = assignments[index];

    assignment.title = Prompt.input("과제명(%s)? ", assignment.title);
    assignment.content = Prompt.input("내용(%s)? ", assignment.content);
    assignment.deadline = Prompt.input("제출 마감일(%s)? ", assignment.deadline);
  }

  static void list() {
    System.out.println("과제 목록: ");
    System.out.printf("%-20s\t%-20s\t%s\n", "번호", "과제", "제출마감일");
    for (int i = 0; i < length; i++) {
      Assignment assignment = assignments[i];
      System.out.printf("%-20d\t%-20s\t%s\n", i, assignment.title, assignment.deadline);
    }
  }

  static void delete() {
    System.out.println("과제 삭제: ");
    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
      System.out.println("과제 번호가 유효하지 않습니다.");
      return;
    }
    for (int i = index; i < (length - 1); i++) {
      assignments[i] = assignments[i + 1];
    }
    assignments[--length] = null;  // 레퍼런스 주소를 초기화
    System.gc();  // garbage collector 한테 요청, 없앨려고 노력한다
  }
}
