<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	<h1>登录页面</h1>
	<form action="${ pageContext.request.contextPath }/AutoLoginServlet" method="post">
		username:<input type="text" name="username"><br>
		记住用户名：<input type="checkbox" name="autologin" value="true">
		<input type="submit" value="登录">
	</form>
</body>
</html>