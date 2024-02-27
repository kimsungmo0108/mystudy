package membership.servlet;

import membership.vo.Member;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/header")
public class HeaderServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<header>");
    out.println(
        "  <a href='/index.html'><img src = 'img/01%20NAVER%20Logo_Green.png' height='80px'></a>");
    out.println("  <a href='about.html'>서비스 소개</a>");
    out.println("  <a href='/membership/list'>리스트</a>");

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      out.println("  <a href = 'auth/form.html'>로그인</a>");
    } else {
      out.printf("<span>%s</span>\n", loginUser.getName());
      out.println("  <a href = '/auth/logout'>로그아웃</a>");
    }
    out.println("  <a href='/about.html'>소개</a>");

    out.println("</header>");
  }
}
