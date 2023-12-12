package bitcamp.myapp.handler.Greeting;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

// 게시글의 '등록' 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다
public class GreetingAddHandler implements MenuHandler {

  GreetingRepository greetingRepository;
  Prompt prompt;

  public GreetingAddHandler(GreetingRepository greetingRepository, Prompt prompt) {
    this.prompt = prompt;
    this.greetingRepository = greetingRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    if (this.greetingRepository.length == this.greetingRepository.greetings.length) {
      int oldSize = this.greetingRepository.greetings.length;
      int newSize = oldSize + (oldSize >> 1);

      Board[] arr = new Board[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.greetingRepository.greetings[i];
      }

      this.greetingRepository.greetings = arr;
    }

    Board board = new Board();
    board.title = this.prompt.input("제목? ");
    board.content = this.prompt.input("내용? ");
    board.writer = this.prompt.input("작성자? ");
    board.createdDate = this.prompt.input("작성일? ");

    this.greetingRepository.greetings[this.greetingRepository.length++] = board;

  }
}
