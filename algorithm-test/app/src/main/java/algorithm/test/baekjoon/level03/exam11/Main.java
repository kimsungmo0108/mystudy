package algorithm.test.baekjoon.level03.exam11;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner intScan = new Scanner(System.in);
    while (true) {
      int a = intScan.nextInt();
      int b = intScan.nextInt();
      if (a > 0 && b > 0) {
        System.out.println(a + b);
      } else
        break;
    }
    intScan.close();
  }
}
