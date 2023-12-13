package bitcamp.myapp.handler.Member;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

public class MemberModifyHandler implements MenuHandler {

  Prompt prompt;
  ObjectRepository<Member> objectRepository;

  public MemberModifyHandler(Prompt prompt, ObjectRepository<Member> objectRepository) {
    this.prompt = prompt;
    this.objectRepository = objectRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.println("회원정보 변경!");
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
    int index = this.prompt.inputInt("회원 번호? ");
    Member oldmember = this.objectRepository.get(index);
    if (oldmember == null) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }
    Member member = new Member();
    member.email = this.prompt.input("이메일(%s): ", oldmember.email);
    member.name = this.prompt.input("이름(%s): ", oldmember.name);
    member.password = this.prompt.input("새암호: ");
    member.createDate = this.prompt.input("가입일(%s): ", oldmember.createDate);
    this.objectRepository.set(index, member);
  }
}
