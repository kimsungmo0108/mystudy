package membership.handler.member;


import membership.dao.MemberDao;
import membership.vo.Member;
import menu.AbstractMenuHandler;
import util.Prompt;

public class MemberViewHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberViewHandler(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  protected void action(Prompt prompt) {

    int no = prompt.inputInt("번호? ");
    Member member = this.memberDao.findBy(no);

    prompt.printf("번호: %s\n", member.getNo());
    prompt.printf("이메일: %s\n", member.getEmail());
    prompt.printf("이름: %s\n", member.getName());
    prompt.printf("주소: %s\n", member.getAddr());
    prompt.printf("전화번호: %s\n", member.getTel());
    prompt.printf("가입일: %1$tY-%1$tm-%1$td %2$tH:%2$tM:%2$tS\n", member.getCreatedDate(), member.getCreatedTime());
    boolean b = prompt.inputBoolean("암호를 찾으시겠습니까? ");
    if(b){
      String id = prompt.input("id? ");
      String tel = prompt.input("전화번호? ");
      if(id.equals(member.getId()) && tel.equals(member.getTel())){
        String pw = member.getPassword();
        prompt.print("비밀번호: ");
        for(int i=0;i<pw.length()-3;i++){
          prompt.print(pw.charAt(i)+"");
        }
        prompt.print("***\n");
      }else{prompt.println("옳지 않은 정보입니다.");}
    }
  }
}
