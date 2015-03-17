<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示全部基本信息</title>
<style type="text/css">
#boundary_row {
	width: 100%;
	height: 3px;
}

#item {
	color: #e1e2e3;
	font-size: 12px;
}

.title_style {
	color: white;
	font-size: 12px;
}

.toptable_style {
	width: 80%;
	cellspacing: 1px;
	padding: 0px;
	margin: 0px;
	background-image: url("/personnel/comm/images/comm/toptable.png")
}

.centtable_style {
	width: 80%;
	cellspacing: 1px;
	background-color: rgb(168, 199, 206);
}

.toptr {
	width: 20%;
	background-color: rgb(211, 234, 239);
	text-align: center;
	font-size: 12px;
	background-color: rgb(211, 234, 239);
}

.centtr {
	padding-left: 100px;
	font-size: 12px;
	background-color: #FFFFFF;
}
/* 
#substyle {
	width: 50%;
	text-align: center;
	margin-top: 10px;
	margin-left: auto;
	margin-right: auto;
	float: left;
} */
#add {
	background-image: url("/personnel/comm/images/comm/submit.png");
	border: none;
	color: white;
}

tr {
	height: 30px;
}
</style>
</head>
<body>
		<table class="toptable_style">
			<tr>
				<td width="85%"><img src="/personnel/comm/images/comm/tb.gif" />
					<span class="title_style">员工基本信息</span></td>
			</tr>
		</table>
<div id="boundary_row"></div>
<c:forEach var="p" items="${persons1}" begin="${index}" end="${index}">
<table class="centtable_style" cellspacing="1px">
<tr><td class="toptr">编号：</td><td class="centtr" align="left">${p.personnelNo }</td></tr>
<tr><td class="toptr">姓名：</td><td class="centtr" align="left">${p.personnelName }</td></tr>
<tr><td class="toptr">民族：</td><td class="centtr" align="left">${p.race }</td></tr>
<tr><td class="toptr">身份证号：</td><td class="centtr" align="left">${p.identityId}</td></tr>
<tr><td class="toptr">机关：</td><td class="centtr" align="left">${p.nativePlace}</td></tr>
<tr><td class="toptr">部门：</td><td class="centtr" align="left">${p.engageForm}</td></tr>
<tr><td class="toptr">性别：</td><td class="centtr" align="left">
<c:if test="${p.personnelSex eq '10010001' }">女</c:if>
<c:if test="${p.personnelSex eq '10010002' }">男</c:if>
</td></tr>
<tr><td class="toptr">婚姻状况：</td><td class="centtr" align="left">
<c:if test="${p.wedLock eq '10020001' }">已婚</c:if>
<c:if test="${p.wedLock eq '10020002' }">未婚</c:if>
</td></tr>
<tr><td class="toptr">电子邮箱：</td><td class="centtr" align="left">${p.EMail}</td></tr>
<tr><td class="toptr">联系电话：</td><td class="centtr" align="left">${p.phone}</td></tr>
<tr><td class="toptr">联系地址：</td><td class="centtr" align="left">${p.address}</td></tr>
<tr><td class="toptr">工号：</td><td class="centtr" align="left">${p.workId}</td></tr>
<tr><td class="toptr">工龄：</td><td class="centtr" align="left">${p.workAge}</td></tr>
<tr><td class="toptr">积分：</td><td class="centtr" align="left">${p.score}</td></tr>
<tr><td class="toptr">政治面貌：</td><td class="centtr" align="left">
<c:if test="${p.politic eq '10030001' }">团员</c:if>
<c:if test="${p.politic eq '10030002' }">党员</c:if>
<c:if test="${p.politic eq '10030003' }">群众</c:if>
</td></tr>
<tr><td class="toptr">最高学历：</td><td class="centtr" align="left">
<c:if test="${p.tipTopDegree eq '10050001' }">小学</c:if>
<c:if test="${p.tipTopDegree eq '10050002' }">初中</c:if>
<c:if test="${p.tipTopDegree eq '10050003' }">高中</c:if>
<c:if test="${p.tipTopDegree eq '10050004' }">大专</c:if>
<c:if test="${p.tipTopDegree eq '10050005' }">大学本科</c:if>
<c:if test="${p.tipTopDegree eq '10050006' }">硕士</c:if>
<c:if test="${p.tipTopDegree eq '10050007' }">博士</c:if>
</td></tr>
<tr><td class="toptr">在职状态：</td><td class="centtr" align="left">
<c:if test="${p.workState eq '10060001' }">在职</c:if>
<c:if test="${p.workState eq '10060002' }">离职</c:if>
<c:if test="${p.workState eq '10060003' }">带薪休假</c:if>
<c:if test="${p.workState eq '10060004' }">停职</c:if>
<c:if test="${p.workState eq '10060005' }">退休</c:if>
<c:if test="${p.workState eq '10060006' }">挂职锻炼</c:if>
</td></tr>
<tr><td class="toptr">所属专业：</td><td class="centtr" align="left">${p.spacialty}</td></tr>
<tr><td class="toptr">毕业院校：</td><td class="centtr" align="left">${p.school}</td></tr>
<tr><td class="toptr">出生日期：</td><td class="centtr" align="left">${fn:substring(p.birthday,0,19) }</td></tr>
<tr><td class="toptr">入职日期：</td><td class="centtr" align="left">${fn:substring(p.beginWorkDate,0,19)}</td></tr>
<tr><td class="toptr">转正日期：</td><td class="centtr" align="left">${fn:substring(p.beFormDate,0,19)}</td></tr>
</table>
</c:forEach>
</body>
</html>