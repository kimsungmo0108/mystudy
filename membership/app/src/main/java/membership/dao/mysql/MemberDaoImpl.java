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
import util.DBConnectionPool;
import util.Prompt;

public class MemberDaoImpl implements MemberDao {

  DBConnectionPool connectionPool;

  public MemberDaoImpl(DBConnectionPool connectionPool) {
    this.connectionPool = connectionPool;
  }

  @Override
  public void add(Member member) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "insert into membership(id, email, name, password, addr, tel, photo) values(?,?,?,sha2(?,256),?,?,?)")) {
      pstmt.setString(1, member.getId());
      pstmt.setString(2, member.getEmail());
      pstmt.setString(3, member.getName());
      pstmt.setString(4, member.getPassword());
      pstmt.setString(5, member.getAddr());
      pstmt.setString(6, member.getTel());
      pstmt.setString(7, member.getPhoto());
      pstmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (Connection con = connectionPool.getConnection();
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
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "select no, id, email, name, photo, create_date, addr, tel from membership")) {
      try (ResultSet rs = pstmt.executeQuery()) {

        ArrayList<Member> list = new ArrayList<>();
        while (rs.next()) {
          Member member = new Member();
          member.setNo(rs.getInt("no"));
          member.setId(rs.getString("id"));
          member.setEmail(rs.getString("email"));
          member.setName(rs.getString("name"));
          member.setCreatedDate(rs.getDate("create_date"));
         // member.setCreatedTime(rs.getTime("created_date"));
          member.setAddr(rs.getString("addr"));
          member.setTel(rs.getString("tel"));
          member.setPhoto(rs.getString("photo"));

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
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select * from membership where no=?")) {
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
          member.setCreatedDate(rs.getDate("create_date"));
          member.setCreatedTime(rs.getTime("create_date"));

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
    String sql;
    if (member.getPassword().length() == 0) {
      sql = "update membership set email=?, name=?, addr=?, tel=?, id=? where no=?";
    } else {
      sql = "update membership set email=?, name=?, password=sha2(?,256), addr=?, tel=?, id=? where no=?";
    }
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)) {

      pstmt.setString(1, member.getEmail());
      pstmt.setString(2, member.getName());
      if (member.getPassword().length() == 0) {
        pstmt.setString(3, member.getAddr());
        pstmt.setString(4, member.getTel());
        pstmt.setString(5, member.getId());
        pstmt.setInt(6, member.getNo());
      } else {
        pstmt.setString(3, member.getPassword());
        pstmt.setString(4, member.getAddr());
        pstmt.setString(5, member.getTel());
        pstmt.setString(6, member.getId());
        pstmt.setInt(7, member.getNo());
      }


      return pstmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }
  @Override
  public Member findByEmailAndPassword(String email, String password) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "select no, email, name, addr, tel, id, create_date from membership where email=? and password=sha2(?,256)")) {
      pstmt.setString(1, email);
      pstmt.setString(2, password);

      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          Member member = new Member();
          member.setNo(rs.getInt("no"));
          member.setEmail(rs.getString("email"));
          member.setName(rs.getString("name"));
          member.setAddr(rs.getString("addr"));
          member.setTel(rs.getString("tel"));
          member.setId(rs.getString("id"));
          member.setCreatedDate(rs.getDate("create_date"));
          member.setCreatedTime(rs.getTime("create_date"));
          return member;
        }
        return null;
      }
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }
}
