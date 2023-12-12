package bitcamp.myapp.handler.Member;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;

public class MemberListHandler implements MenuHandler {

  ObjectRepository objectRepository;

  public MemberListHandler(ObjectRepository objectRepository) {
    this.objectRepository = objectRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.println("회원 목록! ");
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
    System.out.printf("%-20s\t%-20s\t%s\n", "이메일", "이름", "가입일");
    for (Object object : objectRepository.toArray()) {
      Member member = (Member) object;
      System.out.printf("%-20s\t%10s\t%s\n", member.email, member.name, member.createDate);
    }
  }
}
