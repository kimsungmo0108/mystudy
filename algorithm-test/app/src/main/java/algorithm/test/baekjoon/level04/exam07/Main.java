package algorithm.test.baekjoon.level04.exam07;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] nums = new int[31];
    int x;

    for (int i = 1; i < 29; i++) {
      x = scanner.nextInt();
      nums[x] = x;
    }
    for (int i = 1; i < 31; i++) {
      if (nums[i] == 0) {
        System.out.println(i);
      }
    }
    scanner.close();
  }
}
