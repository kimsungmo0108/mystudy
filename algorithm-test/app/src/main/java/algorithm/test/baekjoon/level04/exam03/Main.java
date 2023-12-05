package algorithm.test.baekjoon.level04.exam03;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int i = scanner.nextInt();
    // int x = scanner.nextInt();
    int[] a = new int[i];
    int max = 0;
    int min = 0;
    for (int j = 0; j < i; j++) {
      a[j] = scanner.nextInt();
    }

    for (int j = 1; j < i; j++) {
      max = a[0];
      min = a[0];
      if (a[j - 1] >= a[j]) {
        if (a[j - 1] >= max) {
          max = a[j - 1];
        }
      } else if (a[j - 1] <= min) {
        min = a[j - 1];
      }
    }

    System.out.print(min + " " + max);
    scanner.close();
  }
}
