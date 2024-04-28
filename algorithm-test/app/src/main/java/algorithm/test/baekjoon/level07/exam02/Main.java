package algorithm.test.baekjoon.level07.exam02;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    int[][] num = new int[9][9];
    int max = -1;
    int x = -1;
    int y = -1;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        num[i][j] = sc.nextInt();
      }
    }
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (max < num[i][j]) {
          max = num[i][j];
          x = i;
          y = j;
        }
      }
    }
    System.out.printf("%d \n%d %d", max, x + 1, y + 1);

    sc.close();
  }
}
