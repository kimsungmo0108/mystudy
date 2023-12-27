package bitcamp.util;

public class Test {

  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<>();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");

    //list.add(0, new String("xxx"));
    //list.add(5, new String("yyy"));
    //list.add(1, new String("mmm"));
    //list.add(3, new String("ttt"));
    //list.add(7, new String("ppp"));
//    System.out.println();

    System.out.println(list.remove("xxx"));
    System.out.println(list.remove("ccc"));
    System.out.println(list.remove("ddd"));
    System.out.println(list.remove("aaa"));
    System.out.println(list.remove("bbb"));
//    list.add("xxx");
//    list.add("yyy");
//    list.add("zzz");
    //list.add("ddd");
    //list.remove(2);
    //list.remove(0);
    //list.remove(0);
//    Node node1 = (Node) list.remove(2);
//    Node node2 = (Node) list.remove(2);
//    Node node3 = (Node) list.remove(0);
//    Node node4 = (Node) list.remove(0);
//    System.out.println(node1.value);
//    System.out.println(node2.value);
//    System.out.println(node3.value);
//    System.out.println(node4.value);
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
