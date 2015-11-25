<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="login.do" method="post">
姓名：  <input type="text" name="userName">
密码:<input type="password" name="password">
<input type="submit" value="登录">
<%
String info=(String)request.getAttribute("ErrorInfo"); 
out.println(info==null?"":info);
%>
</form>
</body>
</html>