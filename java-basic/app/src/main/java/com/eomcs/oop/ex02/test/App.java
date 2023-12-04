package com.eomcs.oop.ex02.test;

import com.eomcs.oop.ex02.test.util.Calculator;

// import com.eomcs.oop.ex02.step04.Calculator;

// # 관련된 기능(메서드)을 묶어 분류하기
// 1) 분류 전
// 2) 메서드를 클래스로 묶어 분류하기
// 3) 클래스 변수 도입
// 4) 클래스 변수의 한계 확인
// 5) 인스턴스 변수 도입
// 6) 인스턴스 메서드 활용
// 7) 클래스를 역할에 따라 패키지로 분류하기
//
public class App {

  public static void main(String[] args) {
    Calculator a = new Calculator();
    Calculator b = new Calculator();

    a.plus(2);
    a.plus(3);
    a.minus(1);
    a.multiple(7);
    a.divide(3);

    System.out.printf("result = %d\n", a.result);

    b.plus(2);
    b.plus(3);
    b.minus(1);
    b.multiple(7);
    b.divide(3);

    System.out.printf("result = %d\n", b.result);


  }


}

