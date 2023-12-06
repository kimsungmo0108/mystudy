package algorithm.test.baekjoon.level04.exam04;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] numbers = new int[9];
    for (int j = 0; j < 9; j++) {
      numbers[j] = scanner.nextInt();
    }
    int max = numbers[0];
    int index = 0;
    for (int x = 0; x < 9; x++) {
      if (max < numbers[x]) {
        max = numbers[x];
        index = x;
      }
    }
    System.out.printf("%d\n%d", max, (index + 1));
    scanner.close();
  }
}
