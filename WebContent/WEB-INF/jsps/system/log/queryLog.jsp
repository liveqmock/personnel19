<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/personnel/comm/js/comm/jquery.js"></script>
<script src="/personnel/comm/js/system/js/Calendar3.js" type="text/javascript" language="javascript"></script>
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
.white{
text-decoration: none;
color: white
}
tr {
	height: 30px;
}
</style>
<!-- <script type="text/javascript">
	function sub(a){
		
		var a=document.getElementById("control_date1").value;
		var b=document.getElementById("control_date2").value;
		var testDate = new Date(); 
		var testStr = testDate.format("yyyy-MM-dd"); 

		if(a>b){
			document.getElementById("checkdate").innerHTML="起始日期大于终止日期";
			return false;
			
		}else{
			if(b>testStr){
				document.getElementById("checkdate").innerHTML="超过当前日期";
				return false;
			}else{
				return true;
			}
		}
		
		
		
		
	}


</script> -->
<script type="text/javascript">
	$(document).ready(function(){
		$("input[type=submit]").click(function(){
			var flag = false;
			var date=new Date();
			var datetime = date.toLocaleDateString();
			var upDate =$("input[name=upDate]").val();
			var upDateTime =new Date(upDate.replace("-","/").replace("-","/"));
			var downDate =$("input[name=downDate]").val();
			var downDateTime =new Date(downDate.replace("-","/").replace("-","/"));
			datetime = new Date(datetime.replace("-","/").replace("-","/"));
			if(upDateTime>datetime){
				$("#upSpan").html("对不起 ，开始时间不能大于当前时间");
			}else{
				$("#upSpan").html("");
				if(downDateTime>datetime){
					$("#downSpan").html("对不起 ，结束时间不能大于当前时间");
				}else{
					if(upDateTime>downDateTime){
						$("#downSpan").html("对不起 ，开始时间不能大于结束时间");
					}else{
						$("#downSpan").html("");
						flag=true;
					}
				}
			}
		
		
			return flag;
		});
	});
</script>
</head>
<body>


	<form action="operateLog.sys?method=queryByCondition" method="post">
		<table class="toptable_style">
			<tr>
				<td width="85%"><img src="/personnel/comm/images/comm/tb.gif" />
					<span class="title_style">操作日志查询</span></td>
				<td><span class="title_style"><img
						src="/personnel/comm/images/comm/add.gif" /><input type="submit"
						value="查询" id="add"> </span></td>
				<td><span class="title_style"><a href="javascript:history.go(-1);" class="white">返回</a></span></td>
			</tr>
		</table>
		<div id="boundary_row"></div>
		<table class="centtable_style" cellspacing="1px">
			<tr>
				<td class="toptr">起始日期</td>
				<td class="centtr"><input name="upDate" type="text" id="control_date1" size="40"
                        maxlength="40" onclick="new Calendar().show(this);" readonly="readonly" size="40"/>
                        <span id="upSpan" style="color:red;"></span>
                        </td>
			</tr>
			<tr>
				<td class="toptr">结束日期</td>
				<td class="centtr"><input name="downDate" type="text" id="control_date2" size="40"
                      maxlength="40" onclick="new Calendar().show(this);" readonly="readonly"  />
                      <span id="downSpan" style="color:red;"></span>
                      </td>
			</tr>
			<tr>
				<td class="toptr">操作员</td>
				<td class="centtr"><input size="40" type="text" name="opName"></td>
			</tr>
		</table>
	</form>

</body>
</html>