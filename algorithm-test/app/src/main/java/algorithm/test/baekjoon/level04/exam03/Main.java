package algorithm.test.baekjoon.level04.exam03;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int i = scanner.nextInt();
    // int x = scanner.nextInt();
    int[] numbers = new int[i];
    int max = 0;
    int min = 0;
    for (int j = 0; j < i; j++) {
      numbers[j] = scanner.nextInt();
    }
    max = numbers[0];
    for (int x = 0; x < numbers.length; x++) {
      max = max > numbers[x] ? max : numbers[x];
    }
    min = numbers[0];
    for (int x = 0; x < numbers.length; x++) {
      min = min < numbers[x] ? min : numbers[x];
    }
    System.out.print(min + " " + max);
    scanner.close();
  }
}
