<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>
<div id="head">目前没有分配帐套的部门和职位有</div>
<div id="table">
<table>
	<tr>
			<th>部门名称</th>
			<th>职位名称</th>
    </tr>
<c:forEach items="${list}" var="list">
<form>
<tr>
<td>${list.department.departmentName }</td>
<td>${list.job.jobName }</td>
<td><input type="submit" value="设置工资帐套" ></td>
</tr>
</form>



</c:forEach>
</table>
</div>

</body>
</html> --%>

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
		
		if(flag){
			//form表单提交

			$("form").submit();
		}
		return false;
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
		if(flag){
			$("form").attr("action","setofbook.sal?method=jumpEdit");
			$("form").submit();
		}
		return false;
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

			$("form").attr("action","djr.sys?method=jumpBakDetail");

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
			$("a#tiao").attr("href","setofbook.sal?method=query&&page="+$("input#textfield").val());
			
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
                <td width="94%" valign="bottom"><span class="STYLE1"> 未设置帐套的部门员工列表</span></td>
              </tr>
            </table></td>
            <td><div align="right"><span class="STYLE1">
               <input type="checkbox" name="checkbox11" class="checkbox11" />
              全选      &nbsp;&nbsp;
      
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
        <td width="4%" height="20" bgcolor="d3eaef" class="STYLE10"><div align="center">
          <input type="checkbox" name="checkbox11" class="checkbox11" />
        </div></td>
        <td width="32%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">部门名称</span></div></td>
         <td width="32%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">职务名称</span></div></td>
        <td width="32%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">基本操作</span></div></td>
      </tr>
    </table></td>
  </tr>
  <tr>
  <td>
  <form action="" method="post">
  <c:forEach var="deptJobRel" items="${deptJobRels }" >
  	<tr>
    <td>
    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      <tr>
        <td width="4%" height="20" bgcolor="#FFFFFF" class="STYLE10"><div align="center">
          <input type="checkbox" name="checkbox" class="checkbox" value="${deptJobRel.deptJobRelId }" />
        </div></td>

        <td width="32%" height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE10"><span class="remark">${deptJobRel.department.departmentName }</span></span></div></td>
  		<td width="32%" height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE10"><span class="remark">${deptJobRel.job.jobName }</span></span></div></td>
        <td height="32%" bgcolor="#FFFFFF">
        <div align="center" class="STYLE21">

        <%-- <a href="djr.sal?method=restore&&fileName=${bak.path }" class="normalrestore">还原</a> --%>

        <%-- <a href="djr.sys?method=restore&&fileName=${bak.path }" class="normalrestore">还原</a> --%>

         |<a href="setofbook.sal?method=jumpEdit&&deptJobRelId=${deptJobRel.deptJobRelId }" class="normaledit" ">编辑</a>
        <%--  |<a href="djr.sal?method=jumpBakDetail&&id=${bak.bakId }" class="normalsee" >查看</a>  --%>

         |<a href="setofbook.sal?method=jumpEdit&&deptJobRelId=${deptJobRel.deptJobRelId }" class="normaledit" ">编辑</a>
        <%--  |<a href="djr.sys?method=jumpBakDetail&&id=${bak.bakId }" class="normalsee" >查看</a>  --%>

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
          		 <td width="49"><div align="center"><a href="setofbook.sal?method=query&&page=1"><img src="/personnel/comm/images/comm/main_54.gif" width="40" height="15" /></a></div></td>
          		  <td width="49"><div align="center"><a href="setofbook.sal?method=query&&page=${pageDivid.currentPage-1 }"><img src="/personnel/comm/images/comm/main_56.gif" width="45" height="15" /></a></div></td>
          	</c:if>
          
          	<c:if test="${pageDivid.currentPage==pageDivid.allPage }">
          		  <td width="49"><div align="center"><img src="/personnel/comm/images/comm/main_58.gif" width="45" height="15" /></div></td>
           		  <td width="49"><div align="center"><img src="/personnel/comm/images/comm/main_60.gif" width="40" height="15" /></div></td>
          	</c:if>
          	<c:if test="${pageDivid.currentPage!=pageDivid.allPage }">
          		  <td width="49"><div align="center"><a href="setofbook.sal?method=query&&page=${pageDivid.currentPage+1 }"><img src="/personnel/comm/images/comm/main_58.gif" width="45" height="15" /></a></div></td>
           		  <td width="49"><div align="center"><a href="setofbook.sal?method=query&&page=${pageDivid.allPage }"><img src="/personnel/comm/images/comm/main_60.gif" width="40" height="15" /></a></div></td>
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