package bitcamp.myapp;

import bitcamp.myapp.vo.Board;

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
  static Board board = new Board();

  static void printMenu() {
    for (String i : ON_BOARD_MENU_ARR) {
      System.out.println(i);
    }
  }

  static void execute() {
    printMenu();
    boardloop:
    while (true) {
      String num = Prompt.input("메뉴/게시글> ");
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
        case "0":
          break boardloop;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("번호가 옳지 않습니다.");
      }
    }
  }

  static void add() {
    System.out.println("게시글 등록: ");
    board.title = Prompt.input("제목? ");
    board.content = Prompt.input("내용? ");
    board.writer = Prompt.input("작성자? ");
    board.createDate = Prompt.input("작성일? ");
  }

  static void view() {
    System.out.println("게시글 조회: ");
    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("작성자: %s\n", board.writer);
    System.out.printf("작성일: %s\n", board.createDate);
  }

  static void modify() {
    System.out.println("게시글 변경: ");
    board.title = Prompt.input("제목(%s): ", board.title);
    board.content = Prompt.input("내용(%s): ", board.content);
    board.writer = Prompt.input("작성자(%s): ", board.writer);
    board.createDate = Prompt.input("작성일(%s): ", board.createDate);
  }

  static void delete() {
    System.out.println("게시글 삭제: ");
    board.title = "";
    board.content = "";
    board.writer = "";
    board.createDate = "";
  }
}
