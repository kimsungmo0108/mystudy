package membership.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/footer")
public class FooterServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(
        "<footer style='background-color:gray; color:white; padding:10px; text-align:center'>");
    out.println("  <div>");
    out.println("    <address>경기도 일산서구 덕이동</address>");
    out.println("    <p>rlatjdah8585@daum.net</p>");
    out.println("    <p> &copy; 2024 비트캠프 네이버 클라우드 데브옵스 5기 </p>");
    out.println("  </div>");
    out.println("</footer>");
  }
}
