package algorithm.test.baekjoon.level03.exam10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line = reader.readLine();
    int a = Integer.parseInt(line);
    int x = 1;
    int x2 = a - 1;
    for (int i = 1; i <= a; i++) {
      for (int j = x2; j > 0; j--) {
        writer.write(" ");
      }
      for (int j = 1; j <= x; j++) {
        writer.write("*");
      }
      x2--;
      x++;
      writer.newLine();
    }

    writer.flush();
  }
}
