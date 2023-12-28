package bitcamp.util;

public class QueueTest {

  public static void main(String[] args) {
    Queue<String> q = new Queue<>();
    System.out.println(q.offer("aaa"));
    System.out.println(q.offer("bbb"));
    System.out.println(q.offer("ccc"));
    System.out.println(q.offer("ddd"));

    System.out.println(q.peek());
    System.out.println(q.poll());

    System.out.println(q.peek());
    System.out.println(q.poll());

    System.out.println(q.peek());
    System.out.println(q.poll());

    System.out.println(q.peek());
    System.out.println(q.poll());
  }

}
