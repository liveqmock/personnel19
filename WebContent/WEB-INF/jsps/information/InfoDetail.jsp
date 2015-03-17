<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/personnel/comm/css/information/InfoDetail.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="toptable_style">
		<tr>
			<td><span class="title_style">
			<a href="/personnel/user_info.inf?method=jump"><input type="button"
			value="返回" id="back"> 
			</a></span></td>
		</tr>
		</table>
		<div id="boundary_row"></div>
		<table class="centtable_style" cellspacing="1px">
			<c:forEach var="var" items="${personDetail}">
			<tr>
				<td class="toptr">员工编号</td>
				<td class="centtr">${var.personnelNo}</td>
			</tr>
			<tr>
				<td class="toptr">员工姓名</td>
				<td class="centtr">${var.personnelName}</td>
			</tr>
			<tr>
				<td class="toptr">员工性别</td>
				<td class="centtr">${var.personnelSex}</td>
			</tr>
			<tr>
				<td class="toptr">出生日期</td>
				<td class="centtr">${var.birthday}</td>
			</tr>
			<tr>
				<td class="toptr">身份证号</td>
				<td class="centtr">${var.identityId}</td>
			</tr>
			<tr>
				<td class="toptr">婚姻状况</td>
				<td class="centtr">${var.wedLock}</td>
			</tr>
			<tr>
				<td class="toptr">民族</td>
				<td class="centtr">${var.race}</td>
			</tr>
			<tr>
				<td class="toptr">机关</td>
				<td class="centtr">${var.nativePlace}</td>
			</tr>
			<tr>
				<td class="toptr">政治面貌</td>
				<td class="centtr">${var.politic}</td>
			</tr>
			<tr>
				<td class="toptr">电子邮箱</td>
				<td class="centtr">${var.EMail}</td>
			</tr>
			<tr>
				<td class="toptr">联系电话</td>
				<td class="centtr">${var.phone}</td>
			</tr>
			<tr>
				<td class="toptr">联系地址</td>
				<td class="centtr">${var.address}</td>
			</tr>
			<tr>
				<td class="toptr">部门</td>
				<td class="centtr">${var.duty}</td>
			</tr>
			<tr>
				<td class="toptr">基本工资</td>
				<td class="centtr">未知</td>
			</tr>
			<tr>
				<td class="toptr">聘用形式</td>
				<td class="centtr">${var.engageForm}</td>
			</tr>
			<tr>
				<td class="toptr">最高学历</td>
				<td class="centtr">${var.tipTopDegree}</td>
			</tr>
			<tr>
				<td class="toptr">所属专业</td>
				<td class="centtr">${var.spacialty}</td>
			</tr>
			<tr>
				<td class="toptr">毕业院校</td>
				<td class="centtr">${var.school}</td>
			</tr>
			<tr>
				<td class="toptr">入职日期</td>
				<td class="centtr">${var.beginContract}</td>
			</tr>
			<tr>
				<td class="toptr">在职状态</td>
				<td class="centtr">${var.workState}</td>
			</tr>
			<tr>
				<td class="toptr">工号</td>
				<td class="centtr">${var.workId}</td>
			</tr>
			<tr>
				<td class="toptr">合同期限</td>
				<td class="centtr">${var.contractTerm}</td>
			</tr>
</c:forEach>
		</table>
</body>
			
			
			
			
