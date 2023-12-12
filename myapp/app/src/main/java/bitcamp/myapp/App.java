package bitcamp.myapp;

import bitcamp.menu.MenuGroup;
import bitcamp.menu.MenuHandler;
import bitcamp.menu.MenuItem;
import bitcamp.myapp.handler.Greeting.GreetingAddHandler;
import bitcamp.myapp.handler.Greeting.GreetingDeleteHandler;
import bitcamp.myapp.handler.Greeting.GreetingListHandler;
import bitcamp.myapp.handler.Greeting.GreetingModifyHandler;
import bitcamp.myapp.handler.Greeting.GreetingViewHandler;
import bitcamp.myapp.handler.Member.MemberAddHandler;
import bitcamp.myapp.handler.Member.MemberDeleteHandler;
import bitcamp.myapp.handler.Member.MemberListHandler;
import bitcamp.myapp.handler.Member.MemberModifyHandler;
import bitcamp.myapp.handler.Member.MemberViewHandler;
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
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) {
    Prompt prompt = new Prompt(System.in);
    //new MainMenu(prompt).execute();

    ObjectRepository assignmentRepository = new ObjectRepository();
    ObjectRepository boardRepository = new ObjectRepository();
    ObjectRepository memberRepository = new ObjectRepository();
    ObjectRepository greetingRepository = new ObjectRepository();

    MenuGroup mainMenu = new MenuGroup("메인");

    MenuGroup assignmentMenu = new MenuGroup("과제");
    assignmentMenu.add(new MenuItem("등록", new AssignmentAddHandler(prompt, assignmentRepository)));
    assignmentMenu.add(new MenuItem("조회", new AssignmentViewHandler(prompt, assignmentRepository)));
    assignmentMenu.add(
        new MenuItem("변경", new AssignmentModifyHandler(prompt, assignmentRepository)));
    assignmentMenu.add(new MenuItem("목록", new AssignmentListHandler(assignmentRepository)));
    assignmentMenu.add(
        new MenuItem("삭제", new AssignmentDeleteHandler(prompt, assignmentRepository)));
    mainMenu.add(assignmentMenu);

    MenuGroup boardMenu = new MenuGroup("게시글");
    // 사용자로부터 게시글을 입력 받아서 배열에 저장하는 일을 한다
    MenuHandler boardAddHandler = new BoardAddHandler(prompt, boardRepository);
    // "등록" 이라는 메뉴를 선택 했을 때 BoardAddHandler를 실행시키는 일을 한다
    MenuItem boardAddMenu = new MenuItem("등록", boardAddHandler);
    // 게시글 등록을 처리하는 메뉴를 게시글 메뉴에 추가한다
    boardMenu.add(boardAddMenu);
    boardMenu.add(new MenuItem("조회", new BoardViewHandler(boardRepository, prompt)));
    boardMenu.add(new MenuItem("변경", new BoardModifyHandler(boardRepository, prompt)));
    boardMenu.add(new MenuItem("목록", new BoardListHandler(boardRepository)));
    boardMenu.add(new MenuItem("삭제", new BoardDeleteHandler(boardRepository, prompt)));
    mainMenu.add(boardMenu);

    MenuGroup memberMenu = new MenuGroup("회원");
    memberMenu.add(new MenuItem("등록", new MemberAddHandler(prompt, memberRepository)));
    memberMenu.add(new MenuItem("조회", new MemberViewHandler(prompt, memberRepository)));
    memberMenu.add(new MenuItem("변경", new MemberModifyHandler(prompt, memberRepository)));
    memberMenu.add(new MenuItem("목록", new MemberListHandler(memberRepository)));
    memberMenu.add(new MenuItem("삭제", new MemberDeleteHandler(prompt, memberRepository)));
    mainMenu.add(memberMenu);

    MenuGroup greetingMenu = new MenuGroup("가입인사");
    greetingMenu.add(new MenuItem("등록", new GreetingAddHandler(greetingRepository, prompt)));
    greetingMenu.add(new MenuItem("조회", new GreetingViewHandler(greetingRepository, prompt)));
    greetingMenu.add(new MenuItem("변경", new GreetingModifyHandler(greetingRepository, prompt)));
    greetingMenu.add(new MenuItem("목록", new GreetingListHandler(greetingRepository)));
    greetingMenu.add(new MenuItem("삭제", new GreetingDeleteHandler(greetingRepository, prompt)));
    mainMenu.add(greetingMenu);

    MenuGroup helpMenu = new MenuGroup("도움말");
    mainMenu.add(helpMenu);

    mainMenu.execute(prompt);

    prompt.close();
  }
}
