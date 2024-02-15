package bitcamp.menu;

import bitcamp.util.Prompt;

// 메뉴를 실행시킬 때 작업을 수행할 객체의 사용 규칙 정의
// - 메뉴를 실행시키면, 해당 메뉴는 등록된 MenuHandler 객체를 실행한다.
//
public interface MenuHandler {

  void action(Menu menu, Prompt prompt);
}
