<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/personnel/comm/js/comm/jquery.js"></script>
<script type="text/javascript"
	src="/personnel/comm/js/comm/chili-1.7.pack.js"></script>
<script type="text/javascript"
	src="/personnel/comm/js/comm/jquery.easing.js"></script>
<script type="text/javascript"
	src="/personnel/comm/js/comm/jquery.dimensions.js"></script>
<script type="text/javascript"
	src="/personnel/comm/js/comm/jquery.accordion.js"></script>
<script language="javascript">
	jQuery().ready(function() {
		jQuery('#navigation').accordion({
			header : '.head',
			navigation1 : true,
			event : 'click',
			fillSpace : true,
			animated : 'bounceslide'
		});
	});
</script>
<style type="text/css">
<!--
body {
	margin: 0px;
	padding: 0px;
	font-size: 12px;
}

#navigation {
	margin: 0px;
	padding: 0px;
	width: 147px;
}

#navigation a.head {
	cursor: pointer;
	background: url(/personnel/comm/images/comm/main_34.gif) no-repeat
		scroll;
	display: block;
	font-weight: bold;
	margin: 0px;
	padding: 5px 0 5px;
	text-align: center;
	font-size: 12px;
	text-decoration: none;
}

#navigation ul {
	border-width: 0px;
	margin: 0px;
	padding: 0px;
	text-indent: 0px;
}

#navigation li {
	list-style: none;
	display: inline;
}

#navigation li li a {
	display: block;
	font-size: 12px;
	text-decoration: none;
	text-align: center;
	padding: 3px;
}

#navigation li li a:hover {
	background: url(/personnel/comm/images/comm/tab_bg.gif) repeat-x;
	border: solid 1px #adb9c2;
}
-->
</style>
</head>
<body>
	<div style="height: 100%;">
		<ul id="navigation">
			<li><a class="head">员工资料管理</a>
				<ul>
					<li><a href="/personnel/user_info.do?method=queryAll" target="rightFrame">基本资料</a></li>
					<li><a href="Articles.php" target="rightFrame">高级资料</a></li>
				</ul></li>
			<li><a class="head">统计管理</a>
				<ul>
					<li><a href="AddKind.php" target="rightFrame">综合信息统计</a></li>
					<li><a href="Kinds.php" target="rightFrame">员工积分统计</a></li>
					<li><a href="Kinds.php" target="rightFrame">人事系统统计</a></li>
					<li><a href="Kinds.php" target="rightFrame">人事记录统计</a></li>
				</ul></li>
			<li><a class="head">工资管理</a>
				<ul>
					<li><a href="messages.php" target="rightFrame">帐套管理</a></li>
					<li><a href="comments.php" target="rightFrame">帐套设置</a></li>
					<li><a href="comments.php" target="rightFrame">工资表管理</a></li>
					<li><a href="comments.php" target="rightFrame">月末处理</a></li>
					<li><a href="comments.php" target="rightFrame">工资表查询</a></li>
				</ul></li>
			<li><a class="head">系统管理</a>
				<ul>
					<li><a href="/personnel/comm/resource/system/message.jsp"
						target="rightFrame">基本信息设置</a></li>
					<li><a href="Links.php" target="rightFrame">操作日志管理</a></li>
					<li><a href="comments.php" target="rightFrame">备份恢复数据</a></li>
					<li><a href="comments.php" target="rightFrame">初始化数据库</a></li>
					<li><a href="comments.php" target="rightFrame">系统管理</a></li>
					<li><a href="/personnel/comm/resource/system/setmessage.jsp"
						target="rightFrame">操作员管理</a></li>
					<li><a href="/personnel/comm/resource/system/dictionitem.jsp"
						target="rightFrame">字典日志管理</a></li>
				</ul></li>
			<li><a class="head">人事管理</a>
				<ul>
					<li><a href="AddLink.php" target="rightFrame">员工资料</a></li>
					<li><a href="Links.php" target="rightFrame">员工奖惩</a></li>
					<li><a href="comments.php" target="rightFrame">员工培训</a></li>
					<li><a href="comments.php" target="rightFrame">员工好评</a></li>
					<li><a href="comments.php" target="rightFrame">员工调薪</a></li>
					<li><a href="comments.php" target="rightFrame">员工调动</a></li>
				</ul></li>
			<li><a class="head">版本信息</a>
				<ul>
					<li><a href="http://Www.865171.cn" target="_blank">by
							Jessica(865171.cn)</a></li>
				</ul></li>
		</ul>
	</div>
</body>
</html>