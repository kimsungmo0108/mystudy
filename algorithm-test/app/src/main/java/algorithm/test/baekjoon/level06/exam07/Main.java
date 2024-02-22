package algorithm.test.baekjoon.level06.exam07;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    int n = sc.nextInt();
    int[] abc;
    String str;
    int strCount = n;
    int now = 0;
    int prev;
    for (int i = 0; i < n; i++) {
      str = sc.next();
      abc = new int[26];
      prev = 0;

      for (int j = 0; j < str.length(); j++) {
        now = str.charAt(j);
        if (prev != now) {
          if (abc[now - 97] == 0) {
            abc[now - 97] = 1;
            prev = now;
          } else {
            strCount--;
            break;
          }
        }
      }
    }
    sc.close();
    System.out.println(strCount);
  }
}


