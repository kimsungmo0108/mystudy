package bitcamp.myapp.servlet.member;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.mysql.MemberDaoImpl;
import bitcamp.myapp.vo.Member;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/view")
public class MemberViewServlet extends HttpServlet {

  private MemberDao memberDao;


  @Override
  public void init() throws ServletException {
    this.memberDao = (MemberDaoImpl) this.getServletContext().getAttribute("memberDao");
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
    out.println("   <title> 비트캠프 데브옵스 5 기 </title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원</h1>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Member member = memberDao.findBy(no);
      if (member == null) {
        out.println("<p>회원 번호가 유효하지 않습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      out.printf("<form action='/member/update' method='post'>\n");
      out.printf(" <div>\n");
      out.printf("  번호: <input readonly name = 'no' type = 'text' value='%s'>\n", member.getNo());
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
      out.printf("  가입일: <input readonly name='createDate' type = 'text' value='%s'>\n",
          member.getCreatedDate());
      out.printf("  </div>\n");

      out.printf("  </ul>\n");
      out.printf("  </div>\n");
      out.printf("  <div>\n");
      out.printf("  <button> 변경 </button>");
      out.printf("  <a href='/member/delete?no=%d'>[삭제]</a>\n", no);
      out.printf("  </div>\n");
      out.printf("</form>\n");

    } catch (Exception e) {
      out.println("<p>조회 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}
