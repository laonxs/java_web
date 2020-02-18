<%@page import="java.util.HashMap"%>
<%@page import="cn.ade.domain.User"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>jstl标签库的core标签库</title>
	</head>
	<body>
		<c:set value="1" var="age"></c:set>
		<c:if test="${ age==1 }">
			<font color="red">helloword</font>
		</c:if>
		
		<% 
			String[] arr = {"apple", "orange", "banana"};
		%>
		<c:forEach var="i" items="<%= arr %>">		<%-- 使用<%= %>不需要将数据存入域中 --%>
			${ i }
		</c:forEach>
		
		<% 
			Map<String, User> map = new HashMap<String, User>();
			map.put("san", new User("zhangsan", 10, "zhangsan1"));
			map.put("si", new User("lisi", 10, "lisi1"));
			map.put("wu", new User("wangwu", 10, "wangwu1"));
			pageContext.setAttribute("map", map, pageContext.PAGE_SCOPE);
		%>
		<c:forEach var="i" items="${ map }">
			${ i.key }&emsp;${ i.value.username }
		</c:forEach>
		<c:forEach var="i" items="${ pageScope.map }" begin="1" end="2">
			${ pageScope.i.key }&emsp;${ pageScope.i.value.username }
		</c:forEach>
			
	</body>
</html>