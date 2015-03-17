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
	color: #e1e2e3;
	font-size: 12px;
}

.aset {
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
	width: 850px;
	background-color: red;
	float: left;
}
</style>
</head>
<body>
	<form action="">
		<table class="toptable_style">
			<tr>
				<td width="85%"><img src="/personnel/comm/images/comm/tb.gif" />
					<span class="title_style">管理人员基本信息列表</span></td>
				<td><span class="title_style"> <input type="checkbox"
						name="selectall" id="selectall" /> 全选
				</span> <span class="title_style"><a href="#" class="aset"><img
							src="/personnel/comm/images/comm/add.gif" /> 添加</a> </span> <span
					class="title_style"><img
						src="/personnel/comm/images/comm/del.gif" /><input type="submit"
						value="删除" id="delete"> </span></td>

			</tr>
		</table>
		<div id="boundary_row"></div>
		<table class="centtable_style" cellspacing="1px">
			<tr class="toptr">
				<td>选择</td>
				<td>员工姓名</td>
				<td>员工性别</td>
				<td>电话</td>
				<td>地址</td>
				<td>入职日期</td>
				<td>工龄</td>
				<td>基本操作</td>
			</tr>
			<tr class="centtr">
				<td><input type="checkbox" name="checkbox" id="checkbox" /></td>
				<td>admin</td>
				<td>女</td>
				<td>13913612548</td>
				<td>吉林省长春市</td>
				<td>2013.9.22</td>
				<td>1年</td>
				<td><a href="#">删除|</a><a href="#">查看|</a><a href="#">修改</a></td>
			</tr>
			<tr class="centtr">
				<td><input type="checkbox" name="checkbox" id="checkbox" /></td>
				<td>admin</td>
				<td>女</td>
				<td>13913612548</td>
				<td>吉林省长春市</td>
				<td>2013.9.22</td>
				<td>1年</td>
				<td><a href="#">删除|</a><a href="#">查看|</a><a href="#">修改</a></td>
			</tr>
			<tr class="centtr">
				<td><input type="checkbox" name="checkbox" id="checkbox" /></td>
				<td>admin</td>
				<td>女</td>
				<td>13913612548</td>
				<td>吉林省长春市</td>
				<td>2013.9.22</td>
				<td>1年</td>
				<td><a href="#">删除|</a><a href="#">查看|</a><a href="#">修改</a></td>
			</tr>
			<tr class="centtr">
				<td><input type="checkbox" name="checkbox" id="checkbox" /></td>
				<td>admin</td>
				<td>女</td>
				<td>13913612548</td>
				<td>吉林省长春市</td>
				<td>2013.9.22</td>
				<td>1年</td>
				<td><a href="#">删除|</a><a href="#">查看|</a><a href="#">修改</a></td>
			</tr>
			<tr class="centtr">
				<td><input type="checkbox" name="checkbox" id="checkbox" /></td>
				<td>admin</td>
				<td>女</td>
				<td>13913612548</td>
				<td>吉林省长春市</td>
				<td>2013.9.22</td>
				<td>1年</td>
				<td><a href="#">删除|</a><a href="#">查看|</a><a href="#">修改</a></td>
			</tr>
			<tr class="centtr">
				<td><input type="checkbox" name="checkbox" id="checkbox" /></td>
				<td>admin</td>
				<td>女</td>
				<td>13913612548</td>
				<td>吉林省长春市</td>
				<td>2013.9.22</td>
				<td>1年</td>
				<td><a href="#">删除|</a><a href="#">查看|</a><a href="#">修改</a></td>
			</tr>
			<tr class="centtr">
				<td><input type="checkbox" name="checkbox" id="checkbox" /></td>
				<td>admin</td>
				<td>女</td>
				<td>13913612548</td>
				<td>吉林省长春市</td>
				<td>2013.9.22</td>
				<td>1年</td>
				<td><a href="#">删除|</a><a href="#">查看|</a><a href="#">修改</a></td>
			</tr>
			<tr class="centtr">
				<td><input type="checkbox" name="checkbox" id="checkbox" /></td>
				<td>admin</td>
				<td>女</td>
				<td>13913612548</td>
				<td>吉林省长春市</td>
				<td>2013.9.22</td>
				<td>1年</td>
				<td><a href="#">删除|</a><a href="#">查看|</a><a href="#">修改</a></td>
			</tr>
			<tr class="centtr">
				<td><input type="checkbox" name="checkbox" id="checkbox" /></td>
				<td>admin</td>
				<td>女</td>
				<td>13913612548</td>
				<td>吉林省长春市</td>
				<td>2013.9.22</td>
				<td>1年</td>
				<td><a href="#">删除|</a><a href="#">查看|</a><a href="#">修改</a></td>
			</tr>
			<tr class="centtr">
				<td><input type="checkbox" name="checkbox" id="checkbox" /></td>
				<td>admin</td>
				<td>女</td>
				<td>13913612548</td>
				<td>吉林省长春市</td>
				<td>2013.9.22</td>
				<td>1年</td>
				<td><a href="#">删除|</a><a href="#">查看|</a><a href="#">修改</a></td>
			</tr>
			<tr class="centtr">
				<td><input type="checkbox" name="checkbox" id="checkbox" /></td>
				<td>admin</td>
				<td>女</td>
				<td>13913612548</td>
				<td>吉林省长春市</td>
				<td>2013.9.22</td>
				<td>1年</td>
				<td><a href="#">删除|</a><a href="#">查看|</a><a href="#">修改</a></td>
			</tr>
		</table>
	</form>
	<form action="">
		<table>
			<tr>
				<td><div id="pagestyle"></div></td>
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