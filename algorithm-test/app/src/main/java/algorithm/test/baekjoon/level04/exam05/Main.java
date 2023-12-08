package algorithm.test.baekjoon.level04.exam05;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < m; i++) {
      int x = scanner.nextInt() - 1, y = scanner.nextInt() - 1, z = scanner.nextInt();
      for (int j = x; j <= y; j++) {
        nums[j] = z;
      }
    }
    for (int j : nums) {
      System.out.printf("%d ", j);
    }
    scanner.close();
  }
}
