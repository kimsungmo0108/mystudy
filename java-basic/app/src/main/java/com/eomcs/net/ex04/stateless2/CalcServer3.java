// stateless 방식에서 클라이언트를 구분하고 작업 결과를 유지하는 방법
package com.eomcs.net.ex04.stateless2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class CalcServer3 {

  // 특정 코드 실행을 main() 메소드 호출과 분리해서 별도로 실행시키기
  static class OtherExecution extends Thread {
    Socket socket;

    public OtherExecution(Socket socket) {
      super();
      this.socket = socket;
    }

    @Override
    public void run() {
      try (Socket socket2 = socket;
          DataInputStream in = new DataInputStream(socket.getInputStream());
          DataOutputStream out = new DataOutputStream(socket.getOutputStream());) {

        long clientId = in.readLong();

        String op = in.readUTF();
        int value = in.readInt();

        Integer obj = resultMap.get(clientId);
        int result = 0;

        if (obj != null) {
          System.out.printf("%d 기존 고객 요청 처리!\n", clientId);
          result = obj;
        } else {
          clientId = System.currentTimeMillis();
          System.out.printf("%d 신규 고객 요청 처리!\n", clientId);
        }

        String message = null;
        switch (op) {
          case "+":
            result += value;
            break;
          case "-":
            result -= value;
            break;
          case "*":
            result *= value;
            break;
          case "/":
            Thread.sleep(30000);
            result /= value;
            break;
          default:
            message = "해당 연산을 지원하지 않습니다.";
        }

        resultMap.put(clientId, result);

        out.writeLong(clientId);

        if (message == null) {
          message = String.format("계산 결과: %d", result);
        }
        out.writeUTF(message);
        out.flush();

      } catch (Exception e) {
        System.out.println("클라이언트 요청 처리 중 오류 발생!");
      }
    }
  }

  // 각 클라이언트의 작업 결과를 보관할 맵 객체
  // => Map<clientID, result>
  static Map<Long, Integer> resultMap = new HashMap<>();

  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행 중...");

    ServerSocket ss = new ServerSocket(8888);

    while (true) {
      Socket socket = ss.accept();
      System.out.println("클라이언트 요청 처리!");

      OtherExecution 클라이언트요청처리 = new OtherExecution(socket);
      클라이언트요청처리.start();
      // main() 메소드의 실행과 분리하여 별도로 run() 메소드를 호출한 후 즉시 리턴한다

    }
    // ss.close();
  }
}


