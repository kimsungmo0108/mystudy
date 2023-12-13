package algorithm.test.baekjoon.level04.exam10;

import java.util.Scanner;

public class Main1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    double[] score = new double[n];
    double max = 0.0;
    double total = 0.0;
    for (int i = 0; i < n; i++) {
      score[i] = scanner.nextDouble();
    }
    for (int i = 0; i < n; i++) {
      if (score[i] > max) {
        max = score[i];
      }
    }
    for (int i = 0; i < n; i++) {
      score[i] = score[i] / max * 100;
      total += score[i];
    }
    System.out.println(total / n);
    scanner.close();
  }
}
