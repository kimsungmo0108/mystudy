package bitcamp.myapp;

import java.util.Scanner;

public class BoardMenu {

  static final String ON_BOARD_TITLE = "\n[ \033[1;31m게시글\033[0m ]";
  static final String[] ON_BOARD_MENU_ARR = new String[]{
      ON_BOARD_TITLE,
      "1. 등록",
      "2. 조회",
      "3. 변경",
      "4. 삭제",
      "0. 이전"
  };

  static void printMenu() {
    for (String i : ON_BOARD_MENU_ARR) {
      System.out.println(i);
    }
  }

  static void execute(Scanner numScan) {
    printMenu();
    postloop:
    while (true) {
      String num = App.prompt(numScan, "메뉴/게시글");
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
          printMenu();
          break;
        default:
          System.out.println("번호가 옳지 않습니다.");
      }
    }
  }
}
