<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	
	$("input#newPassword1").change(function(){
		if($("input#newPassword1").val().length==0){
			$("span#newspan1").text("对不起 密码不能为空");
		}else{
			$("span#newspan1").text("");
		}
		if($("input#newPassword1").val()!=$("input#newPassword2").val()&&$("input#newPassword2").val().length!=0){
			$("span#newspan2").text("两次密码不相同");
		}else{
			$("span#newspan2").text("");
		}
	});
	$("input#newPassword2").click(function(){
		if($("input#newPassword1").val().length==0){
			$("span#newspan1").text("对不起 密码不能为空");
		}
	});
	$("input#newPassword2").change(function(){
		if($("input#newPassword1").val()!=$("input#newPassword2").val()){
			$("span#newspan2").text("两次密码不相同");
		}else{
			$("span#newspan2").text("");
		}
	});
	
	$("input#add").click(function(){
		var flag2=true;
		
		if($("#hidden").val()=="b"){
		
			flag2 = false;
		}
		 if($("input#oldPassword").val().length==0){
			$("span#oldspan").text("对不起 密码不能为空");
			
			flag2=false;
		}else{
			if($("input#oldspan").text().length!=0){
				$("span#oldspan").text("");
			}
			
		}
		if($("input#newPassword1").val().length==0){
			$("span#newspan1").text("对不起 密码不能为空");
			flag2 =false;
		}else{
			$("span#newspan1").text("");
		}
		if($("input#newPassword2").val().length==0){
			$("span#newspan2").text("对不起 密码不能为空");
			flag2 =false;
		}else{
			$("span#newspan2").text("");
		} 
		if($("input#newPassword1").val()!=$("input#newPassword2").val()){
			$("span#newspan2").text("两次密码不相同");
			flag2 = false;
		}else{
			$("span#newspan2").text("");
		}
		
		
		return flag2;
	}); 
	
	
	 $("input#oldPassword").change(function(){
		
		var flagk = false;
		if($("input#oldPassword").val().length==0){
			$("span#oldspan").text("对不起 密码不能为空");
		}else{
			$("span#oldspan").text("");
		}
		var oldpwd =$("input#oldPassword").val();
		var xmlhttp;
		if(window.XMLHttpRequest){
			xmlhttp=new XMLHttpRequest();
			
		}else{
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4&&xmlhttp.status==200){
			var str = xmlhttp.responseText;
				if("true"==str){
					
					document.getElementById("oldspan").innerHTML="";
					document.getElementById("hidden").value="a";
					
				}else{
	
					document.getElementById("oldspan").innerHTML="对不起密码错误";
					document.getElementById("hidden").value="b";
					
				}
			}
		};
		xmlhttp.open("get","DpwdServlet?t="+<%=Math.random()%>+"&pwd="+oldpwd,true);
		xmlhttp.send();
		
	}); 
});
</script>
</head>
<body>
	 <form action="operate.sys?method=updatePassword" id="form" method="post"> 
		<table class="toptable_style">
			<tr>
				<td width="85%"><img src="/personnel/comm/images/comm/tb.gif" />
					<span class="title_style">修改密码</span></td>
				<td><span class="title_style"><img
						src="/personnel/comm/images/comm/add.gif" /><input type="submit"
						value="修改" id="add" > </span></td> 
				<td><span class="title_style"><a href="javascript:history.go(-1);" class="white">返回</a> </span></td>
			</tr>
		</table>
		<div id="boundary_row"></div>
		<table class="centtable_style" cellspacing="1px">
			<tr>
				<td class="toptr">原密码</td>
				<td class="centtr">
				<input size="40" type="text" id="oldPassword" onchange="pwd();"/>
				<span style="color:red" id="oldspan"></span>
				</td>
			</tr>

			<tr>
				<td class="toptr">新密码</td>
				<td class="centtr">
				<input size="40" type="text" name="newPassword" id="newPassword1"/>
				<span style="color:red" id="newspan1"></span>
				</td>
			</tr>
			<tr>
				<td class="toptr">新密码</td>
				<td class="centtr">
				<input size="40" type="text" id="newPassword2"/>
				<span style="color:red" id="newspan2"></span>
				<input type="hidden" id="hidden"  value="a"/>
				</td>
			</tr>
			
		</table>
	 </form> 

</body>
</html>