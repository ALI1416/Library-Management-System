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
<title>图书管理</title>
<meta charset="utf-8">
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath%>css/my.css" rel="stylesheet">
<script type="text/javascript" src="<%=basePath%>js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<ul class="c nav nav-tabs navbar-fixed-top">
			<li class="active"><a href="<%=basePath%>book">图书管理</a></li>
			<li><a href="<%=basePath%>reader">读者管理</a></li>
			<li><a href="<%=basePath%>borrow">借阅管理</a></li>
			<li><a href="<%=basePath%>user">用户管理</a></li>
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
			if (e.equals("delForbid")) {
				color = "danger";
				title = "无法删除";
				content = "不可删除！请先删除所有借该书的记录！";
			}
			if (e.equals("delOk")) {
				color = "success";
				title = "删除成功";
				content = "图书已删除！";
			}
			if (e.equals("delErr")) {
				color = "warning";
				title = "删除失败";
				content = "图书不存在！";
			}
			if (e.equals("changeForbid")) {
				color = "danger";
				title = "无法修改";
				content = "输入格式错误！";
			}
			if (e.equals("changeOk")) {
				color = "success";
				title = "修改成功";
				content = "图书已修改！";
			}
			if (e.equals("changeErr")) {
				color = "warning";
				title = "修改失败";
				content = "图书不存在或信息未做修改！";
			}
			if (e.equals("addForbid")) {
				color = "danger";
				title = "无法添加";
				content = "输入格式错误！";
			}
			if (e.equals("addOk")) {
				color = "success";
				title = "添加成功";
				content = "图书已添加！";
			}
			if (e.equals("addErr")) {
				color = "warning";
				title = "添加失败";
				content = "未知错误，请重新添加！";
			}
		} else {
			display = "none";
		}
	%>
	<div class="a">
		<div class="alert alert-<%=color%> alert-dismissable" style="display:<%=display%>">
			<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
			<h4><%=title%></h4>
			<%=content%>
		</div>
		<table class="table table-striped table-bordered table-hover">
			<tr>
				<th>ID</th>
				<th>书名</th>
				<th>作者</th>
				<th>出版社</th>
				<th>ISBN</th>
				<th>总数量</th>
				<th>现存数量</th>
				<th colspan="2">操作</th>
			</tr>
			<tr>
				<form action="<%=basePath%>addBook" method="post">
					<td>新增</td>
					<td>
						<input type="text" name="name" value="" size="24">
					</td>
					<td>
						<input type="text" name="author" value="" size="15">
					</td>
					<td>
						<input type="text" name="publishing" value="" size="15">
					</td>
					<td>
						<input type="text" name="isbn" value="" size="11">
					</td>
					<td>
						<input type="text" name="count" value="" size="1">
					</td>
					<td>
						<input type="text" name="remain" value="" size="1">
					</td>
					<td>
						<input type="submit" class="btn btn-sm btn-success" value="新增">
					</td>
					<td></td>
				</form>
			</tr>
			<c:forEach items="${list }" var="i">
				<tr>
					<form action="<%=basePath%>changeBook/${i.id }/" method="post">
						<td>${i.id }</td>
						<td>
							<input type="text" name="name" value="${i.name }" size="24">
						</td>
						<td>
							<input type="text" name="author" value="${i.author }" size="15">
						</td>
						<td>
							<input type="text" name="publishing" value="${i.publishing }" size="15">
						</td>
						<td>
							<input type="text" name="isbn" value="${i.isbn }" size="11">
						</td>
						<td>
							<input type="text" name="count" value="${i.count }" size="1">
						</td>
						<td>
							<input type="text" name="remain" value="${i.remain }" size="1">
						</td>
						<td>
							<input type="submit" class="btn btn-sm btn-warning" value="修改">
						</td>
						<td>
							<input type="button" class="btn btn-sm btn-danger" onclick="location.href='<%=basePath%>delBook/${i.id }/'" value="删除">
						</td>
					</form>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>