<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>servlet3.0之文件上传</title>
	</head>
	<body>
		<h1>文件上传</h1>
		<form action="${ pageContext.request.contextPath }/FileUpLoadServlet" method="post" enctype="multipart/form-data">
			<input type="file" name="upload"><br>
			<input type="submit" value="文件上传">
		</form>
		<h1>普通表单</h1>
		<form action="${ pageContext.request.contextPath }/FileUpLoadServlet" method="post" enctype="application/x-www-form-urlencoded">
			<input type="file" name="upload"><br>
			<input type="submit" value="文件上传">
		</form>
	</body>
</html>