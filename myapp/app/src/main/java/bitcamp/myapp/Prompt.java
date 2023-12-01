package bitcamp.myapp;

import java.util.Scanner;

public class Prompt {

  static String input(Scanner numScan, String menu) {
    System.out.printf("%s> ", menu);
    return numScan.next();
  }
}
