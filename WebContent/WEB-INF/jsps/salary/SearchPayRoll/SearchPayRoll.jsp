<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/personnel/comm/js/comm/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人工资表查询</title>
<style type="text/css">
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}

a {
	text-decoration: none;
}

.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}

.STYLE6 {
	color: #000000;
	font-size: 12;
}

.STYLE10 {
	color: #000000;
	font-size: 12px;
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

-->
.normal {
	text-decoration: none;
}

.white {
	text-decoration: none;
	color: white;
}

.checkItem {
	text-decoration: none;
	color: white;
}
</style>

<script type="text/javascript">
	$(document).ready(
			function() {

				//全选的控制 全选被选中 其余也被选中
				$("input.checkbox11").click(function() {
					if ($(this).attr("checked")) {
						$("input[name=checkbox]").each(function() {
							$(this).attr("checked", "checked");
						});
					} else {
						$("input[name=checkbox]").each(function() {
							$(this).attr("checked", "");
						});
					}

				});
				//标题栏上的删除控制  其在checkbox中如果有不是自己备份的文件是不可以删除的
				$("a.checkItem").click(
						function() {
							var flag = true;
							var re = true;
							if ($("input[name=checkbox]:checked").length == 0) {
								alert("对不起 请选中需要删除的项)");
								flag = false;
							}
							$("input[name=checkbox]:checked").each(
									function() {
										if ($("input[name=username]").attr(
												"value") != $(this).attr(
												"opName")) {
											flag = false;
											re = false;
										}
									});
							if (!re) {
								alert("对不起  你的权限不足");
							}
							if (flag) {
								//form表单提交
								$("form").attr("action",
										"bak.sys?method=delSome");
								$("form").submit();
							}
							return false;
						});
				//基本操作上的 删除控制  不是自己备份的文件不让删
				$("a.normaldel").click(
						function() {
							var flag = true;
							if ($("input[name=username]").attr("value") != $(
									this).attr("opName")) {
								flag = false;
								alert("对不起 你的权限不足");
							}
							return flag;
						});
				//对顶端的编辑选项进行控制  查过一个checkbox 不让
				$("a#Topedit").click(
						function() {
							var flag = true;
							if ($("input[name=checkbox]:checked").length > 1) {
								alert("对不起 你选中的项多余一个)");
								flag = false;
							}
							if ($("input[name=checkbox]:checked").length == 0) {
								alert("对不起 请选中需要编辑的项");
								flag = false;
							}
							$("input[name=checkbox]:checked").each(
									function() {
										if ($("input[name=username]").attr(
												"value") != $(this).attr(
												"opName")) {
											flag = false;
											alert("对不起 你的权限不足");
										}
									});
							if (flag) {
								$("form").attr("action",
										"bak.sys?method=jumpEdit");
								$("form").submit();
							}
							return false;
						});

				//对基本中编辑的进行控制
				$("a.normaledit").click(
						function() {
							var flag = true;
							if ($("input[name=username]").attr("value") != $(
									this).attr("opName")) {
								flag = false;
								alert("对不起 你的权限不足");
							}
							return flag;
						});
				//对顶端的查看选项进行控制  查过一个checkbox 不让
				$("a#TopSee").click(
						function() {
							var flag = true;
							if ($("input[name=checkbox]:checked").length > 1) {
								alert("对不起 你选中的项多余一个)");
								flag = false;
							}
							if ($("input[name=checkbox]:checked").length == 0) {
								alert("对不起 请选中需要编辑的项");
								flag = false;
							}
							if (flag) {
								$("form").attr("action",
										"bak.sys?method=jumpBakDetail");
								$("form").submit();
							}
							return false;
						});
				//对基本中查看的进行控制
				$("a.normalsee").click(function() {
					var flag = true;

					return flag;
				});
				//对备份文件的描述的控制
				$("span.remark").each(function() {
					if ($(this).text().length > 12) {
						var a = $(this).text().substring(0, 12);
						$(this).text(a + "••• •••");
					}
				});
				//控制跳转到多少页
				$("a#tiao").click(
						function() {
							var flag = true;
							//alert($("input[name=allpage]").val());
							//alert($("input#textfield").val());
							if ($("input#textfield").val() < 1
									|| $("input#textfield").val() > $(
											"input[name=allpage]").val()) {
								flag = false;
							} else {
								$("a#tiao").attr(
										"href",
										"bak.sys?method=query&&page="
												+ $("input#textfield").val());

							}
							return flag;
						});
			});
</script>
</head>
<body>

<center>
	<form action="?method=main" method="POST">
		<br> <font color="red">填写员工号查询所有工资单</font><br>
		<hr color="blue" size="1px"><br>
		<table cellpadding="10px">
			<tr>
				<td>员工号:</td>
				<td align="left"><input type="text" id="id" name="id" value="" required="required"></td>
				<td align="left"><input type="submit" id="submit" name="submit" value="查询"></td>
			</tr>
		</table>
		
	</form>
	<c:if test="${person!=null}">
	<form action="?method=specific" method="POST">
		<hr color="blue" size="1px"><br>
		<table cellpadding="10px">
			<tr>
				<td>员工号:</td>
				<td align="left"><input type="text" id="workid" name="workid" readonly="readonly" value="${person.getWorkId() }" /></td>
				<td>员工名称:</td>
				<td align="left"><input type="text" id="name" name="name" readonly="readonly" value="${person.getPersonnelName() }" /><br /></td>
			</tr>
			<font color="red">填写具体日期查询具体工资单(年份必填)</font>
			<tr>
				<td>年份：</td>
				<td align="left"><input type="text" id="year" name="year" required="required" value="" /> <br /></td>
				<td>月份:</td>
				<td align="left"><input type="text" id="month" name="month" value="" />  <br /></td>
				<input type="submit" id="submit2" name="submit2" value="查看">
			</tr>
		</table>
		
	</form>
	</c:if>
</center>
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" id="topUp">
		<tr>
			<td height="30">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="24" bgcolor="#353c44">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td>
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="6%" height="19" valign="bottom">
													<div align="center">
														<img src="/personnel/comm/images/comm/tb.gif" width="14" height="14" />
													</div>
												</td>
												<td width="94%" valign="bottom">
													<span class="STYLE1">个人工资表查询</span>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
    		<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
     				<tr>
        				<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">年份</span></div></td>
        				<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">月份</span></div></td>
        				<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">奖金</span></div></td>
        				<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">午餐补助</span></div></td>
        				<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">交通补助</span></div></td>
        				<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">资本工资</span></div></td>
        				<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">应付工资</span></div></td>
        				<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">奖罚次数</span></div></td>
        				<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">实际工资</span></div></td>
        				<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">查看详情</span></div></td>
      				</tr>
    			</table>
    		</td>
    	</tr>
    	<c:if test="${person!=null}">
		<tr>
		  	<td>
		  		<c:forEach items="${payroll}" var="payroll" varStatus="a">
	  			<tr>
	   				<td>
	  			  		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
	     					<tr>
	       						<td width="10%" height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center">
	       					 	<span class="STYLE10"><span>${payroll.getYear()}</span></span></div></td>
	       						<td width="10%" height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center">
	       						<span class="STYLE10"><span>${payroll.getMonth()}</span></span></div></td>
	       						<td width="10%" height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center">
	       					 	<span class="STYLE10"><span>${payroll.getSalary().getBonus()==null? 0:payroll.getSalary().getBonus()}</span></span></div></td>
	       						<td width="10%" height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center">
	       						<span class="STYLE10"><span>${payroll.getSalary().getLunchSalary()==null?0:payroll.getSalary().getLunchSalary()}</span></span></div></td>
	       						<td width="10%" height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center">
	       					 	<span class="STYLE10"><span>${payroll.getSalary().getTrafficSalary()==null?0:payroll.getSalary().getTrafficSalary()}</span></span></div></td>
	       						<td width="10%" height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center">
	       						<span class="STYLE10"><span>${payroll.getSalary().getBasicSalary()==null?0:payroll.getSalary().getBasicSalary()}</span></span></div></td>
	       						<td width="10%" height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center">
	       					 	<span class="STYLE10"><span>${payroll.getSalary().getTrafficSalary()==null?0:payroll.getSalary().getAllSalary()}</span></span></div></td>
	       						<td width="10%" height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center">
	       						<span class="STYLE10"><span>${payroll.getPbtimes()}</span></span></div></td>
	       						<td width="10%" height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center">
	       					 	<span class="STYLE10"><span>${payroll.getTotal()}</span></span></div></td>
	       						<td width="10%" height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center">
	       						<span class="STYLE10"><span><button type="button" onclick="window.open('?method=detailed&workid=${person.getWorkId()}&year=${payroll.getYear()}&month=${payroll.getMonth()}','_blank');">详情</button></span></span></div></td>
	     					 </tr>
	   					</table>
	   				</td>
	 			</tr>
		  		</c:forEach>
			</td>
		</tr>
		</c:if>
	</table>
</body>
</html>