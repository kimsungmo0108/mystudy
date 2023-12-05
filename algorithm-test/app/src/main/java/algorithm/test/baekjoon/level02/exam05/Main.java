package algorithm.test.baekjoon.level02.exam05;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner intScan = new java.util.Scanner(System.in);
    short h = intScan.nextShort();
    short m = intScan.nextShort();
    int h1 = h - 1;
    int m1 = m - 45;

    if (h1 < 0 && m1 < 0) {
      System.out.printf("%d %d", (24 + h1), (60 + m1));
    } else if (h >= 0 && m1 >= 0) {
      System.out.printf("%d %d", h, m1);
    } else
      System.out.printf("%d %d", h1, (60 + m1));

    intScan.close();
  }
}
