// 메서드 레퍼런스 - 활용예
package com.eomcs.oop.ex12;

import java.util.function.Predicate;

public class Exam0640 {

  static class My {
    public boolean m() {
      return true;
    }
  }


  public static void main(String[] args) {
    // interface Predicate<T>{
    // boolean test (T value);
    // ...
    // }

    // Predicate<String> p1 = My::m; // 컴파일 오류
    // 1. static 메소드가 아니다
    // 2. String 파라미터가 없다

    // My obj = new My();
    // Predicate<String> p2 = obj::m; // 컴파일 오류
    // 1. My의 m()는 String 파라미터를 못 받는다

    // 기존의 My의 m()을 test() 메소드를 구현하는데 사용하기
    Predicate<My> p1 = (My value) -> {
      return value.m();
    };
    // 코드를 좀 더 줄이기
    Predicate<My> p2 = value -> value.m();

    // 코드를 더 줄이기 - 바로 위의 코드를 작성하는 경우가 많다 보니 다음과 같은 문법이 등장!
    Predicate<My> p3 = My::m; // OK!

    // 위와 같이 단축 문법을 사용하려면,
    // 타입 파라미터의 클래스가 인스턴스 메소드의 클래스랑 같아야 한다
    // 즉 다음과 같이 람다 문법으로 변경될 수 있어야 한다
    // => Predicate<My> p3 = (My value) -> {return value.m();};
    p1.test(new My());
    p2.test(new My());
    p3.test(new My());

  }

}


