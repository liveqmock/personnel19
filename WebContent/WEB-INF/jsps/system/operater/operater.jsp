<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/personnel/comm/js/comm/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理人员基本信息</title>
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
	color: #e1e2e3;
	font-size: 12px;
}

#aset {
	text-decoration: none;
	color: #e1e2e3;
}

.toptable_style {
	width: 100%;
	cellspacing: 1px;
	background-color: #353c44;
}

.centtable_style {
	width: 100%;
	cellspacing: 1px;
	background-color: rgb(168, 199, 206);
}

.toptr {
	background-color: rgb(211, 234, 239);
	text-align: center;
	font-size: 12px;
}

.centtr {
	background-color: #FFFFFF;
	text-align: center;
	font-size: 12px;
}

#delete {
	background-color: #353c44;
	color: #e1e2e3;
	border: hidden;
}

#pagejump {
	width: 26px;
	height: 15px;
	border: hidden;
	background-image: url("/personnel/comm/images/comm/main_62.gif");
}

.pageinput {
	width: 20px;
	height: 12px;
	font-size: 12px;
	float: left;
	border: solid 1px #7aaebd;
}

#pagestyle {
	width: 800px;
	background-color: red;
	float: left;
}

tr {
	height: 25px;
}
</style>

<script type="text/javascript">
	$(document)
			.ready(
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
						$("a.checkItem")
								.click(
										function() {
											var flag = true;
											if ($("input[name=checkbox]:checked").length == 0) {
												alert("对不起 请选中需要删除的项)");
												flag = false;
											}
											if (flag) {
												//form表单提交
												$("form")
														.attr("action",
																"operatermanage.sys?method=deloperaters");
												$("form").submit();
											}
											return false;
										});
					});
	//控制跳转到多少页
	function pagecheck() {
		var currentPage = pagego.currentPage.value;
		if (currentPage.length == 0) {
			return false;
		}
		for (var i = 0; i <= currentPage.length - 1; i++) {
			var perNo = currentPage.charCodeAt(i);
			if (perNo > 57 || perNo < 48) {
				return false;
			}
		}
		$("form").attr("action", "operatermanage.sys?method=operater");
		$("form").submit();
	}
</script>
</head>
<body>
	<form action="" method="post">
		<table class="toptable_style">
			<tr>
				<td width="85%"><img src="/personnel/comm/images/comm/tb.gif" />
					<span class="title_style">管理人员基本信息列表</span></td>
				<td><span class="title_style"> <input type="checkbox"
						name="checkbox11" class="checkbox11" id="checkbox11" /> 全选
				</span> <span class="title_style"><a
						href="operatermanage.sys?method=jumpAddOperater" id="aset"><img
							src="/personnel/comm/images/comm/add.gif" /> 添加</a> </span> <span
					class="title_style"><a href="" class="checkItem" id="aset"><img
							src="/personnel/comm/images/comm/del.gif" />删除</a></span></td>

			</tr>
		</table>
		<div id="boundary_row"></div>
		<table class="centtable_style" cellspacing="1px">
			<tr class="toptr">
				<td>选择</td>
				<td>员工姓名</td>
				<td>用户名</td>
				<td>员工性别</td>
				<td>权限组</td>
				<td>电话</td>
				<td>地址</td>
				<td>邮箱</td>
				<td>基本操作</td>
			</tr>
			<c:forEach var="operater" items="${operaters }">
				<tr class="centtr">
					<td><input type="checkbox" name="checkbox" id="checkbox"
						value="${operater.opId }" /></td>
					<td>${operater.personnelinfo.personnelName }</td>
					<td>${operater.opName }</td>
					<td>${operater.personnelinfo.personnelSex }</td>
					<td>${operater.popedom }</td>
					<td>${operater.personnelinfo.phone }</td>
					<td>${operater.personnelinfo.address }</td>
					<td>${operater.personnelinfo.EMail }</td>
					<td><a
						href="operatermanage.sys?method=deleteAoperater&&opId=${operater.opId }">删除|</a><a
						href="operatermanage.sys?method=operatermassage&&opId=${operater.opId }">查看</a></td>
				</tr>
				
			</c:forEach>

		</table>
	</form>
	<table>

		<tr class="centtr">
			<td>第${pageDivid.currentPage}页/共${pageDivid.allPage}页</td>
			<td><div id="pagestyle"></div></td>
			<c:if test="${pageDivid.currentPage==1 }">
				<td><img src="/personnel/comm/images/comm/main_54.gif" /></td>
				<td><img src="/personnel/comm/images/comm/main_56.gif" /></td>
			</c:if>
			<c:if test="${pageDivid.currentPage!=1 }">
				<td><a href="operatermanage.sys?method=operater&&currentPage=1"><img
						src="/personnel/comm/images/comm/main_54.gif" width="40"
						height="15" /></a></td>
				<td><a
					href="operatermanage.sys?method=operater&&currentPage=${pageDivid.currentPage-1 }"><img
						src="/personnel/comm/images/comm/main_56.gif" width="45"
						height="15" /></a></td>
			</c:if>

			<c:if test="${pageDivid.currentPage==pageDivid.allPage }">
				<td><img src="/personnel/comm/images/comm/main_58.gif"
					width="45" height="15" /></td>
				<td><img src="/personnel/comm/images/comm/main_60.gif"
					width="40" height="15" /></td>
			</c:if>
			<c:if test="${pageDivid.currentPage!=pageDivid.allPage }">
				<td><a
					href="operatermanage.sys?method=operater&&currentPage=${pageDivid.currentPage+1 }"><img
						src="/personnel/comm/images/comm/main_58.gif" width="45"
						height="15" /></a></td>
				<td><a
					href="operatermanage.sys?method=operater&&currentPage=${pageDivid.allPage }"><img
						src="/personnel/comm/images/comm/main_60.gif" width="40"
						height="15" /></a></td>
			</c:if>

			<td>转到</td>
			<td><form action="" name="pagego" onsubmit="return pagecheck();"
					method="post">
					<input type="text" name="currentPage" class="pageinput" />页 <input
						type="submit" value="" id="pagejump">
				</form></td>

		</tr>

	</table>


</body>
</html>