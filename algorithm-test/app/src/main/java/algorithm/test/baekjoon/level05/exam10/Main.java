package algorithm.test.baekjoon.level05.exam10;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    char[] str = sc.nextLine().toCharArray();;
    int total = 0;

    for (int i = 0; i < str.length; i++) {
      if (str[i] == ' ') {
        total += 2;
      } else if (str[i] >= 65 && str[i] <= 67) {
        total += 3;
      } else if (str[i] >= 68 && str[i] <= 70) {
        total += 4;
      } else if (str[i] >= 71 && str[i] <= 73) {
        total += 5;
      } else if (str[i] >= 74 && str[i] <= 76) {
        total += 6;
      } else if (str[i] >= 77 && str[i] <= 79) {
        total += 7;
      } else if (str[i] >= 80 && str[i] <= 83) {
        total += 8;
      } else if (str[i] >= 84 && str[i] <= 86) {
        total += 9;
      } else if (str[i] >= 87 && str[i] <= 90) {
        total += 10;
      } else {
        total += 11;
      }
    }
    System.out.println(total);
    sc.close();
  }
}
