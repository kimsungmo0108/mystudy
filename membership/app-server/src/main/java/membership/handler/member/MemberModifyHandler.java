package membership.handler.member;


import membership.dao.MemberDao;
import membership.vo.Member;
import menu.AbstractMenuHandler;
import util.Prompt;

public class MemberModifyHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberModifyHandler(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  protected void action(Prompt prompt) {

    int no = prompt.inputInt("번호? ");
    Member old = this.memberDao.findBy(no);
    String id = prompt.input("id? ");
    String pw = prompt.input("암호? ");

    if(pw.equals(old.getPassword()) && id.equals(old.getId())) {
      Member member = new Member();
      member.setNo(old.getNo());
      member.setEmail(old.getEmail());
      member.setName(prompt.input("이름(%s)? ", old.getName()));
      member.setAddr(prompt.input("주소(%s)? ", old.getAddr()));
      member.setTel(prompt.input("전화번호(%s)? ", old.getTel()));
      member.setPassword(prompt.input("새 암호? "));
      member.setCreatedDate(old.getCreatedDate());
      member.setCreatedTime(old.getCreatedTime());
      this.memberDao.update(member);
    }else{System.out.println("옳지 않은 정보입니다.");}
  }
}
