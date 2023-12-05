package algorithm.test.baekjoon.level02.exam07;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner intScan = new java.util.Scanner(System.in);
    byte a = intScan.nextByte();
    byte b = intScan.nextByte();
    byte c = intScan.nextByte();
    byte d = a > b ? a : b;
    byte e = d > c ? d : c;

    if (a == b) {
      if (a == c) {
        System.out.println(10000 + a * 1000);
      } else
        System.out.println(1000 + a * 100);
    } else if (b == c) {
      System.out.println(1000 + b * 100);
    } else if (c == a) {
      System.out.println(1000 + c * 100);
    } else
      System.out.println(e * 100);

    intScan.close();
  }
}
