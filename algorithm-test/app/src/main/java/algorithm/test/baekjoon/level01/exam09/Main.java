package algorithm.test.baekjoon.level01.exam09;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner stringScan = new Scanner(System.in);
    int a = stringScan.nextInt();
    int b = stringScan.nextInt();
    int c = stringScan.nextInt();
    System.out.println((a + b) % c);
    System.out.println(((a % c) + (b % c)) % c);
    System.out.println((a * b) % c);
    System.out.println(((a % c) * (b % c)) % c);
    stringScan.close();
  }
}
