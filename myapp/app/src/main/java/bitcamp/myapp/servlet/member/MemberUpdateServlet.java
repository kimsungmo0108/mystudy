package bitcamp.myapp.servlet.member;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.mysql.MemberDaoImpl;
import bitcamp.myapp.vo.Member;
import java.io.IOException;
import java.sql.Date;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {

  private MemberDao memberDao;
  private String uploadDir;

  @Override
  public void init() throws ServletException {
    this.memberDao = (MemberDaoImpl) this.getServletContext().getAttribute("memberDao");
    uploadDir = this.getServletContext().getRealPath("/upload");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      request.setCharacterEncoding("UTF-8");

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (loginUser == null) {
        throw new Exception("로그인하시기 바랍니다.");
      }
      int no = Integer.parseInt(request.getParameter("no"));
      Member old = memberDao.findBy(no);

      Member member = new Member();
      member.setNo(old.getNo());
      member.setName(request.getParameter("name"));
      member.setEmail(request.getParameter("email"));
      member.setPassword(request.getParameter("password"));
      member.setCreatedDate(Date.valueOf(request.getParameter("createDate")));
      if (member == null) {
        throw new Exception("번호가 유효하지 않습니다.");
      } else if (member.getNo() != loginUser.getNo()) {
        throw new Exception("권한이 없습니다.");
      }

      Part photoPart = request.getPart("photo");
      if (photoPart.getSize() > 0) {
        String filename = UUID.randomUUID().toString();
        member.setPhoto(filename);
        photoPart.write(this.uploadDir + '/' + filename);
      } else {
        member.setPhoto(old.getPhoto());
      }

      memberDao.update(member);

      response.sendRedirect("/member/list");

    } catch (Exception e) {
      request.setAttribute("message", "변경 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error").forward(request, response);
    }
  }
}
