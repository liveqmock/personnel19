<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- 这里需要jstl.jar和standard.jar -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="/personnel/comm/js/person/personTrain/rePersonTrain.js"></script>
<script language="javascript" type="text/javascript"
	src="comm/calenderController/My97DatePicker/WdatePicker.js"></script>
<link rel="text/javascript">
<link type="text/css"
	href="comm/css/person/personTrain/rePersonTrain.css" rel="stylesheet" />
<title>修改员工培训信息</title>
</head>
<body>
	<div>
		<div id="rePTrainTitle">
			<div id=titleText>人事管理&nbsp;&nbsp;&nbsp;修改员工培训信息：</div>
		</div>
		<div id="div0">
			<form id="formid" action="personTrain.per?method=update&state=0"
				method="post">
				<!-- state=0时是修改，=1时是伪删除 -->

				<div id="div1">
					员工编号：<input type="text" readonly="readonly" name="personnelNo"
						value="${pt.personnelinfo.personnelNo}">
				</div>
				<div id="div2">
					员工姓名：<input type="text" readonly="readonly" name="personnelName"
						value="${pt.personnelinfo.personnelName}">
				</div>
				<div id="div3">
					培训内容：<input type="text" id="personnelTrainConten"
						name="personnelTrainConten" value="${pt.personnelTrainConten }"
						onblur="getConten();"><span id="span2"
						style="color: red; font-size: smaller;"></span>
				</div>
				<div id="div4">
					培训时间：<input type="text" id="personnelTrainDate"
						name="personnelTrainDate"
						value="${fn:substring(pt.personnelTrainDate,0,19) }"
						onblur="getDate();" onclick="WdatePicker();"><span
						id="span3" style="color: red; font-size: smaller;"></span>
				</div>
				<div id="div5">
					&nbsp;&nbsp;&nbsp;&nbsp;备注：<input type="text" name="personnelTrainRemark"
						value="${pt.personnelTrainRemark }">
				</div>
				<input type="hidden" readonly="readonly" name="personnelTrainId"
					value="${pt.personnelTrainId}">
				<!-- 页面不显示，但是能传值 -->
				<div id="div6"><input type="button" value="保存" onclick="submitForm();"></div>
			</form>
		</div>
	</div>
</body>
</html>