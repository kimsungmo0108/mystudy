package bitcamp.myapp;

import java.util.Scanner;

public class App {

  //static final Scanner numScan = new Scanner(System.in);
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
    MainMenu.printMenu();
    Scanner keyIn = new Scanner(System.in);
    menuloop:
    while (true) {
      // static 대신에 printMenu(MENU_ARR); 해도된다.
      String num = prompt(keyIn, "메인");
      switch (num) {
        case "1":
          onAssignment(keyIn);
          System.out.println();
          MainMenu.printMenu();
          break;
        case "2":
          onBoard(keyIn);
          System.out.println();
          MainMenu.printMenu();
          break;
        case "3":
          System.out.println("도움말입니다.");
          break;
        case "4":
          System.out.println("종료합니다.");
          break menuloop;
        case "menu":
          MainMenu.printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
    keyIn.close();
  }


  static String prompt(Scanner numScan, String menu) {
    System.out.printf("%s> ", menu);
    return numScan.next();
  }

  static void printAssignmentMenu() {
    for (String i : ON_ASSIGNMENT_MENU_ARR) {
      System.out.println(i);
    }
  }

  static void onAssignment(Scanner numScan) {
    printAssignmentMenu();
    assignmentloop:
    while (true) {
      String num = prompt(numScan, "메뉴/과제");
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

  static void onBoard(Scanner numScan) {
    printBoardMenu();
    postloop:
    while (true) {
      String num = prompt(numScan, "메뉴/게시글");
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