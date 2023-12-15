package algorithm.test.baekjoon.level05.exam06;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = scanner.next();
    int[] abc = new int[26];
    int length = str.length();
    for (int i = 0; i < 26; i++) {
      abc[i] = -1;
    }
    for (int i = 0; i < length; i++) {
      if (abc[str.charAt(i) - 97] == -1) {
        abc[str.charAt(i) - 97] = i;
      }
    }
    for (int i = 0; i < 26; i++) {
      System.out.print(abc[i] + " ");
    }
    scanner.close();
  }
}
