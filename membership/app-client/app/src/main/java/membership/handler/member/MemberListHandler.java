package membership.handler.member;


import membership.dao.MemberDao;
import membership.vo.Member;
import menu.AbstractMenuHandler;
import util.Prompt;

public class MemberListHandler extends AbstractMenuHandler {

  private MemberDao memberDao;
  String superRoot;

  public MemberListHandler(MemberDao memberDao, Prompt prompt, String superRoot) {
    super(prompt);
    this.memberDao = memberDao;
    this.superRoot=superRoot;
  }

  @Override
  protected void action() {
    String root = this.prompt.input("관리자 번호 : ");
    if(root.equals(superRoot)){

      System.out.printf("%-10s\t%-10s\t%15s\t%20s\t%20s\t%20s\t\t%s\n", "번호", "id", "이름", "이메일", "주소","전화번호", "가입일");
      //List<Member> list = this.memberDao.findAll();

      for (Member member : memberDao.findAll()) {
        System.out.printf("%-10d\t%-10s\t%15s\t%20s\t%20s\t%20s\t%7$tY-%7$tm-%7$td %8$tH:%8$tM:%8$tS\n",
            member.getNo(),
            member.getId(),
            member.getName(),
            member.getEmail(),
            member.getAddr(),
            member.getTel(),
            member.getCreatedDate(),
            member.getCreatedTime());
      }
    }else{System.out.println("관리자 번호가 옳지 않습니다.");}
  }
}
