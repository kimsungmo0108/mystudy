<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp</title>
</head>
<body>
<h1>/WEB-INF/jsp2/error.jsp</h1>
<p>상태코드: ${request.getAttribute("javax.servlet.error.status_code")}</p>
<p>오류메시지: ${request.getAttribute("javax.servlet.error.message")}</p>
</body>
</html>