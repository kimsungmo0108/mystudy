package algorithm.test.baekjoon.level06.exam05;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    String str = sc.nextLine();
    int[] num = new int[26];
    int count = 0;
    int max = -1;
    int index = -1;

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) >= 65 && str.charAt(i) <= 96) {
        num[str.charAt(i) - 65] += 1;
      } else if (str.charAt(i) >= 97) {
        num[str.charAt(i) - 97] += 1;
      }
    }

    for (int j = 0; j < 26; j++) {
      if (max == num[j]) {
        count++;
      } else if (num[j] > max) {
        max = num[j];
        index = j;
        count = 0;
      }
    }

    if (count > 0) {
      System.out.println("?");
    } else {
      System.out.println((char) (index + 65));
    }
  }
}


