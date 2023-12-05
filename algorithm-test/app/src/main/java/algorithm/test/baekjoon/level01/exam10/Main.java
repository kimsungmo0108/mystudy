package algorithm.test.baekjoon.level01.exam10;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner stringScan = new Scanner(System.in);
    int a = stringScan.nextInt();
    int b = stringScan.nextInt();
    int b1 = b / 100;
    int b2 = (b - (b1 * 100)) / 10;
    int b3 = (b - (b1 * 100) - (b2 * 10));
    System.out.println(a * b3);
    System.out.println(a * b2);
    System.out.println(a * b1);
    System.out.println(a * b);
    stringScan.close();
  }
}
