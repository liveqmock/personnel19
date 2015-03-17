<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function sum(){
	
	var s1=document.getElementById("1").value;
	var s2=document.getElementById("2").value;
	var s3=document.getElementById("3").value;
	var s4=document.getElementById("4").value;
	var a5=Number(s1)+Number(s2)+Number(s3)+Number(s4);
	document.getElementById("5").value=a5;
}

</script>
<form action="salarymanage.sal?method=changeSalary" method="post">
<table>
<tr>
<th>部门名称</th>
<th>职位名称</th>
<th>奖金</th>
<th>餐补</th>
<th>交通补助</th>
<th>基本工资</th>
<th>总工资</th>
</tr>
<tr>
<td>${deptname}</td>
<td>${jobname }</td>
<td><input type="number" value="${dept.salary.bonus }" name="bonus" id="1" onchange="sum()"></td>
<td><input type="number" value="${dept.salary.lunchSalary }" name="lunchSalary" id="2" onchange="sum()"></td>
<td><input type="number" value="${dept.salary.trafficSalary }" name="trafficSalary" id="3" onchange="sum()"></td>
<td><input type="number" value="${dept.salary.basicSalary }" name="basicSalary" id="4" onchange="sum()"></td>
<td><input type="text" value="${dept.salary.allSalary }" name="allSalary" readonly="readonly" id="5"></td>
<td><input type="submit" value="修改"></td>
<td><input type="hidden" name="id" value="${dept.salary.salaryId }"></td>
<td><input type="hidden" name="deptjobid" value="${dept.deptJobRelId}" >${dept.deptJobRelId}</td>
</tr>

</table>
</form>

</body>
</html>