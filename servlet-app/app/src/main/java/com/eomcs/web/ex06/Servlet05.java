// 서블릿 초기화 파라미터 - 애노테이션으로 설정하기
package com.eomcs.web.ex06;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

//@WebServlet(value = "/ex06/s5", loadOnStartup = 1)
@SuppressWarnings("serial")
public class Servlet05 extends HttpServlet {
  @Override
  public void init() throws ServletException {
    System.out.println("/ex06/s5 ==> init()");

    ServletContext config = this.getServletContext();

    String jdbcDriver = config.getInitParameter("jdbc2.driver");
    String jdbcUrl = config.getInitParameter("jdbc2.url");
    String username = config.getInitParameter("jdbc2.username");
    String password = config.getInitParameter("jdbc2.password");

    System.out.println(jdbcDriver);
    System.out.println(jdbcUrl);
    System.out.println(username);
    System.out.println(password);

  }
}

