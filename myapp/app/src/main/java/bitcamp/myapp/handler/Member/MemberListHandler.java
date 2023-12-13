package bitcamp.myapp.handler.Member;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.AnsiEscape;
import java.util.ArrayList;

public class MemberListHandler implements MenuHandler {

  ArrayList<Member> objectRepository;

  public MemberListHandler(ArrayList<Member> objectRepository) {
    this.objectRepository = objectRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.println("회원 목록! ");
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
    System.out.printf("%-20s\t%-20s\t%s\n", "이메일", "이름", "가입일");

    Member[] members = new Member[this.objectRepository.size()];
    this.objectRepository.toArray(members);

    for (Member member : members) {
      System.out.printf("%-20s\t%10s\t%s\n", member.email, member.name, member.createDate);
    }
  }
}
