<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript"
	src="comm/js/person/personInfo/personInfoUpdate.js"></script>
<link type="text/css"
	href="comm/css/person/personInfo/personInfoUpdate.css" rel="stylesheet" />

<script language="javascript" type="text/javascript" src="comm/calenderController/My97DatePicker/WdatePicker.js"></script>
<link rel="text/javascript">

<title>人事管理-员工资料修改界面</title>
</head>
<body>

	<div id="personInfoUpdateContainer">

		<div id="personInfoUpdateTitle">
			<div id=titleText>人事管理&nbsp;&nbsp;&nbsp;员工资料修改：</div>
		</div>

		<div id="personInfoUpdateMain">

			<form id="form1" action="personInfo.per?method=updatePersonSubmit" method="post">
			    
			    <input name="personnelId" type="hidden" value="${requestScope.person.personnelId}"/>
			    <input name="deptJobRelId" type="hidden" value="${requestScope.person.deptJobRel.deptJobRelId}"/>
			    <input name="dutyId" type="hidden" value="${requestScope.person.duty.dutyId}"/>
			    
			    <table>
  
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 员工编号</div>
			            </td>
			            <td class="tdRight">
			                <input name="personnelNo" type="text" value="${requestScope.person.personnelNo}" onblur="personnelNoCheck();" />
			                <span id="alertInfo1" class="alertInfo" ></span>
			            </td>
			        </tr>
			    
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 员工姓名</div>
			            </td>
			            <td class="tdRight">
			                <input name="personnelName" type="text" value="${requestScope.person.personnelName}" onblur="personnelNameCheck();" />
			                <span id="alertInfo2" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 性别</div>
			            </td>
			            <td class="tdRight">
			                <select name="personnelSex">
			                    <c:forEach var="d" items="${requestScope.dictionLogSex }">
			                        <option value="${d.sid }">${d.name }</option>
			                    </c:forEach>
						    </select>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 职务（请在员工调动模块中进行修改）</div>
			            </td>
			            <td class="tdRight">
			                 <input name="jobName" type="text" value="${requestScope.person.deptJobRel.job.jobName}"   readonly />
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 职称（请在员工调动模块中进行修改）</div>
			            </td>
			            <td class="tdRight">
			                <input name="dutyName" type="text" value="${requestScope.person.duty.dutyName}"   readonly />
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 所属部门（请在员工调动模块中进行修改）</div>
			            </td>
			            <td class="tdRight">
			                <input name="departmentName" type="text" value="${requestScope.person.deptJobRel.department.departmentName}"   readonly />
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 出生日期</div>
			            </td>
			            <td class="tdRight">
			                <input name="birthday" value="${fn:substring(requestScope.person.birthday, 0,19)}" type="text" onClick="WdatePicker()"  onblur="birthdayCheck();" ></input>
			                <span id="alertInfo3" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 年龄</div>
			            </td>
			            <td class="tdRight">
			                <input name="age" type="text" value="${requestScope.person.age}" onblur="ageCheck();"  />
			                <span id="alertInfo4" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 身份证号</div>
			            </td>
			            <td class="tdRight">
			                <input name="identityId" type="text" value="${requestScope.person.identityId}" onblur="identityIdCheck();" />
			                <span id="alertInfo5" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 婚姻状况</div>
			            </td>
			            <td class="tdRight">
			                <select name="wedLock">
								<c:forEach var="d" items="${requestScope.dictionLogWedLock }">
			                        <option value="${d.sid }">${d.name }</option>
			                    </c:forEach>
						    </select>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">民族</div>
			            </td>
			            <td class="tdRight">
			                <input name="race" type="text" value="${requestScope.person.race}" onblur="raceCheck();" />
			                <span id="alertInfo6" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 籍贯</div>
			            </td>
			            <td class="tdRight">
			                <input name="nativePlace" type="text" value="${requestScope.person.nativePlace}"  onblur="nativePlaceCheck();" />
			                <span id="alertInfo7" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 政治面貌</div>
			            </td>
			            <td class="tdRight">
			                <select name="politic">
								<c:forEach var="d" items="${requestScope.dictionLogPolitic }">
			                        <option value="${d.sid }">${d.name }</option>
			                    </c:forEach>
						    </select>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">Email</div>
			            </td>
			            <td class="tdRight">
			                <input name="EMail" type="text" value="${requestScope.person.EMail}"  onblur="EMailCheck();" />
			                <span id="alertInfo8" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 联系电话</div>
			            </td>
			            <td class="tdRight">
			                <input name="phone" type="text" value="${requestScope.person.phone}"  onblur="phoneCheck();" />
			                <span id="alertInfo9" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 地址</div>
			            </td>
			            <td class="tdRight">
			                <input name="address" type="text" value="${requestScope.person.address}"  onblur="addressCheck();" />
			                <span id="alertInfo10" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 聘用形式</div>
			            </td>
			            <td class="tdRight">
			                <select name="engageForm">
								<c:forEach var="d" items="${requestScope.dictionLogEngageForm }">
			                        <option value="${d.sid }">${d.name }</option>
			                    </c:forEach>
						    </select>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 最高学历</div>
			            </td>
			            <td class="tdRight">
			                <select name="tipTopDegree">
								<c:forEach var="d" items="${requestScope.dictionLogTipTopDegree }">
			                        <option value="${d.sid }">${d.name }</option>
			                    </c:forEach>
						    </select>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">所属专业</div>
			            </td>
			            <td class="tdRight">
			                <input name="spacialty" type="text" value="${requestScope.person.spacialty}" onblur="spacialtyCheck();" />
			                <span id="alertInfo11" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">毕业院校</div>
			            </td>
			            <td class="tdRight">
			                <input name="school" type="text" value="${requestScope.person.school}" onblur="schoolCheck();" />
			                <span id="alertInfo12" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 入职日期</div>
			            </td>
			            <td class="tdRight">
			                <input name="beginWorkDate" value="${fn:substring(requestScope.person.beginWorkDate, 0,19)}" type="text" onClick="WdatePicker()"  onblur="beginWorkDateCheck();" ></input>
			                <span id="alertInfo13" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 在职状态</div>
			            </td>
			            <td class="tdRight">
			                <select name="workState">
								<c:forEach var="d" items="${requestScope.dictionLogWorkState }">
			                        <option value="${d.sid }">${d.name }</option>
			                    </c:forEach>
						    </select>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 工号</div>
			            </td>
			            <td class="tdRight">
			                <input name="workId" type="text" value="${requestScope.person.workId}"  onblur="workIdCheck();"  />
			                <span id="alertInfo14" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 合同期限（年）</div>
			            </td>
			            <td class="tdRight">
			                <input name="contractTerm" type="text" value="${requestScope.person.contractTerm}"  onblur="contractTermCheck();" />
			                <span id="alertInfo15" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 转正日期</div>
			            </td>
			            <td class="tdRight">
			                <input name="beFormDate" value="${fn:substring(requestScope.person.beFormDate, 0,19)}" type="text" onClick="WdatePicker()"  onblur="beFormDateCheck();" ></input>
			                <span id="alertInfo151" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">离职日期</div>
			            </td>
			            <td class="tdRight">
			                <input name="notWorkState" value="${fn:substring(requestScope.person.notWorkState, 0,19)}" type="text" onClick="WdatePicker()"></input>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 合同起始日期</div>
			            </td>
			            <td class="tdRight">
			                <input name="beginContract" value="${fn:substring(requestScope.person.beginContract, 0,19)}" type="text" onClick="WdatePicker()" onblur="beginContractCheck();"></input>
			                <span id="alertInfo16" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">合同终止日期</div>
			            </td>
			            <td class="tdRight">
			               <input name="endContract" value="${fn:substring(requestScope.person.endContract, 0,19)}" type="text" onClick="WdatePicker()"></input>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">工龄（年）</div>
			            </td>
			            <td class="tdRight">
			                <input name="workAge" type="text" value="${requestScope.person.workAge}"/>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">员工积分</div>
			            </td>
			            <td class="tdRight">
			                <input name="score" type="text" value="${requestScope.person.score}"/>
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






		<div id="personInfoUpdateDown"></div>

	</div>

</body>
</html>