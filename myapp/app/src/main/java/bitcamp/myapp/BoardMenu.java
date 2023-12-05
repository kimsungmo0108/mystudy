package bitcamp.myapp;

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
  static String title, content, createDate, writer;

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
    title = Prompt.input("제목? ");
    content = Prompt.input("내용? ");
    writer = Prompt.input("작성자? ");
    createDate = Prompt.input("작성일? ");
  }

  static void view() {
    System.out.println("게시글 조회: ");
    System.out.printf("제목: %s\n", title);
    System.out.printf("내용: %s\n", content);
    System.out.printf("작성자: %s\n", writer);
    System.out.printf("작성일: %s\n", createDate);
  }

  static void modify() {
    System.out.println("게시글 변경: ");
    title = Prompt.input("제목(%s): ", title);
    content = Prompt.input("내용(%s): ", content);
    writer = Prompt.input("작성자(%s): ", writer);
    createDate = Prompt.input("작성일(%s): ", createDate);
  }

  static void delete() {
    System.out.println("게시글 삭제: ");
    title = "";
    content = "";
    writer = "";
    createDate = "";
  }
}
