package membership.servlet.membership;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import membership.dao.MemberDao;
import membership.dao.mysql.MemberDaoImpl;
import membership.vo.Member;

@WebServlet("/membership/update")
public class MembershipUpdateServlet extends HttpServlet {

  private MemberDao memberDao;

  @Override
  public void init() throws ServletException {
    memberDao = (MemberDaoImpl) this.getServletContext().getAttribute("memberDao");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (loginUser == null) {
        throw new Exception("로그인하시기 바랍니다.");
      }
      Member member = new Member();
      member.setNo(Integer.parseInt(request.getParameter("no")));
      member.setName(request.getParameter("name"));
      member.setEmail(request.getParameter("email"));
      member.setPassword(request.getParameter("password"));
      member.setId(request.getParameter("id"));
      member.setTel(request.getParameter("tel"));
      member.setAddr(request.getParameter("addr"));
      member.setCreatedDate(Date.valueOf(request.getParameter("createDate")));
      if (member == null) {
        throw new Exception("회원 번호가 유효하지 않습니다.");
      } else if (member.getNo() != loginUser.getNo()) {
        throw new Exception("권한이 없습니다.");
      }
      memberDao.update(member);


    } catch (Exception e) {
      request.setAttribute("message", "변경 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}
