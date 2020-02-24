<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>首页</title>
	</head>
	<body>
		<c:if test="${ not empty existUser }">
			你好，${ existUser.name }
		</c:if>
		<c:if test="${ empty existUser }">
			<a href="${ pageContext.request.contextPath }/jsp/login.jsp">登陆</a>
		</c:if>
		<h1>商城主页</h1>
	</body>
</html>