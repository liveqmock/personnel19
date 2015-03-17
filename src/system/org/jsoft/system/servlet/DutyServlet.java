package org.jsoft.system.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;

import org.jsoft.comm.vo.Duty;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.system.service.IDutyService;
import org.jsoft.system.service.impl.DutyService;

public class DutyServlet extends BaseServlet{
	private IDutyService dutyService = new DutyService();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String query(HttpServletRequest req,HttpServletResponse resp) {
		String page = req.getParameter("page");
		List<Duty> dutys = dutyService.queryNpage(page);
		req.setAttribute("dutys", dutys);
		PageDivid pageDivid =dutyService.getPageDivid(page);
		req.setAttribute("pageDivid", pageDivid);
		return "jsps/system/basic/duty/dutyQuery.jsp";
	}
	public String addduty(HttpServletRequest req,HttpServletResponse resp) {
		String dutyName = req.getParameter("dutyName");
		dutyService.add(dutyName);
		return redirPath+"duty.sys?method=query";
	}
	public String jumpAdd(HttpServletRequest req,HttpServletResponse resp) {
		return "jsps/system/basic/duty/addDuty.jsp";
	}
	public String jumpEdit(HttpServletRequest req,HttpServletResponse resp) {
		String[] checkbox =req.getParameterValues("checkbox");
		String dutyId=req.getParameter("dutyId");
		if(checkbox!=null){
			dutyId=checkbox[0];
		}
		Duty duty = dutyService.getduty(dutyId);
		req.setAttribute("duty", duty);
		return "jsps/system/basic/duty/editDuty.jsp";
	}
	public String del(HttpServletRequest req,HttpServletResponse resp) {
		String[] checkbox =req.getParameterValues("checkbox");
		String dutyId=req.getParameter("dutyId");
		System.out.println(checkbox);
		if(checkbox==null){
			dutyService.delLie(dutyId);
		}else{
			dutyService.delLie(checkbox);
		}
		return redirPath+"duty.sys?method=query";
	}
	public String edit(HttpServletRequest req,HttpServletResponse resp) {
		String dutyId=req.getParameter("dutyId");
		String dutyName = req.getParameter("dutyName");
		dutyService.updateDept(dutyId, dutyName);
		return redirPath+"duty.sys?method=query";
	}
	
}
