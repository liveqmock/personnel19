<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.STYLE22 {
	font-size: 12px;
	color: #295568;
}
</style>
<script type="text/javascript">
	function abc() {
		var num = document.getElementById("textfield").value;
		var allpage = ${pageDivid.allPage}
		;
		if (num > allpage) {
			num = allpage;
		}
		if (num < 1) {
			num = 1;
		}
		document.getElementById("tiao").href = "salarymanage.sal?method=queryByCondition&page="
				+ num;

		//控制跳转到多少页
	}
	
	function sum(id){
		
		var s1=document.getElementById("bonus"+id).value;
		var s2=document.getElementById("lunch"+id).value;
		var s3=document.getElementById("traffic"+id).value;
		var s4=document.getElementById("basic"+id).value;
		var a5=Number(s1)+Number(s2)+Number(s3)+Number(s4);
		document.getElementById("all"+id).value=a5;
		
	}

</script>
</head>
<body>
<a href="/personnel/comm/loadexcel/selectCons.jsp?cons=departmentName">导出为excel</a>
	<table>
		<tr>
			<th>部门名称</th>
			<th>职位名称</th>
			<th>奖金</th>
			<th>餐补</th>
			<th>交通补助</th>
			<th>基本工资</th>
			<th>总工资</th>
		</tr>
		<%=request.getRealPath("/")%>
		<%=request.getServletPath()%>
<c:forEach var="list" items="${list }" varStatus="a">
<form action="salarymanage.sal?method=changeSalaryAll&page=${pageDivid.currentPage }" id="act"  method="post">

<tr>
<td>${list.department.departmentName } </td>
<td>${list.job.jobName }</td>
<td><input type="number" value="${list.salary.bonus }" name="bonus" id="bonus${a.count }" onchange="sum(${a.count })"></td>
<td><input type="number" value="${list.salary.lunchSalary }" name="lunchSalary" id="lunch${a.count }" onchange="sum(${a.count })"></td>
<td><input type="number" value="${list.salary.trafficSalary }" name="trafficSalary" id="traffic${a.count }" onchange="sum(${a.count })"></td>
<td><input type="number" value="${list.salary.basicSalary }" name="basicSalary" id="basic${a.count }" onchange="sum(${a.count })"></td>
<td><input type="text" value="${list.salary.allSalary }" name="allSalary" readonly="readonly" id="all${a.count }"></td>
<td><input type="submit" value="修改"></td>
<td><input type="hidden" name="deptjobid" value="${list.deptJobRelId}" ></td>

<td><input type="hidden" name="id" value="${list.salary.salaryId }"></td>
</tr>

</form>
</c:forEach>







	</table>



	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="33%"><div align="left">
					<span class="STYLE22">&nbsp;&nbsp;共有<strong>
							${pageDivid.num }</strong> 条记录，当前第<strong>
							${pageDivid.currentPage }</strong> 页，共 <strong>${pageDivid.allPage
							}</strong> 页</span>
				</div>
			</td>
			<td width="67%"><table width="312" border="0" align="right"
					cellpadding="0" cellspacing="0">
					<tr>

						<c:if test="${pageDivid.currentPage==1 }">
							<td width="49"><div align="center">
									<img src="/personnel/comm/images/comm/main_54.gif" width="40"
										height="15" />
								</div>
							</td>
							<td width="49"><div align="center">
									<img src="/personnel/comm/images/comm/main_56.gif" width="45"
										height="15" />
								</div>
							</td>
						</c:if>
						<c:if test="${pageDivid.currentPage!=1 }">
							<td width="49"><div align="center">
									<a href="salarymanage.sal?method=queryByCondition"><img
										src="/personnel/comm/images/comm/main_54.gif" width="40"
										height="15" /> </a>
								</div>
							</td>
							<td width="49"><div align="center">
									<a
										href="salarymanage.sal?method=queryByCondition&&page=${pageDivid.currentPage-1 }"><img
										src="/personnel/comm/images/comm/main_56.gif" width="45"
										height="15" /> </a>
								</div>
							</td>
						</c:if>

						<c:if test="${pageDivid.currentPage==pageDivid.allPage }">
							<td width="49"><div align="center">
									<img src="/personnel/comm/images/comm/main_58.gif" width="45"
										height="15" />
								</div>
							</td>
							<td width="49"><div align="center">
									<img src="/personnel/comm/images/comm/main_60.gif" width="40"
										height="15" />
								</div>
							</td>
						</c:if>
						<c:if test="${pageDivid.currentPage!=pageDivid.allPage }">
							<td width="49"><div align="center">
									<a
										href="salarymanage.sal?method=queryByCondition&&page=${pageDivid.currentPage+1 }"><img
										src="/personnel/comm/images/comm/main_58.gif" width="45"
										height="15" /> </a>
								</div>
							</td>
							<td width="49"><div align="center">
									<a
										href="salarymanage.sal?method=queryByCondition&&page=${pageDivid.allPage }"><img
										src="/personnel/comm/images/comm/main_60.gif" width="40"
										height="15" /> </a>
								</div>
							</td>
						</c:if>


						<td width="37" class="STYLE22"><div align="center">转到</div></td>
						<td width="22"><div align="center">
								<input type="text" name="textfield" id="textfield"
									style="width: 20px; height: 12px; font-size: 12px; border: solid 1px #7aaebd;"
									onchange="abc()" />
							</div></td>
						<td width="22" class="STYLE22"><div align="center">页</div>
						</td>
						<td width="35"><a
							href="salarymanage.sal?method=queryByCondition&&page=" id="tiao"><img
								src="/personnel/comm/images/comm/main_62.gif" width="26"
								height="15" /> </a>
						</td>

					</tr>
				</table>
</body>
</html>