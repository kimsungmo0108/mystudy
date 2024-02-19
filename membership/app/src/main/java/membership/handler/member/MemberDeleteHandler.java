package membership.handler.member;

import membership.dao.MemberDao;
import menu.AbstractMenuHandler;

import util.Prompt;

public class MemberDeleteHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberDeleteHandler(MemberDao memberDao) {
    this.memberDao = memberDao;

  }

  @Override
  protected void action(Prompt prompt) {
    int index = prompt.inputInt("번호? ");
    if (memberDao.delete(index) == 0) {
      prompt.println("게시글 번호가 유효하지 않습니다.");
    } else {
      prompt.println("삭제했습니다!");
    }

  }
}

