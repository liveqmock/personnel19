<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
	width: 18%;
	background-color: rgb(211, 234, 239);
	text-align: center;
	font-size: 12px;
	background-color: rgb(211, 234, 239);
}

.centtr {
	text-align: center;
	/* 	padding-left: 100px; */
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

a {
	text-decoration: none;
	color: white;
}

tr {
	height: 25px;
}
</style>
</head>
<body>
	<form action="">
		<table class="toptable_style">
			<tr>
				<td width="90%"><img src="/personnel/comm/images/comm/tb.gif" />
					<span class="title_style">操作员</span></td>

				<td><span class="title_style"><a
						href="javascript:history.go(-1);">返回</a></span></td>
			</tr>
		</table>
		<div id="boundary_row"></div>
		<table class="centtable_style" cellspacing="1px">
			<tr>
				<td class="toptr">员工姓名</td>
				<td class="centtr">${operater.personnelinfo.personnelName }</td>
				<td class="toptr">用户名</td>
				<td class="centtr">${operater.opName }</td>
			</tr>
			<tr>
				<td class="toptr">员工编号</td>
				<td class="centtr">${operater.personnelinfo.personnelNo}</td>
				<td class="toptr">员工性别</td>
				<td class="centtr">${operater.personnelinfo.personnelSex }</td>
			</tr>
			<tr>
				<td class="toptr">权限组</td>
				<td class="centtr">${operater.popedom}</td>
				<td class="toptr">员工出生日期</td>
				<td class="centtr">${operater.personnelinfo.birthday }</td>
			</tr>
			<tr>
				<td class="toptr">年龄</td>
				<td class="centtr">${operater.personnelinfo.age }</td>
				<td class="toptr">身份证号</td>
				<td class="centtr">${operater.personnelinfo.identityId }</td>
			</tr>
			<tr>
				<td class="toptr">婚姻状况</td>
				<td class="centtr">${operater.personnelinfo.wedLock }</td>
				<td class="toptr">民族</td>
				<td class="centtr">${operater.personnelinfo.race }</td>
			</tr>
			<tr>
				<td class="toptr">籍贯</td>
				<td class="centtr">${operater.personnelinfo.nativePlace }</td>
				<td class="toptr">政治面貌</td>
				<td class="centtr">${operater.personnelinfo.politic }</td>
			</tr>
			<tr>
				<td class="toptr">邮箱</td>
				<td class="centtr">${operater.personnelinfo.EMail }</td>
				<td class="toptr">电话</td>
				<td class="centtr">${operater.personnelinfo.phone }</td>
			</tr>
			<tr>
				<td class="toptr">地址</td>
				<td class="centtr">${operater.personnelinfo.address }</td>
				<td class="toptr">聘用形式</td>
				<td class="centtr">${operater.personnelinfo.engageForm }</td>
			</tr>
			<tr>
				<td class="toptr">最高学历</td>
				<td class="centtr">${operater.personnelinfo.tipTopDegree }</td>
				<td class="toptr">所属专业</td>
				<td class="centtr">${operater.personnelinfo.spacialty }</td>
			</tr>
			<tr>
				<td class="toptr">毕业院校</td>
				<td class="centtr">${operater.personnelinfo.school }</td>
				<td class="toptr">入职日期</td>
				<td class="centtr">${operater.personnelinfo.beginWorkDate }</td>
			</tr>
			<tr>
				<td class="toptr">在职状态</td>
				<td class="centtr">${operater.personnelinfo.workState }</td>
				<td class="toptr">工号</td>
				<td class="centtr">${operater.personnelinfo.workId }</td>
			</tr>
			<tr>
				<td class="toptr">合同期限</td>
				<td class="centtr">${operater.personnelinfo.contractTerm }</td>
				<td class="toptr">转正日期</td>
				<td class="centtr">${operater.personnelinfo.beFormDate }</td>
			</tr>
			<tr>
				<td class="toptr">转正日期</td>
				<td class="centtr">${operater.personnelinfo.beFormDate }</td>
				<td class="toptr">离职日期</td>
				<td class="centtr">${operater.personnelinfo.notWorkState }</td>
			</tr>
			<tr>
				<td class="toptr">合同起始日期</td>
				<td class="centtr">${operater.personnelinfo.beginContract }</td>
				<td class="toptr">合同终止日期</td>
				<td class="centtr">${operater.personnelinfo.endContract }</td>
			</tr>
			<tr>
				<td class="toptr">工龄</td>
				<td class="centtr">${operater.personnelinfo.workAge }</td>
				<td class="toptr">员工积分</td>
				<td class="centtr">${operater.personnelinfo.score }</td>
			</tr>
			<tr>
				<td class="toptr">转正日期</td>
				<td class="centtr">${operater.personnelinfo.beFormDate }</td>
				<td class="toptr"></td>
				<td class="centtr"></td>
			</tr>

		</table>
		<!-- <div id="substyle">
			<input type="submit" value="增加">
		</div>
		<div id="substyle">
			<input type="submit" value="修改">
		</div> -->
	</form>

</body>
</html>