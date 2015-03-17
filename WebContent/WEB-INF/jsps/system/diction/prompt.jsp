<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
提交成功！
<form action="diction.sys" method="post">
<input type="hidden" name="method" value="addSons"/>
<input type="hidden" name="fatherName" value="${fatherName }"/>
<input type="submit" value="添加子项"/>
</form>
</body>
</html>