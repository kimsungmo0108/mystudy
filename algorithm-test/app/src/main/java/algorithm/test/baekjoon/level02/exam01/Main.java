package algorithm.test.baekjoon.level02.exam01;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner intScan = new java.util.Scanner(System.in);
    int a = intScan.nextInt();
    int b = intScan.nextInt();

    if (a > b) {
      System.out.println(">");
    } else if (a < b) {
      System.out.println("<");
    } else
      System.out.println("==");
  }
}
