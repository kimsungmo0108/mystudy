package algorithm.test.baekjoon.level04.exam10;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    double[] score = new double[n];
    double max = 0.0;
    double total = 0.0;
    for (int i = 0; i < n; i++) {
      score[i] = scanner.nextDouble();
    }
    for (int i = 0; i < n - 1; i++) {
      max = score[i] > score[i + 1] ? score[i] : score[i + 1];
    }
    for (int i = 0; i < n; i++) {
      score[i] = score[i] / max * 100;
      total += score[i];
    }
    System.out.println(max);
    System.out.println(total / n);
    scanner.close();
  }
}
