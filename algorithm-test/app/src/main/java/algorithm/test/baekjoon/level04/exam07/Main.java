package algorithm.test.baekjoon.level04.exam07;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] nums = new int[31];
    int x;

    for (int i = 1; i < 29; i++) {
      x = scanner.nextInt();
      nums[i] = x;
    }

    for (int j = 1; j < 29; j++) {
      if (nums[j] == j) {
        nums[j] = 0;
      } else {
        continue;
      }
    }
    // for (int i : nums) {
    // if (i > 0) {
    // System.out.println(i);
    // }
    // }

    scanner.close();
  }
}
