package com.eomcs.web.ex05;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class MyHttpServlet extends GenericServlet {

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    service((HttpServletRequest) req, (HttpServletResponse) res);
  }

  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }
}
