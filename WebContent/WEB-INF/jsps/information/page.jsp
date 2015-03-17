<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/personnel/comm/css/information/personInfo.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table>
			<tr>
				<td><div id="pagestyle"></div></td>
				<td><a href="/personnel/page.inf?method=paging&curPage=1"><img
						src="/personnel/comm/images/comm/main_54.gif" /></a></td>
				<td><a href="/personnel/page.inf?method=paging&curPage=${page.curPage-1}&way=up"><img
						src="/personnel/comm/images/comm/main_56.gif" /></a></td>
				<td><a href="/personnel/page.inf?method=paging&curPage=${page.curPage+1}&way=down"><img
						src="/personnel/comm/images/comm/main_58.gif" /></a></td>
				<td><a href="/personnel/page.inf?method=paging&curPage=${page.pageNum}"><img
						src="/personnel/comm/images/comm/main_60.gif" /></a></td>
				<td>转到</td>
				<td><input type="text" name="pageNum" id="page" class="pageinput" /></td>
				<td>页</td>
				<td>
				<input type="button" value="" id="pagejump"></td>
		</table>
</body>
</html>