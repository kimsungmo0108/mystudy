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

@WebServlet("/membership/list")
public class MembersihpListServlet extends HttpServlet {

  private MemberDao memberDao;
@Override
  public void init() throws ServletException{
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
    out.println("   <title>회원 관리 시스템</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 리스트</h1>");

    out.println("<a href='/membership/form.html'>새 회원</a>");

    out.println("<table border='1'>");
    out.println("   <thead>");
    out.println("   <tr> <th>번호</th> <th>이름</th> <th>이메일</th> <th>가입일</th> </tr>");
    out.println("   </thead>");
    out.println("   <tbody>");

    try {
      for (Member member : memberDao.findAll()) {
        out.printf(
            "<tr> <td>%d</td><td><a href='/membership/view?no=%1$d'>%s</a></td> <td>%s</td> <td>%s</td>\n",
            member.getNo(),
            member.getName(),
            member.getEmail(),
            member.getCreatedDate());
      }

      out.println("   </tbody>");
      out.println("</table>");

    } catch (Exception e) {
      out.println("<p>목록 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}