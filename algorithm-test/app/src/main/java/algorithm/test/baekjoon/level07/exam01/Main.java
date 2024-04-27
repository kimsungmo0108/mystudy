package algorithm.test.baekjoon.level07.exam01;

public class Main {
  public static void main(String[] args) {

    java.util.Scanner sc = new java.util.Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] num1 = new int[n][m];
    int[][] num2 = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        num1[i][j] = sc.nextInt();
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        num2[i][j] = sc.nextInt();
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.printf("%d ", num1[i][j] + num2[i][j]);
      }
      System.out.println();
    }
  }
}
