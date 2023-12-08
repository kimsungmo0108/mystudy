package algorithm.test.baekjoon.level04.exam06;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int[] nums = new int[n + 1];
    int x, y;
    int temp = 0;
    for (int i = 0; i <= n; i++) {
      nums[i] = i;
    }
    for (int i = 1; i <= m; i++) {
      x = scanner.nextInt();
      y = scanner.nextInt();
      temp = nums[x];
      nums[x] = nums[y];
      nums[y] = temp;
    }
    for (int j = 1; j <= n; j++) {
      System.out.printf("%d ", nums[j]);
    }
    scanner.close();
  }
}
