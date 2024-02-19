package membership.handler.member;


import membership.dao.MemberDao;
import membership.vo.Member;
import menu.AbstractMenuHandler;
import util.Prompt;

public class MemberAddHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberAddHandler(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  protected void action(Prompt prompt) {
    
    Member member = new Member();
    member.setId(prompt.input("아이디? "));
    member.setEmail(prompt.input("이메일? "));
    member.setName(prompt.input("이름? "));
    member.setPassword(prompt.input("암호? "));
    member.setAddr(prompt.input("주소? "));
    member.setTel(prompt.input("전화번호? "));

    this.memberDao.add(member);
  }
}
