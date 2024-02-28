package membership.servlet.auth;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import membership.dao.MemberDao;
import membership.dao.mysql.MemberDaoImpl;
import membership.vo.Member;


@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {

  MemberDao memberDao;

  @Override
  public void init() {

    this.memberDao = (MemberDaoImpl) getServletContext().getAttribute("memberDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String email = "";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals("email")) {
          request.setAttribute("email", cookie.getValue());
          break;
        }
      }
    }
    request.getRequestDispatcher("/auth/form.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      String email = request.getParameter("email");
      String password = request.getParameter("password");
      String saveEmail = request.getParameter("saveEmail");
      if (saveEmail != null) {
        Cookie cookie = new Cookie("email", email);
        cookie.setMaxAge(60 * 60 * 24 * 7);
        response.addCookie(cookie);
      } else {
        Cookie cookie = new Cookie("email", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
      }

      Member member = memberDao.findByEmailAndPassword(email, password);
      if (member != null) {
        request.getSession().setAttribute("loginUser", member);
      }

      request.getRequestDispatcher("/auth/login.jsp").forward(request, response);

    } catch (Exception e) {
      request.setAttribute("message", "변경 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}
