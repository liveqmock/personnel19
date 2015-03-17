<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tree - jQuery EasyUI Demo</title>
<link rel="stylesheet" type="text/css"
	href="/personnel/comm/css/system/easyui.css">
<link rel="stylesheet" type="text/css"
	href="/personnel/comm/css/system/demo.css">
<script type="text/javascript" src="/personnel/comm/js/comm/jquery.js"></script>
<script type="text/javascript"
	src="/personnel/comm/js/system/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="/personnel/comm/js/system/js/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				//标题栏上的删除控制 
				$("a.checkItem").click(function() {
					var flag = true;
					if ($("input[name=checkbox]:checked").length == 0) {
						alert("对不起 请选中需要删除的项)");
						flag = false;
					}
					if (flag) {
						//form表单提交
						$("form").attr("action", "menu.sys?method=delmenus");
						$("form").submit();
					}
					return false;
				});
			});
</script>
<style type="text/css">
.title_style {
	color: #e1e2e3;
	font-size: 12px;
}

#aset {
	text-decoration: none;
	color: #e1e2e3;
}

.toptable_style {
	width: 80%;
	cellspacing: 1px;
	background-color: #353c44;
}

#menustyle {
	width: 80%;
	background-color: rgb(211, 234, 239);
}
</style>
</head>
<body>

	<form action="" method="post">
		<table class="toptable_style">
			<tr>
				<td width="85%"><img src="/personnel/comm/images/comm/tb.gif" />
					<span class="title_style">菜单信息</span></td>
				<td><span class="title_style"><a
						href="menu.sys?method=jumpAddMenu" id="aset"><img
							src="/personnel/comm/images/comm/add.gif" /> 添加</a> </span> <span
					class="title_style"><a href="" class="checkItem" id="aset"><img
							src="/personnel/comm/images/comm/del.gif" />删除</a></span></td>

			</tr>
		</table>
		<div id="menustyle">

			<ul id="tt1" class="easyui-tree" data-options="animate:true,dnd:true">
				<c:forEach var="menuall" items="${menus }">
					<li data-options="state:'closed'"><span><input
							type="checkbox" name="checkbox" class="checkbox" id="checkbox"
							value="${menuall.menuId}" />${menuall.menuName }</span>
						<ul>
							<c:forEach var="menuson" items="${menusons }">
								<c:if test="${menuson.menu==menuall }">
									<li><span><input type="checkbox" name="checkbox"
											class="checkbox" id="checkbox" value="${menuson.menuId}" />${menuson.menuName}
									</span></li>
								</c:if>
							</c:forEach>
						</ul></li>
				</c:forEach>
			</ul>
		</div>
	</form>
</body>
</html>
