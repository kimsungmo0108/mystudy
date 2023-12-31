package com.eomcs.oop.ex02.step06;

// # 관련된 기능(메서드)을 묶어 분류하기
// 1) 분류 전
// 2) 메서드를 클래스로 묶어 분류하기
// 3) 클래스 변수 도입
//
public class App {



  public static void main(String[] args) {

    // 다음 식을 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
    // 2 + 3 - 1 * 7 / 3 = ?

    // 계산 결과를 보관할 변수는 더이상 필요가 없다.
    // Calculator 내부에서 계산 결과를 관리한다.
    // int result = 0;
    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    c1.plus(2);
    c2.plus(3); // + 3
    c1.plus(3);
    c2.multiple(2); // + 3 * 2
    c1.minus(1);
    c2.plus(7); // + 3 * 2 + 7
    c1.multiple(7);
    c2.divide(4); // + 3 * 2 + 7 / 4
    c1.divide(3);
    c2.minus(5); // + 3 * 2 + 7 / 4 - 5 = ?
    System.out.printf("result = %d\n", c1.result);
    System.out.printf("result = %d\n", c1.result);
    // 식2 계산:
    // 다른 식을 계산하기 전에 기존의 계산 결과를 갖고 있는
    // result 변수를 0으로 초기화시켜야 한다.
    // Calculator.result = 0;

  }
}

