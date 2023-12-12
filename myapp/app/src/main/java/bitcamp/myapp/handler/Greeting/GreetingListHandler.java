package bitcamp.myapp.handler.Greeting;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.AnsiEscape;

// 게시글의 '등록' 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다
public class GreetingListHandler implements MenuHandler {

  GreetingRepository greetingRepository;

  public GreetingListHandler(GreetingRepository greetingRepository) {
    this.greetingRepository = greetingRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
    //System.out.printf("%s 목록: \n", this.title);
    System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");

    for (Board board : greetingRepository.toArray()) {
      System.out.printf("%-20s\t%10s\t%s\n", board.title, board.writer, board.createdDate);
    }
  }
}
