package bitcamp.myapp;

import bitcamp.menu.MenuGroup;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.Json.AssignmentDaoImpl;
import bitcamp.myapp.dao.Json.BoardDaoImpl;
import bitcamp.myapp.dao.Json.MemberDaoImpl;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.handler.HelpHandler;
import bitcamp.myapp.handler.assignment.AssignmentAddHandler;
import bitcamp.myapp.handler.assignment.AssignmentDeleteHandler;
import bitcamp.myapp.handler.assignment.AssignmentListHandler;
import bitcamp.myapp.handler.assignment.AssignmentModifyHandler;
import bitcamp.myapp.handler.assignment.AssignmentViewHandler;
import bitcamp.myapp.handler.board.BoardAddHandler;
import bitcamp.myapp.handler.board.BoardDeleteHandler;
import bitcamp.myapp.handler.board.BoardListHandler;
import bitcamp.myapp.handler.board.BoardModifyHandler;
import bitcamp.myapp.handler.board.BoardViewHandler;
import bitcamp.myapp.handler.member.MemberAddHandler;
import bitcamp.myapp.handler.member.MemberDeleteHandler;
import bitcamp.myapp.handler.member.MemberListHandler;
import bitcamp.myapp.handler.member.MemberModifyHandler;
import bitcamp.myapp.handler.member.MemberViewHandler;
import bitcamp.util.Prompt;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientApp {

  Prompt prompt = new Prompt(System.in);

  BoardDao boardDao = new BoardDaoImpl("board.json");
  BoardDao greetingDao = new BoardDaoImpl("greeting.json");
  AssignmentDao assignmentDao = new AssignmentDaoImpl("assignment.json");
  MemberDao memberDao = new MemberDaoImpl("member.json");


  MenuGroup mainMenu;

  ClientApp() {

    prepareMenu();
  }

  public static void main(String[] args) {
    System.out.println("[과제관리 시스템]");
    try {
      // 1) 서버와 연결한 후 연결 정보 준비
      // => new Socket(서버 주소, 포트 번호);
      //    - 서버 주소 : IP주소, 도메인명
      //    - 포트 번호 : 서버 포트 번호
      // => 로컬 컴퓨터를 가르키는 주소
      //    - 127.0.0.1
      //    - 도에미명 : localhost
      System.out.println("서버 연결 중...");
      Socket socket = new Socket("localhost", 8888);
      System.out.println("서버와 연결되었음!");
      
    } catch (Exception e) {
      System.out.println("통신 오류!");
      e.printStackTrace();
    }
    //new ClientApp().run();
  }

  void prepareMenu() {
    mainMenu = MenuGroup.getInstance("메인");

    MenuGroup assignmentMenu = mainMenu.addGroup("과제");
    assignmentMenu.addItem("등록", new AssignmentAddHandler(assignmentDao, prompt));
    assignmentMenu.addItem("조회", new AssignmentViewHandler(assignmentDao, prompt));
    assignmentMenu.addItem("변경", new AssignmentModifyHandler(assignmentDao, prompt));
    assignmentMenu.addItem("삭제", new AssignmentDeleteHandler(assignmentDao, prompt));
    assignmentMenu.addItem("목록", new AssignmentListHandler(assignmentDao, prompt));

    MenuGroup boardMenu = mainMenu.addGroup("게시글");
    boardMenu.addItem("등록", new BoardAddHandler(boardDao, prompt));
    boardMenu.addItem("조회", new BoardViewHandler(boardDao, prompt));
    boardMenu.addItem("변경", new BoardModifyHandler(boardDao, prompt));
    boardMenu.addItem("삭제", new BoardDeleteHandler(boardDao, prompt));
    boardMenu.addItem("목록", new BoardListHandler(boardDao, prompt));

    MenuGroup memberMenu = mainMenu.addGroup("회원");
    memberMenu.addItem("등록", new MemberAddHandler(memberDao, prompt));
    memberMenu.addItem("조회", new MemberViewHandler(memberDao, prompt));
    memberMenu.addItem("변경", new MemberModifyHandler(memberDao, prompt));
    memberMenu.addItem("삭제", new MemberDeleteHandler(memberDao, prompt));
    memberMenu.addItem("목록", new MemberListHandler(memberDao, prompt));

    MenuGroup greetingMenu = mainMenu.addGroup("가입인사");
    greetingMenu.addItem("등록", new BoardAddHandler(greetingDao, prompt));
    greetingMenu.addItem("조회", new BoardViewHandler(greetingDao, prompt));
    greetingMenu.addItem("변경", new BoardModifyHandler(greetingDao, prompt));
    greetingMenu.addItem("삭제", new BoardDeleteHandler(greetingDao, prompt));
    greetingMenu.addItem("목록", new BoardListHandler(greetingDao, prompt));

    mainMenu.addItem("도움말", new HelpHandler(prompt));
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

  void saveData(String filepath, List<?> dataList) {
    try (BufferedWriter out = new BufferedWriter(new FileWriter(filepath))) {

      // GsonBuilder를 이용해서 날짜 옵션을 설정 후 Gson을 생성 후 dataList 객체를 Json으로 변환 후 리턴
      out.write(new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(dataList));

    } catch (Exception e) {
      System.out.printf("%s 파일 저장 중 오류 발생!\n", filepath);
      e.printStackTrace();
    }
  }

//  <E> void loadData(String filepath, List<E> dataList) {
//    try (ObjectInputStream in = new ObjectInputStream(
//        new BufferedInputStream(new FileInputStream(filepath)))) {
//
//      //List<E> list = (List<E>) in.readObject();
//      //dataList.addAll(list);
//
//    } catch (Exception e) {
//      System.out.printf("%s 파일 로딩 중 오류 발생!\n", filepath);
//      e.printStackTrace();
//    }
//  }

  <E> List<E> loadData(String filepath, Class<E> clazz) {

    // 0) 객체를 저장할 list를 준비한다
    ArrayList<E> list = new ArrayList<>();
    try (BufferedReader in = new BufferedReader(new FileReader(filepath))) {
      // 파일에서 JSON 문자열을 모두 읽어서 버퍼에 저장한다
      StringBuilder strBuilder = new StringBuilder();
      String str;
      while ((str = in.readLine()) != null) {
        strBuilder.append(str);
      }

      // 버퍼에 저장된 JSON 문자열을 가지고 컬렉션 객체를 생성한다
      return (List<E>) new GsonBuilder().setDateFormat("yyyy-MM-dd").create()
          .fromJson(strBuilder.toString(), TypeToken.getParameterized(ArrayList.class, clazz));

    } catch (Exception e) {
      System.out.printf("%s 파일 로딩 중 오류 발생!\n", filepath);
      e.printStackTrace();
    }
    return new ArrayList<>();
  }

}
