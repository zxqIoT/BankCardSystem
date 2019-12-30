<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户信息</title>
</head>
<body style="background:url(img/bg3.jpg) ;background-size:cover; ">
<font color="red" size="2"> ${msg}</font>
<font color="red" size="2"> ${time}</font>
<center>
<h1>用户信息</h1>
<div>
<font color="red" size="4"> ${ph}</font>
</div>
<div>
<font color="red" size="4"> ${card}</font>
</div>
<div>
<font color="red" size="4"> ${acount}</font>
</div>
<div>
<font color="red" size="5"> ${infor}</font>
</div>
</center>
</body>
</html>