package algorithm.test.baekjoon.level04.exam08;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean[] no = new boolean[42];
    int c = 0;
    for (int i = 0; i < 10; i++) {
      no[scanner.nextInt() % 42] = true;
    }
    for (int i = 0; i < 42; i++) {
      if (no[i]) {
        c++;
      }
    }
    System.out.println(c);

    scanner.close();
  }
}
