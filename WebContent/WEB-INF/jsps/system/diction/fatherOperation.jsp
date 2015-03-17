<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/personnel/comm/css/system/fatherOperation.css">
<title>Insert title here</title>
</head>
<body>

<div id="top">

</div>

<form action="diction.sys" method="post">
<input type="hidden" name="method" value="addOrUpdateAFather"/>
<input type="hidden" name="operation" value="${operation}"/>
<input type="hidden" name="sid" value="${dl.sid }"/>
<table cellspacing="1px" >
<tr>
<td class="left">名称</td><td class="right"><input type="text" name="name" value="${dl.name }"/></td>
</tr>
<tr>
<td class="left">备注</td><td class="right"><input type="text" name="remark" value="${dl.dictionLogRemark }"/></td>
</tr>
</table>
<div id="a">
<input type="submit" value="提交"/>
</div>
</form>

</body>
</html>