package membership.dao.mysql;


import java.sql.Connection;
import java.sql.PreparedStatement;
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

  public MemberDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Member member) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "insert into membership(id, email, name, password, addr, tel) values(?,?,?,?,?,?)")) {
      pstmt.setString(1, member.getId());
      pstmt.setString(2, member.getEmail());
      pstmt.setString(3, member.getName());
      pstmt.setString(4, member.getPassword());
      pstmt.setString(5, member.getAddr());
      pstmt.setString(6, member.getTel());
      pstmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (
        PreparedStatement pstmt2 = con.prepareStatement(
            "delete from membership where no=?")) {
      pstmt2.setInt(1, no);
      return pstmt2.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Member> findAll() {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select no, id, email, name, created_date, addr, tel from membership")) {
      try (ResultSet rs = pstmt.executeQuery()) {

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
      }
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Member findBy(int no) {
    try (PreparedStatement pstmt = con.prepareStatement("select * from membership where no=?")) {
      pstmt.setInt(1, no);
      try (ResultSet rs = pstmt.executeQuery()) {
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
      }
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
    return null;
  }

  @Override
  public int update(Member member) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "update membership set email=?, name=?, password=?, addr=?, tel=? where no=?")) {
      pstmt.setString(1, member.getEmail());
      pstmt.setString(2, member.getName());
      pstmt.setString(3, member.getPassword());
      pstmt.setString(4, member.getAddr());
      pstmt.setString(5, member.getTel());
      pstmt.setInt(6, member.getNo());

      return pstmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }
}
