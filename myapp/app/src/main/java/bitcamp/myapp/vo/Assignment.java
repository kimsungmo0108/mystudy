package bitcamp.myapp.vo;

import bitcamp.myapp.Prompt;

public class Assignment {

  String title, content, deadline;

  public void add() {
    System.out.println("과제 등록: ");
    this.title = Prompt.input("과제명? ");
    this.content = Prompt.input("내용? ");
    this.deadline = Prompt.input("제출 마감일? ");
  }

  public void view() {
    System.out.println("과제 조회: ");
    System.out.printf("과제명: %s\n", this.title);
    System.out.printf("내용: %s\n", this.content);
    System.out.printf("과제 마감일: %s\n", this.deadline);
  }

  public void modify() {
    System.out.println("과제 변경: ");
    this.title = Prompt.input("과제명(%s)? ", this.title);
    this.content = Prompt.input("내용(%s)? ", this.content);
    this.deadline = Prompt.input("제출 마감일(%s)? ", this.deadline);
  }

  public void delete() {
    System.out.println("과제 삭제: ");
    this.title = "";
    this.content = "";
    this.deadline = "";
  }
}
