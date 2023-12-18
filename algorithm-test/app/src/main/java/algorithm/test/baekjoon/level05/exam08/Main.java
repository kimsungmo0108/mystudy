package algorithm.test.baekjoon.level05.exam08;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String S = input.nextLine();

    if (S.equals(" ")) {
      System.out.println(0);
    } else {
      S = S.strip();
      String[] Sarr = S.split(" ");
      System.out.println(Sarr.length);
    }
    input.close();
  }
}
