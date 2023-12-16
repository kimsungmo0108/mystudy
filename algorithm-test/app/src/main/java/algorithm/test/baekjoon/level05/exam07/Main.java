package algorithm.test.baekjoon.level05.exam07;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    String[] str = new String[n];
    int[] length = new int[n];
    for (int i = 0; i < n; i++) {
      length[i] = Integer.parseInt(scanner.next());
      str[i] = scanner.next();
    }
    for (int i = 0; i < n; i++) {
      for (int k = 0; k < str[i].length(); k++) {
        for (int j = 0; j < length[i]; j++) {
          System.out.print(str[i].charAt(k));
        }
      }
      System.out.println();
    }
    scanner.close();
  }
}
