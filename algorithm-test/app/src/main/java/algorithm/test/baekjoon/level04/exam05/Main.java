package algorithm.test.baekjoon.level04.exam05;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] numbers = new int[9];
    for (int j = 0; j < 9; j++) {
      numbers[j] = scanner.nextInt();
    }

    scanner.close();
  }
}
