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
    System.out.printf("%-20s\t%-20s\t%s\n", "번호", "이름", "가입일");
    for (int i = 0; i < this.memberRepository.length; i++) {
      Member member = this.memberRepository.members[i];
      System.out.printf("%-20d\t%-20s\t%s\n", i, member.name, member.createDate);
    }
  }
}
