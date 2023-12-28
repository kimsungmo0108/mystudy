package bitcamp.util;

import java.util.Arrays;

public class LinkedList<E> {

  private Node<E> first;
  private Node<E> last;
  private int size;

  public int size() {
    return size;
  }

  public void add(E value) {
    Node<E> node = new Node<>();
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
    Node<E> node = first;
    while (node != null) {
      arr[index++] = node.value;
      node = node.next;
    }
    return arr;
  }

  public E[] toArray(E[] arr) {
    E[] values = arr;
    if (values.length < size) {
      values = Arrays.copyOf(arr, size);
    }

    int i = 0;
    Node<E> node = first;
    while (node != null) {
      values[i++] = node.value;
      node = node.next;
    }
    return values;
  }

  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다");
    }
    int cursor = 0;
    Node<E> node = first;
    while (cursor++ < index) {
      node = node.next;
    }
    return node.value;
  }

  public E set(int index, E value) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다");
    }
    int cursor = 0;
    Node<E> node = first;
    while (cursor++ < index) {
      node = node.next;
    }
    E old = node.value;
    node.value = value;
    return old;
  }

  public void add(int index, E value) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다");
    }
    Node<E> node = new Node<>();
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
      Node<E> currNode = first;
      //Node tempNode = new Node();
      int cursor = 0;
      while (++cursor < index) {
        //tempNode = currNode;
        currNode = currNode.next;
      }
      //tempNode.next = node;
      //node.next = currNode;
      node.next = currNode.next;
      currNode.next = node;
    }
    size++;
  }

  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다");
    }

    Node<E> currNode = first;
    Node<E> deleted = null;
    int cursor = 0;

    if (size == 1) {
      deleted = first;
      first = last = null;
    } else if (index == 0) {
      deleted = first;
      first = first.next;
    } else {
      while (++cursor < index) {
        currNode = currNode.next;
      }
      deleted = currNode.next;
      currNode.next = currNode.next.next;

      if (index == size - 1) {
        last = currNode;
      }
    }
    size--;
    E old = deleted.value;
    deleted.value = null;
    deleted.next = null;
    return old;
  }

  public boolean remove(E value) {
    Node<E> prevNode = null;
    Node<E> node = first;

    for (int i = 0; i < size; i++) {
      if (node.value.equals(value)) {
        break;
      }
      prevNode = node;
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
      prevNode.next = node.next;
    }

    size--;
    return true;
  }


  private static class Node<E> {

    E value;
    Node<E> next;

  }
}
