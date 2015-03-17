<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/personnel/comm/js/comm/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		var a =document.getElementById("id").value;
		document.getElementById("sjob").innerHTML = a;
  	
		
	}
	function change(a) {
		var b = document.getElementsByTagName("option");

		var c;
		for(var i=0;i<b.length;i++){
			if(b[i].value==a){
				 c=b[i].getAttribute("v")
			
				}
			
		}
		
		document.getElementById("sjob").innerHTML = c;

	}
</script>
</head>
<body>
	<form action="salarymanage.sal?method=queryOneJump" method="post">
	
		<input type="hidden" id="id" value="${str}"> <a
			href="salarymanage.sal?method=queryAllJump">查询全部</a> <br> 按条件查询 <br>
		部门名称 <select name="sdept" id="sdept" onchange="change(this.value);">
		<!-- 你自己都说map 必须在循环里面  可是 change是在循环外面啊  当然没有值啊       -->
			<c:forEach items="${map}" var="map" varStatus="a">
				<option value="${map.key.departmentId}" v="${map.value}">${map.key.departmentName}</option>
			</c:forEach>



		</select> 职位名称 <select name="sjob" id="sjob">
		</select> <br> <input type="submit" value="提交">

	</form>
</body>
</html>