package algorithm.test.baekjoon.level06.exam03;


public class Main {
  public static void main(String[] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i <= n; i = i + 2) {
      for (int k = n - 1; k > 0; k--) {
        System.out.print(" ");
      }

      System.out.print("*");
      for (int j = 1; j < i + 1; j++) {
        System.out.print("*");
      }
      System.out.print("\n");
    }
  }
}


