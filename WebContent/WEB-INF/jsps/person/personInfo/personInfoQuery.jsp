<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript"
	src="comm/js/person/personInfo/personInfoQuery.js"></script>
<link type="text/css"
	href="comm/css/person/personInfo/personInfoQuery.css" rel="stylesheet" />

<script type="text/javascript" src="/personnel/comm/js/comm/jquery.js"></script>

<script language="javascript" type="text/javascript" src="../../calenderController/My97DatePicker/WdatePicker.js"></script>


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

<title>人事管理-员工资料查询界面</title>
</head>
<body>

	<div id="personInfoQueryContainer">
	
	    <div id="personInfoQueryTitle">
			<div id=titleText>人事管理&nbsp;&nbsp;&nbsp;员工资料管理：</div>
			<div class="titleButton">
			    <img class="titleButtonImage" src="/personnel/comm/images/comm/add.gif">
			    <a class="titleButtonText" href="personInfo.per?method=insertPersonPage" >新增</a>
			</div>
		</div>
		
		<!--         -->

		<div id="QueryPage">
			<div id=selectionTitle>请选择查找细节</div>
			
			<div id="selectionMain">
				<form id="form1" action="#"
					method="post">
					<input name="testText" type="text" /> <input type="submit"
						value="查询"  />
				</form>
			</div>

		</div>

		<div id="personInfoQueryShow">
		
		<c:if test="${ empty requestScope.persons }">
		    <div class="nullList">没有员工资料的信息，请选择其他操作</div>
		</c:if>
		
		<c:if test="${! empty requestScope.persons }">

			<table>
				<tr class="tr1">
		    		<td class=“td0”>基本操作</td>
					<td class=“td1”>员工编号</td>
					<td class=“td2”>员工姓名</td>
					<td class=“td3”>性别</td>
					<td class=“td3-1”>职务</td>
					<td class=“td3-2”>职称</td>
					<td class=“td3-3”>所属部门</td>
					<td class=“td4”>出生日期</td>
					<td class=“td5”>年龄</td>
					<td class=“td6”>身份证号</td>
					<td class=“td7”>婚姻状况</td>
					<td class=“td8”>民族</td>
					<td class=“td9”>籍贯</td>
					<td class=“td10”>政治面貌</td>
					<td class=“td11”>Email</td>
					<td class=“td12”>联系电话</td>
					<td class=“td13”>地址</td>
					<td class=“td14”>聘用形式</td>
					<td class=“td15”>最高学历</td>
					<td class=“td16”>所属专业</td>
					<td class=“td17”>毕业院校</td>
					<td class=“td18”>入职日期</td>
					<td class=“td19”>在职状态</td>
					<td class=“td20”>工号</td>
					<td class=“td21”>合同期限</td>
					<td class=“td22”>转正日期</td>
					<td class=“td23”>离职日期</td>
					<td class=“td24”>合同起始日期</td>
					<td class=“td25”>合同终止日期</td>
					<td class=“td26”>工龄</td>
					<td class=“td27”>员工积分</td>

				</tr>
				<c:forEach var="p" items="${requestScope.persons }">
					<tr class="tr2">
		    			<td class="td0">
		    			    <a href="personInfo.per?method=updatePersonPage&personnelId=${p.personnelId }" class = "titleA"   >修改</a>
		    			    <span> | </span>
		    			    <a href="personInfo.per?method=deletePerson&personnelId=${p.personnelId }" class = "titleA">删除</a>
		    			</td>
						<td class="td1">${p.personnelNo }</td>
						<td class="td2">${p.personnelName }</td>
						<td class="td3">${p.personnelSex }</td>
						<td class="td3-1">${p.deptJobRel.job.jobName }</td>
				    	<td class="td3-2">${p.duty.dutyName }</td>
				     	<td class="td3-3">${p.deptJobRel.department.departmentName }</td>
						<td class="td4">${fn:substring(p.birthday, 0,19)}</td>
						<td class="td5">${p.age }&nbsp;岁</td>
						<td class="td6">${p.identityId }</td>
						<td class="td7">${p.wedLock }</td>
						<td class="td8">${p.race }</td>
						<td class="td9">${p.nativePlace }</td>
						<td class="td10">${p.politic }</td>
						<td class="td11">${p.EMail }</td>
						<td class="td12">${p.phone }</td>
						<td class="td13">${p.address }</td>
						<td class="td14">${p.engageForm }</td>
						<td class="td15">${p.tipTopDegree }</td>
						<td class="td16">${p.spacialty }</td>
						<td class="td17">${p.school }</td>
						<td class="td18">${fn:substring(p.beginWorkDate, 0,19)}</td>
						<td class="td19">${p.workState }</td>
						<td class="td20">${p.workId }</td>
						<td class="td21">${p.contractTerm }&nbsp;年</td>
						<td class="td22">${fn:substring(p.beFormDate, 0,19)}</td>
						<td class="td23">${fn:substring(p.notWorkState, 0,19)}</td>
						<td class="td24">${fn:substring(p.beginContract, 0,19)}</td>
						<td class="td25">${fn:substring(p.endContract, 0,19)}</td>
						<td class="td26">${p.workAge }&nbsp;年</td>
						<td class="td27">${p.score }</td>
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
														href="personInfo.per?method=firstJumpIntoPage&&pgNum=${pg.num}&&pgPages=${pg.allPage}"><img
														src="/personnel/comm/images/comm/main_54.gif" width="40"
														height="15" /></a>
												</div></td>
											<td width="49"><div align="center">
													<c:if test="${pg.currentPage ne '1' }">
														<a
															href="personInfo.per?method=firstJumpIntoPage&&cP=${pg.currentPage-1}&&pgNum=${pg.num}&&pgPages=${pg.allPage}"><img
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
															href="personInfo.per?method=firstJumpIntoPage&&cP=${pg.currentPage+1}&&pgNum=${pg.num}&&pgPages=${pg.allPage}"><img
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
														href="personInfo.per?method=firstJumpIntoPage&&cP=${pg.allPage}&&pgNum=${pg.num}&&pgPages=${pg.allPage}"><img
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
												href="personInfo.per?method=firstJumpIntoPage&&pgNum=${pg.num}&&pgPages=${pg.allPage}&&cP="
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
		    

	</div>

</body>
</html>