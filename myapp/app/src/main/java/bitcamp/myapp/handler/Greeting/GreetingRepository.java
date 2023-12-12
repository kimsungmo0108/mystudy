package bitcamp.myapp.handler.Greeting;

import bitcamp.myapp.vo.Board;

// 게시글 데이터를 보관하는 일을 한다
//
public class GreetingRepository {

  private Board[] greetings = new Board[3];
  private int length = 0;

  public void add(Board board) {
    if (this.length == this.greetings.length) {
      int oldSize = this.greetings.length;
      int newSize = oldSize + (oldSize >> 1);

      Board[] arr = new Board[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.greetings[i];
      }

      this.greetings = arr;
    }

    this.greetings[this.length++] = board;
  }

  public Board remove(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }

    Board arr = this.greetings[index];

    for (int i = index; i < (this.length - 1); i++) {
      this.greetings[i] = this.greetings[i + 1];
    }
    this.greetings[--this.length] = null;

    return arr;
  }

  public Board[] toArray() {
    Board[] arr = new Board[this.length];
    for (int i = 0; i < this.length; i++) {
      arr[i] = this.greetings[i];
    }
    return arr;
  }

  public Board get(int index) {
    if (index < 0 || index >= this.length) {
      //System.out.println("번호가 유효하지 않습니다.");
      return null;
    }
    return this.greetings[index];
  }

  public Board set(int index, Board board) {
    if (index < 0 || index >= this.length) {
      return null;
    }
    Board old = this.greetings[index];
    this.greetings[index] = board;

    // 새 객체로 교체하기 전에 이전 객체를 리턴한다
    // 호출하는 쪽에서 받아 스거나 말거나 알아서 하라고!?!?!?!?!?!?!?!?
    return old;
  }
}
