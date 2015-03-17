<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/personnel/comm/css/management/fontSet.css" type="text/css"
	rel="stylesheet" />
<link
	href="/personnel/comm/css/management/PersonnelManagement/Result.css"
	type="text/css" rel="stylesheet" />
<!-- 注意这个link的位置 -->
<link href="/personnel/comm/css/management/PersonnelRecords/Result.css"
	type="text/css" rel="stylesheet" />
<!-- 注意这个link的位置 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>personnel Records </title>

<style type="text/css">
.STYLE19 {
	color: #344b50;
	font-size: 12px;
}
.recordstable_style {
	width: 500px;	
	cellspacing: 1px;
	background-color: rgb(168, 199, 206);
	margin-left: 50px;
}
.adjustSalaryTableNameSet{
	width: 30%;
	text-align: center;	
	margin-left: 300px;
}
.removetable_style {
	width: 800px;	
	cellspacing: 1px;
	background-color: rgb(168, 199, 206);
	margin-left: 100px;
}
.removeTableNameSet{
	width: 30%;
	text-align: center;	
	margin-left: 400px;
}
.peocTableNameSet{
	width: 30%;
	text-align: center;	
	margin-left: 250px;
}
.trainTableNameSet{
	width: 30%;
	text-align: center;	
	margin-left: 250px;
}
.appraiseTableNameSet{
	width: 30%;
	text-align: center;	
	margin-left: 250px;
}
.tableSet{
	float: left;
}

</style>
</head>
<body>
<br>
	<div class="personinfoDiv">
		<div class="perDivSet"><font class="fontSet">姓名:</font><span class="STYLE22"><strong>${person.personnelName}</strong></span></div>
		<div class="perDivSet"><font class="fontSet">部门:</font><span class="STYLE22"><strong>${person.getDeptJobRel().getDepartment().getDepartmentName()}</strong></span></div>
		<div class="perDivSet"><font class="fontSet">职位:</font><span class="STYLE22"><strong>${person.getDeptJobRel().getJob().getJobName()}</strong></span></div>
		<div class="perDivSet"><font class="fontSet">基本薪资:</font><span class="STYLE22"><strong>${person.getDeptJobRel().getSalary().getBasicSalary()}元</strong></span></div>
	</div>
	<br>
	<div >
	<div class="tableSet">
		<c:if test="${adjustSalary.size() eq '0' }">
			<div class="TableNameSet"><font color="red">无调薪记录</font></div>
		</c:if>
		<c:if test="${adjustSalary.size() ge '0' }">
				<span class="adjustSalaryTableNameSet">调薪表</span>
		
			<table class="recordstable_style" cellspacing="1px">
	
				<tr class="toptr" >
					<td class="topTrwidthAndLengthSet">调薪时间</td>
					
					<td class="topTrwidthAndLengthSet">调薪原因</td>
					<td class="topTrwidthAndLengthSet">调薪备注</td>
				</tr>
				<c:forEach var="parAdjustSalary"
					items="${requestScope.adjustSalary}">
					<tr class="centtr">
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${fn:substring(parAdjustSalary.adjustSalaryDate, 0,19)}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${parAdjustSalary.adjustSalaryReason}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${parAdjustSalary.personnelAdjustSalaryRemark}</td>
					</tr>
				</c:forEach>
				
			</table>
		</c:if>
	</div>
	
	<div class="tableSet">
		<c:if test="${train.size() eq'0' }">
			<div class="TableNameSet"><font color="red">无培训记录</font></div>
		</c:if>
		<c:if test="${train.size() ge '0' }">
			<div class="trainTableNameSet">培训表</div>
			
			<table class="recordstable_style" cellspacing="1px">
				<tr class="toptr">
					<td class="topTrwidthAndLengthSet">培训日期</td>
					
					<td class="topTrwidthAndLengthSet">培训内容</td>
					<td class="topTrwidthAndLengthSet">培训备注</td>
				</tr>
				<c:forEach var="perTrain" items="${train}">
					<tr class="centtr">
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${fn:substring(perTrain.personnelTrainDate, 0,19)}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${perTrain.personnelTrainConten}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${perTrain.personnelTrainRemark}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	</div><br><br><br><br>
	<div>
	<div class="tableSet">
		<c:if test="${peoc.size() eq '0' }">
			<div class="TableNameSet"><font color="red">无奖罚记录</font></div>
		</c:if>
		<c:if test="${peoc.size() ge '0' }">
			<div class="peocTableNameSet">奖罚表</div>
			
			<table class="recordstable_style" cellspacing="1px">
				<tr class="toptr">
					<td class="topTrwidthAndLengthSet">奖罚日期</td>
					
					<td class="topTrwidthAndLengthSet">奖罚原因</td>
					<td class="topTrwidthAndLengthSet">奖罚备注</td>
				</tr>
				<c:forEach var="perPeoc" items="${peoc}">
					<tr class="centtr">
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${fn:substring(perPeoc.peocDate, 0,19)}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${perPeoc.peocReason}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${perPeoc.personnelTrainRemark}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	<div class="tableSet">
		<c:if test="${apprise.size() eq '0' }">
			<div class="TableNameSet"><font color="red">无考评记录</font></div>
		</c:if>
		<c:if test="${apprise.size() ge '0' }">
			<div class="appraiseTableNameSet">考评表</div>
			
			<table class="recordstable_style" cellspacing="1px">
				<tr class="toptr">
					<td class="topTrwidthAndLengthSet">考评日期</td>
					
					<td class="topTrwidthAndLengthSet">考评内容</td>
					<td class="topTrwidthAndLengthSet">考评结果</td>
					<td class="topTrwidthAndLengthSet">考评备注</td>
				</tr>
				<c:forEach var="perApprise" items="${apprise}">
					<tr class="centtr">
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${fn:substring(perApprise.personnelAppraiseDate, 0,19)}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${perApprise.personnelAppraiseContent}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">
						<c:if test="${perApprise.personnelAppraiseResult eq '10070001'}">优秀</c:if>
						<c:if test="${perApprise.personnelAppraiseResult eq '10070002'}">良好</c:if>
						<c:if test="${perApprise.personnelAppraiseResult eq '10070003'}">中等</c:if>
						<c:if test="${perApprise.personnelAppraiseResult eq '10070004'}">合格</c:if>
						<c:if test="${perApprise.personnelAppraiseResult eq '10070005'}">不合格</c:if></td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${perApprise.personnelAppraiseRemark}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	</div><br><br><br><br><br><br><br>
	<div class="tableSet">
		<c:if test="${remove.size() eq'0' }">
			<div class="TableNameSet"><font color="red">无调动记录</font></div>
		</c:if>
		<c:if test="${remove.size() ge '0' }">
			<div class="removeTableNameSet">调动表</div>
			
			<table class="removetable_style" cellspacing="1px">
				<tr class="toptr">
					<td class="topTrwidthAndLengthSet">调动时间</td>
					
					<td class="topTrwidthAndLengthSet">调前职位</td>
					<td class="topTrwidthAndLengthSet">调后职位</td>
					<td class="topTrwidthAndLengthSet">调前部门</td>
					<td class="topTrwidthAndLengthSet">调后部门</td>
					<td class="topTrwidthAndLengthSet">调动原因</td>
					<td class="topTrwidthAndLengthSet">备注</td>
				</tr>
				<c:forEach var="perRemove" items="${remove}">
					<tr class="centtr">
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${fn:substring(perRemove.removeDate, 0,19)}
						
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${perRemove.beforeRemoveJob}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${perRemove.afterRemoveJob}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${perRemove.beforeRemoveDepartment}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${perRemove.afterRemoveDepartment}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${perRemove.removeReason}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${perRemove.personnelRemoveRemark}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>