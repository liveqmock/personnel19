<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/personnel/comm/css/system/diction.css">
<title>Insert title here</title>
<script language="javascript" type="text/javascript">
function openup(name){
	
var ts=document.getElementsByTagName("tr");
for(var i=0;i<ts.length;i++){
	var str=ts[i].id;
	if(str){//str非空 
		var a=str.split(",");
        if(a[0]==name){
        	
        	document.getElementById(str).style.display="block";
        }
	}
	
}
}


</script>
<style>
.th{
    
	background-color: RGB(173,210,218);
	font-size: 17px;
}
.tc{
	background-color:RGB(255,255,255);
}

table{
	width:80%;
	/* background-color: RGB(140,210,218); */
	 background-color: RGB(168,199,206); 
	
}
td {
	font-size:14px;
	text-align:center;
	
	
}
tr{
height:25px;
}
</style>
</head>
<body>
<div id="dictop" >
<form action="diction.sys" method="post">
<input type="hidden" name="method" value="operateFather">
<input type="hidden" name="operation" value="add">
 <input type="submit" value="新增父项" />
 </form>
</div>

<table cellspacing="1px"  width=80%>
<tr height="25px" >
<td class="th">名称</td>
<td class="th">修改时间</td>
<td class="th">备注</td>
<td class="th">基本操作</td>
</tr>
<c:forEach var="father" items="${fathers}" >
<tr   ><%-- id="${father.name }" --%>
<td class="tc">${father.name}</td>
<td class="tc">${father.dictionLogDate }</td>
<td class="tc">${father.dictionLogRemark}</td>
<td class="tc">
<a href="diction.sys?method=addSons&&fatherSid=${father.sid}">增加子项</a>
<a href="diction.sys?method=fatherDelete&&sid=${father.sid}">删除</a>
<a href="diction.sys?method=operateFather&&sid=${father.sid}&&operation=update">修改</a>
<a onclick="openup('${father.name}' )" >展开</a>
</td>
</tr>
<c:forEach items="${sons}" var="son">
<c:if test="${son.pid==father.sid}">

<tr style="display:none" id="${father.name},${son.name}" class="tc"><!-- style="display:none" -->
<td>${son.name}</td>
<td>${son.dictionLogDate }</td>
<td>${son.dictionLogRemark}</td>
<td>
<a href="diction.sys?method=delSon&&sid=${son.sid}">删除</a>
<a href="diction.sys?method=toModSon&&sid=${son.sid}">修改</a>
</td>
</tr>

</c:if>
</c:forEach>
</c:forEach> 
</table>
<script type="text/javascript">
   


	

</script>
</body>
</html>