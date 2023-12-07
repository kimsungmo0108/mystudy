package bitcamp.util;

import java.io.InputStream;
import java.util.Scanner;

public class Prompt {

  Scanner KEY_IN;

  public Prompt(InputStream in) {
    KEY_IN = new Scanner(in);
  }

  //가변 파라미터는 맨 뒤에 와야한다
  public String input(String title, Object... args) {
    System.out.print(String.format(title, args));
    return this.KEY_IN.nextLine();
  }

  public int inputInt(String title, Object... args) {
    String str = this.input(title, args);
    return Integer.parseInt(str);
  }

  public float inputFloat(String title, Object... args) {
    String str = this.input(title, args);
    return Float.parseFloat(str);
  }

  public boolean inputBoolean(String title, Object... args) {
    String str = this.input(title, args);
    return Boolean.parseBoolean(str);
  }

  public void close() {
    this.KEY_IN.close();
  }
}
