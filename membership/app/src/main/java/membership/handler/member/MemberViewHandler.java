package membership.handler.member;


import membership.dao.MemberDao;
import membership.vo.Member;
import menu.AbstractMenuHandler;
import util.Prompt;

public class MemberViewHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberViewHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {

    int no = this.prompt.inputInt("번호? ");
    Member member = this.memberDao.findBy(no);

    System.out.printf("번호: %s\n", member.getNo());
    System.out.printf("이메일: %s\n", member.getEmail());
    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("주소: %s\n", member.getAddr());
    System.out.printf("전화번호: %s\n", member.getTel());
    System.out.printf("가입일: %1$tY-%1$tm-%1$td %2$tH:%2$tM:%2$tS\n", member.getCreatedDate(), member.getCreatedTime());
    boolean b = this.prompt.inputBoolean("암호를 찾으시겠습니까? ");
    if(b){
      String id = this.prompt.input("id? ");
      String tel = this.prompt.input("전화번호? ");
      if(id.equals(member.getId()) && tel.equals(member.getTel())){
        String pw = member.getPassword();
        System.out.print("비밀번호: ");
        for(int i=0;i<pw.length()-3;i++){
          System.out.print(pw.charAt(i));
        }
        System.out.print("***\n");
      }else{System.out.println("옳지 않은 정보입니다.");}
    }
  }
}
