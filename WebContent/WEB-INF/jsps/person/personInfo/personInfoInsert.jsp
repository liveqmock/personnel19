<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript"
	src="comm/js/person/personInfo/personInfoInsert.js"></script>
<link type="text/css"
	href="comm/css/person/personInfo/personInfoInsert.css" rel="stylesheet" />

<script language="javascript" type="text/javascript" src="comm/calenderController/My97DatePicker/WdatePicker.js"></script>
<link rel="text/javascript">

<title>人事管理-员工资料新增界面</title>
</head>
<body>

	<div id="personInfoInsertContainer">

		<div id="personInfoInsertTitle">
			<div id=titleText>人事管理&nbsp;&nbsp;&nbsp;员工资料新增：</div>
		</div>

		<div id="personInfoInsertMain">

			<form id="form1" action="personInfo.per?method=insertPersonSubmit" method="post">
			    
			    <table>
  
                    <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">测试</div>      
			            </td>
			            <td class="tdRight">
			                <input name="file1" type="file"/>
			                <span id="alertInfo1" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 员工编号</div>      
			            </td>
			            <td class="tdRight">
			                <input name="personnelNo" type="text" onblur="personnelNoCheck();" /> 
			                <span id="alertInfo1" class="alertInfo" ></span>
			            </td>
			        </tr>
			    
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 员工姓名</div>
			            </td>
			            <td class="tdRight">
			                <input name="personnelName" type="text"  onblur="personnelNameCheck();"  />
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
			                <div class="tdLeftText">* 职务</div>
			            </td>
			            <td class="tdRight">
			                 <select name="jobId">
								<c:forEach var="j" items="${requestScope.jobs }">
			                        <option value="${j.jobId }">${j.jobName }</option>
			                    </c:forEach>
						    </select>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 职称</div>
			            </td>
			            <td class="tdRight">
			                <select name="dutyId">
								<c:forEach var="d" items="${requestScope.dutys }">
			                        <option value="${d.dutyId }">${d.dutyName }</option>
			                    </c:forEach>
						    </select>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 所属部门</div>
			            </td>
			            <td class="tdRight">
			                <select name="departmentId">
								<c:forEach var="d" items="${requestScope.departments }">
			                        <option value="${d.departmentId }">${d.departmentName }</option>
			                    </c:forEach>
						    </select>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 出生日期</div>
			            </td>
			            <td class="tdRight">
			                <input name="birthday"  type="text" onClick="WdatePicker()" onblur="birthdayCheck();"></input>
			                <span id="alertInfo3" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 年龄</div>
			            </td>
			            <td class="tdRight">
			                <input name="age" type="text" onblur="ageCheck();" />
			                <span id="alertInfo4" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 身份证号</div>
			            </td>
			            <td class="tdRight">
			                <input name="identityId" type="text" onblur="identityIdCheck();" />
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
			                <input name="race" type="text" onblur="raceCheck();" />
			                <span id="alertInfo6" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 籍贯</div>
			            </td>
			            <td class="tdRight">
			                <input name="nativePlace" type="text" onblur="nativePlaceCheck();"/>
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
			                <input name="EMail" type="text" onblur="EMailCheck();"/>
			                <span id="alertInfo8" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 联系电话</div>
			            </td>
			            <td class="tdRight">
			                <input name="phone" type="text" onblur="phoneCheck();"/>
			                <span id="alertInfo9" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 地址</div>
			            </td>
			            <td class="tdRight">
			                <input name="address" type="text" onblur="addressCheck();"/>
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
			                <input name="spacialty" type="text" onblur="spacialtyCheck();" />
			                <span id="alertInfo11" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">毕业院校</div>
			            </td>
			            <td class="tdRight">
			                <input name="school" type="text" onblur="schoolCheck();"/>
			                <span id="alertInfo12" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 入职日期</div>
			            </td>
			            <td class="tdRight">
			                <input name="beginWorkDate"  type="text" onClick="WdatePicker()" onblur="beginWorkDateCheck();"></input>
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
			                <input name="workId" type="text" onblur="workIdCheck();" />
			                <span id="alertInfo14" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 合同期限（年）</div>
			            </td>
			            <td class="tdRight">
			                <input name="contractTerm" type="text" onblur="contractTermCheck();"/>
			                <span id="alertInfo15" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 转正日期</div>
			            </td>
			            <td class="tdRight">
			                <input name="beFormDate"  type="text" onClick="WdatePicker()" onblur="beFormDateCheck();"></input>
			                <span id="alertInfo151" class="alertInfo" ></span>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">离职日期</div>
			            </td>
			            <td class="tdRight">
			                <input name="notWorkState"  type="text" readonly="readonly" value="此处不可填写"></input>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 合同起始日期</div>
			            </td>
			            <td class="tdRight">
			                <input name="beginContract"  type="text" readonly="readonly" value="初始日期为当前系统日期"></input>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">合同终止日期</div>
			            </td>
			            <td class="tdRight">
			               <input name="endContract" type="text" readonly="readonly" value="此处不可填写"></input>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 工龄（年）</div>
			            </td>
			            <td class="tdRight">
			                <input name="workAge" type="text" readonly="readonly" value="初始工龄默认为0"/>
			            </td>
			        </tr>
			        
			        <tr>
			            <td class="tdLeft">
			                <div class="tdLeftText">* 员工积分</div>
			            </td>
			            <td class="tdRight">
			                <input name="score" type="text" readonly="readonly" value="初始基本默认为100"/>
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