package com.eomcs.oop.ex02.step07.util;


public class Calculator {
  // 인스턴스 변수(= non-static 변수)
  // - 작업 결과를 개별적으로 관리하고 싶을 때 인스턴스 변수로 선언한다.
  // - 인스턴스 변수는 클래스가 로딩 될 때 만들어지지 않는다.
  // - new 명령을 사용해서 만들어야 한다.
  // - 변수 선언 앞에 static이 붙지 않는다.
  public int result = 0;

  // 다른 패키지에서 이 클래스와 멤버(필드 및 메소드)를 접근할 수 있도록 public으로 공개한다
  public void plus(int value) {
    this.result += value;
  }

  public void minus(int value) {
    this.result -= value;
  }

  public void multiple(int value) {
    this.result *= value;
  }

  public void divide(int value) {
    this.result /= value;
  }

  public static int abs(int a) {
    //
    // if (a >= 0)
    // return a;
    // else
    // return a * -1;
    //
    return a >= 0 ? a : a * -1;
  }
}
