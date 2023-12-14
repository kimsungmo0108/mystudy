package algorithm.test.baekjoon.level05.exam01;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();
    int index = scanner.nextInt();
    System.out.println(str.charAt(index - 1));


    scanner.close();
  }
}
