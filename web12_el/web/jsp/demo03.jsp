<%@page import="cn.ade.domain.User"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>获取不同形式的数据</title>
	</head>
	<body>
		<%-- 自定义数据 --%>
		<% 
			String username = "张三";
			// 自定义对象必须放在指定作用域中，否则无法存储
			pageContext.setAttribute("username", username);	
			
			String[] arr = {"张三", "李四", "王五"};
			// application.setAttribute("arr", arr);  // 也可以使用下面的方式进行存储值的操作
			pageContext.setAttribute("arr", arr, pageContext.APPLICATION_SCOPE);	
			
			List <String> list = new ArrayList<String>();
			list.add("张三");
			list.add("李四");
			list.add("王五");
			pageContext.setAttribute("list", list, pageContext.PAGE_SCOPE);
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("san", "张三");
			map.put("si", "李四");
			map.put("wu", "王五");
			pageContext.setAttribute("map", map, pageContext.PAGE_SCOPE);
			
			Map<String, User> _map = new HashMap<String, User>();
			_map.put("san", new User("zhangsan", 10, "zhangsan1"));
			_map.put("si", new User("lisi", 11, "lisi1"));
			_map.put("wu", new User("wangwu", 12, "wangwu1"));
			pageContext.setAttribute("_map", _map, pageContext.PAGE_SCOPE);
		%>
		
		<h1>获取字符串</h1>
		${ pageScope.username }	<%-- 张三 --%>
		
		<h1>获取数组元素</h1>
		${ applicationScope.arr[0] }	<%-- 张三 --%>
		
		<h1>获取集合元素</h1>
		${ pageScope.list }		<%-- [张三, 李四, 王五] --%>
		${ pageScope.list[0] }	<%-- 张三 --%>
		
		<h1>获取map集合</h1>
		${ pageScope.map }		<%-- {san=张三, wu=王五, si=李四} --%>
		${ pageScope.map.san }	<%-- 张三 --%>
		
		<h1>获取map集合</h1>
		${ pageScope._map.san.username }	<%-- zhangsan --%>
	</body>
</html>