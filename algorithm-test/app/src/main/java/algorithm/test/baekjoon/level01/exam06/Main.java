package algorithm.test.baekjoon.level01.exam06;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner intScan = new Scanner(System.in);
    int a = intScan.nextInt();
    int b = intScan.nextInt();
    System.out.println(a + b);
    System.out.println(a - b);
    System.out.println(a * b);
    System.out.println(a / b);
    System.out.println(a % b);
    intScan.close();
  }
}
