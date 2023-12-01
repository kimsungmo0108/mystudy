package bitcamp.myapp;

import java.util.Scanner;

public class Prompt {

  static Scanner KEY_IN = new Scanner(System.in);

  static String input(String menu) {
    System.out.printf("%s> ", menu);
    return KEY_IN.next();
  }

  static void close() {
    KEY_IN.close();
  }
}
