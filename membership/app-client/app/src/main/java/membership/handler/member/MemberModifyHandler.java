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
    String id = this.prompt.input("id? ");
    String pw = this.prompt.input("암호? ");

    if(pw.equals(old.getPassword()) && id.equals(old.getId())) {
      Member member = new Member();
      member.setNo(old.getNo());
      member.setEmail(old.getEmail());
      member.setName(this.prompt.input("이름(%s)? ", old.getName()));
      member.setAddr(this.prompt.input("주소(%s)? ", old.getAddr()));
      member.setTel(this.prompt.input("전화번호(%s)? ", old.getTel()));
      member.setPassword(this.prompt.input("새 암호? "));
      member.setCreatedDate(old.getCreatedDate());
      member.setCreatedTime(old.getCreatedTime());
      this.memberDao.update(member);
    }else{System.out.println("옳지 않은 정보입니다.");}
  }
}
