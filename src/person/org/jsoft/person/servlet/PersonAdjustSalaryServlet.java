package org.jsoft.person.servlet;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.Operater;
import org.jsoft.comm.vo.Salary;
import org.jsoft.person.dao.IPersonAdjustSalaryDAO;
import org.jsoft.person.dao.impl.PersonAdjustSalaryDAO;
import org.jsoft.person.service.IPersonAdjustSalaryService;
import org.jsoft.person.service.impl.PersonAdjustSalaryService;
import org.jsoft.system.service.IOperateLogService;
import org.jsoft.system.service.IOperaterService;
import org.jsoft.system.service.impl.OperateLogService;
import org.jsoft.system.service.impl.OperaterService;

/**
 * Servlet implementation class PersonAdjustSalaryServlet
 */
public class PersonAdjustSalaryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private IOperaterService operaterService = new OperaterService();
	private IOperateLogService operateLogService = new OperateLogService();
	public String showSalary(HttpServletRequest request,HttpServletResponse response){
		IPersonAdjustSalaryService personAdjustSalary=new PersonAdjustSalaryService();
		String personnelId=(String)request.getSession().getAttribute("personnelid");
		List<Salary> salaryList = personAdjustSalary.showSalaryByPersonnelId(personnelId);
		String salaryId=salaryList.get(0).getSalaryId();
		request.getSession().setAttribute("salaryId", salaryId);
		request.getSession().setAttribute("salaryList", salaryList);
		return "jsps/person/personAdjustSalary/personAdjustSalary.jsp";
	}
	
	public String save(HttpServletRequest request,HttpServletResponse response){
		String salaryId=(String) request.getSession().getAttribute("salaryId");
		Double bonus=Double.parseDouble(request.getParameter("bonus"));
		Double lunchSalary=Double.parseDouble(request.getParameter("lunchSalary"));
		Double trafficSalary=Double.parseDouble(request.getParameter("trafficSalary"));
		Double basicSalary=Double.parseDouble(request.getParameter("basicSalary"));
		Double allSalary=Double.parseDouble(request.getParameter("allSalary"));
		String personAdjustSalaryReason=request.getParameter("personAdjustSalaryReason");
		String personnelAdjustSalaryRemark=request.getParameter("personnelAdjustSalaryRemark");
		IPersonAdjustSalaryDAO<DeptJobRel> personAdjustSalaryDAO=new PersonAdjustSalaryDAO<DeptJobRel>();
		String personnelId=(String)request.getSession().getAttribute("personnelid");
		DeptJobRel deptJobRel=personAdjustSalaryDAO.getDeptJobRelByPersonnelId("personnelid1");
		IPersonAdjustSalaryService personAdjustSalaryService=new PersonAdjustSalaryService();
		personAdjustSalaryService.updateSalary(salaryId, bonus, lunchSalary, trafficSalary, basicSalary, allSalary);
		personAdjustSalaryService.addPersonneladjustsalary(personAdjustSalaryReason, personnelAdjustSalaryRemark, deptJobRel);
		/*日志*/
		String info="修改了员工id为"+personnelId+"的薪水";
		operateLogService.add(operaterService.getById(((Operater)request.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return redirPath+"personAdjustSalary.per?method=showSalary";
	}

}
