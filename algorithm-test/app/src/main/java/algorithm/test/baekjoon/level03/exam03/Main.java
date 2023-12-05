package algorithm.test.baekjoon.level03.exam03;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner intScan = new java.util.Scanner(System.in);
    int a = intScan.nextInt();
    int sum = 0;
    for (int i = 1; i <= a; i++) {
      sum += i;
    }
    System.out.println(sum);
    intScan.close();
  }
}

