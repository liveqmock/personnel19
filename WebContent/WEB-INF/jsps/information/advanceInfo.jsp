<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/personnel/comm/css/information/printInfo.css">
<link rel="stylesheet" href="/personnel/comm/css/information/InfoDetail.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="toptable_style">
		<tr>
			<td><span class="title_style">
			<a href="/personnel/user_info.inf?method=jump"><input type="button"
			value="返回" id="back"> 
			</a></span></td>
		</tr>
		</table>
		<div id="boundary_row"></div>
		<table class="centtable_style" cellspacing="1px">
			<tr>
				<td class="toptr">奖惩资料查询</td>
				<td class="centtr"><A HREF="/personnel/user_info.inf?method=queryEn"><input type="button" value="点击查看奖惩资料" class="redBtn"/></A></td>
			</tr>
			<tr>
				<td class="toptr">培训资料</td>
				<td class="centtr"><A HREF="/personnel/user_info.inf?method=queryTrain"><input type="button" value="点击查看培训资料" class="redBtn"/></A></td>
			</tr>
			<tr>
				<td class="toptr">考评资料</td>
				<td class="centtr"><A HREF="/personnel/user_info.inf?method=queryAppraise"><input type="button" value="点击查看考评资料" class="redBtn"/></A></td>
			</tr>
			<tr>
				<td class="toptr">调薪资料</td>
				<td class="centtr"><A HREF="/personnel/user_info.inf?method=querySalary"><input type="button" value="点击查看调薪资料" class="redBtn"/></A></td>
			</tr>
			<tr>
				<td class="toptr">调动资料</td>
				<td class="centtr"><A HREF="/personnel/user_info.inf?method=queryRemove"><input type="button" value="点击查看调动资料" class="redBtn"/></A></td>
			</tr>
			<tr>
				<td class="toptr">工资信息</td>
				<td class="centtr"><A HREF="/personnel/user_info.inf?method=querySal"><input type="button" value="点击查看工资信息" class="redBtn"/></A></td>
			</tr>
		</table>
</body>

