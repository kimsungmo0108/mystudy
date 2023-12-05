package algorithm.test.baekjoon.level03.exam05;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner intScan = new java.util.Scanner(System.in);
    short a = intScan.nextShort();
    int totalLong = a / 4;

    if (a != 0) {
      for (short i = 1; i < totalLong; i++) {
        System.out.print("long ");
      }
      System.out.print("long int");
    }
    intScan.close();
  }
}

