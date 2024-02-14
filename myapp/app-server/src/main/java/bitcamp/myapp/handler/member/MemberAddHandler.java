package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;
import bitcamp.util.TransactionManager;
import java.util.Date;

public class MemberAddHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  private TransactionManager txManager;

  public MemberAddHandler(TransactionManager txManager, MemberDao memberDao) {
    this.memberDao = memberDao;
    this.txManager = txManager;
  }

  @Override
  protected void action(Prompt prompt) {
    try {
      Member member = new Member();
      member.setEmail(prompt.input("이메일? "));
      member.setName(prompt.input("이름? "));
      member.setPassword(prompt.input("암호? "));
      member.setCreatedDate(new Date());

      txManager.startTransaction();
      memberDao.add(member);
      txManager.commit();

    } catch (Exception e) {
      try {
        txManager.rollback();
      } catch (Exception e2) {
        prompt.println("회원 입력 중 오류 발생!");
      }
    }
  }
}
