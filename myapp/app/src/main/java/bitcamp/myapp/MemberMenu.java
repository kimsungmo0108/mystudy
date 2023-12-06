package bitcamp.myapp;

import bitcamp.myapp.vo.Member;

public class MemberMenu {

  static final String ON_MEMBER_TITLE = "\n[ \033[1;31m회원\033[0m ]";
  static final String[] ON_MEMBER_MENU_ARR = new String[]{
      ON_MEMBER_TITLE,
      "1. 입력",
      "2. 조회",
      "3. 변경",
      "4. 삭제",
      "5. 회원 목록",
      "0. 이전"
  };
  static Member[] members = new Member[3];
  static int length = 0;


  static void printMenu() {
    for (String i : ON_MEMBER_MENU_ARR) {
      System.out.println(i);
    }
  }

  static void execute() {
    printMenu();
    memberloop:
    while (true) {
      String num = Prompt.input("메뉴/회원> ");
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
          break memberloop;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("번호가 옳지 않습니다.");
      }
    }
  }

  static void add() {
    System.out.println("회원 입력? ");
    if (length == members.length) {
      int oldSize = members.length;
      int newSize = oldSize + (oldSize / 2);
      Member[] arr = new Member[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = members[i];
      }
      members = arr;
    }
    Member member = new Member();
    member.email = Prompt.input("이메일? ");
    member.name = Prompt.input("이름? ");
    member.pw = Prompt.input("암호? ");
    member.date = Prompt.input("가입일? ");

    members[length] = member;
    length++;
  }

  static void view() {
    System.out.println("회원 조회: ");
    int index = Integer.parseInt(Prompt.input("회원 번호: "));
    if (index < 0 || index >= length) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }
    Member member = members[index];
    System.out.printf("이메일: %s\n", member.email);
    System.out.printf("이름: %s\n", member.name);
    System.out.printf("암호: %s\n", member.pw);
    System.out.printf("가입일: %s\n", member.date);
  }

  static void modify() {
    System.out.println("회원 변경: ");
    int index = Integer.parseInt(Prompt.input("회원 번호: "));
    if (index < 0 || index >= length) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }
    Member member = members[index];
    member.email = Prompt.input("이메일(%s): ", member.email);
    member.name = Prompt.input("이름(%s): ", member.name);
    member.pw = Prompt.input("암호(%s): ", member.pw);
    member.date = Prompt.input("가입일(%s): ", member.date);
  }

  static void delete() {
    System.out.println("회원 삭제: ");
    int index = Integer.parseInt(Prompt.input("회원 번호: "));
    if (index < 0 || index >= length) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }
    for (int i = index; i < (length - 1); i++) {
      members[i] = members[i + 1];
    }
    length--;
    members[length] = null;
    System.gc();
  }

  static void list() {
    System.out.println("회원 목록: ");
    System.out.printf("%-20s\t%-20s\t%-20s\n", "회원 번호", "이름", "가입일");
    for (int i = 0; i < length; i++) {
      Member member = members[i];
      System.out.printf("%-20d\t%-20s\t%-20s\n", i, member.name, member.date);
    }
  }
}
