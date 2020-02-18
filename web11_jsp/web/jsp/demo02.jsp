<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>练习jsp的基本语法</title>
	</head>
	<body>	
		<%-- 定义局部变量 --%>
		<%
			int c = 30;
		%>
		
		<%-- 定义成员变量 --%>
		<%! 
			int a = 10;
			int b = 20;
		%>
		
		<%-- 定义成员方法 --%>
		<%!
			public int add() {
				return a + b;
			} 
		%>
		
		<font color="red">
			<%-- 向页面输出 --%>
			<%
				out.println(add()+c);		// 60
			%>
		</font><br>
		
		<font color="red">
			<%-- 向页面输出 --%>
			<%=
				add()+c						// 60
			%>
		</font>
	</body>
</html>