<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="/personnel/comm/css/person/personnelRemove/personnelRemove.css">
<script type="text/javascript" src="/personnel/comm/js/person/personnelRemove/personnelRemove.js"></script>
<title>Insert title here</title>
</head>
<body>
<div id="container">
		<div id=title>人事管理&nbsp;&nbsp;&nbsp;员工调动：</div>
	<c:if test="${personnelid eq null }">
		<form action="personnelRemove.per?method=showJob" method="post">
			<div id="queryText">请输入员工编号：</div>
			<div id="queryInput">
			<input type="text" name="personnelNo" id="queryInputI"/>
			<input type="submit" value="查询"/>
			</div>
			<div id="queryError">
				<c:if test="${!(personnelNo eq null) }">
					<div class="error">查无此人</div>
				</c:if>
			</div>
		</form>
	</c:if>
	
	<c:if test="${!(personnelid eq null) }">
		<form id="formid" action="personnelRemove.per?method=saveRemove" method="post">
			<table>
				<tr id="trStyle1">
					<td class="tdStyle1">原部门</td>
					<td class="tdStyle1">原职位</td>
					<td class="tdStyle1">新部门</td>
					<td class="tdStyle1">新职位</td>
					<td class="tdStyle2">调动原因</td>
					<td class="tdStyle2">备注</td>
				</tr>
				<tr id="trStyle2">
					<td class="tdStyle1"><input type="text" readonly="readonly" value="${personDepartment.departmentName }" name="beforeRemoveDepartment" class="textboxForRead"/></td>
					<td class="tdStyle1"><input type="text" readonly="readonly" value="${personJob.jobName }" name="beforeRemoveJob" class="textboxForRead"/></td>
					<td class="tdStyle1">
						<select name="afterRemoveDepartment" class="textbox1">
							<c:forEach var="department" items="${departmentList }">
								<option value="${department.departmentId }">${department.departmentName }</option>
							</c:forEach>
						</select>
					</td>
					<td class="tdStyle1">
						<select name="afterRemoveJob" class="textbox1">
							<c:forEach var="job" items="${jobList }">
								<option value="${job.jobId }">${job.jobName }</option>
							</c:forEach>
						</select>
					</td>
					<td class="tdStyle2"><textarea name="removeReason" class="textbox2"></textarea></td>
					<td class="tdStyle2"><textarea name="personnelRemoveRemark" class="textbox2"></textarea></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td id="submitButton"><input type="submit" value="提交"/></td>
					<td><input type="button" value="返回" onclick="back();"/></td>
				</tr>
			</table>
		</form>
	</c:if>
</div>
</body>
</html>