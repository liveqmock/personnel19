<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- 这里需要jstl.jar和standard.jar -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="/personnel/comm/js/person/personTrain/personTrainByDept.js"></script>
<script language="javascript" type="text/javascript"
	src="comm/calenderController/My97DatePicker/WdatePicker.js"></script>
<link rel="text/javascript">

<link type="text/css"
	href="comm/css/person/personTrain/personTrain.css"
	rel="stylesheet" />
<title>员工培训管理</title>
</head>
<body>

	<div>
		<div id="pTrainTitle">
			<div id=titleText>人事管理&nbsp;&nbsp;&nbsp;员工培训管理：</div>
			<div class="titleButton">
				<img class="titleButtonImage"
					src="/personnel/comm/images/comm/add.gif"> <a
					class="titleButtonText" onClick="locking()">新增</a>
					<a href="" class="titleButtonText1">导入Excel</a>
					<!-- <input type="file" /> -->
					<a href="" class="titleButtonText2">导出Excel</a>
			</div>
		</div>
		<div id="query" align="center">
			<!-- 员工好评 <select name="state">
				<option selected="selected">查询所有</option>
				<option>按部门查询</option>
				<option>按职务查询</option>
				eg：程序员，经理等
			</select>  -->
			<a href="personTrain.per?method=findAll&state=0&currentPage=1">查询所有</a> 
			<form>
			按部门查询：<input type="text" name="departmentName">
			按职务查询：<input type="text" name="jobName"><input type="button" value="查询" onclick="submitForm2();"></form>
			<table class="tableQuery">
				<tr class="tr1">
					<th>员工编号</th>
					<th>员工姓名</th>
					<th>培训内容</th>
					<th>培训时间</th>
					<th>备注</th>
					<th>是否删除</th>
				</tr>
				<c:forEach var="newls" items="${ls }">
					<tr class="tr2">
						<td>${newls.personnelinfo.personnelNo }</td>
						<td>${newls.personnelinfo.personnelName }</td>
						<td>${newls.personnelTrainConten }</td>
						<td>${fn:substring(newls.personnelTrainDate,0,19) }</td>
						<td>${newls.personnelTrainRemark }</td>
						<td><a
							href="personTrain.per?method=findSingle&personnelTrainId=${newls.personnelTrainId }&personnelName=${newls.personnelinfo.personnelName }&personnelTrainConten=${newls.personnelTrainConten }&personnelTrainDate=${newls.personnelTrainDate }&personnelTrainRemark=${newls.personnelTrainRemark }&state=1">删除</a>&nbsp;
							<a
							href="personTrain.per?method=findSingle&personnelTrainId=${newls.personnelTrainId }&personnelName=${newls.personnelinfo.personnelName }&state=0">修改</a>
						</td>
					</tr>
				</c:forEach>

			</table>
			<!-- 分页 -->
			<div style="margin-top: 10px;">
				<table width="312" border="0" style="margin-left: 153px;"
					cellpadding="0" cellspacing="0">
					<tr>
						<td width="49"><div align="center">
								<a href="personTrain.per?method=findAll&state=1&currentPage=1&departmentName=${departmentName }">
									<img src="/personnel/comm/images/comm/main_54.gif" width="40"
									height="15" style="margin-top: 5px;" />
								</a>
							</div></td>
						<c:if test="${currentPage ne 1 }">
							<td width="49">
								<div align="center">
									<a
										href="personTrain.per?method=findAll&state=1&currentPage=${currentPage-1 }&departmentName=${departmentName }">
										<img src="/personnel/comm/images/comm/main_56.gif" width="45"
										height="15" style="margin-top: 5px;" />
									</a>
								</div>
							</td>
						</c:if>
						<c:if test="${currentPage ne allPage }">
							<td width="49"><div align="center">
									<a
										href="personTrain.per?method=findAll&state=1&currentPage=${currentPage+1 }&departmentName=${departmentName }">
										<img src="/personnel/comm/images/comm/main_58.gif" width="45"
										height="15" style="margin-top: 5px;" />
									</a>
								</div></td>
						</c:if>
						<td width="49"><div align="center">
								<a
									href="personTrain.per?method=findAll&state=1&currentPage=${allPage }&departmentName=${departmentName }">
									<img src="/personnel/comm/images/comm/main_60.gif" width="40"
									height="15" style="margin-top: 5px;" />
								</a>
							</div></td>
						<td width="37" class="STYLE22"><div align="center">转到</div></td>
						<td width="22"><div align="center">
								<input type="text" name="textfield" id="textfield"
									style="width: 20px; height: 12px; font-size: 12px; border: solid 1px #7aaebd;" />
							</div></td>
						<td width="22" class="STYLE22"><div align="center">页</div></td>
						<td width="35"><a onclick="getPage();"><img
								src="/personnel/comm/images/comm/main_62.gif" width="26"
								height="15" /></a></td>
					</tr>
					<tr><td colspan="7" align="right"><span id="page" style="color: red; font-size: smaller;"></span></td></tr>
				</table>
				<input type="hidden" id="allPage" value="${allPage }">
			</div>
		</div>

		<div id="ly" style="position: relative; display: none;"></div>
		<!-- Get是用来从服务器上获得数据，而Post是用来向服务器上传递数据,这里表单需要用post -->
		<!--          浮层框架开始         -->
		<div id="Layer2" align="center">
			<table align="center">
				<tr>
					<td>
						<div align="right">
							<a href=JavaScript:; class="STYLE1"
								onclick="Lock_CheckForm(this);">[取消]</a>     
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div>
							<form id="formid" action="personTrain.per?method=save"
								method="post">
								<div id="personnelNo">
									员工编号： <select name="input1">
										<c:forEach var="newls" items="${ls1 }">
											<option>${newls.personnelNo }</option>
										</c:forEach>
									</select>
								</div>
								<div id="personnelTrainConten">
									培训内容：<input id="input2" name="input2" type="text"
										onblur="getConten();"><span id="span2"
										style="color: red; font-size: smaller;"></span>
								</div>
								<div id="personnelTrainDate">
									培训时间：<input id="input3" name="input3" type="text"
										onblur="getTime();" onclick="WdatePicker();"><span
										id="span3" style="color: red; font-size: smaller;"></span>
								</div>
								<div id="personnelTrainRemark">
									备注：<input name="input5" type="text">
								</div>
								<div id="button">
									<input type="button" value="提交" onclick="submitForm();">
								</div>
							</form>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<!--  浮层框架结束-->

	</div>
</body>
</html>