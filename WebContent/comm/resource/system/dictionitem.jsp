<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.toptable_style {
	width: 65%;
	cellspacing: 1px;
	margin-left: auto;
	margin-right: auto;
	background-color: #353c44;
}

.title_style {
	color: #e1e2e3;
	font-size: 12px;
}

.aset {
	text-decoration: none;
	color: #e1e2e3;
}

#boundary_row {
	width: 100%;
	height: 10px;
}

#filedstyle {
	margin-left: auto;
	margin-right: auto;
	width: 64%;
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

.centtable_style {
	width: 100%;
	cellspacing: 1px;
	background-color: rgb(168, 199, 206);
}

#pagestyle {
	width: 60%;
}

.pageinput {
	width: 20px;
	height: 12px;
	font-size: 12px;
	float: left;
	border: solid 1px #7aaebd;
}

#pagejump {
	width: 26px;
	height: 15px;
	border: hidden;
	background-image: url("/personnel/comm/images/comm/main_62.gif");
}
tr{
	height: 28px;
}
</style>
</head>
<body>
	<table class="toptable_style">
		<tr>
			<td width="90%"><img src="/personnel/comm/images/comm/tb.gif" />
				<span class="title_style">字典日志内容</span></td>
			<td><span class="title_style"><a href="#" class="aset"><img
						src="/personnel/comm/images/comm/add.gif" /> 添加</a> </span></td>
		</tr>
	</table>
	<div id="boundary_row"></div>
	<form>
		<fieldset id="filedstyle">
			<legend>性别</legend>
			<table class="centtable_style" cellspacing="1px">
				<tr class="toptr">
					<td>字段</td>
					<td>添加日期</td>
					<td>备注</td>
					<td>基本操作</td>
				</tr>
				<tr class="centtr">
					<td>admin</td>
					<td>2013.9.22</td>
					<td>1年</td>
					<td><a href="#">删除|</a><a href="#">查看|</a><a href="#">修改</a></td>
				</tr>
				<tr class="centtr">
					<td>admin</td>
					<td>2013.9.22</td>
					<td>1年</td>
					<td><a href="#">删除|</a><a href="#">查看|</a><a href="#">修改</a></td>
				</tr>
				<tr class="centtr">
					<td>admin</td>
					<td>2013.9.22</td>
					<td>1年</td>
					<td><a href="#">删除|</a><a href="#">查看|</a><a href="#">修改</a></td>
				</tr>
				<tr class="centtr">
					<td>admin</td>
					<td>2013.9.22</td>
					<td>1年</td>
					<td><a href="#">删除|</a><a href="#">查看|</a><a href="#">修改</a></td>
				</tr>
				<tr class="centtr">
					<td>admin</td>
					<td>2013.9.22</td>
					<td>1年</td>
					<td><a href="#">删除|</a><a href="#">查看|</a><a href="#">修改</a></td>
				</tr>
			</table>
		</fieldset>
		<fieldset id="filedstyle">
			<legend>性别</legend>
			<table class="centtable_style" cellspacing="1px">
				<tr class="toptr">
					<td>字段</td>
					<td>添加日期</td>
					<td>备注</td>
					<td>基本操作</td>
				</tr>
				<tr class="centtr">
					<td>admin</td>
					<td>2013.9.22</td>
					<td>1年</td>
					<td><a href="#">删除|</a><a href="#">查看|</a><a href="#">修改</a></td>
				</tr>
				<tr class="centtr">
					<td>admin</td>
					<td>2013.9.22</td>
					<td>1年</td>
					<td><a href="#">删除|</a><a href="#">查看|</a><a href="#">修改</a></td>
				</tr>
				<tr class="centtr">
					<td>admin</td>
					<td>2013.9.22</td>
					<td>1年</td>
					<td><a href="#">删除|</a><a href="#">查看|</a><a href="#">修改</a></td>
				</tr>
				<tr class="centtr">
					<td>admin</td>
					<td>2013.9.22</td>
					<td>1年</td>
					<td><a href="#">删除|</a><a href="#">查看|</a><a href="#">修改</a></td>
				</tr>
				<tr class="centtr">
					<td>admin</td>
					<td>2013.9.22</td>
					<td>1年</td>
					<td><a href="#">删除|</a><a href="#">查看|</a><a href="#">修改</a></td>
				</tr>
				<tr class="centtr">
					<td>admin</td>
					<td>2013.9.22</td>
					<td>1年</td>
					<td><a href="#">删除|</a><a href="#">查看|</a><a href="#">修改</a></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<form action="">
		<table>
			<tr>
				<td id="pagestyle"></td>
				<td><a href="#"><img
						src="/personnel/comm/images/comm/main_54.gif" /></a></td>
				<td><a href="#"><img
						src="/personnel/comm/images/comm/main_56.gif" /></a></td>
				<td><a href="#"><img
						src="/personnel/comm/images/comm/main_58.gif" /></a></td>
				<td><a href="#"><img
						src="/personnel/comm/images/comm/main_60.gif" /></a></td>
				<td>转到</td>
				<td><input type="text" name="page" id="page" class="pageinput" /></td>
				<td>页</td>
				<td><input type="submit" value="" id="pagejump"></td>
			</tr>
		</table>
	</form>
</body>
</html>