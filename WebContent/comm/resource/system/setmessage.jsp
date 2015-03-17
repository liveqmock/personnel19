<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
</style>
</head>
<body>
	<form action="">
		<table class="toptable_style">
			<tr>
				<td width="85%"><img src="/personnel/comm/images/comm/tb.gif" />
					<span class="title_style">管理员</span></td>
				<td><span class="title_style"><img
						src="/personnel/comm/images/comm/add.gif" /><input type="submit"
						value="添加" id="add"> </span></td>
				<td><span class="title_style"><input type="submit"
						value="返回" id="add"> </span></td>
			</tr>
		</table>
		<div id="boundary_row"></div>
		<table class="centtable_style" cellspacing="1px">
			<tr>
				<td class="toptr">员工姓名</td>
				<td class="centtr"><input size="40" type="text"></td>
			</tr>
			<tr>
				<td class="toptr">用户名</td>
				<td class="centtr"><input size="40" type="text"></td>
			</tr>
			<tr>
				<td class="toptr">密码</td>
				<td class="centtr"><input size="40" type="password"></td>
			</tr>
			<tr>
				<td class="toptr">职称</td>
				<td class="centtr"><select name="dutys">
						<option value="duty1" selected="selected">职称1</option>
						<option value="duty2">职称2</option>
						<option value="duty3">职称3</option>
						<option value="duty4">职称4</option>
				</select></td>
			</tr>
			<tr>
				<td class="toptr">职务</td>
				<td class="centtr"><input type="checkbox" name="job1" />职务1<input
					type="checkbox" name="job2" /> 职务2</td>
			</tr>
			<tr>
				<td class="toptr">性别</td>
				<td class="centtr"><input type="radio" name="sex" value="male" />
					男<input type="radio" name="sex" value="female" /> 女</td>
			</tr>
			<tr>
				<td class="toptr">性别</td>
				<td class="centtr"><input type="radio" name="sex" value="male" />
					男<input type="radio" name="sex" value="female" /> 女</td>
			</tr>
			<tr>
				<td class="toptr">性别</td>
				<td class="centtr"><input type="radio" name="sex" value="male" />
					男<input type="radio" name="sex" value="female" /> 女</td>
			</tr>
			<tr>
				<td class="toptr">性别</td>
				<td class="centtr"><input type="radio" name="sex" value="male" />
					男<input type="radio" name="sex" value="female" /> 女</td>
			</tr>
			<tr>
				<td class="toptr">性别</td>
				<td class="centtr"><input type="radio" name="sex" value="male" />
					男<input type="radio" name="sex" value="female" /> 女</td>
			</tr>
			<tr>
				<td class="toptr">性别</td>
				<td class="centtr"><input type="radio" name="sex" value="male" />
					男<input type="radio" name="sex" value="female" /> 女</td>
			</tr>

		</table>
		<!-- <div id="substyle">
			<input type="submit" value="增加">
		</div>
		<div id="substyle">
			<input type="submit" value="修改">
		</div> -->
	</form>

</body>
</html>