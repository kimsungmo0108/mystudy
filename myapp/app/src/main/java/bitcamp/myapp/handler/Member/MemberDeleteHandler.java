package bitcamp.myapp.handler.Member;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;


public class MemberDeleteHandler implements MenuHandler {

  Prompt prompt;
  MemberRepository memberRepository;

  public MemberDeleteHandler(Prompt prompt, MemberRepository memberRepository) {
    this.prompt = prompt;
    this.memberRepository = memberRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.println("회원 삭제!");
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
    int index = this.prompt.inputInt("회원 번호? ");
    if (this.memberRepository.remove(index) == null) {
      System.out.println("회원 번호가 유효하지 않습니다.");
    }
  }
}
