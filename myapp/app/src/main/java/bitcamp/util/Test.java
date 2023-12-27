package bitcamp.util;

public class Test {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add(new String("aaa"));
    list.add(new String("bbb"));
    list.add(new String("ccc"));
    list.add(new String("ddd"));

    //list.add(0, new String("xxx"));
    list.add(0, new String("xxx"));
    list.add(3, new String("yyy"));
    list.add(6, new String("111"));

    for (Object value : list.toArray()) {
      System.out.printf("%s, ", value);
    }
    System.out.println();

//    try {
//      System.out.println(list.get(0));
//      System.out.println(list.get(1));
//      System.out.println(list.get(2));
//      System.out.println(list.get(3));
//      System.out.println(list.get(4));
//    } catch (Exception e) {
//      System.out.println(e.getMessage());
//    }
//
//    try {
//      System.out.println(list.set(0, "eee"));
//    } catch (Exception e) {
//      System.out.println(e.getMessage());
//    }

  }

}
