package bitcamp.myapp.handler.Member;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

public class MemberAddHandler implements MenuHandler {

  Prompt prompt;
  ObjectRepository<Member> objectRepository;

  public MemberAddHandler(Prompt prompt, ObjectRepository<Member> objectRepository) {
    this.prompt = prompt;
    this.objectRepository = objectRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    Member member = new Member();
    member.email = this.prompt.input("이메일? ");
    member.name = this.prompt.input("이름? ");
    member.password = this.prompt.input("비밀번호? ");
    member.createDate = this.prompt.input("가입일? ");
    // 목록에 객체를 추가시키는 코드를 BoardRepository가 감췄다(캡슐화 했다)
    // 대신 목록에 객체를 추가시킬 수 있도록 메소드를 제공하고 있다
    // 따라서 다음과 같이 boardRepository가 제공하는 메소드를 사용하여 게시글 객체를 추가하라
    this.objectRepository.add(member);
  }
}
