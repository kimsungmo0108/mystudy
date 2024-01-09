// List 와 forEach() - forEach() 사용 후
package com.eomcs.oop.ex12;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Exam0920 {

  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<>();
    names.add("홍길동");
    names.add("임꺽정");
    names.add("유관순");
    names.add("김구");
    names.add("안중근");

    class MyConsumer<T> implements Consumer<T> {
      @Override
      public void accept(T item) {
        System.out.println(item);
      }
    }
    // 이 메소드는 list의 각 항목을 반복할 때마다 호출된다
    // 따라서 list에 대해 반복문을 돌면서 각 항목에 대해 처리할 작업이 있다면
    // 이 메소드에 작성한다
    names.forEach(new MyConsumer<String>());


    //
    // public void forEach(Consumer<? super E> action) {
    // for(E value : this) {
    // action.accept(value);
    // }
    // }
  }
}
