package algorithm.test.baekjoon.level06.exam02;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    int[] chess1 = {1, 1, 2, 2, 2, 8};
    int[] chess2 = new int[6];
    for (int i = 0; i < 6; i++) {
      int a = sc.nextInt();
      if ((chess1[i] - a) == 0) {
        continue;
      } else {
        chess2[i] = chess1[i] - a;
      }
    }

    for (int i : chess2) {
      System.out.printf("%d ", i);
    }
    sc.close();
  }
}


