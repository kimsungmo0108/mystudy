package algorithm.test.baekjoon.level02.exam02;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner intScan = new java.util.Scanner(System.in);
    int a = intScan.nextInt();

    if (90 <= a && a <= 100) {
      System.out.println("A");
    } else if (80 <= a && a <= 89) {
      System.out.println("B");
    } else if (70 <= a && a <= 79) {
      System.out.println("C");
    } else if (60 <= a && a <= 69) {
      System.out.println("D");
    } else
      System.out.println("F");
  }
}
