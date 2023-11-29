package bitcamp.myapp;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    String ANSI_CLEAR = "\033[0m";
    String ANSI_BOLD_RED = "\033[1;31m";
    String ANSI_RED = "\033[0;31m";
    String appTitle = "[과제관리 시스템]";

    String[] menuArr = new String[]{
        ANSI_BOLD_RED + appTitle + ANSI_CLEAR + "\n",
        "1. 과제",
        "2. 게시글",
        "3. 도움말",
        ANSI_RED + "4. 종료" + ANSI_CLEAR
    };

    for (String item : menuArr) {
      System.out.println(item);
    }

    Scanner numScan = new Scanner(System.in);
    menuloop:
    while (true) {
      System.out.print("> ");
      String num = numScan.next();
      switch (num) {
        case "1":
          System.out.println("과제입니다.");
          break;
        case "2":
          System.out.println("게시글입니다.");
          break;
        case "3":
          System.out.println("도움말입니다.");
          break;
        case "4":
          System.out.println("종료합니다.");
          break menuloop;
        case "menu":
          for (String item : menuArr) {
            System.out.println(item);
          }
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
    numScan.close();
  }
}