package algorithm.test.baekjoon.level03.exam08;

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
    int i = 0;
    int a = Integer.parseInt(line);
    int[] aArr = new int[a];
    int[] bArr = new int[a];
    int temp = 0;
    while (i < a) {
      String[] input = reader.readLine().split(" ");
      aArr[i] = Integer.parseInt(input[0]);
      bArr[i] = Integer.parseInt(input[1]);
      i++;
    }
    for (int j = 0; j < a; j++) {
      temp = aArr[j] + bArr[j];
      writer.write("Case #" + String.valueOf(j + 1) + ": " + aArr[j] + " + " + bArr[j] + " = ");
      writer.write(String.valueOf(temp));
      writer.newLine();
    }
    writer.flush();
  }
}
