package org.jsoft.management.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.Operater;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.management.service.impl.PersonnelManagementService;
import org.jsoft.management.util.PersonnelCommMethod;
import org.jsoft.system.service.IOperateLogService;
import org.jsoft.system.service.IOperaterService;
import org.jsoft.system.service.impl.OperateLogService;
import org.jsoft.system.service.impl.OperaterService;

/**
 * Servlet implementation class PersonnelManagementServlet
 */
public class PersonnelManagementServlet extends BaseServlet {
	private IOperaterService operaterService = new OperaterService();
	private IOperateLogService operateLogService = new OperateLogService();
	/*public String findAllInfo(HttpServletRequest req,HttpServletResponse resp)
	{
		
		return "jsps/management/PersonnelManagement/Result.jsp";
	}*/
	public String  findAll(HttpServletRequest req,HttpServletResponse resp)
	{
	
		PersonnelCommMethod pcm=new PersonnelCommMethod();
		PersonnelManagementService pms=new PersonnelManagementService();
		String username=(String) pcm.getParams(req, "username");
		String sex=(String) pcm.getParams(req,"sex");
		String  salaryLow=  (String) pcm.getParams(req,"salaryLow");
		String  salaryUp=  (String) pcm.getParams(req,"salaryUp");
		String job=(String) pcm.getParams(req,"job");
		String department=(String) pcm.getParams(req,"department");
		String all=(String)pcm.getParams(req, "all");
				
		Map Params=new HashMap();
		pcm.addIntoMap(username, "username", Params);
		pcm.addIntoMap(sex, "sex",Params);
		pcm.addIntoMap(salaryLow, "salaryLow", Params);
		pcm.addIntoMap(salaryUp, "salaryUp", Params);
		pcm.addIntoMap(job, "job", Params);
		pcm.addIntoMap(department, "department", Params);
	    pcm.addIntoMap(all, "all", Params);
	    List result=new ArrayList();
	    if(Params.size()==0)
	    {
	    	String all1= "all";
	    	 pcm.addIntoMap(all1, "all", Params);
	    }
		result=pms.findAllByParaments(Params, req);
		req.setAttribute("result", result);
	
		/*日志*/
		String info="根据条件查看符合条件的人事信息";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return "jsps/management/PersonnelManagement/Result.jsp";
	}
 
  
	public String findPerPages(HttpServletRequest req,HttpServletResponse resp)
	{
		PersonnelCommMethod pcm=new PersonnelCommMethod();
		PersonnelManagementService pms=new PersonnelManagementService();
		String c=(String) pcm.getParams(req, "cP");
			int cp=Integer.parseInt(c); 
		PageDivid pg=new PageDivid();
	    pg.setCurrentPage(cp);
	    pg.setAllPage(Integer.parseInt((String) req.getParameter("pgPages")));
	    pg.setNum(Integer.parseInt((String) req.getParameter("pgNum")));
	    List result=pms.findPerPage(req.getParameter("allHql"), pg);
	    req.setAttribute("pg", pg);
		req.setAttribute("result", result);
		req.setAttribute("allHql", req.getParameter("allHql"));
		/*日志*/
		String info="分页查询人事信息";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return "jsps/management/PersonnelManagement/Result.jsp";		
	}
	public String findPersonAllInfo(HttpServletRequest req,HttpServletResponse resp)
	{
		PersonnelCommMethod pcm=new PersonnelCommMethod();
		PersonnelManagementService pms=new PersonnelManagementService();
		String personId=req.getParameter("personId");
	    Personnelinfo p=new Personnelinfo();
		if(!"".equals(personId))
		{
			
			p=pms.findPersonAllInfo(personId);
		}
		System.out.println(p.getPersonnelName());
	
		req.setAttribute("person", p);
		/*日志*/
		String info="查询一个人的具体人事信息";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return "jsps/management/PersonnelManagement/PersonInfo.jsp";
	}

}
