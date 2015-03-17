<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/personnel/comm/js/comm/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

	.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}
.STYLE6 {color: #000000; font-size: 12; }
.STYLE10 {color: #000000; font-size: 12px; }
.STYLE19 {
	color: #344b50;
	font-size: 12px;
}
.STYLE21 {
	font-size: 12px;
	color: #3b6375;
}
.STYLE22 {
	font-size: 12px;
	color: #295568;
}
-->
.normal{
 text-decoration: none;
}
.white{
	text-decoration: none;
	color: white;
}
.checkItem{
text-decoration: none;
	color: white;
}
	#dddd{
		width: 800px;
		height: 400px;
		margin: auto;
		margin-top:20px;
		
		padding: 0px;
		
	}
	
	#top{
		width: 100%;
		height: 100%;
		padding: 0px;
		margin: 0px;
	}
	 #top td{
		text-align: center;
		height:50%;
		width:50%;
		background-color:#B0C4DE;
		padding: 0px;
		margin: 0px;
	}
	#top a{
	font-size:40px;
	text-align: center;
	
	color:white;
	text-decoration: none;

	}

</style>
<script type="text/javascript">
$(document).ready(function(){
	$('td').css({'cursor':'pointer'});
	$("td").click(function(){
		window.location=$(this).attr("src");

	});
	
});

</script>
</head>
<body>


<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" id="topUp" style="margin: -10px;padding: 0px;">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="/personnel/comm/images/comm/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> 基本信息设置</span></td>
              </tr>
            </table></td>
            <td><div align="right"><span class="STYLE1">
           <!--     <input type="checkbox" name="checkbox11" class="checkbox11" />
              全选      &nbsp;&nbsp;
              <a href="djr.sys?method=jumpAdd" class="white" ><img src="/personnel/comm/images/comm/add.gif" width="10" height="10" /> 添加   &nbsp;</a> 
              <a href="" class="checkItem"><img src="/personnel/comm/images/comm/del.gif" width="10" height="10" /> 删除    &nbsp;&nbsp;</a>
            <a href="djr.sys?method=jumpEdit" class="white" id="Topedit"><img src="/personnel/comm/images/comm/edit.gif" width="10" height="10" /> 编辑   &nbsp;</a> -->
            <!--    <a href="djr.sys?method=jumpBakDetail" class="white" id="TopSee"><img src="/personnel/comm/images/comm/edit.gif" width="10" height="10" /> 查看  &nbsp;</a> -->
              </span><span class="STYLE1"> &nbsp;</span></div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  </table>

<div id="dddd">

<table id="top">
	<tr>
		<td src="dept.sys?method=query"><a href="dept.sys?method=query">部门管理</a></td>
		<td src="djr.sys?method=query"><a href="djr.sys?method=query">职务管理</a></td>
	</tr>
	<tr>
		<td src="duty.sys?method=query"><a href="duty.sys?method=query">职称管理</a></td>
		<td src="encorchast.sys?method=query"><a href="encorchast.sys?method=query">奖惩制度管理</a></td>
	</tr>
</table>

</div>

</body>
</html>