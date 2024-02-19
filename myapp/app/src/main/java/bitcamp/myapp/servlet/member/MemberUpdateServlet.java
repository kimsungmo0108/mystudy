package bitcamp.myapp.servlet.member;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.mysql.MemberDaoImpl;
import bitcamp.myapp.vo.Member;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {

  private MemberDao memberDao;

  @Override
  public void init() throws ServletException {
    this.memberDao = (MemberDaoImpl) this.getServletContext().getAttribute("memberDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html lang = 'en'>");
    out.println("<head>");
    out.println("   <meta charset = 'UTF-8'>");
    out.println("   <title> 비트캠프 데브옵스 5 기 </title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원</h1>");

    try {
      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (loginUser == null) {
        out.println("<p>로그인하시기 바랍니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      Member member = new Member();
      member.setNo(Integer.parseInt(request.getParameter("no")));
      member.setName(request.getParameter("name"));
      member.setEmail(request.getParameter("email"));
      member.setPassword(request.getParameter("password"));
      member.setCreatedDate(Date.valueOf(request.getParameter("createDate")));
      memberDao.update(member);

      out.println("<p>회원을 변경했습니다.</p>");
    } catch (Exception e) {
      out.println("<p>회원 변경 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}
