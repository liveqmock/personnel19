<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#boundary_row {
	width: 100%;
	height: 3px;
}

#item {
	color: #e1e2e3;
	font-size: 12px;
}

.title_style {
	color: white;
	font-size: 12px;
}

.toptable_style {
	width: 80%;
	cellspacing: 1px;
	padding: 0px;
	margin: 0px;
	background-image: url("/personnel/comm/images/comm/toptable.png")
}

.centtable_style {
	width: 80%;
	cellspacing: 1px;
	background-color: rgb(168, 199, 206);
}

.toptr {
	width: 20%;
	background-color: rgb(211, 234, 239);
	text-align: center;
	font-size: 12px;
	background-color: rgb(211, 234, 239);
}

.centtr {
	padding-left: 100px;
	font-size: 12px;
	background-color: #FFFFFF;
}
.white{
text-decoration: none;
color: white
}
/* 
#substyle {
	width: 50%;
	text-align: center;
	margin-top: 10px;
	margin-left: auto;
	margin-right: auto;
	float: left;
} */
#add {
	background-image: url("/personnel/comm/images/comm/submit.png");
	border: none;
	color: white;
}

tr {
	height: 30px;
}
</style>
</head>
<body>
	<!-- <form action="bak.do?method=edit" method="post"> -->
		<table class="toptable_style">
			<tr>
				<td width="85%"><img src="/personnel/comm/images/comm/tb.gif" />
					<span class="title_style">操作日志信息</span></td>
			<!-- 	<td><span class="title_style"><img
						src="/personnel/comm/images/comm/add.gif" /><input type="submit"
						value="修改" id="add"> </span></td> -->
				<td><span class="title_style"><a href="javascript:history.go(-1);" class="white">返回</a> </span></td>
			</tr>
		</table>
		<div id="boundary_row"></div>
		<table class="centtable_style" cellspacing="1px">
			<tr>
				<td class="toptr">操作人员</td>
				<td class="centtr">
				<c:if test="${operateLog.operater==null }">
				 <input size="40" type="text" disabled="disabled"/>
				</c:if>
				<c:if test="${operateLog.operater!=null }">
				 <input size="40" type="text" disabled="disabled" value="${operateLog.operater.opName}"/>
				</c:if>
				</td>
			</tr>
			<tr>
				<td class="toptr">操作时间</td>
				<td class="centtr"><input size="40" type="text" disabled="disabled" value="${operateLog.bakDate }"/></td>
			</tr>

			<tr>
				<td class="toptr">操作描述</td>
				<td class="centtr"><textarea rows="0.5" cols="33" disabled="disabled" name="remark">${operateLog.event }</textarea></td>
			</tr>
		</table>
	<!-- </form> -->

</body>
</html>