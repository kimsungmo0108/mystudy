package algorithm.test.baekjoon.level04.exam01;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    byte i = scanner.nextByte();
    byte[] a = new byte[i];
    for (int j = 0; j < i; j++) {
      a[j] = scanner.nextByte();
    }
    byte x = scanner.nextByte();
    byte count = 0;
    for (int j = 0; j < i; j++) {
      if (a[j] == x) {
        count++;
      }
    }
    System.out.println(count);
    scanner.close();
  }
}
