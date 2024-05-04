package algorithm.test.baekjoon.level07.exam04;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    int n = sc.nextInt();
    int[][] arr = new int[100][100];
    int math = n * 100;
    for (int i = 0; i < n; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      for (int j = b; j < b + 10; j++) {
        for (int k = a; k < a + 10; k++) {
          arr[j][k] = 1;
        }
      }
    }
    int cnt = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] == 1)
          cnt++;
      }
    }
    System.out.println(cnt);

    sc.close();
  }
}
