package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import java.util.ArrayList;

// 게시글의 '등록' 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
//
public class BoardDeleteHandler extends AbstractMenuHandler {

  private ArrayList<Board> objectRepository;

  public BoardDeleteHandler(ArrayList<Board> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  public void action() {
    int index = this.prompt.inputInt("번호? ");
    if (this.objectRepository.remove(index) == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
    }
  }
}
