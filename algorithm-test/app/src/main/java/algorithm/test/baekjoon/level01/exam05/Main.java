package algorithm.test.baekjoon.level01.exam05;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner intScan = new Scanner(System.in);
    double a = intScan.nextDouble();
    double b = intScan.nextDouble();
    double sum = a / b;
    System.out.println(sum);
    intScan.close();
  }
}
