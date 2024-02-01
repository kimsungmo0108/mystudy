package membership.handler.member;


import membership.dao.MemberDao;
import membership.vo.Member;
import menu.AbstractMenuHandler;
import util.Prompt;

public class MemberListHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberListHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {

    System.out.printf("%-4s\t%-10s\t%30s\t%s\n", "번호", "이름", "이메일", "가입일");
    //List<Member> list = this.memberDao.findAll();

    for (Member member : memberDao.findAll()) {
      System.out.printf("%-4d\t%-10s\t%30s\t%4$tY-%4$tm-%4$td %4$tH:%4$tM:%4$tS\n",
          member.getNo(),
          member.getName(),
          member.getEmail(),
          member.getCreatedDate());
    }
  }
}
