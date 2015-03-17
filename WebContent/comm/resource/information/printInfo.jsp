<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="/personnel/comm/js/information/personInfo.js"></script>
<link rel="stylesheet" href="/personnel/comm/css/information/printInfo.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<CENTER>
<br>
<br>
请选择您要打印的字段：
<br>
<br>
<DIV>
<FORM action="###">
<table>
		<TR>
			<TD>员工编号</TD><TD> <input type="checkbox"  name="checkbox" value=""/></TD>
			<TD>员工姓名 </TD><TD><input type="checkbox"  name="checkbox" value=""/></TD>
			<TD>性别</TD><TD> <input type="checkbox"  name="checkbox" value=""/></TD>
		</TR>
			
		<TR>	
			<TD>出生日期</TD><TD> <input type="checkbox"  name="checkbox" value=""/></TD>
			<TD>身份证号 </TD><TD><input type="checkbox"  name="checkbox" value=""/></TD>
			<TD>婚姻状况 </TD><TD><input type="checkbox"  name="checkbox" value=""/></TD>
		</TR>
			
		<TR>	
			<TD>名族 </TD><TD><input type="checkbox"  name="checkbox" value=""/></TD>
			<TD>机关 </TD><TD><input type="checkbox"  name="checkbox" value=""/></TD>
			<TD>政治面貌</TD><TD> <input type="checkbox"  name="checkbox" value=""/></TD>
			</TR>
			
			<TR>
			<TD>电子邮箱 </TD><TD><input type="checkbox"  name="checkbox" value=""/></TD>
			<TD>联系电话 </TD><TD><input type="checkbox"  name="checkbox" value=""/></TD>
			<TD>联系地址 </TD><TD><input type="checkbox"  name="checkbox" value=""/></TD>
			</TR>
			
			<TR>
			<TD>部门 </TD><TD><input type="checkbox"  name="checkbox" value=""/></TD>
			<TD>职位</TD><TD> <input type="checkbox"  name="checkbox" value=""/></TD>
			<TD>职称</TD><TD> <input type="checkbox"  name="checkbox" value=""/></TD>
			</TR>
			
			<TR>
			<TD>基本工资</TD><TD> <input type="checkbox"  name="checkbox" value=""/></TD>
			<TD>聘用形式 </TD><TD><input type="checkbox"  name="checkbox" value=""/></TD>
			<TD>最高学历</TD><TD> <input type="checkbox"  name="checkbox" value=""/></TD>
			</TR>
			
			<TR>
			<TD>所属专业 </TD><TD><input type="checkbox"  name="checkbox" value=""/></TD>
			<TD>毕业院校</TD><TD> <input type="checkbox"  name="checkbox" value=""/></TD>
			<TD>入职日期</TD><TD> <input type="checkbox"  name="checkbox" value=""/></TD>
			</TR>
			
			<TR>
			<TD>在职状态 </TD><TD><input type="checkbox"  name="checkbox" value=""/></TD>
			<TD>工号</TD><TD> <input type="checkbox"  name="checkbox" value=""/></TD>
			<TD>合同期限</TD><TD> <input type="checkbox"  name="checkbox" value=""/></TD>
			</TR>
			<TR>
			<TD><input type="submit" value="打印" class="redBtn"/></TD>
			<TD colspan="2"><input type="button" value="全选/全不选" class="redBtn" onclick="selectAll()"/></TD>
			</TR>
</table>
</FORM>
</DIV>	
</CENTER>
</body>
</html>