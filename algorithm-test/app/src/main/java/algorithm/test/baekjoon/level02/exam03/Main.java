package algorithm.test.baekjoon.level02.exam03;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner intScan = new java.util.Scanner(System.in);
    int a = intScan.nextInt();
    int a1 = a % 4;
    int a2 = a % 100;
    int a3 = a % 400;

    if ((a1 == 0) && (a2 > 0)) {
      System.out.println('1');
    } else if (a3 == 0) {
      System.out.println('1');
    } else
      System.out.println('0');
  }
}
