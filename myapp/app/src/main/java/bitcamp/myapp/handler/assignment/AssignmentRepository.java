package bitcamp.myapp.handler.assignment;

import bitcamp.myapp.vo.Assignment;

public class AssignmentRepository {

  private Assignment[] assignments = new Assignment[3];
  private int length = 0;

  public void add(Assignment assignment) {
    if (this.length == this.assignments.length) {
      //System.out.println("과제를 더이상 등록할 수 없습니다.");
      int oldSize = this.assignments.length;
      int newSize = oldSize + (oldSize / 2);

      // 이전 배열에 들어 있는 값을 새 배열에 복사
      Assignment[] arr = new Assignment[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.assignments[i];
      }

      // 새 배열을 가리키도록 배열 레퍼런스를 변경
      this.assignments = arr;
    }
    this.assignments[this.length++] = assignment;
  }

  public Assignment remove(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }

    Assignment arr = this.assignments[index];
    for (int i = index; i < (this.length - 1); i++) {
      this.assignments[i] = this.assignments[i + 1];
      // 다음 레퍼런스의 값을 삭제하려는 현재 레퍼런스로 이동
    }
    this.assignments[--this.length] = null;

    return arr;
  }

  public Assignment[] toArray() {

    Assignment[] arr = new Assignment[this.length];
    for (int i = 0; i < this.length; i++) {
      arr[i] = this.assignments[i];
    }
    return arr;
  }

  public Assignment get(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }
    
    return this.assignments[index];
  }

  public Assignment set(int index, Assignment assignment) {
    if (index < 0 || index >= this.length) {
      return null;
    }

    Assignment arr = this.assignments[index];
    this.assignments[index] = assignment;
    return arr;
  }
}
