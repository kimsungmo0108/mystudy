package bitcamp.myapp.menu;

import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberMenu implements Menu {

  Member[] members = new Member[3];
  int length = 0;
  String title;
  Prompt prompt;

  public MemberMenu(String title, Prompt prompt) {
    this.title = title;
    this.prompt = prompt;
  }

  void printMenu() {
    System.out.printf("\n[%s]\n", this.title);
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("5. 목록");
    System.out.println("0. 이전");
  }

  @Override
  public String getTitle() {
    return null;
  }

  public void execute(Prompt prompt) {
    this.printMenu();

    while (true) {
      String input = this.prompt.input("메인/%s> ", this.title);

      switch (input) {
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
          return;
        case "menu":
          this.printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }
  }

  void add() {
    System.out.printf("%s 입력: \n", this.title);
    if (this.length == this.members.length) {
      int oldSize = this.members.length;
      int newSize = oldSize + (oldSize / 2);
      Member[] arr = new Member[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.members[i];
      }
      this.members = arr;
    }
    Member member = new Member();
    member.email = this.prompt.input("이메일? ");
    member.name = this.prompt.input("이름? ");
    member.password = this.prompt.input("암호? ");
    member.createDate = this.prompt.input("가입일? ");
    this.members[this.length++] = member;
  }

  void view() {
    System.out.printf("%s 조회: \n", this.title);
    int index = this.prompt.inputInt("%s 번호? ", this.title);
    if (index < 0 || index >= this.length) {
      System.out.printf("%s 번호가 유효하지 않습니다.\n", this.title);
      return;
    }
    Member member = this.members[index];
    System.out.printf("이메일: %s\n", member.email);
    System.out.printf("이름: %s\n", member.name);
    System.out.printf("가입일: %s\n", member.createDate);
  }

  void modify() {
    System.out.printf("%s 변경: \n", this.title);
    int index = this.prompt.inputInt("%s 번호? ", this.title);
    if (index < 0 || index >= this.length) {
      System.out.printf("%s 번호가 유효하지 않습니다.\n", this.title);
      return;
    }
    Member member = this.members[index];
    member.email = this.prompt.input("이메일(%s): ", member.email);
    member.name = this.prompt.input("이름(%s): ", member.name);
    member.password = this.prompt.input("새암호: ");
    member.createDate = this.prompt.input("가입일(%s): ", member.createDate);
  }

  void delete() {
    System.out.printf("%s 삭제: \n", this.title);
    int index = this.prompt.inputInt("%s 번호? ", this.title);
    if (index < 0 || index >= this.length) {
      System.out.printf("%s 번호가 유효하지 않습니다.\n", this.title);
      return;
    }
    for (int i = index; i < (this.length - 1); i++) {
      this.members[i] = this.members[i + 1];
    }
    this.members[--this.length] = null;
  }

  void list() {
    System.out.printf("%s 목록: \n", this.title);
    System.out.printf("%-20s\t%-20s\t%s\n", "번호", "이름", "가입일");
    for (int i = 0; i < this.length; i++) {
      Member member = this.members[i];
      System.out.printf("%-20d\t%-20s\t%s\n", i, member.name, member.createDate);
    }
  }
}
