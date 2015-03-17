<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>

<jsp:include page="/comm/resource/comm/login.html"></jsp:include>
<span id="result_a">${result }</span>
<script type="text/javascript">

document.getElementById("result_").innerHTML=document.getElementById("result_a").innerHTML;
</script>
</body>
</html>