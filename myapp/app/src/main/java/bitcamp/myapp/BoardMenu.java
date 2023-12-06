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
      "5. 목록",
      "0. 이전"
  };
  static Board[] boards = new Board[3];
  static int length = 0;

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
        case "5":
          list();
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

    if (length == boards.length) {
      int oldSize = boards.length;
      int newSize = oldSize + (oldSize / 2);
      Board[] arr = new Board[newSize];

      for (int i = 0; i < oldSize; i++) {
        arr[i] = boards[i];
      }
      boards = arr;
    }

    Board board = new Board();
    board.title = Prompt.input("제목? ");
    board.content = Prompt.input("내용? ");
    board.writer = Prompt.input("작성자? ");
    board.createDate = Prompt.input("작성일? ");

    boards[length++] = board;
  }

  static void view() {
    System.out.println("게시글 조회: ");
    int index = Integer.parseInt(Prompt.input("번호: "));

    if (index < 0 || index >= length) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }
    Board board = boards[index];

    System.out.println("제목: " + board.title);
    System.out.println("내용: " + board.content);
    System.out.println("작성자: " + board.writer);
    System.out.println("작성일: " + board.createDate);
  }

  static void modify() {
    System.out.println("게시글 변경: ");
    int index = Integer.parseInt(Prompt.input("번호: "));
    if (index < 0 || index >= length) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }
    Board board = boards[index];

    board.title = Prompt.input("제목(%s): ", board.title);
    board.content = Prompt.input("내용(%s): ", board.content);
    board.writer = Prompt.input("작성자(%s): ", board.writer);
    board.createDate = Prompt.input("작성일(%s): ", board.createDate);
  }


  static void list() {
    System.out.println("게시글 목록: ");
    System.out.printf("%-20s\t%-20s\t%-20s\t%s\n", "번호", "제목", "작성자", "작성일");
    for (int i = 0; i < length; i++) {
      Board board = boards[i];
      System.out.printf("%-20d\t%-20s\t%-20s\t%s\n", i, board.title, board.writer,
          board.createDate);
    }
  }

  static void delete() {
    System.out.println("게시글 삭제: ");
    int index = Integer.parseInt(Prompt.input("번호: "));
    for (int i = index; i < (length - 1); i++) {
      boards[i] = boards[i + 1];
    }
    boards[--length] = null;
    System.gc();
  }
}
