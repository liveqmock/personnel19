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
<c:if test="${flagAppraise==null}">
		<jsp:forward page="/user_info.inf?method=queryAppraise"></jsp:forward>
</c:if>
	<form action="" style="width: 100%">
		<table class="toptable_style">
			<tr>
				<td width="85%"><img src="/personnel/comm/images/comm/tb.gif" />
					<span class="title_style">员工评价详细信息</span></td>
				<td><span class="title_style"> <input type="checkbox"
						name="selectall" id="selectall" onclick="selectAll()"/> 全选/全不选
				</span> &nbsp;
				<span class="title_style"><a href="#" class="aset"  onclick=" popwinAppraise()"> 打印</a> </span> </td>
			</tr>
		</table>
		<div id="boundary_row"></div>
		<table class="centtable_style" cellspacing="1px">
			<tr class="toptr">
				<td>选定</td>
				<td>员工编号</td>
				<td>考评日期</td> 
				<td>考评结果</td> 
				<td>考评内容</td>
				<td>考评备注</td>
			</tr>
		<c:forEach var="var" items="${showPersonAppraise}">
			<tr class="centtr">
				<td><input type="checkbox" name="checkbox" id="checkbox" /></td>
				<td>${var.personnelinfo.personnelId}</td>
				<td>${var.personnelAppraiseDate}</td>
				<td>${var.personnelAppraiseResult}</td>
				<td>${var.personnelAppraiseContent}</td>
				<td>${var.personnelAppraiseRemark}</td>
			</tr>
			</c:forEach>
		</table>
	<jsp:include page="/WEB-INF/jsps/information/pageAppraise.jsp"></jsp:include>
	</form>
</body>
</html>