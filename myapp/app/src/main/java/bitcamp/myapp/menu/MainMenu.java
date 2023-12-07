package bitcamp.myapp.menu;

import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

public class MainMenu {

  // 애플리케이션 객체(클래스) App을 실행할 때 다음 변수를 미리 준비해 둔다.

  static final String[] MENU_ARR = new String[]{
      AnsiEscape.APP_TITLE,
      "1. 과제",
      "2. 게시글",
      "3. 회원",
      "4. 가입인사",
      "5. 도움말",
      AnsiEscape.MENU4
  };
  Prompt prompt;

  public MainMenu(Prompt prompt) {
    this.prompt = prompt;
  }

  static void printMenu() {
    // 메뉴를 저장한 변수를 메소드 안에 두는 대신에
    // 클래스 블록 안에 두면
    // printMenu()를 호출할 때마다 변수를 만들지 않기 때문에 실행 속도나 메모리 부분에서
    // 훨씬 효율적이다.
    // 보통 메소드 호출될 때마다 값이 바뀌는 변수가 아니라 고정 값을 갖는 변수인 경우
    // 메소드 밖에 도는 것이 좋다.
    for (String item : MENU_ARR) {
      System.out.println(item);
    }
  }

  public void execute() {
    BoardMenu boardMenu = new BoardMenu("게시판", this.prompt);
    BoardMenu greetingMenu = new BoardMenu("가입인사", this.prompt);
    AssignmentMenu assignmentMenu = new AssignmentMenu("과제", this.prompt);
    MemberMenu memberMenu = new MemberMenu("회원", this.prompt);

    printMenu();

    while (true) {
      String num = this.prompt.input("메인> ");
      switch (num) {
        case "1":
          assignmentMenu.execute();
          System.out.println();
          printMenu();
          break;
        case "2":
          boardMenu.execute();
          System.out.println();
          printMenu();
          break;
        case "3":
          memberMenu.execute();
          System.out.println();
          printMenu();
          break;
        case "4":
          greetingMenu.execute();
          System.out.println();
          printMenu();
          break;
        case "5":
          System.out.println("도움말입니다.");
          break;
        case "0":
          System.out.println("종료합니다.");
          return;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
  }
}
