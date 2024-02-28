package membership.servlet.membership;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import membership.dao.MemberDao;
import membership.dao.mysql.MemberDaoImpl;
import membership.vo.Member;
import menu.AbstractMenuHandler;
import util.Prompt;

@WebServlet("/membership/delete")
public class MembershipDeleteServlet extends HttpServlet {

  private MemberDao memberDao;

  @Override
  public void init() throws ServletException {
    this.memberDao = (MemberDaoImpl) this.getServletContext().getAttribute("memberDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (loginUser == null) {
        throw new Exception("로그인하시기 바랍니다.");
      }
      int no = Integer.parseInt(request.getParameter("no"));
      Member member = memberDao.findBy(no);
      if (member.getNo() != loginUser.getNo()) {
        throw new Exception("권한이 없습니다.");
      }
      memberDao.delete(no);
      response.sendRedirect("/membership/list");

    } catch (Exception e) {
      request.setAttribute("message", "삭제 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}


