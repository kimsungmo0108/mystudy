package algorithm.test.baekjoon.level06.exam07;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    int n = sc.nextInt();
    int[] abc;
    String str;
    int strcount = 0;
    int c = 0;
    for (int i = 0; i < n; i++) {
      str = sc.next();
      abc = new int[26];
      for (int j = 0; j < str.length(); j++) {
        c = str.charAt(j) - 97;
        abc[c] += 1;
        if (abc[c] > 0) {
        }
      }
    }

    // System.out.println(strcount);
  }
}


