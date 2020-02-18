<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>运算符的使用</title>
	</head>
	<body>
		<%
			pageContext.setAttribute("n1", 10);
		    pageContext.setAttribute("n2", 20);
		    pageContext.setAttribute("n3", 30);
		    pageContext.setAttribute("n4", 40);
		%>
		
		<h1>算术运算符的使用:+、-、*、/(div)、%(mod)</h1>
		${ n1+n2+n3 }		<%-- 60 --%>
		${ "10"+n1 }		<%-- 20 --%>
		${ '10'+n1 }		<%-- 20 --%>
		<%-- ${ 'a'+n1 } 将字符a转换成数字进行计算，会报异常 --%>
		
		<h1>逻辑运算符：==、！=、>、>=、<、<= </h1>
		${ n1 eq n2 }		<%-- false true false true true true --%>
		${ n1 ne n2 }
		${ n1 gt n2 }
		${ n1 ge n1 }
		${ n1 lt n2 }
		${ n1 le n2 }
		
		<h1>关系运算符：&&、||、！</h1>	
		${ n1 eq n2 and n1 eq n2 }		<%-- false false true --%>
		${ n1 eq n2 or  n1 eq n2 }
		${ not (n1 eq n2) }
		
		<h1>三元运算符</h1>
		${ n1>n2?"正确":"错误" }
		
		<h1>empty运算符</h1>
		${ empty user }			<%-- true --%>
		${ not empty user }		<%-- false --%>
	</body>
</html>