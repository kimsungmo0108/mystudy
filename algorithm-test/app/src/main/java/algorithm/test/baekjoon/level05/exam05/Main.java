package algorithm.test.baekjoon.level05.exam05;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    String str = scanner.next();
    int total = 0;
    for (int i = 0; i < n; i++) {
      total += str.charAt(i) - '0';
    }
    System.out.println(total);
    scanner.close();
  }
}
