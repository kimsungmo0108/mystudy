package membership.handler.member;

import membership.dao.MemberDao;
import menu.AbstractMenuHandler;

import util.Prompt;

public class MemberDeleteHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberDeleteHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {

    int index = this.prompt.inputInt("번호? ");
    this.memberDao.delete(index);
  }
}

