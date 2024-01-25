package algorithm.test.baekjoon.level06.exam04;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    String str = sc.nextLine();
    char[] chars = new char[str.length()];
    byte b = 0;
    str.getChars(0, str.length(), chars, 0);
    for (int i = 0; i <= (str.length() / 2); i++) {
      if (chars[i] == chars[str.length() - 1 - i]) {
        b = 1;
      } else if (chars[i] != chars[str.length() - 1 - i]) {
        b = 0;
        break;
      }
    }

    System.out.println(b);
  }
}


