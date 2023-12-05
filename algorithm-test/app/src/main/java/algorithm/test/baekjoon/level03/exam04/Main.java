package algorithm.test.baekjoon.level03.exam04;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner intScan = new java.util.Scanner(System.in);
    int sum = intScan.nextInt();
    short a = intScan.nextByte();
    int total = 0;

    int[] b = new int[a];
    short[] c = new short[a];

    for (byte i = 0; i < a; i++) {
      b[i] = intScan.nextInt();
      c[i] = intScan.nextShort();
    }
    for (byte i = 0; i < a; i++) {
      total += (b[i] * c[i]);
    }
    if (total == sum) {
      System.out.println("Yes");
    } else
      System.out.println("No");


    intScan.close();
  }
}

