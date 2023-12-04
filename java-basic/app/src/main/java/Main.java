// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.OutputStreamWriter;
// import java.util.StringTokenizer;
//
// public class Main {
// public static void main(String[] args) throws IOException {
// BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
// BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
// String i;
//
// while (true) {
// try {
// int num1 =
// int num2 =
//
// int sum = num1 + num2;
// System.out.println("덧셈 결과: " + sum);
// } catch (NumberFormatException e) {
// System.out.println("유효하지 않은 입력입니다. 숫자를 입력하세요.");
// }
// }
// bfr.close();
// bfw.flush();
// bfw.close();
// }
// }

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("무한히 숫자를 더합니다. 숫자를 입력하세요. 종료하려면 'exit'을 입력하세요.");

    int sum = 0;
    loop: while (scanner.hasNext()) {
      if (scanner.hasNextInt()) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(a + b);
      } else {
        String input = scanner.next();
        if (input.equalsIgnoreCase("exit")) {
          break;
        } else {
          break loop;

        }
      }
    }
    scanner.close();
  }
}
