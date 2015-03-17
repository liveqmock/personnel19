<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript"
	src="comm/js/person/personEOC/peocUpdate.js"></script>
<link type="text/css"
	href="comm/css/person/personEOC/peocUpdate.css" rel="stylesheet" />

<script language="javascript" type="text/javascript" src="comm/calenderController/My97DatePicker/WdatePicker.js"></script>
<link rel="text/javascript">

<title>人事管理-员工奖惩修改界面</title>
</head>
<body>

	<div id="peocUpdateContainer">
    
		<div id="peocUpdateTitle">
			<div id=titleText>人事管理&nbsp;&nbsp;&nbsp;员工奖惩修改：</div>
		</div>

		<div id="peocUpdateMain">

			<form id="form1" action="personEOC.per?method=updatePeocSubmit" method="post">
			
			<input name="peocId" type="hidden" value="${requestScope.peocId}" />
	
			    <table>
  
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 员工编号</div>
			            </td>
			            <td class="tdRight">
			                <input name="personnelNo" type="text" value="${requestScope.peoc.personnelinfo.personnelNo}" readonly="readonly"/>
			            </td>
			        </tr>
			    
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 员工姓名</div>
			            </td>
			            <td class="tdRight">
			                <input name="personnelName" type="text" value="${requestScope.peoc.personnelinfo.personnelName}" readonly="readonly"/>
			            </td>
			        </tr>
			        


			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 奖惩日期</div>
			            </td>
			            <td class="tdRight">
			                <input name="peocDate" value="${fn:substring(requestScope.peoc.peocDate, 0,19)}" type="text" onClick="WdatePicker()" onblur="peocDateCheck();"></input>
			                <span id="alertInfo1" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 奖惩原因</div>
			            </td>
			            <td class="tdRight">
			                <input name="peocReason" value="${requestScope.peoc.peocReason}" type="text" onblur="peocReasonCheck();"></input>
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
			                <input name="peocRemark" value="${requestScope.peoc.personnelTrainRemark}" type="text" onblur="peocRemarkCheck();"></input>
			                <span id="alertInfo3" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        
			        
			        <tr>
			            <td class="tdLeft">
			            </td>
			            <td class="tdRight">
			                <input class="submitButton" type="button" value="确认修改" onclick="submitButton();" />
			            </td>
			        </tr>
			        
			    </table>
 
				
			</form>

		</div>






		<div id="peocUpdateDown"></div>

	</div>

</body>
</html>