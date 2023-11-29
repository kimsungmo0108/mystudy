import java.util.Scanner;

public class Test4 {

  static final String ANSI_CLEAR = "\033[0m";
  static final String ANSI_BOLD_RED = "\033[1;31m";
  static final String ANSI_RED = "\033[0;31m";
  static final String APP_TITLE = "[과제관리 시스템]";
  static final String[] MENU_ARR = {"\n" + ANSI_BOLD_RED + APP_TITLE + ANSI_CLEAR, "1. 과제",
      "2. 게시글", "3. 도움말", ANSI_RED + "4. 종료" + ANSI_CLEAR};

  static java.util.Scanner numScan = new java.util.Scanner(System.in);

  public static void main(String[] args) {

    printMenu();

    menuloop: while (true) {
      String num = prompt(numScan);

      switch (num) {
        case "1":
          System.out.println("1. 과제 메뉴를 선택하셨습니다.");
          break;
        case "2":
          System.out.println("2. 게시글 메뉴를 선택하셨습니다.");
          break;
        case "3":
          System.out.println("3. 도움말 메뉴를 선택하셨습니다.");
          break;
        case "4":
          System.out.println("4. 종료 메뉴를 선택하셨습니다.");
          break menuloop;
        case "menu":
          printMenu();
        default:
          System.out.println("다른 번호를 입력해주세요.");

      }
    }
    numScan.close();
  }

  static void printMenu() {
    for (String i : MENU_ARR) {
      System.out.println(i);
    }
  }

  static String prompt(Scanner n) {
    System.out.println("> ");
    return n.next();
  }
}
