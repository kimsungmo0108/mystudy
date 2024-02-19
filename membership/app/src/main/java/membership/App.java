package membership;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
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
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import util.Prompt;

public class App {

//  ExecutorService executorService = Executors.newCachedThreadPool();
//  MemberDao memberDao;
//  MenuGroup mainMenu;
//  String superRoot = "1111";

//  App() {
//    prepareDatabase();
//    prepareMenu();
//  }


  public static void main(String[] args) throws Exception {
    System.out.println("회원관리 시스템 서버 실행!");
    //new App().run();

    // 톰캣 서버를 구동시키는 객체 준비
    Tomcat tomcat = new Tomcat();

    // 서버의 포트 번호 설정
    tomcat.setPort(8888);

    // 톰캣 서버를 실행하는 동안 사용할 임시 폴더 지정
    tomcat.setBaseDir("./temp");

    // 톰캣 서버의 연결 정보를 설정
    Connector connector = tomcat.getConnector();
    connector.setURIEncoding("UTF-8");

    // 톰캣 서버에 배포할 웹 애플리케이션의 환경 정보 준비
    StandardContext ctx = (StandardContext) tomcat.addWebapp(
        "/", // 컨텍스트 경로(웹 애플리케이션 경로)
        new File("./src/main/webapp").getAbsolutePath() // 웹 애플리케이션 파일이 있는 실제 경로
    );
    ctx.setReloadable(true);

    // 웹 애플리케이션 기타 정보 설정
    WebResourceRoot resources = new StandardRoot(ctx);

    // 웹 애플리케이션의 서블릿 클래스 등록
    resources.addPreResources(new DirResourceSet(
        resources, // 루트 웹 애플리케이션 정보
        "/WEB-INF/classes", // 서블릿 클래스 파일의 위치 정보
        new File("build/classes/java/main").getAbsolutePath(), // 서블릿 클래스 파일이 있는 실제 경로
        "/" // 웹 애플리케이션 내부 경로
    ));

    // 웹 애플리케이션 설정 정보를 웹 애플리케이션 환경 정보에 등록
    ctx.setResources(resources);

    // 톰캣 서버 구동
    tomcat.start();

    // 톰캣 서버를 구동한 후 종료될 때까지 JVM을 끝내지 말고 기다린다.
    tomcat.getServer().await();

    System.out.println("서버 종료!");
  }

//  void prepareDatabase() {
//    try {
//      Connection con = DriverManager.getConnection(
//          "jdbc:mysql://db-ld2ag-kr.vpc-pub-cdb.ntruss.com/studydb", "study", "Bitcamp!@#123");
//
////      memberDao = new MemberDaoImpl(con);
//
//    } catch (Exception e) {
//      System.out.println("통신 오류!");
//      e.printStackTrace();
//    }
//  }
//
//  void prepareMenu() {
//    mainMenu = MenuGroup.getInstance("메인");
//
//    MenuGroup memberMenu = mainMenu.addGroup("회원");
//    memberMenu.addItem("등록", new MemberAddHandler(memberDao));
//    memberMenu.addItem("조회", new MemberViewHandler(memberDao));
//    memberMenu.addItem("변경", new MemberModifyHandler(memberDao));
//    memberMenu.addItem("삭제", new MemberDeleteHandler(memberDao));
//    memberMenu.addItem("목록", new MemberListHandler(memberDao, superRoot));
//
//  }
//
//  void processRequest(Socket socket) {
//    try (Socket s = socket;
//        DataOutputStream out = new DataOutputStream(s.getOutputStream());
//        DataInputStream in = new DataInputStream(s.getInputStream());
//        Prompt prompt = new Prompt(in, out)) {
//
//      while (true) {
//        try {
//          mainMenu.execute(prompt);
//          prompt.print("[[quit!]]");
//          prompt.end();
//          prompt.close();
//          break;
//        } catch (Exception e) {
//          System.out.println("예외 발생!");
//          e.printStackTrace();
//        }
//      }
//
//    } catch (Exception e) {
//      System.out.println("클라이언트 통신 오류!");
//      e.printStackTrace();
//    }
//  }
//
//  void run() {
//
//      try (ServerSocket serverSocket = new ServerSocket(8888)) {
//        while (true) {
//          Socket socket = serverSocket.accept();
//          executorService.execute(() -> processRequest(socket));
//        }
//      } catch (Exception e) {
//        System.out.println("예외 발생!");
//        e.printStackTrace();
//      }
//  }
}
