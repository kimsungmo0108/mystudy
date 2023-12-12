package bitcamp.myapp.handler.Greeting;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

// 게시글의 '등록' 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다
public class GreetingDeleteHandler implements MenuHandler {

  GreetingRepository greetingRepository;
  Prompt prompt;

  public GreetingDeleteHandler(GreetingRepository greetingRepository, Prompt prompt) {
    this.greetingRepository = greetingRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
    int index = this.prompt.inputInt("번호? ");
    if (index < 0 || index >= this.greetingRepository.length) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    for (int i = index; i < (this.greetingRepository.length - 1); i++) {
      this.greetingRepository.greetings[i] = this.greetingRepository.greetings[i + 1];
    }
    this.greetingRepository.greetings[--this.greetingRepository.length] = null;
  }
}
