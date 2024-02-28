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

@WebServlet("/membership/view")
public class MembershipViewServlet extends HttpServlet {

  private MemberDao memberDao;

  @Override
  public void init() throws ServletException {
    memberDao = (MemberDaoImpl) this.getServletContext().getAttribute("memberDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
    request.getRequestDispatcher("/header").include(request, response);
    out.println("<h1>회원 조회</h1>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Member member = memberDao.findBy(no);
      if (member == null) {
        out.println("<p>회원 번호가 유효하지 않습니다.</p>");
        request.getRequestDispatcher("/footer").include(request, response);
        out.println("</body>");
        out.println("</html>");
        return;
      }
      out.printf("<form action='/membership/update' method='post'>\n");
      out.printf(" <div>\n");
      out.printf("  번호: <input readonly name = 'no' type = 'text' value='%s'>\n", member.getNo());
      out.printf("  </div>\n");
      out.printf(" <div>\n");
      out.printf("  아이디: <input name = 'id' type = 'text' value='%s'>\n", member.getId());
      out.printf("  </div>\n");
      out.printf(" <div>\n");
      out.printf("  이름: <input name = 'name' type = 'text' value='%s'>\n", member.getName());
      out.printf("  </div>\n");
      out.printf("  <div>\n");
      out.printf("  이메일: <input readonly name = 'email' type='text' value='%s'>\n",
          member.getEmail());
      out.printf("  </div>\n");
      out.printf(" <div>\n");
      out.printf("  비밀번호: <input name = 'password' type = 'password'>\n");
      out.printf("  </div>\n");
      out.printf(" <div>\n");
      out.printf("  주소: <input name = 'addr' type = 'text' value='%s'>\n", member.getAddr());
      out.printf("  </div>\n");
      out.printf(" <div>\n");
      out.printf("  전화번호: <input readonly name = 'tel' type = 'text' value='%s'>\n", member.getTel());
      out.printf("  </div>\n");
      out.printf(" <div>\n");
      out.printf("  가입일: <input readonly name='createDate' type = 'text' value='%s'>\n",
          member.getCreatedDate());
      out.printf("  </div>\n");

      out.printf("  </ul>\n");
      out.printf("  </div>\n");
      out.printf("  <div>\n");
      out.printf("  <button> 변경 </button>");
      out.printf("  <a href='/membership/delete?no=%d'>[삭제]</a>\n", no);
      out.printf("  </div>\n");
      out.printf("</form>\n");
    } catch (Exception e) {
      request.setAttribute("message", "조회 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
    request.getRequestDispatcher("/footer").include(request, response);
    out.println("</body>");
    out.println("</html>");
  }
}
