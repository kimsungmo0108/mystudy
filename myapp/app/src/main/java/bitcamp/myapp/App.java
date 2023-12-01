package bitcamp.myapp;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    // 코드를 기능 단위로 묶어 메소드로 정의하면
    // 메소드의 이름을 통해 해당 기능을 쉽게 유추할 수 있어 유지보수에 좋다.
    MainMenu.printMenu();
    Scanner keyIn = new Scanner(System.in);
    menuloop:
    while (true) {
      String num = Prompt.input(keyIn, "메인");
      switch (num) {
        case "1":
          AssignmentMenu.execute(keyIn);
          System.out.println();
          MainMenu.printMenu();
          break;
        case "2":
          BoardMenu.execute(keyIn);
          System.out.println();
          MainMenu.printMenu();
          break;
        case "3":
          System.out.println("도움말입니다.");
          break;
        case "4":
          System.out.println("종료합니다.");
          break menuloop;
        case "menu":
          MainMenu.printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
    keyIn.close();
  }

}