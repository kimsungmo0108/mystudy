package algorithm.test.baekjoon.level06.exam02;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    int n = 128, i, result = 0;
    for (i = 1; i < n; i++) {
      if (n % i == 0) {
        result += i;
      }
    }
    System.out.println(result);
    sc.close();
  }
}
