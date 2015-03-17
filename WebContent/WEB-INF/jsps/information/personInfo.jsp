<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/personnel/comm/css/information/personInfo.css">
<link rel="stylesheet" type="text/css" href="/personnel/comm/css/information/ymPrompt.css">
<script type="text/javascript" src="/personnel/comm/js/information/ymPrompt.js"></script>
<script src="/personnel/comm/js/information/personInfo.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>personInfo</title>
</head>
<body>
<c:if test="${flag==null}">
		<jsp:forward page="/user_info.inf?method=queryAll"></jsp:forward>
</c:if>
	<form action="" style="width: 100%">
		<table class="toptable_style">
			<tr>
				<td width="85%"><img src="/personnel/comm/images/comm/tb.gif" />
					<span class="title_style">管理人员基本信息列表</span></td>
				<td><span class="title_style"> <input type="checkbox"
						name="selectall" id="selectall" onclick="selectAll()"/> 全选/全不选
				</span> &nbsp;
				<span class="title_style"><a href="#" class="aset"  onclick="popwin()"> 打印</a> </span> </td>
			</tr>
		</table>
		<div id="boundary_row"></div>
		<table class="centtable_style" cellspacing="1px">
			<tr class="toptr">
				<td>选择</td>
				<td>员工姓名</td>
				<td>员工性别</td>
				<td>电话</td>
				<td>地址</td>
				<td>入职日期</td>
				<td>工龄</td>
				<td>基本操作</td>
			</tr>
		<c:forEach var="var" items="${showPersonInfo}">
			<tr class="centtr">
				<td><input type="checkbox" name="checkbox" id="checkbox" /></td>
				<td>${var.personnelName}</td>
				<td>${var.personnelSex}</td>
				<td>${var.phone}</td>
				<td>${var.address}</td>
				<td>${var.beginContract}</td>
				<td>${var.workAge}</td>
				<td><a href="/personnel/user_info.inf?method=queryByPersonnelId&personnelId=${var.personnelId}">查看</a></td>
			</tr>
			</c:forEach>
		</table>
	<jsp:include page="/WEB-INF/jsps/information/page.jsp"></jsp:include>
	</form>
</body>
</html>