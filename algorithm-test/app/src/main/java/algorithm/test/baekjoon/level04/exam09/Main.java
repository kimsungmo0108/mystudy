package algorithm.test.baekjoon.level04.exam09;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int[] num = new int[n];
    int a, b;
    int temp;
    for (int i = 0; i < n; i++) {
      num[i] = i;
      // System.out.println(num[i] + 1);
    }
    for (int i = 0; i < m; i++) {
      a = scanner.nextInt() - 1;
      b = scanner.nextInt() - 1;
      for (; a < b; a++, b--) {
        temp = num[a];
        num[a] = num[b];
        num[b] = temp;
      }
    }
    for (int i = 0; i < n; i++) {
      System.out.print((num[i] + 1) + " ");
    }
    scanner.close();
  }
}
