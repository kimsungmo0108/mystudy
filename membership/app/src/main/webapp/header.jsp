<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="membership.vo.Member"%>

    <header>
      <a href='/index.html'><img src = '/img/01%20NAVER%20Logo_Green.png' height='80px'></a>
      <a href='/membership/list'>리스트</a>
    <%
    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {%>
        <a href = "/auth/login">로그인</a>
<%    } else {%>
      <span><%=loginUser.getName()%></span>
        <a href = "/auth/logout">로그아웃</a>
<%    }%>
      <a href="/about.html">소개</a>
    </header>