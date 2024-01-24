// sychronized 스태틱 메소드 - 적용 전
package com.eomcs.concurrent.ex5;

public class Exam0510 {
  public static void main(String[] args) {
    Job j1 = new Job();
    Worker w1 = new Worker("홍길동", j1);
    Worker w2 = new Worker("임꺽정", j1);
    w1.start();
    w2.start();
  }

  static class Job {
    static void play(String threadName) throws Exception {
      System.out.println(threadName);
      Thread.sleep(10000);
    }
  }

  static class Worker extends Thread {
    Job job;

    public Worker(String name, Job job) {
      super(name);
      this.job = job;
    }

    @Override
    public void run() {
      try {
        job.play(getName());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
