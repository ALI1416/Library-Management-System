<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<title>用户管理</title>
<meta charset="utf-8">
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath%>css/my.css" rel="stylesheet">
<script type="text/javascript" src="<%=basePath%>js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<ul class="c nav nav-tabs">
			<li><a href="<%=basePath%>book">图书管理</a></li>
			<li><a href="<%=basePath%>reader">读者管理</a></li>
			<li><a href="<%=basePath%>borrow">借阅管理</a></li>
			<li class="active"><a href="<%=basePath%>user">用户管理</a></li>
			<li><a>欢迎您<b> ${sessionScope.user } </b>用户
			</a></li>
			<li class="pull-right"><a href="<%=basePath%>logout">退出登录</a></li>
		</ul>
	</div>
	<%
		String display = "none";
		String color = "";
		String title = "";
		String content = "";
		String e = request.getParameter("e");
		if (e != null) {
			display = "";
			if (e.equals("pwdOk")) {
				color = "success";
				title = "修改成功";
				content = "密码修改成功！";
			}
			if (e.equals("pwdErr")) {
				color = "warning";
				title = "修改失败";
				content = "密码错误！";
			}
		} else {
			display = "none";
		}
	%>
	<div class="alert alert-<%=color%> alert-dismissable" style="display:<%=display%>">
		<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
		<h4><%=title%></h4>
		<%=content%>
	</div>
	<div class="b">
		<form action="<%=basePath%>changePwd/${sessionScope.id }/" method="post">
			<div>
				<h2>修改密码</h2>
			</div>
			<div>
				原密码：<input type="text" name="pwd">
			</div>
			<div>
				新密码：<input type="text" name="newPwd">
			</div>
			<div>
				<input type="reset" value="重置" class="b2 btn btn-danger"> <input type="submit" value="修改" class="b2 btn btn-success">
			</div>
		</form>
	</div>
</body>
</html>