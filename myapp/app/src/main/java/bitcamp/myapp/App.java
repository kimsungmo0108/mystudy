package bitcamp.myapp;

import java.util.Scanner;

public class App {

  // 애플리케이션 객체(클래스) App을 실행할 때 다음 변수를 미리 준비해 둔다.
  static final String ANSI_CLEAR = "\033[0m";
  static final String ANSI_BOLD_RED = "\033[1;31m";
  static final String ANSI_RED = "\033[0;31m";
  static final String APP_TITLE = ANSI_BOLD_RED + "[과제관리 시스템]" + ANSI_CLEAR + "\n";
  static final String MENU4 = ANSI_RED + "4. 종료" + ANSI_CLEAR;
  static final String[] MENU_ARR = new String[]{
      APP_TITLE,
      "1. 과제",
      "2. 게시글",
      "3. 도움말",
      MENU4
  };
  static final Scanner numScan = new Scanner(System.in);
  static final String ON_ASSIGNMENT_TITLE = "\n[ \033[1;31m과제\033[0m ]";
  static final String[] ON_ASSIGNMENT_MENU_ARR = new String[]{
      ON_ASSIGNMENT_TITLE,
      "1. 등록",
      "2. 조회",
      "3. 변경",
      "4. 삭제",
      "0. 이전"
  };

  static final String ON_BOARD_TITLE = "\n[ \033[1;31m게시글\033[0m ]";
  static final String[] ON_BOARD_MENU_ARR = new String[]{
      ON_BOARD_TITLE,
      "1. 등록",
      "2. 조회",
      "3. 변경",
      "4. 삭제",
      "0. 이전"
  };

  public static void main(String[] args) {

    // 코드를 기능 단위로 묶어 메소드로 정의하면
    // 메소드의 이름을 통해 해당 기능을 쉽게 유추할 수 있어 유지보수에 좋다.
    printMainMenu();
    menuloop:
    while (true) {
      // static 대신에 printMenu(MENU_ARR); 해도된다.
      String num = prompt("메인");
      switch (num) {
        case "1":
          onAssignment();
          System.out.println();
          printMainMenu();
          break;
        case "2":
          onBoard();
          System.out.println();
          printMainMenu();
          break;
        case "3":
          System.out.println("도움말입니다.");
          break;
        case "4":
          System.out.println("종료합니다.");
          break menuloop;
        case "menu":
          printMainMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
    numScan.close();
  }

  static void printMainMenu() {

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

  static String prompt(String menu) {
    System.out.printf("%s> ", menu);
    return numScan.next();
  }

  static void printAssignmentMenu() {
    for (String i : ON_ASSIGNMENT_MENU_ARR) {
      System.out.println(i);
    }
  }

  static void onAssignment() {
    printAssignmentMenu();
    assignmentloop:
    while (true) {
      String num = prompt("메뉴/과제");
      switch (num) {
        case "1":
          System.out.println("과제 등록입니다.");
          break;
        case "2":
          System.out.println("과제 조회입니다.");
          break;
        case "3":
          System.out.println("과제 변경입니다.");
          break;
        case "4":
          System.out.println("과제 삭제입니다.");
          break;
        case "0":
          break assignmentloop;
        case "menu":
          printAssignmentMenu();
          break;
        default:
          System.out.println("번호가 옳지 않습니다.");
      }
    }
  }

  static void printBoardMenu() {
    for (String i : ON_BOARD_MENU_ARR) {
      System.out.println(i);
    }
  }

  static void onBoard() {
    printBoardMenu();
    postloop:
    while (true) {
      String num = prompt("메뉴/게시글");
      switch (num) {
        case "1":
          System.out.println("게시글 등록입니다.");
          break;
        case "2":
          System.out.println("게시글 조회입니다.");
          break;
        case "3":
          System.out.println("게시글 변경입니다.");
          break;
        case "4":
          System.out.println("게시글 삭제입니다.");
          break;
        case "0":
          break postloop;
        case "menu":
          printBoardMenu();
          break;
        default:
          System.out.println("번호가 옳지 않습니다.");
      }
    }
  }
}