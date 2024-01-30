package algorithm.test.baekjoon.level06.exam06;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    String str = sc.nextLine();
    int count = 0;

    for (int i = 0; i < str.length();) {
      if (str.charAt(i) == 'c') {
        if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
          i += 2;
        } else {
          i++;
        }
      } else if (str.charAt(i) == 'd') {
        if (str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=') {
          i += 3;
        } else if (str.charAt(i + 1) == '-') {
          i += 2;
        } else {
          i++;
        }
      } else if (str.charAt(i) == 'l' && str.charAt(i + 1) == 'j') {
        i += 2;
      } else if (str.charAt(i) == 'n' && str.charAt(i + 1) == 'j') {
        i += 2;
      } else if (str.charAt(i) == 's' && str.charAt(i + 1) == '=') {
        i += 2;
      } else if (str.charAt(i) == 'z' && str.charAt(i + 1) == '=') {
        i += 2;
      } else {
        i++;
      }
      count++;
    }
    System.out.println(count);
    sc.close();
  }
}


