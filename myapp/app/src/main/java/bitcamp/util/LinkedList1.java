package bitcamp.util;

public class LinkedList1 {

  Node1 first;
  Node1 last;
  int size;

  public void add(Object value) {
    Node1 node = new Node1();
    node.value = value;
    if (first == null) {
      first = last = node;
    } else {
      last.next = node;
      last = node;
    }
    size++;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size];
    Node1 node = first;
    for (int i = 0; i < size; i++) {
      arr[i] = node.value;
      node = node.next;
    }
    return arr;
  }

  public Object get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    Node1 node;
    if (index == 0) {
      node = first;
    } else if (index == size - 1) {
      node = last;
    } else {
      node = first;
      for (int i = 0; i < index; i++) {
        node = node.next;
      }
    }

    return node.value;
  }

  public Object set(int index, Object value) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    Node1 node = first;
    if (index == 0) {
      node.value = value;
    } else if (index == size - 1) {
      last.value = value;
    } else {
      for (int i = 0; i < index; i++) {
        node = node.next;
      }
      node.value = value;
    }
    return node.value;
  }

  public void add(int index, Object value) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }
    Node1 old = first;
    Node1 node = new Node1();
    node.value = value;
    if (first == null) {
      first = last = node;
    } else if (index == 0) {
      node.next = first;
      first = node;
    } else if (index == size) {
      last.next = node;
      last = node;
    } else {
      for (int i = 0; i < index - 1; i++) {
        old = old.next;
      }
      node.next = old.next;
      old.next = node;
    }
    size++;
  }

  public Object remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    Node1 old = first;
    Node1 node = new Node1();
    if (first == last) {
      node.value = first.value;
      first = last = null;
    } else if (index == 0) {
      node.value = first.value;
      first = first.next;
    } else {
      for (int i = 0; i < index - 1; i++) {
        old = old.next;
      }
      if (index == (size - 1)) {
        last.next = null;
      }
      node.value = old.next.value;
      old.next = old.next.next;
    }
    size--;
    return node.value;
  }

  public boolean remove(Object value) {
    Node1 node = first;
    Node1 old = null;

    for (int i = 0; i < size; i++) {
      if (node.value.equals(value)) {
        break;
      }
      old = node;
      node = node.next;
    }

    if (node == null) {
      return false;
    }

    if (node == first) {
      first = first.next;
      if (first == null) {
        last = null;
      }
    } else {
      old.next = node.next;
    }

    size--;
    return true;
  }
}
