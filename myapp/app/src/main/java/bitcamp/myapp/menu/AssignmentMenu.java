package bitcamp.myapp.menu;

import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;

public class AssignmentMenu {

  // 의존객체(Dependency Object ==> Dependency)
  // - 클래스가 작업을 수행할 때 사용하는 객체
  Prompt prompt;
  String title;
  Assignment[] assignments = new Assignment[3];
  int length = 0;

  public AssignmentMenu(String title, Prompt prompt) {
    this.title = title;
    this.prompt = prompt;
  }

  void printMenu() {
    System.out.printf("\n[ %s ]\n", this.title);
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("5. 목록");
    System.out.println("0. 이전");
  }

  void execute() {
    this.printMenu();
    assignmentloop:
    while (true) {
      String num = this.prompt.input("메뉴/%s> ", this.title);
      switch (num) {
        case "1":
          this.add();
          break;
        case "2":
          this.view();
          break;
        case "3":
          this.modify();
          break;
        case "4":
          this.delete();
          break;
        case "5":
          this.list();
          break;
        case "0":
          break assignmentloop;
        case "menu":
          this.printMenu();
          break;
        default:
          System.out.println("번호가 옳지 않습니다.");
      }
    }
  }

  void add() {
    System.out.printf("%s 등록: \n", this.title);

    if (this.length == this.assignments.length) {
      int oldSize = this.assignments.length;
      int newSize = oldSize + (oldSize / 2);
      // 이전 배열에 들어 있는 값을 새 배열에 복사
      Assignment[] arr = new Assignment[newSize];

      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.assignments[i];
      }

      // 새 배열을 가리키도록 배열 레퍼런스를 변경
      this.assignments = arr;
    }

    Assignment assignment = new Assignment();
    assignment.title = this.prompt.input("과제명? ");
    assignment.content = this.prompt.input("내용? ");
    assignment.deadline = this.prompt.input("제출 마감일? ");

    this.assignments[this.length++] = assignment;
  }

  void view() {
    System.out.printf("%s 조회: \n", this.title);
    int index = this.prompt.inputInt("번호? ");

    if (index < 0 || index >= this.length) {
      System.out.println("과제 번호가 유효하지 않습니다.");
      return;
    }
    Assignment assignment = this.assignments[index];

    System.out.printf("과제명: %s \n", assignment.title);
    System.out.printf("내용: %s \n", assignment.content);
    System.out.printf("제출 마감일: %s \n", assignment.deadline);
  }

  void modify() {
    System.out.printf("%s 변경: \n", this.title);
    int index = this.prompt.inputInt("번호? ");
    if (index < 0 || index >= this.length) {
      System.out.println("과제 번호가 유효하지 않습니다.");
      return;
    }
    Assignment assignment = this.assignments[index];

    assignment.title = this.prompt.input("과제명(%s): ", assignment.title);
    assignment.content = this.prompt.input("내용(%s):", assignment.content);
    assignment.deadline = this.prompt.input("제출 마감일(%s): ", assignment.deadline);
  }

  void list() {
    System.out.printf("%s 목록: \n", this.title);
    System.out.printf("%-20s\t%-20s\t%s\n", "번호", "과제", "제출마감일");
    for (int i = 0; i < this.length; i++) {
      Assignment assignment = this.assignments[i];
      System.out.printf("%-20d\t%-20s\t%s\n", i, assignment.title, assignment.deadline);
    }
  }

  void delete() {
    System.out.printf("%s 삭제: \n", this.title);
    int index = this.prompt.inputInt("번호? ");
    if (index < 0 || index >= this.length) {
      System.out.println("과제 번호가 유효하지 않습니다.");
      return;
    }
    for (int i = index; i < (this.length - 1); i++) {
      this.assignments[i] = this.assignments[i + 1];
    }
    this.assignments[--this.length] = null;  // 레퍼런스 주소를 초기화
    System.gc();  // garbage collector 한테 요청, 없앨려고 노력한다
  }
}
