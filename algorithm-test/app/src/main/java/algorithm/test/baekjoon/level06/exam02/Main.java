package algorithm.test.baekjoon.level06.exam02;

public class Main {
  public static void main(String[] args) {
    Thread thread = new Thread(() -> {
      System.out.println("작업 스레드가 실행됩니다");
      System.out.println("작업 스레드가 실행됩니다");
      System.out.println("작업 스레드가 실행됩니다");
    });
    thread.start();
  }
}
