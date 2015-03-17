package org.jsoft.person.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.DictionLog;
import org.jsoft.comm.vo.Duty;
import org.jsoft.comm.vo.Encorchast;
import org.jsoft.comm.vo.Job;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Peoc;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.person.service.impl.PersonEOCService;
import org.jsoft.person.service.impl.PersonInfoService;

public class PersonEOCServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private PersonEOCService peocService = new PersonEOCService();

	public String firstJumpIntoPage(HttpServletRequest req,
			HttpServletResponse resp) {

		System.out.println("firstJumpInto");
		
		List<Peoc> peocsTemp = this.peocService.queryPeocsAll();
		
		PageDivid pg = new PageDivid();
		pg.setEachPageNum(10);
		pg.setAllPage(peocsTemp.size()/pg.getEachPageNum() + peocsTemp.size()% pg.getEachPageNum());
		pg.setNum(peocsTemp.size());
		
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
		
		List<Peoc> peocs = this.peocService.queryPeocsAll(pg);
		req.setAttribute("peocs", peocs);
		return "jsps/person/personEOC/peocQuery.jsp";
	}
	
	public String updatePeocPage(HttpServletRequest req,
			HttpServletResponse resp) {

		System.out.println("updatePeocPage");
		String peocId = req.getParameter("peocId");
		Peoc peoc = peocService.queryPeocSingle(peocId);
		req.setAttribute("peoc", peoc);
		req.setAttribute("peocId", peocId);
		
		List<Encorchast> eocs = peocService.queryEncorchastAll();
		req.setAttribute("eocs", eocs);

		return "jsps/person/personEOC/peocUpdate.jsp";
	}
	
	public String updatePeocSubmit (HttpServletRequest req,
			HttpServletResponse resp) {
		System.out.println("updatePeocSubmit");
		
		String peocId = req.getParameter("peocId");
		String personnelNo = req.getParameter("personnelNo");
		String personnelName = req.getParameter("personnelName");
		String peocDate = req.getParameter("peocDate");
		String peocReason = req.getParameter("peocReason");
		String encOrChastId = req.getParameter("encOrChastId");
		String peocRemark = req.getParameter("peocRemark");
		
		this.peocService.updatePeoc(peocRemark , peocId , personnelNo, personnelName, peocDate, peocReason, encOrChastId);
		
		return redirPath + "personEOC.per?method=firstJumpIntoPage";

	}
	
	public String insertPeocPage(HttpServletRequest req,
			HttpServletResponse resp) {

		System.out.println("insertPeocPage");
		
		PersonInfoService piService = new PersonInfoService();
		List<Personnelinfo> persons = piService.queryPersonsAll();
		req.setAttribute("persons", persons);

		List<Encorchast> eocs = peocService.queryEncorchastAll();
		req.setAttribute("eocs", eocs);

		return "jsps/person/personEOC/peocInsert.jsp";
	}
	
	public String insertPeocSubmit(HttpServletRequest req,
			HttpServletResponse resp) {

		System.out.println("insertPeocSubmit");
		
		String personnelId = req.getParameter("personnelId");
		String peocReason = req.getParameter("peocReason");
		String encOrChastId = req.getParameter("encOrChastId");
		String peocRemark = req.getParameter("peocRemark");
		
		this.peocService.insertPeoc(personnelId, peocReason, encOrChastId, peocRemark);

		return redirPath + "personEOC.per?method=firstJumpIntoPage";
	}
	
	public String deletePeoc(HttpServletRequest req,
			HttpServletResponse resp) {

		System.out.println("deletePeoc");
		
		String peocId = req.getParameter("peocId");
		this.peocService.deletePeoc(peocId);
		

		return redirPath + "personEOC.per?method=firstJumpIntoPage";
	}

	

}
