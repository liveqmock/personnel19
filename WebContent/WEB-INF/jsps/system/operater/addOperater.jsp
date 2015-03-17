<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				$("#notip").html("对不起 员工编号不可以为空");
			} else {
				$("#notip").html("");
			}
		});
		$("input#opName").change(function() {
			var opName = $("input#opName").val();
			if (opName.length == 0) {
				$("#nametip").html("对不起 用户名不可以为空");
			} else {
				$("#nametip").html("");
			}
		});
		$("input#opPassword").change(function() {
			var opPassword = $("input#opPassword").val();
			if (opPassword.length == 0) {
				$("#passwordtip").html("对不起 密码不可以为空");
			} else {
				$("#passwordtip").html("");
			}
		});
	});
</script>
<script type="text/javascript">
	function check() {
		if (operaters.personnelNo.value != "") {
			var str = operaters.personnelNos.value;
			var size;
			var flag = false;
			var arr = new Array();
			arr = str.split(",");
			for (size in arr) {
				if (operaters.personnelNo.value == arr[size]) {
					flag = true;
				}
			}
			if (!flag) {
				$("#notip").html("对不起 员工编号不存在");
				return flag;
			}
		}
		if (operaters.opNames.value != "") {
			var str = operaters.opNames.value;
			var size;
			var flag = true;
			var arr = new Array();
			arr = str.split(",");
			for (size in arr) {
				if (operaters.opName.value == arr[size]) {
					flag = false;
				}
			}
			if (!flag) {
				$("#nametip").html("对不起 用户名已存在");
				return flag;
			}
		}

	}
</script>
</head>
<body>
	<form action="operatermanage.sys?method=addOperater" method="post"
		name="operaters" onsubmit="return check()">
		<input type="hidden" value="${personnelNos }" name="personnelNos"
			id="personnelNos" />
		<input type="hidden" value="${opNames }" name="opNames"
			id="opNames" />
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
				<td class="toptr">员工编号</td>
				<td class="centtr"><input id="personnelNo" name="personnelNo"
					size="40" type="text"><span style="color: red;" id="notip"></span><span
					id="addinfo"><a href="personInfo.per?method=insertPersonPage">非员工，添加员工信息</a></span></td>
			</tr>
			<tr>
				<td class="toptr">用户名</td>
				<td class="centtr"><input id="opName" name="opName" size="40"
					type="text"><span style="color: red;" id="nametip"></span></td>
			</tr>
			<tr>
				<td class="toptr">密码</td>
				<td class="centtr"><input id="opPassword" name="opPassword"
					size="40" type="password"><span style="color: red;"
					id="passwordtip"></span></td>
			</tr>
			<tr>
				<td class="toptr">管理员类型</td>
				<td class="centtr"><select name="operatertype">
						<option value="1" selected="selected">统计管理员</option>
						<option value="2">工资管理员</option>
						<option value="3">系统管理员</option>
						<option value="4">人事管理员</option>
				</select></td>
			</tr>
		</table>
	</form>

</body>
</html>