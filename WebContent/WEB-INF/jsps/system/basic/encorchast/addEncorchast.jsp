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
.white{
text-decoration: none;
color: white
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
<script type="text/javascript">
$(document).ready(function(){
	$("input[type=submit]").click(function(){
		var flag = false;
		var fileName1 = $("input#fileName1").val();
		var fileName2 = $("input#fileName2").val();
		var fileName3 = $("input#fileName3").val();
			if(fileName1.length==0){
				$("#tixing1").html("对不起 此处不可以为空");
			}else{
				$("#tixing1").html("");
			}
			if(fileName2.length==0){
				$("#tixing2").html("对不起 此处不可以为空");
			}else{
				$("#tixing2").html("");
			}
			if(fileName3.length==0){
				$("#tixing3").html("对不起 此处不可以为空");
			}else{
				$("#tixing3").html("");
			}
			if(fileName1.length!=0&&fileName2.length!=0&&fileName3.length!=0){
				flag = true;
			}
		return flag;
	});

/* 	$("input#fileName").change(function(){
		var fileName = $("input#fileName").val();
		var afterpoint=fileName.substring(fileName.length-4,fileName.length);
		if(afterpoint!=".sql"){
			$("#tixing").html("对不起 文件名必须以.sql结尾");
		}else{
		
			$("#tixing").html("");
		}
	}); */
	
});
</script>
</head>
<body>
	<form action="encorchast.sys?method=addEncorchast" method="post">
		<table class="toptable_style">
			<tr>
				<td width="85%"><img src="/personnel/comm/images/comm/tb.gif" />
					<span class="title_style">管理员</span></td>
				<td><span class="title_style"><img
						src="/personnel/comm/images/comm/add.gif" /><input type="submit"
						value="提交" id="add"> </span></td>
				<td><span class="title_style"><a href="javascript:history.go(-1);" class="white">返回</a> </span></td>
			</tr>
		</table>
		<div id="boundary_row"></div>
		<table class="centtable_style" cellspacing="1px">
			<tr>
				<td class="toptr">奖惩分数</td>
				<td class="centtr"><input type="text" id="fileName1" name="personnelEncOrChastPoint" size="40"/><span style="color:red;" id="tixing1"></span></td>
			</tr>
			<tr>
				<td class="toptr">奖惩金额</td>
				<td class="centtr"><input type="text" id="fileName2" name="money" size="40"/><span style="color:red;" id="tixing2"></span></td>
			</tr>
			<tr>
				<td class="toptr">奖惩级别</td>
				<td class="centtr"><input type="text" id="fileName3" name="personnelEncOrChastSort" size="40"/><span style="color:red;" id="tixing3"></span></td>
			</tr>
		</table>	
	</form>
</body>
</html>