<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/personnel/comm/css/management/fontSet.css" type="text/css"
	rel="stylesheet" />
<!-- 注意这个link的位置 -->
<link
	href="/personnel/comm/css/management/PersonnelManagement/Result.css"
	type="text/css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
<script type="text/javascript" src="/personnel/comm/js/comm/jquery.js"></script>
<script type="text/javascript"
	src="/personnel/comm/js/management/PersonnelManagement/Search.js"></script>

<script type="text/javascript">
function submitForm()
{
    var temp=checkSalary();
    if(temp=="jump")
    {
    	document.getElementById("formId").submit();
    }
   
}
</script>
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
	<div id="ResultMain">
		
		<div id="search"><br>
		<div align="center"><font size="4px">搜索条件</font></div>
			<form action="personnelManagement.man" id="formId">

				<input type="hidden" name="method" value="findAll" />
				<table class="searchtable_style" cellspacing="1px" align="center">
					<tr class="centtr">
						<td  width="150px;" height="30"  class="leftTd"bgcolor="#FFFFFF" class="STYLE19"><font
							class="fontSet">性别: </font></td>
						<td width="150px;" align="left" height="30" bgcolor="#FFFFFF" class="STYLE19"><input
							type="radio" name="sex" value="10010002" /> <font class="fontSet">男
						</font><input type="radio" name="sex" value="10010001" /> <font
							class="fontSet">女</font></td>
						<td width="150px;" class="leftTd"height="30" bgcolor="#FFFFFF" class="STYLE19">
							<font class="fontSet">姓名: </font>
						</td>
						<td  width="150px;" align="left" height="30" bgcolor="#FFFFFF" class="STYLE19">
							<input class="inputLength" type="text" name="username" />
						</td>
					</tr>
					<tr class="centtr">
						<td width="150px;" class="leftTd" height="30" bgcolor="#FFFFFF" class="STYLE19"><font
							class="fontSet">最低工资: </font></td>
						<td  width="150px;" align="left" height="30" bgcolor="#FFFFFF" class="STYLE19"><input
							class="inputLength" type="text" name="salaryLow" id="low"
							onblur="checkIsNumber(this.value)" /><font class="fontSet">元</font></td>
						<td class="leftTd"height="30" bgcolor="#FFFFFF" class="STYLE19"><font
							class="fontSet">最高工资:</font></td>
						<td align="left" height="30" bgcolor="#FFFFFF" class="STYLE19">
							<input class="inputLength" type="text" name="salaryUp" id="up"
							onblur="checkIsNumber(this.value)" /><font class="fontSet">元</font>
						</td>
					</tr>
					<tr class="centtr">
						<td class="leftTd" height="30" bgcolor="#FFFFFF" class="STYLE19"><font
							class="fontSet">职务: </font></td>
						<td align="left" height="30" bgcolor="#FFFFFF" class="STYLE19">
							<input class="inputLength" type="text" name="job" />
						</td>
						<td  class="leftTd" height="30" bgcolor="#FFFFFF" class="STYLE19"><font
							class="fontSet">部门: </font></td>
						<td  align="left" height="30" bgcolor="#FFFFFF" class="STYLE19"><input
							class="inputLength" type="text" name="department" /></td>
					</tr></table><br>
					<div align="center"><input
							type="button" value="搜索"  onclick="submitForm()"
							style="height: 20px; width: 40px;" /><!-- onclick="submitForm() -->
						<font
							color="red" size="2px"><span id="salaryError"></span></font></div>

			</form>
		</div>
		<br>

		<c:if test="${pg.currentPage <= pg.allPage}">
			<div id="resultTable">
				<!-- 结果 -->
				<table class="toptable_style">
			<tr>
				<td width="85%"><img src="/personnel/comm/images/comm/tb.gif" />
					<span class="title_style">员工信息列表</span></td>
			</tr>
</table>
<div id="boundary_row"></div>
				<table class="centtable_style" cellspacing="1px" border="0">
					<tr class="toptr">
						<td class="topTrwidthAndLengthSet">员工姓名</td>
						<td class="topTrwidthAndLengthSet">所在部门</td>
						<td class="topTrwidthAndLengthSet">员工职务</td>
						<td class="topTrwidthAndLengthSet">员工性别</td>
						<td class="topTrwidthAndLengthSet">电话</td>
						<td class="topTrwidthAndLengthSet">邮箱</td>
						
						<td class="topTrwidthAndLengthSet">出生日期</td>
						<td class="topTrwidthAndLengthSet">入职日期</td>
						<td class="topTrwidthAndLengthSet">转正日期</td>
						<td class="topTrwidthAndLengthSet">基本薪资</td>
						
						<td class="topTrwidthAndLengthSet">基本操作</td>
					</tr>
					<c:forEach var="pr" items="${result}">
						<tr class="centtr">
							<td height="20" bgcolor="#FFFFFF" class="STYLE19">${pr.personnelName}</td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE19">${pr.deptJobRel.getDepartment().getDepartmentName()}</td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE19">${pr.deptJobRel.getJob().getJobName()}</td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE19"><c:if test="${pr.personnelSex =='10010001'}">女</c:if><c:if test="${pr.personnelSex =='10010002' }">男</c:if></td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE19">${pr.phone}</td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE19">${pr.EMail}</td>
							
							<td height="20" bgcolor="#FFFFFF" class="STYLE19">${fn:substring(pr.birthday,
								0,10)}</td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE19">${fn:substring(pr.beginWorkDate,
								0,10)}</td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE19">${fn:substring(pr.beginContract,
								0,10)}</td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE19">${pr.deptJobRel.getSalary().getBasicSalary()}元</td>
							
							<td height="20" bgcolor="#FFFFFF" class="STYLE21"><a
								href="personnelManagement.man?method=findPersonAllInfo&&personId=${pr.personnelId}">查看详情</a></td>
						</tr>
					</c:forEach>
				</table>
				
			</div>
		</c:if>

		<c:if test="${pg.currentPage > pg.allPage}">
			<div align="center"><font color="red">对不起没有找到</font></div>
		</c:if>

	</div>
	<div id="ResultUp">
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
														href="personnelManagement.man?cP=1&&method=findPerPages&&allHql=${allHql}&&pgNum=${pg.num}&&pgPages=${pg.allPage}"><img
														src="/personnel/comm/images/comm/main_54.gif" width="40"
														height="15" /></a>
												</div></td>
											<td width="49"><div align="center">
													<c:if test="${pg.currentPage ne '1' }">
														<a
															href="personnelManagement.man?cP=${pg.currentPage-1}&&method=findPerPages&&allHql=${allHql}&&pgNum=${pg.num}&&pgPages=${pg.allPage}"><img
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
															href="personnelManagement.man?cP=${pg.currentPage+1}&&method=findPerPages&&allHql=${allHql}&&pgNum=${pg.num}&&pgPages=${pg.allPage}"><img
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
														href="personnelManagement.man?cP=${pg.allPage}&&method=findPerPages&&allHql=${allHql}&&pgNum=${pg.num}&&pgPages=${pg.allPage}"><img
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
												href="personnelManagement.man?method=findPerPages&&allHql=${allHql}&&pgNum=${pg.num}&&pgPages=${pg.allPage}&&cP="
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

</body>
</html>