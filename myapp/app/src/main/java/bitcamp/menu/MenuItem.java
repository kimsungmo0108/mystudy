package bitcamp.menu;

import bitcamp.util.Prompt;

// Composite 패턴에서 Leaf 역할을 수행하는 클래스
// Leaf란?
// - 하위 항목을 포함하지 않는 말단 객체
// - 에를들어 파일시스템에서 '파일'에 해당
//
public class MenuItem implements Menu {

  String title;
  MenuHandler menuHandler;

  public MenuItem(String title) {
    this.title = title;
  }

  public MenuItem(String title, MenuHandler menuHandler) {
    this(title);
    this.menuHandler = menuHandler;
  }

  public void execute(Prompt prompt) {
    if (this.menuHandler != null) {
      this.menuHandler.action(this);
    }
  }

  @Override
  public String getTitle() {
    return this.title;
  }
}