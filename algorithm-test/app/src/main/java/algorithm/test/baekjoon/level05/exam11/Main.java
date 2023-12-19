package algorithm.test.baekjoon.level05.exam11;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str;

    while (sc.hasNext()) {
      str = sc.nextLine();
      System.out.println(str);
      if (str.equalsIgnoreCase("exit")) {
        break;
      }
    }

    sc.close();
  }
}
