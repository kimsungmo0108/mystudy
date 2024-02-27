package membership.servlet.membership;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import membership.dao.MemberDao;
import membership.dao.mysql.MemberDaoImpl;
import membership.vo.Member;

@WebServlet("/membership/add")
public class MembershipAddServlet extends HttpServlet {

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
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>비트캠프 데브옵스 5기</title>");
    out.println("</head>");
    out.println("<body>");
    request.getRequestDispatcher("/header").include(request, response);

    out.println("<h2>회원</h2>");

    out.println("<form action='/membership/add' method='post' enctype='multipart/form-data'>");
    out.println("  <div>");
    out.println("        아이디: <input name='id' type='text'>");
    out.println("  </div>");
    out.println("  <div>");
    out.println("        이름: <input name='name' type='text'>");
    out.println("  </div>");
    out.println("  <div>");
    out.println("        이메일: <input name='email' type='email'>");
    out.println("  </div>");
    out.println("  <div>");
    out.println("       비밀번호: <input name='password' type='password'>");
    out.println("  </div>");
    out.println("  <div>");
    out.println("        주소: <input name='addr' type='text'>");
    out.println("  </div>");
    out.println("  <div>");
    out.println("        전화번호: <input name='tel' type='text'>");
    out.println("  </div>");
    out.println("  <div>");
    out.println("        사진: <input name='photo' type='file'>");
    out.println("  </div>");
    out.println("    <button>등록</button>");
    out.println("</form>");
    request.getRequestDispatcher("/footer").include(request, response);
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");

    try {
      Member member = new Member();
      member.setName(request.getParameter("name"));
      member.setEmail(request.getParameter("email"));
      member.setPassword(request.getParameter("password"));
      member.setId(request.getParameter("id"));
      member.setTel(request.getParameter("tel"));
      member.setAddr(request.getParameter("addr"));

      Part part = request.getPart("photo");
      if (part.getSize() > 0) {
        String filename = UUID.randomUUID().toString();
        member.setPhoto(filename);
        part.write(uploadDir + "/" + filename);
      }

      memberDao.add(member);
      response.sendRedirect("/membership/list");

    } catch (Exception e) {
      request.setAttribute("message", "등록 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error").forward(request, response);
    }
  }
}
