<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/personnel/comm/js/comm/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	text-decoration: none;
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

#addinfo {
	/*	padding：内容和本容器之间的距离
	margin：本容器和外容器之间的距离
 */
	margin-right: 20px;
	float: right;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$("input[type=submit]").click(function() {
			var flag = false;
			var opName = $("input#opName").val();
			var personnelNo = $("input#personnelNo").val();
			var opPassword = $("input#opPassword").val();
			if (personnelNo.length == 0) {
				$("#notip").html("对不起 员工编号不可以为空");
			} else {
				$("#notip").html("");
				if (opName.length == 0) {
					$("#nametip").html("对不起 用户名不可以为空");
				} else {
					$("#nametip").html("");
					if (opPassword.length == 0) {
						$("#passwordtip").html("对不起 密码不可以为空");
					} else {
						$("#passwordtip").html("");
						flag = true;
					}
				}
			}
			return flag;
		});
		$("input#personnelNo").change(function() {
			var personnelNo = $("input#personnelNo").val();
			if (personnelNo.length == 0) {
				$("#notip").html("对不起 菜单名称不可以为空");
			} else {
				$("#notip").html("");
			}
		});
		$("input#opName").change(function() {
			var opName = $("input#opName").val();
			if (opName.length == 0) {
				$("#nametip").html("对不起 菜单链接地址不可以为空");
			} else {
				$("#nametip").html("");
			}
		});

	});
</script>
<script type="text/javascript">
	function check() {
		var flag = true;
		var men_menu = menuform.men_menuId.value;
		var men_menus = new Array();
		men_menus = men_menu.split("+");
		var men_menuName = men_menus[1];
		if (men_menuName != null) {
			if (menuform.menuName.value != "") {
				var str = menuform.menuRels.value;
				var size;
				var arr = new Array();
				var items = new Array();
				arr = str.split(".");
				for (size in arr) {
					items = arr[size].split(",");
					if (men_menuName == items[0]) {
						for (var i = 1; i < items.length; i++) {
							if (menuform.menuName.value == items[i]) {
								flag = false;
							}
						}

					}
				}

			}

		} else {
			if (menuform.menuName.value != "") {
				var str = menuform.mainmenus.value;
				var size;
				var arr = new Array();
				arr = str.split(",");
				for (size in arr) {
					if (menuform.menuName.value == arr[size]) {
						flag = false;
					}
				}
			}
		}
		if (!flag) {
			$("#notip").html("对不起 菜单名已存在");
			return flag;
		}

	}
</script>
</head>
<body>
	<form action="menu.sys?method=addMenu" method="post" name="menuform"
		onsubmit="return check()">
		<input type="hidden" value="${menuRels }" name="menuRels"
			id="menuRels" /> <input type="hidden" value="${mainmenus }"
			name="mainmenus" id="mainmenus" />
		<table class="toptable_style">
			<tr>
				<td width="85%"><img src="/personnel/comm/images/comm/tb.gif" />
					<span class="title_style">管理员</span></td>
				<td><span class="title_style"><img
						src="/personnel/comm/images/comm/add.gif" /><input type="submit"
						value="添加" id="add"> </span></td>
				<td><a href="javascript:history.go(-1);" class="title_style">返回</a></td>
			</tr>
		</table>
		<div id="boundary_row"></div>
		<table class="centtable_style" cellspacing="1px">
			<tr>
				<td class="toptr">父菜单</td>
				<td class="centtr"><select name="men_menuId">
						<option value="" selected="selected"></option>
						<c:forEach var="menuall" items="${menus }">
							<option value="${menuall.menuId}">${menuall.menuName }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="toptr">菜单名称</td>
				<td class="centtr"><input id="personnelNo" name="menuName"
					size="40" type="text"><span style="color: red;" id="notip"></span></td>
			</tr>
			<tr>
				<td class="toptr">菜单链接地址</td>
				<td class="centtr"><input id="opName" name="menuUrl" size="40"
					type="text"><span style="color: red;" id="nametip"></span></td>
			</tr>
			<tr>
				<td class="toptr">备注</td>
				<td class="centtr"><input id="remark" name="remark" size="40"
					type="text"></td>
			</tr>
		</table>
	</form>

</body>
</html>