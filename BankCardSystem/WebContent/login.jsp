<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style type="text/css">
*{
	margin: 0;
	padding: 0;
}

.bg-blur {
            float: left;
            width: 100%;
            background-repeat: no-repeat;
            background-position: center;
            background-size: cover;
            -webkit-filter: blur(15px);
            -moz-filter: blur(15px);
            -o-filter: blur(15px);
            -ms-filter: blur(15px);
            filter: blur(15px);
        }

body{
	font-family: "微软雅黑";
	font-size: 14px;
	background: url(img/bg.jpg) fixed center center;
}
.logo_box{
	width: 280px;
	height: 490px;
	padding: 35px;
	color: #EEE;
	position: absolute;
	left: 50%;
	top:100px;
	margin-left: -175px;
}
.logo_box h3{
	text-align: center;
	height: 20px;
	font: 20px "microsoft yahei",Helvetica,Tahoma,Arial,"Microsoft jhengHei",sans-serif;
	color: #FFFFFF;
	height: 20px;
	line-height: 20px;
	padding:0 0 35px 0;
}
.forms{
	width: 280px;
	height: 485px;
}
.logon_inof{
	width: 100%;
	min-height: 450px;
	padding-top: 35px;
	position: relative;
}		
.input_outer{
	height: 46px;
	padding: 0 5px;
	margin-bottom: 20px;
	border-radius: 50px;
	position: relative;
	border: rgba(255,255,255,0.2) 2px solid !important;
}
.u_user{
	width: 25px;
	height: 25px;
	background: url(img/login_ico.png);
	background-position:  -125px 0;
	position: absolute;
	margin: 12px 13px;
}
.us_uer{
	width: 25px;
	height: 25px;
	background-image: url(img/login_ico.png);
	background-position: -125px -34px;
	position: absolute;
	margin: 12px 13px;
}
.l-login{
	position: absolute;
	z-index: 1;
	left: 50px;
	top: 0;
	height: 46px;
	font: 14px "microsoft yahei",Helvetica,Tahoma,Arial,"Microsoft jhengHei";
	line-height: 46px;
}
label{
	color: rgb(255, 255, 255);
	display: block;
}
.text{
	width: 220px;
	height: 46px;
	outline: none;
	display: inline-block;
	font: 14px "microsoft yahei",Helvetica,Tahoma,Arial,"Microsoft jhengHei";
	margin-left: 50px;
	border: none;
	background: none;
	line-height: 46px;
}
/*///*/
.mb2{
	margin-bottom: 20px
}
.mb2 a{
	text-decoration: none;
	outline: none;
}
.submit {
	padding: 15px;
	margin-top: 20px;
	display: block;
}
.act-but{
	height: 20px;
	line-height: 20px;
	text-align: center;
	font-size: 20px;
	border-radius: 50px;
	background: #0096e6;
}
/*////*/
.check{
	width: 280px;
	height: 22px;
}
.clearfix::before{
	content: "";
	display: table;
}
.clearfix::after{
	display: block;
	clear: both;
	content: "";
	visibility: hidden;
	height: 0;
}
.login-rm{
	float: left;
}
.login-fgetpwd {
	float: right;
}
.check{
	width: 18px;
	height: 18px;
	background: #fff;
	border: 1px solid #e5e6e7;
	margin: 0 5px 0 0;
	border-radius: 2px;
}
.check-ok{
	background-position: -128px -70px;
	width: 18px;
	height: 18px;
	display: inline-block;
	border: 1px solid #e5e6e7;
	margin: 0 5px 0 0;
	border-radius: 2px;
	vertical-align: middle
}
.checkbox{
	vertical-align: middle;
	margin: 0 5px 0 0;
}
/*////*/
.sas{
	width: 280px;
	height: 18px;
	float: left;
	color: #FFFFFF;
	text-align: center;
	font-size: 16px;
	line-height: 16px;
	margin-bottom: 50px;
}
.sas a{
	width: 280px;
	height: 18px;
	color: #FFFFFF;
	text-align: center;
	line-height: 18px;
	text-decoration: none;
}
</style>
</head>
<body>
	<%
		String username = "";
		String password = "";
		Cookie[] c = request.getCookies();
		if (c != null) {
			for (int i = 0; i < c.length; i++) {
				if ("logname".equals(c[i].getName())) {
					username = c[i].getValue();
				} else if ("logpassword".equals(c[i].getName())) {
					password = c[i].getValue();
				}
			}
		} else {
			username = " ";
			password = " ";
		}
	%>

<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>

<div class="logo_box">
	<center><h2>欢迎登陆</h2></center>
	<form action="Loginservlet" name="f" method="post">
		<div class="input_outer">
			<span class="u_user"></span>
			<input name="logname" class="text" placeholder="输入用户名" style="color: #FFFFFF !important" type="text" value="<%=username%>">
		</div>
		<div class="input_outer">
			<span class="us_uer"></span>
			<input name="logpassword" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;" placeholder="输入密码"  type="password" value="<%=password%>">
		</div>
		<div>
				<input type="submit" value="登录"
					style="border: rgba(255, 255, 255, 1) 2px solid !important; border-radius: 50px; color: #FFFFFF; background: #0096e6; height: 50px; width: 280px; text-align: center; font-size: 20px; padding: 15px; display: block;">
		</div>
		<input name="savesid" value="0" id="check-box" class="checkbox" type="checkbox" value="jizhu" ><span>记住用户名</span>
	</form>
	<a href="/BankCardSystem/fgpwd.jsp" class="login-fgetpwd" style="color: #FFFFFF">忘记密码？</a>

	
	<div class="sas">
		<a href="/BankCardSystem/register.jsp">还没注册账号！</a>
	</div>
	<div>
	<font color="red" size="2"> ${msg }</font>
	</div>
	
	
</div>

</body>
</html>

</body>
</html>