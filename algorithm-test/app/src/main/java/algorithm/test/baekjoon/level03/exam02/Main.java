package algorithm.test.baekjoon.level03.exam02;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner intScan = new java.util.Scanner(System.in);
    byte a = intScan.nextByte();
    byte[] b = new byte[a];
    byte[] c = new byte[a];

    for (byte i = 0; i < a; i++) {
      b[i] = intScan.nextByte();
      c[i] = intScan.nextByte();
    }
    for (byte i = 0; i < a; i++) {
      System.out.println(b[i] + c[i]);
    }

    intScan.close();
  }
}

