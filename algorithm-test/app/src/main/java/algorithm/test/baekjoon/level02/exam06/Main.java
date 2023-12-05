package algorithm.test.baekjoon.level02.exam06;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner intScan = new java.util.Scanner(System.in);
    short h = intScan.nextShort();
    short m = intScan.nextShort();
    short run = intScan.nextShort();
    int totalM = m + run;
    int m2 = totalM % 60;
    int h1 = totalM / 60;

    if (run <= 60 && (h + h1) < 24) {
      System.out.printf("%d %d", (h + h1), m2);
    } else if (run > 60 && (h + h1) < 24) {
      System.out.printf("%d %d", (h + h1), m2);
    } else
      System.out.printf("%d %d", (h + h1) - 24, m2);
    intScan.close();
  }
}
