package bitcamp.myapp;

import java.util.Scanner;

public class Prompt {

  static Scanner KEY_IN = new Scanner(System.in);

  //가변 파라미터는 맨 뒤에 와야한다
  public static String input(String title, Object... args) {
    System.out.print(String.format(title, args));
    return KEY_IN.nextLine();
  }

  static void close() {
    KEY_IN.close();
  }
}
