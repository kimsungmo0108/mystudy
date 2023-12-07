package bitcamp.myapp.menu;

import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

public class BoardMenu {

  Prompt prompt;
  String title;

  Board[] boards = new Board[3];
  int length = 0;

  // BoardMenu 인스턴스를 생성할 때 반드시 게시판 제목을 설정하도록 강요한다
  // 생성자(constructor)란?
  // => 인스턴스를 사용하기 전에 유효한 상태로 설정하는 작업을 수행하는 메소드
  public BoardMenu(String title, Prompt prompt) {
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
    boardloop:
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
          break boardloop;
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

    if (this.length == this.boards.length) {
      int oldSize = this.boards.length;
      int newSize = oldSize + (oldSize >> 1);
      Board[] arr = new Board[newSize];

      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.boards[i];
      }
      this.boards = arr;
    }

    Board board = new Board();
    board.title = this.prompt.input("제목? ");
    board.content = this.prompt.input("내용? ");
    board.writer = this.prompt.input("작성자? ");
    board.createDate = this.prompt.input("작성일? ");

    this.boards[this.length++] = board;
  }

  void view() {
    System.out.printf("%s 조회: \n", this.title);
    int index = this.prompt.inputInt("번호: ");

    if (index < 0 || index >= this.length) {
      System.out.printf("%s 번호가 유효하지 않습니다.\n", this.title);
      return;
    }
    Board board = this.boards[index];

    System.out.println("제목: " + board.title);
    System.out.println("내용: " + board.content);
    System.out.println("작성자: " + board.writer);
    System.out.println("작성일: " + board.createDate);
  }

  void modify() {
    System.out.printf("%s 변경: ", this.title);
    int index = this.prompt.inputInt("번호: ");
    if (index < 0 || index >= this.length) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }
    Board board = this.boards[index];

    board.title = this.prompt.input("제목(%s): ", board.title);
    board.content = this.prompt.input("내용(%s): ", board.content);
    board.writer = this.prompt.input("작성자(%s): ", board.writer);
    board.createDate = this.prompt.input("작성일(%s): ", board.createDate);
  }

  void list() {
    System.out.printf("%s 목록: ", this.title);
    System.out.printf("%-20s\t%-20s\t%-20s\t%s\n", "번호", "제목", "작성자", "작성일");
    for (int i = 0; i < this.length; i++) {
      Board board = this.boards[i];
      System.out.printf("%-20d\t%-20s\t%-20s\t%s\n", i, board.title, board.writer,
          board.createDate);
    }
  }

  void delete() {
    System.out.printf("%s 삭제: ", this.title);
    int index = this.prompt.inputInt("번호: ");
    for (int i = index; i < (this.length - 1); i++) {
      this.boards[i] = this.boards[i + 1];
    }
    this.boards[--this.length] = null;
    System.gc();
  }
}
