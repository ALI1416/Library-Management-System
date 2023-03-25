<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<title>登录</title>
<meta charset="utf-8">
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath%>css/my.css" rel="stylesheet">
<script type="text/javascript" src="<%=basePath%>js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<ul class="c nav nav-tabs">
			<li class="active"><a href="<%=basePath%>logout">登录</a></li>
		</ul>
	</div>
	<%
		String display = "none";
		String color = "";
		String title = "";
		String content = "";
		String e = request.getParameter("e");
		if (e != null) {
			if (e.equals("loginErr")) {
				display = "";
				color = "warning";
				title = "登录失败";
				content = "账号或密码错误！";
			}
		}
	%>
	<div class="alert alert-<%=color%> alert-dismissable" style="display:<%=display%>">
		<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
		<h4><%=title%></h4>
		<%=content%>
	</div>
	<div class="b">
		<form action="<%=basePath%>login" method="post">
			<div>
				<h2>登录</h2>
			</div>
			<div>
				账号：<input type="text" name="user">
			</div>
			<div>
				密码：<input type="password" name="pwd">
			</div>
			<div>
				<input type="reset" value="重置" class="b2 btn btn-danger"> <input type="submit" value="登录" class="b2 btn btn-success">
			</div>
		</form>
	</div>
</body>
</html>