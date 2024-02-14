package membership;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import util.Prompt;

public class ClientApp {

  String serverAddress;

  int port;

  ClientApp server(String serverAddress) {
    this.serverAddress = serverAddress;
    return this;
  }

  ClientApp port(int port) {
    this.port = port;
    return this;
  }

  public static void main(String[] args) {

    new ClientApp().server("localhost").port(8888).run();
  }

  void run() {
    try (Socket socket = new Socket(serverAddress, port);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        Prompt prompt = new Prompt(System.in)) {
      while (true) {
        String response = in.readUTF();
        if(response.equals("[[quit!]]")){
          break;
        }
        System.out.print(response);
        String input = prompt.input("");
        out.writeUTF(input);

      }
    } catch (IOException e) {
      System.out.println("서버 통신 오류!");
      e.printStackTrace();
    }
  }
}
