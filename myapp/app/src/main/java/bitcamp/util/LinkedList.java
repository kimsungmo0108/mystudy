package bitcamp.util;

public class LinkedList {

  private Node first;
  private Node last;
  private int size;

  public void add(Object value) {
    Node node = new Node();
    node.value = value;

    if (last == null) {
      // 노드 객체가 없을 때
      first = last = node;
    } else {
      // 기존에 노드 객체가 있을 때
      // 마지막 노드의 다음 노드로 새로 만든 노드를 가리키게 한다
      last.next = node;
      last = node;
    }
    size++;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size];
    int index = 0;
    Node node = first;
    while (node != null) {
      arr[index++] = node.value;
      node = node.next;
    }
    return arr;
  }

}
