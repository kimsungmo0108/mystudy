package bitcamp.util;


// 수퍼 크랠스ㅡ이 레퍼런스는 서브 클래스의 인스턴스 주소를 담을 수 있다
// 따라서 Object 레퍼런스는 Memeber, Assignment, Board 등 어떤 객체의 주소라도 담을 수 있다
public class ObjectRepository<E> {

  // 목록에 관련된 코드를 외부에서 볼 수 없게 감춘다
  private Object[] objects = new Object[3];

  private int length = 0;
  // 대신 목록에 값을 추가하거나, 꺼내거나 삭제하려면
  // 메소드를 통해 수행하도록 유도한다
  // => Encapsulation

  public void add(E object) {
    if (this.length == this.objects.length) {
      int oldSize = this.objects.length;
      int newSize = oldSize + (oldSize >> 1);

      Object[] arr = new Object[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.objects[i];
      }

      this.objects = arr;
    }
    this.objects[this.length++] = object;
  }

  public E remove(int index) {

    if (index < 0 || index >= this.length) {
      return null;
    }

    // 배열에서 삭제하기 전에 임시 보관 해둔다
    Object deleted = this.objects[index];

    for (int i = index; i < (this.length - 1); i++) {
      this.objects[i] = this.objects[i + 1];
    }
    this.objects[--this.length] = null;

    //삭제한 객체를 리턴한다
    // 받아서 쓰던가 말던가 호출하는 쪽에서 알아서 할 일이다
    return (E) deleted;
  }

  public Object[] toArray() {
    Object[] arr = new Object[this.length];
    for (int i = 0; i < this.length; i++) {
      arr[i] = this.objects[i];
    }
    return arr;
  }

  public void toArray(E[] arr) {
    for (int i = 0; i < this.length; i++) {
      arr[i] = (E) this.objects[i];
    }
    //return arr;
  }

  public E get(int index) {
    if (index < 0 || index >= this.length) {
      //System.out.println("번호가 유효하지 않습니다.");
      return null;
    }
    return (E) this.objects[index];
  }

  public E set(int index, E object) {
    if (index < 0 || index >= this.length) {
      return null;
    }
    Object old = this.objects[index];
    this.objects[index] = object;

    // 새 객체로 교체하기 전에 이전 객체를 리턴한다
    // 호출하는 쪽에서 받아 스거나 말거나 알아서 하라고!?!?!?!?!?!?!?!?
    return (E) old;
  }

  public int size() {
    return this.length;
  }
}
