package membership;


import java.sql.Connection;
import java.sql.DriverManager;
import membership.dao.MemberDao;
import membership.dao.mysql.MemberDaoImpl;
import membership.handler.member.MemberAddHandler;
import membership.handler.member.MemberDeleteHandler;
import membership.handler.member.MemberListHandler;
import membership.handler.member.MemberModifyHandler;
import membership.handler.member.MemberViewHandler;
import menu.MenuGroup;
import util.Prompt;

public class App {

  Prompt prompt = new Prompt(System.in);
  MemberDao memberDao;
  MenuGroup mainMenu;
  String superRoot = "1111";

  App() {
    prepareDatabase();
    prepareMenu();
  }


  public static void main(String[] args) {
    System.out.println("[과제관리 시스템]");
    new App().run();
  }

  void prepareDatabase() {
    try {
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://db-ld2ag-kr.vpc-pub-cdb.ntruss.com/studydb", "study", "Bitcamp!@#123");

      memberDao = new MemberDaoImpl(con, prompt);

    } catch (Exception e) {
      System.out.println("통신 오류!");
      e.printStackTrace();
    }
  }

  void prepareMenu() {
    mainMenu = MenuGroup.getInstance("메인");

    MenuGroup memberMenu = mainMenu.addGroup("회원");
    memberMenu.addItem("등록", new MemberAddHandler(memberDao, prompt));
    memberMenu.addItem("조회", new MemberViewHandler(memberDao, prompt));
    memberMenu.addItem("변경", new MemberModifyHandler(memberDao, prompt));
    memberMenu.addItem("삭제", new MemberDeleteHandler(memberDao, prompt));
    memberMenu.addItem("목록", new MemberListHandler(memberDao, prompt, superRoot));
    
  }

  void run() {
    while (true) {
      try {
        mainMenu.execute(prompt);
        prompt.close();
        break;
      } catch (Exception e) {
        System.out.println("예외 발생!");
      }
    }
  }
}
