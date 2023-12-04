package com.eomcs.oop.ex02.test.util;

public class Calculator {
  public int result = 0;

  public void plus(int b) {
    this.result += b;
  }

  public void minus(int b) {
    this.result -= b;
  }

  public void multiple(int b) {
    this.result *= b;
  }

  public void divide(int b) {
    this.result /= b;
  }

}
