package algorithm.test.baekjoon.level03.exam12;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    loop: while (scanner.hasNext()) {
      if (scanner.hasNextInt()) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(a + b);
      } else {
        String input = scanner.next();
        if (input.equalsIgnoreCase("exit")) {
          break;
        } else {
          break loop;

        }
      }
    }
    scanner.close();
  }
}
