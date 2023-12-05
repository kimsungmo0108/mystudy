package algorithm.test.baekjoon.level02.exam04;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner intScan = new java.util.Scanner(System.in);
    short x = intScan.nextShort();
    short y = intScan.nextShort();
    if (x > 0 && y > 0) {
      System.out.println('1');
    } else if (x < 0 && y > 0) {
      System.out.println('2');
    } else if (x < 0 && y < 0) {
      System.out.println('3');
    } else
      System.out.println('4');

    intScan.close();
  }
}
