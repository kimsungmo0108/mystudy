// sychronized 인스턴스 메소드 - 적용 후
package com.eomcs.concurrent.ex5;

public class Exam0620 {
  public static void main(String[] args) {
    Job j1 = new Job();
    Worker1 w1 = new Worker1("홍길동", j1);
    Worker2 w2 = new Worker2("김길동", j1);
    Worker3 w3 = new Worker3("고길동", j1);
    Worker4 w4 = new Worker4("조승우", j1);

    w1.start();
    w2.start();
    w3.start();
    w4.start();
  }

  static class Job {
    // 같은 변수(=인스턴스)에 대해 여러 스레드가 동시에 진입하는 것을 막는다.
    // 만약 다른 변수(=인스턴스)라면?
    // - 막지 않는다.
    synchronized void play1(String threadName) throws Exception {
      System.out.println(threadName + ".play1() 호출함!");
      Thread.sleep(10000);
    }

    synchronized void play2(String threadName) throws Exception {
      System.out.println(threadName + ".play2() 호출함!");
      Thread.sleep(10000);
    }

    synchronized void play3(String threadName) throws Exception {
      System.out.println(threadName + ".play3() 호출함!");
      Thread.sleep(10000);
    }
  }

  static class Worker1 extends Thread {
    Job job;

    public Worker1(String name, Job job) {
      super(name);
      this.job = job;
    }

    @Override
    public void run() {
      try {
        job.play1(getName());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }

  static class Worker2 extends Thread {
    Job job;

    public Worker2(String name, Job job) {
      super(name);
      this.job = job;
    }

    @Override
    public void run() {
      try {
        job.play2(getName());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }

  static class Worker3 extends Thread {
    Job job;

    public Worker3(String name, Job job) {
      super(name);
      this.job = job;
    }

    @Override
    public void run() {
      try {
        job.play3(getName());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }
  static class Worker4 extends Thread {
    Job job;

    public Worker4(String name, Job job) {
      super(name);
      this.job = job;
    }

    @Override
    public void run() {
      try {
        job.play1(getName());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }
}
