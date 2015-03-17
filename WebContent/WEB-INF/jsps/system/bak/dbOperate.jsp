<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/personnel/comm/js/comm/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>备份恢复数据库</title>
<style type="text/css">
<!--
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}
a{
text-decoration: none;
}

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
</style>

<script type="text/javascript">
$(document).ready(
function(){

	
	//全选的控制 全选被选中 其余也被选中
	$("input.checkbox11").click(function(){
		if($(this).attr("checked")){
			$("input[name=checkbox]").each(function(){
				$(this).attr("checked","checked");
			});
		}else{
			$("input[name=checkbox]").each(function(){
				$(this).attr("checked","");
			});
		}
		
	});
	//标题栏上的删除控制  其在checkbox中如果有不是自己备份的文件是不可以删除的
	$("a.checkItem").click(function(){
		var flag = true;
		var re = true;
		if($("input[name=checkbox]:checked").length==0){
			alert("对不起 请选中需要删除的项)");
			flag=false;
		}
		$("input[name=checkbox]:checked").each(function(){
			if($("input[name=username]").attr("value")!=$(this).attr("opName")){
				flag =false;
				re=false;
			}
		});
		if(!re){
			alert("对不起  你的权限不足");
		}
		if(flag){
			//form表单提交
			$("form").attr("action","bak.sys?method=delSome");
			$("form").submit();
		}
		return false;
	});
	//基本操作上的 删除控制  不是自己备份的文件不让删
	$("a.normaldel").click(function(){
		var flag = true;
		if($("input[name=username]").attr("value")!=$(this).attr("opName")){
			flag=false;
			alert("对不起 你的权限不足");
		}
		return flag;
	});
	//对顶端的编辑选项进行控制  查过一个checkbox 不让
	$("a#Topedit").click(function(){
		var flag = true;
		if($("input[name=checkbox]:checked").length>1){
			alert("对不起 你选中的项多余一个)");
			flag=false;
		}
		if($("input[name=checkbox]:checked").length==0){
			alert("对不起 请选中需要编辑的项");
			flag=false;
		}
		$("input[name=checkbox]:checked").each(function(){
			if($("input[name=username]").attr("value")!=$(this).attr("opName")){
				flag =false;
				alert("对不起 你的权限不足");
			}
		});
		if(flag){
			$("form").attr("action","bak.sys?method=jumpEdit");
			$("form").submit();
		}
		return false;
	});
	
	//对基本中编辑的进行控制
	$("a.normaledit").click(function(){
		var flag = true;
		if($("input[name=username]").attr("value")!=$(this).attr("opName")){
			flag=false;
			alert("对不起 你的权限不足");
		}
		return flag;
	});
	//对顶端的查看选项进行控制  查过一个checkbox 不让
	$("a#TopSee").click(function(){
		var flag = true;
		if($("input[name=checkbox]:checked").length>1){
			alert("对不起 你选中的项多余一个)");
			flag=false;
		}
		if($("input[name=checkbox]:checked").length==0){
			alert("对不起 请选中需要编辑的项");
			flag=false;
		}
		if(flag){
			$("form").attr("action","bak.sys?method=jumpBakDetail");
			$("form").submit();
		}
		return false;
	});
	//对基本中查看的进行控制
	$("a.normalsee").click(function(){
		var flag = true;
	
		return flag;
	});
	//对备份文件的描述的控制
	$("span.remark").each(function(){
		if($(this).text().length>12){
			var a = $(this).text().substring(0,12);
			$(this).text(a+"••• •••");
		}
	});
	//控制跳转到多少页
	$("a#tiao").click(function(){
		var flag = true;
		//alert($("input[name=allpage]").val());
		//alert($("input#textfield").val());
		if($("input#textfield").val()<1||$("input#textfield").val()>$("input[name=allpage]").val()){
			flag =false;
		}else{
			$("a#tiao").attr("href","bak.sys?method=query&&page="+$("input#textfield").val());
			
		}
		return flag;
	});
});
	
	

</script>
</head>
<body>
	<input type="hidden" name="username" value="${operater.opName }"/>
	<input type="hidden" name="allpage" value="${pageDivid.allPage }"/>
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" id="topUp">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="/personnel/comm/images/comm/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> 数据库备份列表</span></td>
              </tr>
            </table></td>
            <td><div align="right"><span class="STYLE1">
               <input type="checkbox" name="checkbox11" class="checkbox11" />
              全选      &nbsp;&nbsp;<a href="bak.sys?method=jumpQueryBak" class="white"><img src="/personnel/comm/images/comm/add.gif" width="10" height="10" /> 查询   &nbsp;</a>
              <a href="bak.sys?method=jumpAddBak" class="white" ><img src="/personnel/comm/images/comm/add.gif" width="10" height="10" /> 添加   &nbsp;</a> 
              <a href="" class="checkItem"><img src="/personnel/comm/images/comm/del.gif" width="10" height="10" /> 删除    &nbsp;&nbsp;</a>
              <a href="bak.sys?method=jumpEditBak" class="white" id="Topedit"><img src="/personnel/comm/images/comm/edit.gif" width="10" height="10" /> 编辑   &nbsp;</a>
               <a href="bak.sys?method=jumpBakDetail" class="white" id="TopSee"><img src="/personnel/comm/images/comm/edit.gif" width="10" height="10" /> 查看  &nbsp;</a>
              </span><span class="STYLE1"> &nbsp;</span></div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  
  <tr>
    <td>
    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      <tr>
        <td width="5%" height="20" bgcolor="d3eaef" class="STYLE10"><div align="center">
          <input type="checkbox" name="checkbox11" class="checkbox11" />
        </div></td>
        <td width="19%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">备份人员</span></div></td>
        <td width="19%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">备份时间</span></div></td>
        <td width="19%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">备份描述</span></div></td>
        <td width="19%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">备份文件地址</span></div></td>
        <td width="19%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">基本操作</span></div></td>
      </tr>
    </table></td>
  </tr>
  <tr>
  <td>
  <form action="" method="post">
  <c:forEach var="bak" items="${baks }" >
  	<tr>
    <td>
    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      <tr>
        <td width="5%" height="20" bgcolor="#FFFFFF" class="STYLE10"><div align="center">
          <input type="checkbox" name="checkbox" class="checkbox" value="${bak.bakId }" opName="${bak.operater.opName }"/>
        </div></td>
        <td width="19%" height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE10"><span>${bak.operater.opName }</span></span></div></td>
        <td width="19%" height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE10"><span>${bak.bakDate }</span></span></div></td>
        <td width="19%" height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE10"><span class="remark">${bak.bakRemark }</span></span></div></td>
        <td width="19%" height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE10"><span>${bak.path }</span></span></div></td>
        <td height="19%" bgcolor="#FFFFFF"><div align="center" class="STYLE21"><a href="bak.sys?method=restore&&fileName=${bak.path }" class="normalrestore">还原</a>|<a href="bak.sys?method=del&&id=${bak.bakId }" class="normaldel" opName="${bak.operater.opName }">删除</a>
        |<a href="bak.sys?method=jumpEdit&&id=${bak.bakId }" class="normaledit" opName="${bak.operater.opName }">编辑</a>
         |<a href="bak.sys?method=jumpBakDetail&&id=${bak.bakId }" class="normalsee" >查看</a>
        </div></td>
      </tr>
    </table></td>
 	 </tr>
  </c:forEach>
  </form>
  </td>
  </tr>
  
  
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="33%"><div align="left"><span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;共有<strong> ${pageDivid.num }</strong> 条记录，当前第<strong> ${pageDivid.currentPage }</strong> 页，共 <strong>${pageDivid.allPage }</strong> 页</span></div></td>
        <td width="67%"><table width="312" border="0" align="right" cellpadding="0" cellspacing="0">
          <tr>
           
          	<c:if test="${pageDivid.currentPage==1 }">
          		 <td width="49"><div align="center"><img src="/personnel/comm/images/comm/main_54.gif" width="40" height="15" /></div></td>
          		 <td width="49"><div align="center"><img src="/personnel/comm/images/comm/main_56.gif" width="45" height="15" /></div></td>
          	</c:if>
          	<c:if test="${pageDivid.currentPage!=1 }">
          		 <td width="49"><div align="center"><a href="bak.sys?method=query&&page=1"><img src="/personnel/comm/images/comm/main_54.gif" width="40" height="15" /></a></div></td>
          		  <td width="49"><div align="center"><a href="bak.sys?method=query&&page=${pageDivid.currentPage-1 }"><img src="/personnel/comm/images/comm/main_56.gif" width="45" height="15" /></a></div></td>
          	</c:if>
          
          	<c:if test="${pageDivid.currentPage==pageDivid.allPage }">
          		  <td width="49"><div align="center"><img src="/personnel/comm/images/comm/main_58.gif" width="45" height="15" /></div></td>
           		  <td width="49"><div align="center"><img src="/personnel/comm/images/comm/main_60.gif" width="40" height="15" /></div></td>
          	</c:if>
          	<c:if test="${pageDivid.currentPage!=pageDivid.allPage }">
          		  <td width="49"><div align="center"><a href="bak.sys?method=query&&page=${pageDivid.currentPage+1 }"><img src="/personnel/comm/images/comm/main_58.gif" width="45" height="15" /></a></div></td>
           		  <td width="49"><div align="center"><a href="bak.sys?method=query&&page=${pageDivid.allPage }"><img src="/personnel/comm/images/comm/main_60.gif" width="40" height="15" /></a></div></td>
          	</c:if>
          
           
            <td width="37" class="STYLE22"><div align="center">转到</div></td>
            <td width="22"><div align="center">
              <input type="text" name="textfield" id="textfield"  style="width:20px; height:12px; font-size:12px; border:solid 1px #7aaebd;"/>
            </div></td>
            <td width="22" class="STYLE22"><div align="center">页</div></td>
            <td width="35"><a href="" id="tiao"><img src="/personnel/comm/images/comm/main_62.gif" width="26" height="15" /></a></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>