package bitcamp.util;

public class StackTest {

  public static void main(String[] args) {
    Stack<String> str = new Stack<>();
    str.push("aaa");
    str.push("bbb");
    str.push("ccc");
    str.push("ddd");

    while (!str.empty()) {
      System.out.println(str.pop());
    }

//    for (Object value : str.toArray(new String[0])) {
//      System.out.printf("%s, ", value);
//    }
  }

}
