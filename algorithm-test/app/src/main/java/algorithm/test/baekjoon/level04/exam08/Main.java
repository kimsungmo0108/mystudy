package algorithm.test.baekjoon.level04.exam08;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] nums = new int[10];
    int c = 0;

    for (int i = 0; i < 10; i++) {
      nums[i] = (scanner.nextInt() % 42);
    }

    for (int i = 0; i < 10; i++) {
      for (int k = 0; k < 10; k++) {
        int j = nums[i] != nums[k] ? 1 : 0;
        c += j;
      }
    }

    System.out.println(c);

    scanner.close();
  }
}
