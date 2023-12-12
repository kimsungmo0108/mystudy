package bitcamp.myapp.handler.Member;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.AnsiEscape;

public class MemberListHandler implements MenuHandler {

  MemberRepository memberRepository;

  public MemberListHandler(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.println("회원 목록! ");
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
    System.out.printf("%-20s\t%-20s\t%s\n", "이메일", "이름", "가입일");
    for (Member member : memberRepository.toArray()) {
      System.out.printf("%-20s\t%10s\t%s\n", member.email, member.name, member.createDate);
    }
  }
}
