package algorithm.test.baekjoon.level05.exam09;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String a = sc.next();
    String b = sc.next();
    String c = "";
    String d = "";
    int alen = a.length();
    int blen = b.length();
    String[] a2 = a.split("");
    String[] b2 = b.split("");
    for (int i = 0; i <= alen; i++) {
      String t = a2[i];
      a2[i] = a2[alen - 1];
      a2[alen - 1] = t;
      alen--;
    }
    for (int i = 0; i <= blen; i++) {
      String t = b2[i];
      b2[i] = b2[blen - 1];
      b2[blen - 1] = t;
      blen--;
    }
    for (int i = 0; i < a.length(); i++) {
      c += a2[i];
    }
    for (int i = 0; i < b.length(); i++) {
      d += b2[i];
    }
    if (Integer.parseInt(c) > Integer.parseInt(d)) {
      System.out.println(Integer.parseInt(c));
    } else
      System.out.println(Integer.parseInt(d));
    sc.close();
  }
}
