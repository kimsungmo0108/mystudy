package bitcamp.myapp.servlet.member;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.mysql.MemberDaoImpl;
import bitcamp.myapp.vo.Member;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {

  private MemberDao memberDao;
  private String uploadDir;

  @Override
  public void init() throws ServletException {
    this.memberDao = (MemberDaoImpl) this.getServletContext().getAttribute("memberDao");
    uploadDir = this.getServletContext().getRealPath("/upload");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      int no = Integer.parseInt(request.getParameter("no"));
      Member member = memberDao.findBy(no);

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (loginUser == null) {
        throw new Exception("로그인하시기 바랍니다.");
      } else if (loginUser != member) {
        throw new Exception("권한이 없습니다.");
      }

      if (member == null) {
        throw new Exception("회원 번호가 유효하지 않습니다.");
      }
      memberDao.delete(no);

      String filename = member.getPhoto();
      if (filename != null) {
        new File(this.uploadDir + "/" + filename).delete();
      }

      response.sendRedirect("/member/list");

    } catch (Exception e) {
      request.setAttribute("message", "삭제 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error").forward(request, response);
    }
  }
}
