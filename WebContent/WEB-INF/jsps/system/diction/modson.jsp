<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.left{
	width:30%;
	background-color: RGB(173,210,218);
}
.right{
	width:66%;
	background-color: RGB(255,255,255);
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/personnel/comm/css/system/modson.css">
</head>
<body>
<div id="dictop"></div>
<form action="diction.sys" method="post">
<input type="hidden" name="method" value="modSon"/>
<input type="hidden" name="sid" value="${son.sid }"/>
<table>
<tr>
<td class="left">名称</td><td class="right"><input type="text" name="name" value="${son.name }"/></td>
</tr>
<tr>
<td class="left">备注</td><td class="right"><input type="text" name="remark" value="${son.dictionLogRemark }"/></td>
</tr>
</table>
<input type="submit" value="提交"/>
</form>
</body>
</html>