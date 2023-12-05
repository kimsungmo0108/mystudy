package algorithm.test.baekjoon.level03.exam01;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner intScan = new java.util.Scanner(System.in);
    byte a = intScan.nextByte();
    for (byte i = 1; i < 10; i++) {
      System.out.printf("%d * %d = %d\n", a, i, (a * i));
    }

    intScan.close();
  }
}

