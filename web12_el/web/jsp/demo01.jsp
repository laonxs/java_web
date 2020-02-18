<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>使用EL表达式获取指定作用域的数据</title>
	</head>
	<body>
		<%-- 向4个域对象中存储数据 --%>
		<% 
			pageContext.setAttribute("name", "pValue");
			request.setAttribute("name", "rValue");
			session.setAttribute("name", "sValue");
			application.setAttribute("name", "aValue");
		%>
		
		<h1>使用传统方式获取指定作用域的数据</h1> 
		<%= pageContext.getAttribute("name") %>
		<%= request.getAttribute("name") %>
		<%= session.getAttribute("name") %>
		<%= application.getAttribute("name") %>
		
		<h1>使用EL表达式的域对象获取指定作用域的数据</h1>
		${ pageScope.name }
		${ requestScope.name }
		${ sessionScope.name }
		${ applicationScope.name }

		<%-- 底层使用jsp内置对象pageContext.findAttribute()，从小到大寻找 --%>
		${ name }
	</body>
</html>