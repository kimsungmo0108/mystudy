package bitcamp.myapp.controller;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthController {

  MemberDao memberDao;


  public AuthController(MemberDao memberDao) {

    this.memberDao = memberDao;
  }


  @RequestMapping("/auth/login")
  public String login(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    if (request.getMethod().equals("GET")) {
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
      return "/auth/form.jsp";
    }

    String email = request.getParameter("email");
    String password = request.getParameter("password");

    // include 서블릿에서는 쿠키를 응답헤더에 추가할 수 없다
    // => 프론트 컨트롤러가 추가하게 하라!
    ArrayList<Cookie> cookies = new ArrayList<>();
    String saveEmail = request.getParameter("saveEmail");
    if (saveEmail != null) {
      Cookie cookie = new Cookie("email", email);
      cookie.setMaxAge(60 * 60 * 24 * 7);
      cookies.add(cookie);
    } else {
      Cookie cookie = new Cookie("email", "");
      cookie.setMaxAge(0);
      cookies.add(cookie);
    }

    request.setAttribute("cookies", cookies);

    Member member = memberDao.findByEmailAndPassword(email, password);
    if (member != null) {
      request.getSession().setAttribute("loginUser", member);
    }

    return "/auth/login.jsp";
  }

  @RequestMapping("/auth/logout")
  public String logout(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getSession().invalidate();
    return "redirect:/index.html";
  }

}
