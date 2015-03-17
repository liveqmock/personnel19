<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.th{
    height:25px;
	background-color: RGB(173,210,218);
}
.tc{
    height:25px;
	background-color: RGB(255,255,255);
}
.tcl{
    width:100px;
    height:25px;
	background-color: RGB(255,255,255);
}
#aa{
width:200px;
height:30px;
padding-left:500px;
padding-top: 20px;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/personnel/comm/css/system/fatherOperation.css">
<title>Insert title here</title>
</head>
<body>
<div id="top">${FatherName}</div>
<form action="diction.sys" method="post">
<input type="hidden" name="method" value="addSonsInDB"/>
<input type="hidden" name="fatherName" value="${FatherName}"/>
<table cellspacing="1px" >
<tr><td class="tcl"></td><td class="th">名称</td><td class="th">备注</td></tr>
<tr><td class="tcl">子项一</td><td class="tc"><input type="text" name="sn1"/></td><td class="tc"><input type="text" name="sr1"/></td></tr>
<tr><td class="tcl">子项二</td><td class="tc"><input type="text" name="sn2"/></td><td class="tc"><input type="text" name="sr2"/></td></tr>
<tr><td class="tcl">子项三</td><td class="tc"><input type="text" name="sn3"/></td><td class="tc"><input type="text" name="sr3"/></td></tr>
<tr><td class="tcl">子项四</td><td class="tc"><input type="text" name="sn4"/></td><td class="tc"><input type="text" name="sr4"/></td></tr>
<tr><td class="tcl">子项五</td><td class="tc"><input type="text" name="sn5"/></td><td class="tc"><input type="text" name="sr5"/></td></tr>
<tr><td class="tcl">子项六</td><td class="tc"><input type="text" name="sn6"/></td><td class="tc"><input type="text" name="sr6"/></td></tr>
</table>

<div id="aa">
<input type="submit" value="提交"/>
</div>
</form>
</body>
</html>