package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Member;
import java.util.List;

public interface MemberDao {

  void add(Member member);

  int delete(int no);

  List<Member> findAll();

  Member findBy(int no);

  int update(Member member);

}
