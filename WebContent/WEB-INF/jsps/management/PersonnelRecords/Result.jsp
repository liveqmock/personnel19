<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript" src="/personnel/comm/js/comm/jquery.js"></script>
<link href="/personnel/comm/css/management/fontSet.css" type="text/css"
	rel="stylesheet" />
<link
	href="/personnel/comm/css/management/PersonnelManagement/Result.css"
	type="text/css" rel="stylesheet" />
<!-- 注意这个link的位置 -->
<script language="javascript" type="text/javascript"
	src="comm/calenderController/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript"
	src="/personnel/comm/js/management/PersonnelManagement/Search.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script >
$(document).ready(
		function(){
		//控制跳转到多少页
			$("a#tiao").click(function(){
				var flag = true;
				//alert($("input[name=allpage]").val());
				//alert($("input#textfield").val());
				if($("input#cPTemp").val()<1||$("input#cPTemp").val()>$("input[name=allpage]").val()){
					document.getElementById("numError").innerHTML="输入的页数不在已有页数范围之内,请重新输入！";
					flag =false;
				}else{
					document.getElementById("numError").innerHTML=" ";
					$("a#tiao").attr("href",$("a#tiao").attr("href")+$("input#cPTemp").val());
					
				}
				return flag;
			});
		
		});


</script>
<style type="text/css">
.fontSet {
	font-size: 14px;
	color: #000000;
}

.inputLength1 {
	max-width: 140px;
	border: solid 1px #d4d0c8;
}

.inputLength2 {
	max-width: 75px;
	border: solid 1px #d4d0c8;
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
.searchtable_style {
	
	cellspacing: 1px;
	background-color: rgb(168, 199, 206);
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
.downRight{
margin-right: 15px;
}
.personTable
{
margin-left: 15px;
width: 97%;
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

	<div><br>
	<div align="center"><font size="4px">搜索条件</font></div>
		<form action="personnelRecords.man" id="form2">
			<input type="hidden" name="method" value="findRecords" />
			
			<table class="searchtable_style" cellspacing="1px" align="center">
					<tr class="centtr">
						<td  width="100px;" height="30"  class="leftTd"bgcolor="#FFFFFF" class="STYLE19">
						<font class="fontSet">部门:</font></td>
						<td width="100px;" align="left" height="30" bgcolor="#FFFFFF" class="STYLE19">
						<input type="text"
				          name="department" class="inputLength2" /> </td>
						<td width="100px;" class="leftTd"height="30" bgcolor="#FFFFFF" class="STYLE19">
							<font
				class="fontSet">表名:</font>
						</td>
						<td  width="100px;" align="left" height="30" bgcolor="#FFFFFF" class="STYLE19">
							<select name="searchTableName">

				<option value="Personneladjustsalary">员工调薪表</option>
				<option value="Personnelremove">员工调动表</option>
				<option value="Personneltrain">员工培训表</option>
				<option value="Personnelappraise">员工考评表</option>
				<option value="Peoc">员工奖罚表</option>
			</select>
						</td>
					</tr>
					<tr class="centtr">
						<td  width="100px;" height="30"  class="leftTd"bgcolor="#FFFFFF" class="STYLE19">
						<font
				class="fontSet">起始时间: </font></td>
						<td width="100px;" align="left" height="30" bgcolor="#FFFFFF" class="STYLE19">
						<input type="text" id="date1"name="startDate"
				class="inputLength1" onClick="WdatePicker()" /> </td>
						<td width="100px;" class="leftTd"height="30" bgcolor="#FFFFFF" class="STYLE19">
							<font
				class="fontSet">终止时间:</font>
						</td>
						<td  width="100px;" align="left" height="30" bgcolor="#FFFFFF" class="STYLE19">
							<input type="text" id="date2"name="endDate"
				class="inputLength1" onClick="WdatePicker()" />
						</td>
					</tr>
				
					</table><br>
					<div align="center">
			<input type="button"   value="搜索" onclick="submitForm2()" 
				style="height: 20px; width: 40px;" />&nbsp;&nbsp;<font color="red" size="2px"><span id="dateError"></span></font>
		</div><!-- onclick="submitForm2();" -->
		</form>
	</div>
	<br>
	<c:if test="${time eq 'first'}">
		<c:if test="${personList.size() eq '0'}">
			<div align="center"><font color="red">对不起，没有记录</font></div>
		</c:if>
		<c:if test="${personList.size() !='0'}">
			<form action="personnelRecords.man">
			<div id="resultTable">
			<table class="toptable_style">
			<tr>
				<td width="85%"><img src="/personnel/comm/images/comm/tb.gif" />
					<span class="title_style">员工综合信息列表</span></td>
			</tr>
</table>
<div id="boundary_row"></div>
				<table class="centtable_style" cellspacing="1px">
					<tr class="toptr">
						<td class="topTrwidthAndLengthSet">员工编号</td>
						<td class="topTrwidthAndLengthSet">员工姓名</td>
						<td class="topTrwidthAndLengthSet">所在部门</td>
						<td class="topTrwidthAndLengthSet">员工职务</td>
						<td class="topTrwidthAndLengthSet">员工调动次数</td>
						<td class="topTrwidthAndLengthSet">员工调薪次数</td>
						<td class="topTrwidthAndLengthSet">员工培训次数</td>
						<td class="topTrwidthAndLengthSet">员工考评次数</td>
						<td class="topTrwidthAndLengthSet">员工奖罚次数</td>
						<td class="topTrwidthAndLengthSet">基本操作</td>
					</tr>

					<c:forEach var="person" items="${personList}" varStatus="loop">
						<tr class="centtr">
							<td height="20" bgcolor="#FFFFFF" class="STYLE19">${person.getPersonnelId()}</td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE19">${person.getPersonnelName()}</td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE19">${person.getDeptJobRel().getDepartment().getDepartmentName()}</td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE19">${person.getDeptJobRel().getJob().getJobName()}</td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE19">${result[loop.count-1].get(0)}次</td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE19">${result[loop.count-1].get(1)}次</td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE19">${result[loop.count-1].get(2)}次</td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE19">${result[loop.count-1].get(3)}次</td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE19">${result[loop.count-1].get(4)}次</td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE21"><a
								href="personnelRecords.man?method=findPersonRecord&&personId=${person.personnelId}">查看详情</a></td>
						</tr>
					</c:forEach>
				</table>
				</div>
			</form>
		</c:if>
	</c:if>
	<c:if test="${time eq 'second'}">
		<c:if test="${result.size() eq '0'}">
			<div align="center"><font color="red">对不起，没有符合条件的记录</font></div>
		</c:if>
		<c:if test="${result.size() !='0'}">
			<c:if test="${flag eq 'Personneladjustsalary'}">
				<!-- 查询员工调薪表 -->
					<div class="personTable">
					<table class="toptable_style">
			<tr>
				<td width="85%"><img src="/personnel/comm/images/comm/tb.gif" />
					<span class="title_style">员工调薪记录列表</span></td>
			</tr>
</table>
<div id="boundary_row"></div>
				<table class="centtable_style" cellspacing="1px">
					<tr class="toptr">
						<td class="topTrwidthAndLengthSet">员工名称</td>
						<td class="topTrwidthAndLengthSet">员工职务</td>
						<td class="topTrwidthAndLengthSet">调薪时间</td>
						<td class="topTrwidthAndLengthSet">调薪原因</td>
						<td class="topTrwidthAndLengthSet">调薪备注</td>
						<td class="topTrwidthAndLengthSet">基本操作</td>
					</tr>
					<c:forEach var="record" items="${result}" varStatus="loop">
						<tr class="centtr">
							<td height="20" bgcolor="#FFFFFF" class="STYLE19">${person[loop.count-1].getPersonnelName()}</td>

							<td height="20" bgcolor="#FFFFFF" class="STYLE19">${record.getDeptJobRel().getJob().getJobName()}</td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE19">${fn:substring(record.adjustSalaryDate,
								0,19)}</td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE19">${record.adjustSalaryReason}</td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE19">${record.personnelAdjustSalaryRemark}</td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE21"><a
								href="personnelRecords.man?method=findPersonRecord&&personId=${person[loop.count-1].getPersonnelId()}">查看详情</a></td>
						</tr>
					</c:forEach>
				</table></div>
			</c:if>
		</c:if>
	</c:if>
	<c:if test="${flag eq 'Personnelremove'}">
		<!-- 查询员工调动表 -->
		<c:if test="${result.size() eq '0'}">
			<div align="center"><font color="red">对不起，没有符合条件的调动记录</font></div>
		</c:if>
		<c:if test="${result.size() !='0'}">
		<div class="personTable">
		<table class="toptable_style">
			<tr>
				<td width="85%"><img src="/personnel/comm/images/comm/tb.gif" />
					<span class="title_style">员工调动记录列表</span></td>
			</tr>
</table>
<div id="boundary_row"></div>
			<table class="centtable_style" cellspacing="1px">
				<tr class="toptr">
					<td class="topTrwidthAndLengthSet">员工名称</td>
					<td class="topTrwidthAndLengthSet">调动之前的职务</td>
					<td class="topTrwidthAndLengthSet">调动之后的职务</td>
					<td class="topTrwidthAndLengthSet">调动之前的部门</td>
					<td class="topTrwidthAndLengthSet">调动之后的部门</td>
					<td class="topTrwidthAndLengthSet">调动时间</td>
					<td class="topTrwidthAndLengthSet">调动原因</td>
					<td class="topTrwidthAndLengthSet">调动备注</td>
					<td class="topTrwidthAndLengthSet">基本操作</td>
				</tr>
				<c:forEach var="record" items="${result}">
					<tr class="centtr">
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${record.getPersonnelinfo().getPersonnelName()}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${record.beforeRemoveJob}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${record.afterRemoveJob}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${record.beforeRemoveDepartment}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${record.afterRemoveDepartment}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${fn:substring(record.removeDate,
							0,19)}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${record.removeReason}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${record.personnelRemoveRemark}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE21"><a
							href="personnelRecords.man?method=findPersonRecord&&personId=${record.getPersonnelinfo().getPersonnelId()}">查看详情</a></td>
					</tr>
				</c:forEach>
			</table></div>
		</c:if>
	</c:if>
	<c:if test="${flag eq 'Personneltrain'}">
		<!-- 查询员工培训表 -->
		<c:if test="${result.size() eq '0'}">
			<div align="center"><font color="red">对不起，没有符合条件的培训记录</font></div>
		</c:if>
		<c:if test="${result.size() !='0'}">
		<div class="personTable">
		<table class="toptable_style">
			<tr>
				<td width="85%"><img src="/personnel/comm/images/comm/tb.gif" />
					<span class="title_style">员工培训记录列表</span></td>
			</tr>
</table>
<div id="boundary_row"></div>
			<table class="centtable_style" cellspacing="1px">
				<tr class="toptr">
					<td class="topTrwidthAndLengthSet">员工名称</td>
					<td class="topTrwidthAndLengthSet">培训时间</td>
					<td class="topTrwidthAndLengthSet">培训内容</td>
					<td class="topTrwidthAndLengthSet">培训备注</td>
					<td class="topTrwidthAndLengthSet">基本操作</td>
				</tr>
				<c:forEach var="record" items="${result}">
					<tr class="centtr">
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${record.getPersonnelinfo().getPersonnelName()}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${fn:substring(record.personnelTrainDate,
							0,19)}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${record.personnelTrainConten}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${record.personnelTrainRemark}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE21"><a
							href="personnelRecords.man?method=findPersonRecord&&personId=${record.getPersonnelinfo().getPersonnelId()}">查看详情</a></td>
					</tr>
				</c:forEach>
			</table></div>
		</c:if>
	</c:if>
	<c:if test="${flag eq 'Personnelappraise'}">
		<!-- 查询员工评价表 -->
		<c:if test="${result.size() eq '0'}">
			<div align="center"><font color="red">对不起，没有符合条件的考评记录</font></div>
		</c:if>
		<c:if test="${result.size() !='0'}">
		<div class="personTable">
		<table class="toptable_style">
			<tr>
				<td width="85%"><img src="/personnel/comm/images/comm/tb.gif" />
					<span class="title_style">员工考评记录列表</span></td>
			</tr>
</table>
<div id="boundary_row"></div>
			<table class="centtable_style" cellspacing="1px">
				<tr class="toptr">
					<td class="topTrwidthAndLengthSet">员工名称</td>
					<td class="topTrwidthAndLengthSet">考核日期</td>
					<td class="topTrwidthAndLengthSet">考核内容</td>
					<td class="topTrwidthAndLengthSet">考核结果</td>
					<td class="topTrwidthAndLengthSet">考核备注</td>
					<td class="topTrwidthAndLengthSet">基本操作</td>
				</tr>
				<c:forEach var="record" items="${result}">
					<tr class="centtr">
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${record.getPersonnelinfo().getPersonnelName()}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${fn:substring(record.personnelAppraiseDate,
							0,19)}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${record.personnelAppraiseContent}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">
						<c:if test="${record.personnelAppraiseResult eq '10070001'}">优秀</c:if>
						<c:if test="${record.personnelAppraiseResult eq '10070002'}">良好</c:if>
						<c:if test="${record.personnelAppraiseResult eq '10070003'}">中等</c:if>
						<c:if test="${record.personnelAppraiseResult eq '10070004'}">合格</c:if>
						<c:if test="${record.personnelAppraiseResult eq '10070005'}">不合格</c:if>
						</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${record.personnelAppraiseRemark}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE21"><a
							href="personnelRecords.man?method=findPersonRecord&&personId=${record.getPersonnelinfo().getPersonnelId()}">查看详情</a></td>
					</tr>
				</c:forEach>
			</table></div>
		</c:if>
	</c:if>
	<c:if test="${flag eq 'Peoc'}">
		<!-- 查询员工奖罚表 -->
		<c:if test="${result.size() eq '0'}">
			<div align="center"><font color="red">对不起，没有符合条件的奖罚记录</font></div>
		</c:if>
		<c:if test="${result.size() !='0'}">
		<div class="personTable">
		<table class="toptable_style">
			<tr>
				<td width="85%"><img src="/personnel/comm/images/comm/tb.gif" />
					<span class="title_style">员工奖罚记录列表</span></td>
			</tr>
</table>
<div id="boundary_row"></div>
			<table class="centtable_style" cellspacing="1px">
				<tr class="toptr">
					<td class="topTrwidthAndLengthSet">员工名称</td>
					<td class="topTrwidthAndLengthSet">奖罚日期</td>
					<td class="topTrwidthAndLengthSet">奖罚原因</td>
					<td class="topTrwidthAndLengthSet">奖罚备注</td>
					<td class="topTrwidthAndLengthSet">基本操作</td>
				</tr>
				<c:forEach var="record" items="${result}">
					<tr class="centtr">
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${record.getPersonnelinfo().getPersonnelName()}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${fn:substring(record.peocDate,
							0,19)}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${record.peocReason}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19">${record.personnelTrainRemark}</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE21"><a
							href="personnelRecords.man?method=findPersonRecord&&personId=${record.getPersonnelinfo().getPersonnelId()}">查看详情</a></td>
					</tr>
				</c:forEach>
			</table></div>
		</c:if>
	</c:if>
	<c:if test="${time eq 'first' }">
		<c:if test="${personList.size() !='0'}">
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td height="30"><table width="100%" border="0"
								cellspacing="0" cellpadding="0">
								<tr>
									<td width="45%"><div align="left">
											<c:if test="${pg.currentPage <= pg.allPage}">
												<span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;共有<strong>
														${pg.num}</strong> 条记录，当前第<strong>${pg.currentPage}</strong> 页，共 <strong>${pg.allPage}</strong>
													页
												</span>
											</c:if>
										</div></td>

									<td width="55%"><table width="312" border="0"
											align="right" cellpadding="0" cellspacing="0">
											<tr>
												<td width="49"><div align="center">

														<a
															href="personnelRecords.man?method=findAllPersonnelRecords&&cP=1&&pgNum=${pg.num}&&pgPages=${pg.allPage}"><img
															src="/personnel/comm/images/comm/main_54.gif" width="40"
															height="15" /></a>
													</div></td>
												<td width="49"><div align="center">
														<c:if test="${pg.currentPage ne '1' }">
															<a
																href="personnelRecords.man?method=findAllPersonnelRecords&&cP=${pg.currentPage-1}&&pgNum=${pg.num}&&pgPages=${pg.allPage}"><img
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
																href="personnelRecords.man?method=findAllPersonnelRecords&&cP=${pg.currentPage+1}&&pgNum=${pg.num}&&pgPages=${pg.allPage}"><img
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
															href="personnelRecords.man?method=findAllPersonnelRecords&&cP=${pg.allPage}&&pgNum=${pg.num}&&pgPages=${pg.allPage}"><img
															src="/personnel/comm/images/comm/main_60.gif" width="40"
															height="15" /></a>
														<!--尾页 -->

													</div></td>
												<td width="37" class="STYLE22"><div align="center">转到</div></td>
												<td width="22"><div align="center">
												<input type="hidden" name="allpage" value="${pg.allPage}"/>
														<input class="inputLength2" type="text" name="cP"
															id="cPTemp"
															style="width: 20px; height: 12px; font-size: 12px; border: solid 1px #7aaebd;" />
													</div></td>
												<td width="22" class="STYLE22"><div align="center">页</div></td>
												
													<td width="35"> 
													<a href="personnelRecords.man?method=findAllPersonnelRecords&&pgNum=${pg.num}&&pgPages=${pg.allPage}&&cP=" id="tiao">
													<img src="/personnel/comm/images/comm/main_62.gif" width="26" height="15" />
													</a>
											</td>
											</tr>
										</table></td>
								</tr>

							</table></td>
					</tr>
					
						
					<tr align="right"><td><div class="downRight"><a href=""><font size="2px;" color="#295568;">导出Excel</font></a></div></td>
					</tr>
					<tr align="right"><td><font size="2px;"  color="red"><span id="numError"></span></font></td></tr>
				</table>
			
		
		</c:if>
	</c:if>
	<c:if test="${time !='first'}">
		<c:if test="${result.size() !='0' }">
			

				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td height="30"><table width="100%" border="0"
								cellspacing="0" cellpadding="0">
								<tr>
									<td width="45%"><div align="left">
											<c:if test="${pg.currentPage <= pg.allPage}">
												<span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;共有<strong>
														${pg.num}</strong> 条记录，当前第<strong>${pg.currentPage}</strong> 页，共 <strong>${pg.allPage}</strong>
													页
												</span>
											</c:if>
										</div></td>

									<td width="55%"><table width="312" border="0"
											align="right" cellpadding="0" cellspacing="0">
											<tr>
												<td width="49"><div align="center">

														<a
															href="personnelRecords.man?cP=1&&method=findPerPages&&allHql=${allHql}&&pgNum=${pg.num}&&pgPages=${pg.allPage}&&flag=${flag}"><img
															src="/personnel/comm/images/comm/main_54.gif" width="40"
															height="15" /></a>
													</div></td>
												<td width="49"><div align="center">
														<c:if test="${pg.currentPage ne '1' }">
															<a
																href="personnelRecords.man?cP=${pg.currentPage-1}&&method=findPerPages&&allHql=${allHql}&&pgNum=${pg.num}&&pgPages=${pg.allPage}&&flag=${flag}"><img
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
																href="personnelRecords.man?cP=${pg.currentPage+1}&&method=findPerPages&&allHql=${allHql}&&pgNum=${pg.num}&&pgPages=${pg.allPage}&&flag=${flag}"><img
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
															href="personnelRecords.man?cP=${pg.allPage}&&method=findPerPages&&allHql=${allHql}&&pgNum=${pg.num}&&pgPages=${pg.allPage}&&flag=${flag}"><img
															src="/personnel/comm/images/comm/main_60.gif" width="40"
															height="15" /></a>
														<!--尾页 -->

													</div></td>
												<td width="37" class="STYLE22"><div align="center">转到</div></td>
												<td width="22"><div align="center">
												<input type="hidden" name="allpage" value="${pg.allPage}"/>
												<input type="text"  class="inputLength"  name="cP" id="cPTemp"  style="width:20px; height:12px; font-size:12px; border:solid 1px #7aaebd;"/>
													</div> </td>
												<td width="22" class="STYLE22"><div align="center">页</div></td>
												<td width="35"> 
													<a href="personnelRecords.man?method=findPerPages&&allHql=${allHql}&&pgNum=${pg.num}&&flag=${flag}&&pgPages=${pg.allPage}&&cP=" id="tiao">
													<img src="/personnel/comm/images/comm/main_62.gif" width="26" height="15" />
													</a>
											</td>
											</tr>
										</table></td>
								</tr>

							</table></td>
					</tr>
					<tr align="right">				
						<td><div class="downRight"><a href=""><font size="2px;" color="#295568;">导出Excel</font></a></div></td>
					</tr>
					<tr align="right"><td><font size="2px;"  color="red"><span id="numError"></span></font></tr>
				</table>
			

			
		</c:if>

	</c:if>
</body>
</html>