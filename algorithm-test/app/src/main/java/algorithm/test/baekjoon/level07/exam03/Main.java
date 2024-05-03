package algorithm.test.baekjoon.level07.exam03;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    char[] cArr1 = sc.next().toCharArray();
    char[] cArr2 = sc.next().toCharArray();
    char[] cArr3 = sc.next().toCharArray();
    char[] cArr4 = sc.next().toCharArray();
    char[] cArr5 = sc.next().toCharArray();

    for (int i = 0; i < 15; i++) {
      if (cArr1.length > i) {
        System.out.print(cArr1[i]);
      }
      if (cArr2.length > i) {
        System.out.print(cArr2[i]);
      }
      if (cArr3.length > i) {
        System.out.print(cArr3[i]);
      }
      if (cArr4.length > i) {
        System.out.print(cArr4[i]);
      }
      if (cArr5.length > i) {
        System.out.print(cArr5[i]);
      }
    }

    sc.close();
  }
}
