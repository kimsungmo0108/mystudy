package membership.dao.mysql;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import java.util.List;
import membership.dao.DaoException;
import membership.dao.MemberDao;
import membership.vo.Member;
import util.Prompt;

public class MemberDaoImpl implements MemberDao {

  Connection con;
  Prompt prompt;

  public MemberDaoImpl(Connection con, Prompt prompt) {
    this.con = con;
    this.prompt = prompt;
  }

  @Override
  public void add(Member member) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(
          String.format(
              "insert into membership(id, email, name, password, addr, tel) values('%s','%s','%s','%s','%s', '%s')",
              member.getId(),
              member.getEmail(),
              member.getName(),
              member.getPassword(),
              member.getAddr(),
              member.getTel()));
      // sha2('%s',256)
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select id, password from membership where no="+no);
      if(rs.next()){
        String id = this.prompt.input("아이디? ");
        String pw = this.prompt.input("암호? ");
        if(pw.equals(rs.getString("password")) && id.equals(rs.getString("id"))) {
          return stmt.executeUpdate("delete from membership where no=" + no);
        }else{System.out.println("옳지 않은 정보입니다.");}
      }
    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
    return -1;
  }

  @Override
  public List<Member> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from membership");
      ArrayList<Member> list = new ArrayList<>();
      while (rs.next()) {
        Member member = new Member();
        member.setNo(rs.getInt("no"));
        member.setId(rs.getString("id"));
        member.setEmail(rs.getString("email"));
        member.setName(rs.getString("name"));
        member.setCreatedDate(rs.getDate("created_date"));
        member.setCreatedTime(rs.getTime("created_date"));
        member.setAddr(rs.getString("addr"));
        member.setTel(rs.getString("tel"));

        list.add(member);
      }
      return list;
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Member findBy(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from membership where no=" + no);

      if (rs.next()) {
        Member member = new Member();
        member.setNo(rs.getInt("no"));
        member.setId(rs.getString("id"));
        member.setEmail(rs.getString("email"));
        member.setName(rs.getString("name"));
        member.setAddr(rs.getString("addr"));
        member.setTel(rs.getString("tel"));
        member.setPassword(rs.getString("password"));
        member.setCreatedDate(rs.getDate("created_date"));
        member.setCreatedTime(rs.getTime("created_date"));

        return member;
      }
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
    return null;
  }

  @Override
  public int update(Member member) {
    try {
      Statement stmt = con.createStatement();
          return stmt.executeUpdate(
              String.format("update membership set email='%s', name='%s', password='%s', addr='%s', tel='%s' where no=%d",
                  member.getEmail(),
                  member.getName(),
                  member.getPassword(),
                  member.getAddr(),
                  member.getTel(),
                  member.getNo()));
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }
}
