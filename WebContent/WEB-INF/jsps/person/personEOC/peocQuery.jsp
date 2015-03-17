<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript"
	src="comm/js/person/personEOC/peocQuery.js"></script>
<link type="text/css"
	href="comm/css/person/personEOC/peocQuery.css" rel="stylesheet" />
	
	<script type="text/javascript" src="/personnel/comm/js/comm/jquery.js"></script>
	
<script language="javascript" type="text/javascript" src="../../calenderController/My97DatePicker/WdatePicker.js"></script>
<link rel="text/javascript">

<script>
	$(document)
			.ready(
					function() {
						//控制跳转到多少页
						$("a#tiao")
								.click(
										function() {
											var flag = true;
											//alert($("input[name=allpage]").val());
											//alert($("input#textfield").val());
											if ($("input#cPTemp").val() < 1
													|| $("input#cPTemp").val() > $(
															"input[name=allpage]")
															.val()) {
												document
														.getElementById("numError").innerHTML = "输入的页数不在已有页数范围之内,请重新输入！";
												flag = false;
											} else {
												document
														.getElementById("numError").innerHTML = " ";
												$("a#tiao")
														.attr(
																"href",
																$("a#tiao")
																		.attr(
																				"href")
																		+ $(
																				"input#cPTemp")
																				.val());

											}
											return flag;
										});

					});
</script>

<style type="text/css">
.inputLength {
	max-width: 70px;
	border: solid 1px #d4d0c8;
}
.searchtable_style {
	
	cellspacing: 1px;
	background-color: rgb(168, 199, 206);
}
#search {
	margin-left: 50px;
	margin-right: 50px;
}

.STYLE19 {
	color: #344b50;
	font-size: 12px;
}

.STYLE21 {
	font-size: 12px;
	color: #3b6375;
}

.STYLE22 {
	font-size: 12px;
	color: #295568;
}

.fontSet {
	font-size: 14px;
	color: #000000;
}
.leftTd
{
background-color: rgb(211, 234, 239);
text-align: right;
}
#resultTable
{
margin-left: 15px;
margin-right: 15px;
	float:left;
width: 97%;
}
.down
{
margin-left: 18px;
margin-right: 25px;
}
.downRight{
margin-right: 5px;
}

</style>

<title>人事管理-员工奖惩查询界面</title>
</head>
<body>

	<div id="peocQueryContainer">
	
	    <div id="peocQueryTitle">
			<div id=titleText>人事管理&nbsp;&nbsp;&nbsp;员工奖惩管理：</div>
			<div class="titleButton">
			    <img class="titleButtonImage" src="/personnel/comm/images/comm/add.gif">
			    <a class="titleButtonText" href="personEOC.per?method=insertPeocPage" >新增</a>
			</div>
		</div>

		<div id="QueryPage">
			<div id=selectionTitle>请选择查找细节</div>
			
			<div id="selectionMain">
				<form id="form1" action="personInfo.per?method=firstJumpInto"
					method="post">
					<input name="testText" type="text" /> <input type="button"
						value="查询" onclick="submitButton();" />
				</form>
			</div>
			
		</div>

		<div id="peocQueryShow">

		<c:if test="${ empty requestScope.peocs }">
		    <div class="nullList">没有员工奖惩的信息，请选择其他操作</div>
		</c:if>
		
		<c:if test="${! empty requestScope.peocs }">

			<table>
			
				<tr class="tr1">
				
		    		<td class="td0">基本操作</td>		    		
		    		<td class="td1">员工编号</td>
		    		<td class="td2">员工姓名</td>		    		
		    		<td class="td3">奖惩日期</td>
		    		<td class="td4">奖惩原因</td>		    		
		    		<td class="td5">奖惩种类</td>
		    		<td class="td6">奖惩分数</td>
		    		<td class="td7">奖惩金额</td>		    		
		    		<td class="td8">奖惩备注</td>

				</tr>
				<c:forEach var="p" items="${requestScope.peocs }">
					<tr class="tr2">
		    			<td class="td0">
		    			    <a href="personEOC.per?method=updatePeocPage&peocId=${p.peocId }" class = "titleA"   >修改</a>
		    			    <span> | </span>
		    			    <a href="personEOC.per?method=deletePeoc&peocId=${p.peocId }" class = "titleA">删除</a>
		    			
		    			</td>
						<td class="td1">${p.personnelinfo.personnelNo }</td>
						<td class="td2">${p.personnelinfo.personnelName }</td>
						<td class="td3">${fn:substring(p.peocDate, 0,19)}</td>
						<td class="td4">${p.peocReason }</td>
						<td class="td5">${p.encorchast.personnelEncOrChastSort }</td>
						<td class="td6">${p.encorchast.personnelEncOrChastPoint }</td>
						<td class="td7">${p.encorchast.money }</td>
						<td class="td8">${p.personnelTrainRemark }</td>

					</tr>

				</c:forEach>

			</table>
			
		</c:if>

		</div>

		
		<div class="down">
		<c:if test="${result.size() !='0'}">
			<table width="100%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td height="30"><table width="100%" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<td width="45%" class="recordSet"><div align="left">
										<c:if test="${pg.currentPage <= pg.allPage}">
											<span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;共有<strong>
													${pg.num}</strong> 条记录，当前第<strong>${pg.currentPage}</strong> 页，共 <strong>${pg.allPage}</strong>
												页
											</span>
										</c:if>
									</div></td>

								<td width="55%"><table width="310" border="0" align="right"
										cellpadding="0" cellspacing="0">
										<tr>
											<td width="49"><div align="center">
													<a
														href="personEOC.per?method=firstJumpIntoPage&&pgNum=${pg.num}&&pgPages=${pg.allPage}"><img
														src="/personnel/comm/images/comm/main_54.gif" width="40"
														height="15" /></a>
												</div></td>
											<td width="49"><div align="center">
													<c:if test="${pg.currentPage ne '1' }">
														<a
															href="personEOC.per?method=firstJumpIntoPage&&cP=${pg.currentPage-1}&&pgNum=${pg.num}&&pgPages=${pg.allPage}"><img
															src="/personnel/comm/images/comm/main_56.gif" width="45"
															height="15" /></a>
													</c:if>
													<!-- 上一页 -->
													<c:if test="${pg.currentPage eq '1' }">
														<img src="/personnel/comm/images/comm/main_56.gif"
															width="45" height="15" />
													</c:if>
													<!-- 上一页 -->
												</div></td>
											<td width="49"><div align="center">
													<c:if test="${pg.currentPage != pg.allPage}">
														<a
															href="personEOC.per?method=firstJumpIntoPage&&cP=${pg.currentPage+1}&&pgNum=${pg.num}&&pgPages=${pg.allPage}"><img
															src="/personnel/comm/images/comm/main_58.gif" width="45"
															height="15" /></a>
													</c:if>
													<!-- 下一页 -->
													<c:if test="${pg.currentPage eq pg.allPage}">
														<img src="/personnel/comm/images/comm/main_58.gif"
															width="45" height="15" />
													</c:if>
													<!-- 下一页 -->
												</div></td>
											<td width="49"><div align="center">
													<a
														href="personEOC.per?method=firstJumpIntoPage&&cP=${pg.allPage}&&pgNum=${pg.num}&&pgPages=${pg.allPage}"><img
														src="/personnel/comm/images/comm/main_60.gif" width="40"
														height="15" /></a>
													<!--尾页 -->

												</div></td>
											<td width="37" class="STYLE22"><div align="center">转到</div></td>
											<td width="22"><div align="center">
													<input type="hidden" name="allpage" value="${pg.allPage}" />
													<input type="text" class="inputLength" name="cP"
														id="cPTemp"
														style="width: 20px; height: 12px; font-size: 12px; border: solid 1px #7aaebd;" />

												</div></td>
											<td width="22" class="STYLE22"><div align="center">页</div></td>
											<td width="35"><a
												href="personEOC.per?method=firstJumpIntoPage&&pgNum=${pg.num}&&pgPages=${pg.allPage}&&cP="
												id="tiao"> <img
													src="/personnel/comm/images/comm/main_62.gif" width="26"
													height="15" />
											</a></td>
										</tr>
									</table></td>
							</tr>

						</table></td>
				</tr>
				<tr align="right">
					<td><div class="downRight"><a href=""><font size="2px;" color="#295568;">导出Excel</font></a></div></td>
				</tr>
				<tr align="right">
					<td><font size="2px;" color="red"><span id="numError"></span></font></td>
				</tr>
			</table>
		</c:if>



</div>
	</div>
		


	</div>

</body>
</html>