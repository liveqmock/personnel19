package org.jsoft.person.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.DictionLog;
import org.jsoft.comm.vo.Duty;
import org.jsoft.comm.vo.Job;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.person.service.impl.PersonInfoService;

public class PersonInfoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private PersonInfoService piService = new PersonInfoService();

	public String firstJumpIntoPage(HttpServletRequest req,
			HttpServletResponse resp) {

		System.out.println("firstJumpInto");
		
		List<Personnelinfo> personsTemp = this.piService.queryPersonsAll();
		
		PageDivid pg = new PageDivid();
		pg.setEachPageNum(2);
		pg.setAllPage(personsTemp.size()/pg.getEachPageNum() + personsTemp.size()% pg.getEachPageNum());
		pg.setNum(personsTemp.size());
		
		String pgNum = req.getParameter("pgNum");
		String pgPages = req.getParameter("pgPages");
		String cP = req.getParameter("cP");
		
		if( !(pgNum == null)){
			pg.setNum(Integer.parseInt(pgNum));
		}
		if( !(pgPages == null)){
			pg.setAllPage(Integer.parseInt(pgPages));
		}
		if( ( !(cP == null)  ) && ( !"".equals(cP) )  ){
			pg.setCurrentPage(Integer.parseInt(cP));
		}
		req.setAttribute("pg", pg);
		
		List<Personnelinfo> persons = this.piService.queryPersonsAll(pg);
		req.setAttribute("persons", persons);	
		
		return "jsps/person/personInfo/personInfoQuery.jsp";
	}

	public String updatePersonPage(HttpServletRequest req,
			HttpServletResponse resp) {

		System.out.println("updatePerson");
		String personnelId = req.getParameter("personnelId");

		Personnelinfo person = piService.queryPersonSingle(personnelId);
	
		req.setAttribute("person", person);
		
		List<DictionLog> dictionLogSex = piService.queryDictionInfos("1001");
		List<DictionLog> dictionLogWedLock = piService.queryDictionInfos("1002");
		List<DictionLog> dictionLogPolitic = piService.queryDictionInfos("1003");
		List<DictionLog> dictionLogEngageForm = piService.queryDictionInfos("1004");
		List<DictionLog> dictionLogTipTopDegree = piService.queryDictionInfos("1005");
		List<DictionLog> dictionLogWorkState = piService.queryDictionInfos("1006");
		req.setAttribute("dictionLogSex", dictionLogSex);
		req.setAttribute("dictionLogWedLock", dictionLogWedLock);
		req.setAttribute("dictionLogPolitic", dictionLogPolitic);
		req.setAttribute("dictionLogEngageForm", dictionLogEngageForm);
		req.setAttribute("dictionLogTipTopDegree", dictionLogTipTopDegree);
		req.setAttribute("dictionLogWorkState", dictionLogWorkState);

		return "jsps/person/personInfo/personInfoUpdate.jsp";
	}

	public String updatePersonSubmit(HttpServletRequest req,
			HttpServletResponse resp) {

		System.out.println("updatePersonSubmit");

		String personnelId = req.getParameter("personnelId");

		String personnelNo = req.getParameter("personnelNo");
		String personnelName = req.getParameter("personnelName");
		String personnelSex = req.getParameter("personnelSex");
		String birthday = req.getParameter("birthday");
		String age = req.getParameter("age");
		String identityId = req.getParameter("identityId");
		String wedLock = req.getParameter("wedLock");
		String race = req.getParameter("race");
		String nativePlace = req.getParameter("nativePlace");
		String politic = req.getParameter("politic");
		String EMail = req.getParameter("EMail");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String engageForm = req.getParameter("engageForm");
		String tipTopDegree = req.getParameter("tipTopDegree");
		String spacialty = req.getParameter("spacialty");
		String school = req.getParameter("school");
		String beginWorkDate = req.getParameter("beginWorkDate");
		String workState = req.getParameter("workState");
		String workId = req.getParameter("workId");
		String contractTerm = req.getParameter("contractTerm");
		String beFormDate = req.getParameter("beFormDate");
		String notWorkState = req.getParameter("notWorkState");
		String beginContract = req.getParameter("beginContract");
		String endContract = req.getParameter("endContract");
		String workAge = req.getParameter("workAge");
		String score = req.getParameter("score");

		piService.updatePerson(personnelId, personnelNo, personnelName,
				personnelSex, birthday, age, identityId, wedLock, race,
				nativePlace, politic, EMail, phone, address, engageForm,
				tipTopDegree, spacialty, school, beginWorkDate, workState,
				workId, contractTerm, beFormDate, notWorkState, beginContract,
				endContract, workAge, score);

		// return "jsps/person/personInfo/personInfoUpdate.jsp";
		return redirPath + "personInfo.per?method=firstJumpIntoPage";

	}

	public String deletePerson(HttpServletRequest req, HttpServletResponse resp) {

		System.out.println("deletePerson");
		String personnelId = req.getParameter("personnelId");
		this.piService.deletePerson(personnelId);

		return redirPath + "personInfo.per?method=firstJumpIntoPage";
	}
	
	public String insertPersonPage(HttpServletRequest req,
			HttpServletResponse resp) {

		System.out.println("insertPersonPage");
		
		List<DictionLog> dictionLogSex = piService.queryDictionInfos("1001");
		List<DictionLog> dictionLogWedLock = piService.queryDictionInfos("1002");
		List<DictionLog> dictionLogPolitic = piService.queryDictionInfos("1003");
		List<DictionLog> dictionLogEngageForm = piService.queryDictionInfos("1004");
		List<DictionLog> dictionLogTipTopDegree = piService.queryDictionInfos("1005");
		List<DictionLog> dictionLogWorkState = piService.queryDictionInfos("1006");
		req.setAttribute("dictionLogSex", dictionLogSex);
		req.setAttribute("dictionLogWedLock", dictionLogWedLock);
		req.setAttribute("dictionLogPolitic", dictionLogPolitic);
		req.setAttribute("dictionLogEngageForm", dictionLogEngageForm);
		req.setAttribute("dictionLogTipTopDegree", dictionLogTipTopDegree);
		req.setAttribute("dictionLogWorkState", dictionLogWorkState);
		
		List<Duty> dutys = piService.queryDutysAll();
		System.out.println("asd");
		for(Duty d : dutys){
			System.out.println(d.getDutyName());
		}
		System.out.println("asd");
		List<Department> departments = piService.queryDepartmentsAll();
		List<Job> jobs = piService.queryJobsAll();
		req.setAttribute("dutys", dutys);
		req.setAttribute("departments", departments);
		req.setAttribute("jobs", jobs);
		
		return "jsps/person/personInfo/personInfoInsert.jsp";
	}
	
	public String insertPersonSubmit(HttpServletRequest req,
			HttpServletResponse resp) {

		System.out.println("insertPersonSubmit");

		String personnelNo = req.getParameter("personnelNo");
		String personnelName = req.getParameter("personnelName");
		String personnelSex = req.getParameter("personnelSex");
		
		String jobId = req.getParameter("jobId");
		String dutyId = req.getParameter("dutyId");

		String departmentId = req.getParameter("departmentId");
		
		String birthday = req.getParameter("birthday");
		String age = req.getParameter("age");
		String identityId = req.getParameter("identityId");
		String wedLock = req.getParameter("wedLock");
		String race = req.getParameter("race");
		String nativePlace = req.getParameter("nativePlace");
		String politic = req.getParameter("politic");
		String EMail = req.getParameter("EMail");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String engageForm = req.getParameter("engageForm");
		String tipTopDegree = req.getParameter("tipTopDegree");
		String spacialty = req.getParameter("spacialty");
		String school = req.getParameter("school");
		String beginWorkDate = req.getParameter("beginWorkDate");
		String workState = req.getParameter("workState");
		String workId = req.getParameter("workId");
		String contractTerm = req.getParameter("contractTerm");
		String beFormDate = req.getParameter("beFormDate");
		String notWorkState = "";
		String beginContract = "";
		String endContract = "";
		String workAge = "0";
		String score = "100";

		piService.InsertPerson(jobId, dutyId,  departmentId, personnelNo, personnelName,
				personnelSex, birthday, age, identityId, wedLock, race,
				nativePlace, politic, EMail, phone, address, engageForm,
				tipTopDegree, spacialty, school, beginWorkDate, workState,
				workId, contractTerm, beFormDate, notWorkState, beginContract,
				endContract, workAge, score);

		return redirPath + "personInfo.per?method=firstJumpIntoPage";

	}

}
