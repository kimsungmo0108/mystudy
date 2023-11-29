package bitcamp.myapp;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    String ANSI_CLEAR = "\033[0m";
    String ANSI_BOLD_RED = "\033[1;31m";
    String ANSI_RED = "\033[0;31m";
    String appTitle = "[과제관리 시스템]";
    String menu1 = "1. 과제", menu2 = "2. 게시글", menu3 = "3. 도움말", menu4 = "4. 종료";

    System.out.println(ANSI_BOLD_RED + appTitle + ANSI_CLEAR);
    System.out.println();
    System.out.println(menu1);
    System.out.println(menu2);
    System.out.println(menu3);
    System.out.println(ANSI_RED + menu4 + ANSI_CLEAR);

    // 키보드로 입력받는 메소드 연습
    //java.io.InputStream in = System.in;
    //java.util.Scanner numScan = new Scanner(in);
    //int num = numScan.nextInt();
    // 문자열=="abc"  ===>  if (num.equals("abc"));

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
          System.out.println(ANSI_BOLD_RED + appTitle + ANSI_CLEAR);
          System.out.println();
          System.out.println(menu1);
          System.out.println(menu2);
          System.out.println(menu3);
          System.out.println(ANSI_RED + menu4 + ANSI_CLEAR);
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
    numScan.close();
  }
}