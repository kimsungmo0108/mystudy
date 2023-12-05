package algorithm.test.baekjoon.level04.exam02;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int i = scanner.nextInt();
    int x = scanner.nextInt();
    int[] a = new int[i];
    for (int j = 0; j < i; j++) {
      a[j] = scanner.nextInt();
    }
    for (int j = 0; j < i; j++) {
      if (a[j] < x) {
        System.out.print(a[j] + " ");
      }
    }
    scanner.close();
  }
}
