package algorithm.test.baekjoon.level06.exam03;


public class Main {
  public static void main(String[] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i < n + 1; i++) {
      for (int j = n - i; j > 0; j--) {
        System.out.print(" ");
      }
      for (int k = 0; k < ((i - 1) * 2) + 1; k++) {
        System.out.print("*");
      }
      System.out.print("\n");
    }

    for (int i = n - 1; i > 0; i--) {
      for (int j = 1; j < n - i + 1; j++) {
        System.out.print(" ");
      }
      for (int k = ((i - 1) * 2) + 1; k > 0; k--) {
        System.out.print("*");
      }
      System.out.print("\n");
    }
    sc.close();
  }
}


