package membership;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import membership.dao.MemberDao;
import membership.dao.mysql.MemberDaoImpl;
import membership.handler.member.MemberAddHandler;
import membership.handler.member.MemberDeleteHandler;
import membership.handler.member.MemberListHandler;
import membership.handler.member.MemberModifyHandler;
import membership.handler.member.MemberViewHandler;
import menu.MenuGroup;
import util.Prompt;

public class ServerApp {

  ExecutorService executorService = Executors.newCachedThreadPool();
  MemberDao memberDao;
  MenuGroup mainMenu;
  String superRoot = "1111";

  ServerApp() {
    prepareDatabase();
    prepareMenu();
  }


  public static void main(String[] args) {
    System.out.println("회원관리 시스템 서버 실행!");
    new ServerApp().run();
  }

  void prepareDatabase() {
    try {
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://db-ld2ag-kr.vpc-pub-cdb.ntruss.com/studydb", "study", "Bitcamp!@#123");

      memberDao = new MemberDaoImpl(con);

    } catch (Exception e) {
      System.out.println("통신 오류!");
      e.printStackTrace();
    }
  }

  void prepareMenu() {
    mainMenu = MenuGroup.getInstance("메인");

    MenuGroup memberMenu = mainMenu.addGroup("회원");
    memberMenu.addItem("등록", new MemberAddHandler(memberDao));
    memberMenu.addItem("조회", new MemberViewHandler(memberDao));
    memberMenu.addItem("변경", new MemberModifyHandler(memberDao));
    memberMenu.addItem("삭제", new MemberDeleteHandler(memberDao));
    memberMenu.addItem("목록", new MemberListHandler(memberDao, superRoot));

  }

  void processRequest(Socket socket) {
    try (Socket s = socket;
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        DataInputStream in = new DataInputStream(s.getInputStream());
        Prompt prompt = new Prompt(in, out)) {

      while (true) {
        try {
          mainMenu.execute(prompt);
          prompt.print("[[quit!]]");
          prompt.end();
          prompt.close();
          break;
        } catch (Exception e) {
          System.out.println("예외 발생!");
          e.printStackTrace();
        }
      }

    } catch (Exception e) {
      System.out.println("클라이언 통신 오류!");
      e.printStackTrace();
    }
  }

  void run() {

      try (ServerSocket serverSocket = new ServerSocket(8888)) {
        while (true) {
          Socket socket = serverSocket.accept();
          executorService.execute(() -> processRequest(socket));
        }
      } catch (Exception e) {
        System.out.println("예외 발생!");
        e.printStackTrace();
      }
  }
}
