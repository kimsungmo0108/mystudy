package bitcamp.myapp.controller.auth;

import bitcamp.myapp.controller.RequestMapping;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutController {

  @RequestMapping
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getSession().invalidate();
    return "redirect:/index.html";
  }
}
