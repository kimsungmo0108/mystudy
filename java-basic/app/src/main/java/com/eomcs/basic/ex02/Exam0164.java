// StringBuffer vs StringBuilder
package com.eomcs.basic.ex02;

public class Exam0164 {
  public static void main(String[] args) throws Exception {
    // StringBuffer strBuffer = new StringBuffer();
    StringBuilder strBuilder = new StringBuilder();

    Worker w1 = new Worker(strBuilder, "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    Worker w2 = new Worker(strBuilder, "--------------------------------------------------");
    Worker w3 = new Worker(strBuilder, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    Worker w4 = new Worker(strBuilder, "**************************************************");

    // 순차적으로 작업을 시키지 않고 동시에 진행한다
    // => Thread 객체에 대해 start()를 호출하면 run() 메소드를 실행시키고 즉시 리턴한다
    // => 즉 run() 메소드의 작업이 끝날 때까지 기다리지 않는다
    w1.start();
    w2.start();
    w3.start();
    w4.start();

    // 이전에 실행시킨 작업이 끝날 때까지
    // 2초 정도 기다렸다가 다음 명령을 실행한다
    Thread.currentThread().sleep(2000);
    System.out.println("실행 끝!");
    System.out.println(strBuilder.length());

  }


  // 하는 일 :
  // - 주어진 메시지를 버퍼에 100번 담는 일을 한다
  //
  static class Worker extends Thread {
    String massage;
    StringBuilder strBuilder;

    public Worker(StringBuilder strBuilder, String massage) {
      this.strBuilder = strBuilder;
      this.massage = massage;
    }

    @Override
    public void run() {
      for (int i = 0; i < 100; i++) {
        strBuilder.append(massage);
      }
      System.out.printf("\'%s\' 메시지 저장 끝! \n", massage);
    }
  }

}


