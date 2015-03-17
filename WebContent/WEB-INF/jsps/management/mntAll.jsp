<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>综合信息统计</title>
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
.STYLE22 {
	font-size: 12px;
	color: #295568;
}
.downRight{
margin-right: 5px;
}
</style>
</head>
<body>
<center><br>
<font color="red">~你可以在下方相应位置输入限制条件进行查询~</font><br>
<hr color="blue" size="1px"><br>
<form action="mntAll.man?method=pickUp" method="post">
<table cellpadding="10px">
<tr>
<td>编号：</td><td align="left"><input type="text" name="pNo" height="1px"></td>
<td>姓名：</td><td align="left"><input type="text" name="pName"></td>
</tr>
<tr>
<td>部门：</td><td align="left"><input type="text" name="engageForm"></td>
<td>在职状态：</td><td align="left"><select name="workState"> 
        <option value=""></option>
        <option value="10060001">在职</option>
        <option value="10060002">离职</option>
        <option value="10060003">带薪休假</option>
        <option value="10060004">停职</option>
        <option value="10060005">退休</option>
        <option value="10060006">挂职锻炼</option>
      </select></td>
</tr>
<tr>
<td>入职日期：</td><td align="left">
  <script language="javascript" type="text/javascript" src="calenderController/My97DatePicker/WdatePicker.js"></script>
  <input name="beginWorkDate1" type="text" onClick="WdatePicker()" ></input>
       &nbsp;至 &nbsp;
  <input name="beginWorkDate2" type="text" onClick="WdatePicker()" ></input></td>
</tr>
</table><br>
<input type="submit" value="确定" size="40px">
</form>
</center>
<hr color="blue" size="1px">
<c:if test="${stateGeneral eq 'ok' }">
<table class="toptable_style">
			<tr>
				<td width="85%"><img src="/personnel/comm/images/comm/tb.gif" />
					<span class="title_style">员工综合信息列表</span></td>
			</tr>
</table>
<span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;共有<strong>${total+1}</strong> 条记录，当前为第<strong>${i/10+1}</strong>页</span>
<div id="boundary_row"></div>
<table class="centtable_style" cellspacing="1px">
   <tr  class="toptr">
         <th>编号</th>
         <th>姓名</th>
         <th>性别</th>
         <th>年龄</th>
         <th>身份证号</th>
         <th>联系电话</th>
         <th>部门</th>
         <th>最高学历</th>
         <th>入职日期</th>
         <th>工号</th>
         <th>积分</th>
         <th>操作</th>
   </tr>
   <c:forEach var="p" items="${persons1}" varStatus="a" begin="${i}" end="${i+9}">
   <tr class="centtr">
       <td>${p.personnelNo}</td>
       <td>${p.personnelName}</td>
       <td>
       <c:if test="${p.personnelSex eq '10010001' }">女</c:if>
       <c:if test="${p.personnelSex eq '10010002' }">男</c:if>
       </td>
       <td>${p.age}</td>
       <td>${p.identityId}</td>
       <td>${p.phone}</td>
       <td>${p.engageForm}</td>
       <td>
       <c:if test="${p.tipTopDegree eq '10050001' }">小学</c:if>
       <c:if test="${p.tipTopDegree eq '10050002' }">初中</c:if>
       <c:if test="${p.tipTopDegree eq '10050003' }">高中</c:if>
       <c:if test="${p.tipTopDegree eq '10050004' }">大专</c:if>
       <c:if test="${p.tipTopDegree eq '10050005' }">大学本科</c:if>
       <c:if test="${p.tipTopDegree eq '10050006' }">硕士</c:if>
       <c:if test="${p.tipTopDegree eq '10050007' }">博士</c:if>
       </td>
       <td>${fn:substring(p.beginWorkDate,0,19)}</td>
       <td>${p.workId}</td>
       <td>${p.score}</td>
       <td><a href="managementJump.man?method=lookAll&n=${a.index}">查看详情</a></td>
   </tr>
   </c:forEach>
</table>
</c:if>
<form action="mntAll.man?method=turnPage&num=jump" method="post">
		<table>
			<tr>
				<td><div id="pagestyle"></div></td>				
				<td><a href="mntAll.man?method=turnPage&num=first"><img
						src="/personnel/comm/images/comm/main_54.gif" /></a></td>
				<td><a href="mntAll.man?method=turnPage&num=up"><img
						src="/personnel/comm/images/comm/main_56.gif" /></a></td>
				<td><a href="mntAll.man?method=turnPage&num=down"><img
						src="/personnel/comm/images/comm/main_58.gif" /></a></td>
				<td><a href="mntAll.man?method=turnPage&num=last"><img
						src="/personnel/comm/images/comm/main_60.gif" /></a></td>
				<td>转到</td>
				<td><input type="text" name="page" id="page" class="pageinput" /></td>
				<td>页</td>
				<td><input type="submit" value="" id="pagejump"></td>
			</tr>
			<tr align="center">
			  <td><div class="downRight"><a href="#"><font size="2px;" color="#295568;">导出Excel</font></a></div></td>
			</tr>
		</table>
	</form>
</body>
</html>