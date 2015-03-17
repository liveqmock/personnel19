<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- 这里需要jstl.jar和standard.jar -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="/personnel/comm/js/person/personAppraise/rePersonAppraise.js"></script>
<script language="javascript" type="text/javascript"
	src="comm/calenderController/My97DatePicker/WdatePicker.js"></script>
<link rel="text/javascript">
<link type="text/css"
	href="comm/css/person/personAppraise/rePersonAppraise.css"
	rel="stylesheet" />
<title>修改员工考评信息</title>
</head>
<body>
	<div>
		<div id="rePAppraiseTitle">
			<div id=titleText>人事管理&nbsp;&nbsp;&nbsp;修改员工考评信息：</div>
		</div>

		<div id="div0">

			<form id="formid" action="personAppraise.per?method=update&state=0"
				method="post">
				<!-- state=0时是修改，=1时是伪删除 -->

				<div id="div1">
					员工编号：<input type="text" readonly="readonly" name="personnelNo"
						value="${pa.personnelinfo.personnelNo}">
				</div>
				<div id="div2">
					员工姓名：<input type="text" readonly="readonly" name="personnelName"
						value="${pa.personnelinfo.personnelName}">
				</div>
				<div id="div3">
					考核内容：<input type="text" id="personnelAppraiseContent"
						name="personnelAppraiseContent"
						value="${pa.personnelAppraiseContent }"
						onblur="getContent();"><span id="span2"
						style="color: red; font-size: smaller;"></span>
				</div>
				<div id="div4">
					考核时间：<input type="text" id="personnelAppraiseDate"
						name="personnelAppraiseDate"
						value="${fn:substring(pa.personnelAppraiseDate,0,19) }"
						onblur="getDate();" onclick="WdatePicker();"><span
						id="span3" style="color: red; font-size: smaller;"></span>
				</div>
				<div id="div5">
					考核结果：<input type="text" id="personnelAppraiseResult"
						name="personnelAppraiseResult"
						value="${pa.personnelAppraiseResult }" onblur="getResult();"><span
						id="span4" style="color: red; font-size: smaller;"></span>
				</div>
				<div id="div6">
					&nbsp;&nbsp;&nbsp;&nbsp;备注：<input type="text" name="personnelAppraiseRemark"
						value="${pa.personnelAppraiseRemark }">
				</div>


				<input type="hidden" readonly="readonly" name="personnelAppraiseId"
					value="${pa.personnelAppraiseId}">
				<!-- 页面不显示，但是能传值 -->
				<div id="div7"><input type="button" value="保存" onclick="submitForm();"></div>
			</form>
		</div>
	</div>
</body>
</html>