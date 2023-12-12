package algorithm.test.baekjoon.level04.exam08;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] nums = new int[10];
    int c = 0, c1 = 0;
    int j, j1 = 0;

    for (int i = 0; i < 10; i++) {
      nums[i] = (scanner.nextInt() % 42);
    }

    for (int i = 0; i < 10; i++) {
      for (int k = i + 1; k < 10; k++) {
        j = nums[i] != nums[k] ? 1 : 0;
        if (j == 1) {
          j1++;
        } else if (j == 0) {
          break;
        }
      }
      if (j1 > 0) {
        c++;
        j1 = 0;
      }
    }

    System.out.println(c);

    scanner.close();
  }
}
