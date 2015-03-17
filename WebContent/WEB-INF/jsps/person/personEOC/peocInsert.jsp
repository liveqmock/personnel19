<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript"
	src="comm/js/person/personEOC/peocInsert.js"></script>
<link type="text/css"
	href="comm/css/person/personEOC/peocInsert.css" rel="stylesheet" />

<script language="javascript" type="text/javascript" src="comm/calenderController/My97DatePicker/WdatePicker.js"></script>
<link rel="text/javascript">

<title>人事管理-员工奖惩新增界面</title>
</head>
<body>

	<div id="peocInsertContainer">

		<div id="peocInsertTitle">
			<div id=titleText>人事管理&nbsp;&nbsp;&nbsp;员工奖惩新增：</div>
		</div>

		<div id="peocInsertMain">

			<form id="form1" action="personEOC.per?method=insertPeocSubmit" method="post">
			    
			    <table>
  
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 请选择员工</div>
			            </td>
			            <td class="tdRight">
			                <select name="personnelId">
			                    <c:forEach var="p" items="${requestScope.persons }">
			                        <option value="${p.personnelId }">${p.personnelNo}&nbsp;&nbsp;${p.personnelName }</option>
			                    </c:forEach>
			                </select>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 奖惩日期</div>
			            </td>
			            <td class="tdRight">
			                 <input name="asdasd"  type="text" value="自动添加当前系统日期  "  readonly="readonly"></input>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 奖惩原因</div>
			            </td>
			            <td class="tdRight">
			                <input name="peocReason"  type="text" onblur="peocReasonCheck();"></input>
			                <span id="alertInfo2" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 奖惩选项</div>
			            </td>
			            <td class="tdRight">
			                <select name="encOrChastId">
								<c:forEach var="e" items="${requestScope.eocs }">
			                        <option value="${e.encOrChastId }">${e.personnelEncOrChastSort }&nbsp;${e.personnelEncOrChastPoint }分&nbsp;${e.money }元</option>
			                    </c:forEach>
						    </select>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">奖惩备注</div>
			            </td>
			            <td class="tdRight">
			                <input name="peocRemark"   type="text" onblur="peocRemarkCheck"></input>
			                <span id="alertInfo3" class="alertInfo" ></span>
			            </td>
			        </tr>
			        

			        <tr>
			            <td class="tdLeft">
			            </td>
			            <td class="tdRight">
			                <input class="submitButton" type="button" value="确认添加" onclick="submitButton();" />
			            </td>
			        </tr>
			        
			    </table>
 
				
			</form>
		</div>






		<div id="personInfoInsertDown"></div>

	</div>

</body>
</html>