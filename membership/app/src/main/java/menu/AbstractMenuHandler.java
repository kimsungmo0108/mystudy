package menu;

import util.AnsiEscape;
import util.Prompt;

public abstract class AbstractMenuHandler implements MenuHandler {

  protected Menu menu;


  @Override
  public void action(Menu menu, Prompt prompt) {
    this.printMenuTitle(menu.getTitle(), prompt);
    this.menu = menu;  // 서브 클래스를 구현할 때 사용할 일이 있다면 쓸 수 있도록 보관해 둔다

    // Menu를 실행할 때 이 메소드가 호출되면
    // 즉시 서브 클래스의 다음 메소드를 호출한다
    this.action(prompt);
  }

  private void printMenuTitle(String title, Prompt prompt) {
    prompt.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, title);
  }


  // 서브 클래스가 구현해야 할 메소드
  // 수퍼 클래스의 action(Menu)을 실행할 때 호출되는 메소드이다
  // 따라서 접근 범위를 서브 클래스에서 접근할 수 있도록 제한한다
  protected abstract void action(Prompt prompt);
}
