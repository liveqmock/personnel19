<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="/personnel/comm/css/management/PersonnelManagement/PersonInfo.css"
	type="text/css" rel="stylesheet" />
<!-- 注意这个link的位置 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="/personnel/comm/js/management/PersonnelManagement/PersonInfo.js"></script>
<style type="text/css">
.STYLE19 {
	color: #344b50;
	font-size: 12px;
}
.leftTd
{
	background-color: rgb(211, 234, 239);
	text-align: right;
	font-size: 12px;		
}
.rightTd
{
	background-color: #FFFFFF;
	text-align: left;
	font-size: 12px;
	color: #344b50;
	
}
.infotable_style
{
  	margin-left: auto;
margin-right: auto;
	cellspacing: 1px;
	background-color: rgb(168, 199, 206);
}
.toptable_style {
	width: 100%;
	cellspacing: 1px;
	background-color: #353c44;
}
#boundary_row {
	width: 100%;
	height: 3px;
}
</style>
</head>
<body>

	<div id="info">
	<table class="toptable_style">
			<tr>
				<td width="85%"><img src="/personnel/comm/images/comm/tb.gif" />
					<span class="title_style">员工信息列表</span></td>
			</tr>
</table>
<div id="boundary_row"></div>
		<table class="infotable_style" cellspacing="1px">
			<tr class="centtr">
				<td width="100" height="20" class="leftTd"bgcolor="#FFFFFF"  >工号:</td>
				<td width="100"height="20" bgcolor="#FFFFFF" class="rightTd">${person.personnelNo}</td>
				<td width="100" height="20" bgcolor="#FFFFFF" class="leftTd">电话:</td>
				<td width="100"  height="20" bgcolor="#FFFFFF" class="rightTd">${person.phone}</td>
				<td width="100" height="20" bgcolor="#FFFFFF" class="leftTd">积分:</td>
				<td width="100"height="20" bgcolor="#FFFFFF" class="rightTd">${person.score}分</td>


				<td width="100"height="20" bgcolor="#FFFFFF" class="leftTd">邮箱:</td>
				<td width="100"height="20" bgcolor="#FFFFFF" class="rightTd">${person.EMail}</td>
			</tr>
			<tr class="centtr">
				<td height="20" bgcolor="#FFFFFF" class="leftTd">姓名:</td>
				<td height="20" bgcolor="#FFFFFF" class="rightTd">${person.personnelName}</td>
				<td height="20" bgcolor="#FFFFFF" class="leftTd">地址:</td>
				<td height="20" bgcolor="#FFFFFF" class="rightTd">${person.address}</td>
				<td height="20" bgcolor="#FFFFFF" class="leftTd">婚姻状况:</td>
				<td height="20" bgcolor="#FFFFFF" class="rightTd">
				<c:if test="${person.wedLock eq '10020001'}">已婚</c:if>
				<c:if test="${person.wedLock eq '10020002' }">未婚</c:if>
			</td>
				<td height="20" bgcolor="#FFFFFF" class="leftTd">身份证号:</td>
				<td height="20" bgcolor="#FFFFFF" class="rightTd">${person.identityId}</td>

			</tr>
			<tr class="centtr">

				<td height="20" bgcolor="#FFFFFF" class="leftTd">年龄:</td>
				<td height="20" bgcolor="#FFFFFF" class="rightTd">${person.age}岁</td>
				<td height="20" bgcolor="#FFFFFF" class="leftTd">政治面貌:</td>
				<td height="20" bgcolor="#FFFFFF" class="rightTd">
				<c:if test="${person.politic eq '10030001'}">团员</c:if>
				<c:if test="${person.politic eq '10030002' }">党员</c:if>
				<c:if test="${person.politic eq '10030003' }">群众</c:if></td>
				<td height="20" bgcolor="#FFFFFF" class="leftTd">在职状态:</td>
				<td height="20" bgcolor="#FFFFFF" class="rightTd">
				<c:if test="${person.workState eq'10060001'}">在职</c:if>
				<c:if test="${person.workState eq'10060002' }">离职</c:if>
				<c:if test="${person.workState eq'10060003'}">带薪休假</c:if>
				<c:if test="${person.workState eq'10060004'}">停职</c:if>
				<c:if test="${person.workState eq'10060005' }">退休</c:if>
				<c:if test="${person.workState eq'10060006' }">挂职锻炼</c:if></td>
				<td height="20" bgcolor="#FFFFFF" class="leftTd">转正日期:</td>
				<td height="20" bgcolor="#FFFFFF" class="rightTd">${fn:substring(person.beginContract,0,10)}</td>


			</tr>
			<tr class="centtr">
				<td height="20" bgcolor="#FFFFFF" class="leftTd">性别:</td>
				<td height="20" bgcolor="#FFFFFF" class="rightTd"><c:if test="${person.personnelSex == '10010001' }">女</c:if><c:if test="${person.personnelSex == '10010002' }">男</c:if></td>
				<td height="20" bgcolor="#FFFFFF" class="leftTd">出生日期:</td>
				<td height="20" bgcolor="#FFFFFF" class="rightTd">${fn:substring(person.birthday,
					0,10)}</td>
				<td height="20" bgcolor="#FFFFFF" class="leftTd">聘用形式:</td>
				<td height="20" bgcolor="#FFFFFF" class="rightTd">
				<c:if test="${person.engageForm eq '10040001'}">临时聘用</c:if>
				<c:if test="${person.engageForm eq '10040002'}">长期聘用</c:if></td>
				<td height="20" bgcolor="#FFFFFF" class="leftTd">合同起始日期:</td>
				<td height="20" bgcolor="#FFFFFF" class="rightTd">${fn:substring(person.beFormDate,0,10)}</td>

			</tr>
			<tr class="centtr">
				<td height="20" bgcolor="#FFFFFF" class="leftTd">籍贯:</td>
				<td height="20" bgcolor="#FFFFFF" class="rightTd">${person.nativePlace}</td>
				<td height="20" bgcolor="#FFFFFF" class="leftTd">毕业院校:</td>
				<td height="20" bgcolor="#FFFFFF" class="rightTd">${person.school}</td>

				<td height="20" bgcolor="#FFFFFF" class="leftTd">合同期限:</td>
				<td height="20" bgcolor="#FFFFFF" class="rightTd">${person.contractTerm}年</td>
				<td height="20" bgcolor="#FFFFFF" class="leftTd">合同终止日期:</td>
				<td height="20" bgcolor="#FFFFFF" class="rightTd">${fn:substring(person.endContract,0,10)}</td>


			</tr>
			<tr class="centtr">
				<td height="20" bgcolor="#FFFFFF" class="leftTd">民族:</td>
				<td height="20" bgcolor="#FFFFFF" class="rightTd">${person.race}</td>
				<td height="20" bgcolor="#FFFFFF" class="leftTd">所属专业:</td>
				<td height="20" bgcolor="#FFFFFF" class="rightTd">${person.spacialty}</td>


				<td height="20" bgcolor="#FFFFFF" class="leftTd">入职日期:</td>
				<td height="20" bgcolor="#FFFFFF" class="rightTd">${fn:substring(person.beginWorkDate,
					0,10)}</td>
				<td></td>
				<td></td>
			</tr>

			<tr class="centtr">
				<td height="20" bgcolor="#FFFFFF" class="leftTd">工龄:</td>
				<td height="20" bgcolor="#FFFFFF" class="rightTd">${person.workAge}年</td>

				<td height="20" bgcolor="#FFFFFF" class="leftTd">最高学历:</td>
				<td height="20" bgcolor="#FFFFFF" class="rightTd">
				<c:if test="${person.tipTopDegree eq '10050001'}">小学</c:if>
				<c:if test="${person.tipTopDegree eq '10050002'}">初中</c:if>
				<c:if test="${person.tipTopDegree eq '10050003'}">高中</c:if>
				<c:if test="${person.tipTopDegree eq '10050004'}">大专</c:if>
				<c:if test="${person.tipTopDegree eq '10050005'}">大学本科</c:if>
				<c:if test="${person.tipTopDegree eq '10050006'}">硕士</c:if>
				<c:if test="${person.tipTopDegree eq '10050007'}">博士</c:if></td>
				<td height="20" bgcolor="#FFFFFF" class="leftTd">离职日期:</td>
				<td height="20" bgcolor="#FFFFFF" class="rightTd">${fn:substring(person.notWorkState,0,10)}</td>

				<td class="blankTd"></td>
				<td class="blankTd"></td>
				
			</tr>
		</table>
		<div align="center">
			<a href=""><font size="2px;" color="#295568;">导出Excel</font></a>

		</div>
	</div>
</body>
</html>