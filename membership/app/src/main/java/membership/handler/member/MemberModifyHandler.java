package membership.handler.member;


import membership.dao.MemberDao;
import membership.vo.Member;
import menu.AbstractMenuHandler;
import util.Prompt;

public class MemberModifyHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberModifyHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {

    int no = this.prompt.inputInt("번호? ");
    Member old = this.memberDao.findBy(no);

    Member member = new Member();
    member.setNo(old.getNo());
    member.setEmail(this.prompt.input("이메일(%s)? ", old.getEmail()));
    member.setName(this.prompt.input("이름(%s)? ", old.getName()));
    member.setPassword(this.prompt.input("새 암호? "));
    member.setCreatedDate(old.getCreatedDate());

    this.memberDao.update(member);
  }
}
