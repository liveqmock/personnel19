<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="personAdjustSalary.per?method=save" method="post">
	<table border="1">
			<tr>
				<td>奖金</td>
				<td>午餐补助</td>
				<td>交通补助</td>
				<td>基本工资</td>
				<td>应发工资</td>
				<td>调薪原因</td>
				<td>备注</td>
			</tr>
		<c:forEach var="salary" items="${salaryList }">
			<tr>
				<td><input type="text" value="${salary.bonus }" name="bonus"/></td>
				<td><input type="text" value="${salary.lunchSalary }" name="lunchSalary"/></td>
				<td><input type="text" value="${salary.trafficSalary }" name="trafficSalary"/></td>
				<td><input type="text" value="${salary.basicSalary }" name="basicSalary"/></td>
				<td><input type="text" value="${salary.allSalary }" name="allSalary" readonly="readonly"/></td>
				<td><input type="text" value="请输入调薪原因" name="personAdjustSalaryReason" /></td>
				<td><input type="text" value="请输入备注" name="personnelAdjustSalaryRemark" /></td>
			</tr>
		</c:forEach>
			<tr>
				<td><input type="submit" value="提交"/></td>
			</tr>
	</table>
</form>
</body>
</html>