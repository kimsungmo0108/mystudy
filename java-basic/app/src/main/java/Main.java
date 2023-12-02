import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader red = new BufferedReader(new InputStreamReader(System.in));
    String a = red.readLine();
    int t = Integer.parseInt(a);
    int[] aArr = new int[t];
    int[] bArr = new int[t];

    for (int i = 0; i < t; i++) {
      // aArr[i] = red.readLine();
      aArr[i] = Integer.parseInt(red.readLine());
      // bArr[i] = Integer.parseInt(red.readLine());
    }
    buf.write(aArr);
    // buf.write(String.valueOf(aArr));
    // for (int j = 0; j < t; j++) {
    // buf.write(String.valueOf(aArr[j] + bArr[j]) + "\n");
    // }

    red.close();
    buf.flush();
    buf.close();
  }
}
