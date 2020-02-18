<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>使用EL表达式获取请求参数</title>
	</head>
	<body>
		<h1>获取请求参数</h1>
		${ param.username }		<%-- 获取到的是字符串参数 --%>
		${ param.hobby }		<%-- 获取的是数组的第一个值 --%>
		${ paramValues.hobby }	<%-- 获取到的是数组地址 --%>
		
		<h1>获取请求头</h1>
		${ header.accept }		<%-- text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8  --%>
		
		<h1>pageContext：获取项目名</h1>
		<%= ((HttpServletRequest)pageContext.getRequest()).getContextPath() %>	<%-- /web_el --%>
		${ pageContext.request.contextPath }	<%-- /web_el --%>
		
		<h1>获取全局初始化参数</h1>
		${ initParam.username }	<%-- password --%>
		
		<h1>获取Cookie</h1>
		${ cookie }				<%-- {JSESSIONID=javax.servlet.http.Cookie@6087eab8} --%>
	</body>
</html>