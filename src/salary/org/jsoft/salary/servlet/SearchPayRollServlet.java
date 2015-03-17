package org.jsoft.salary.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.salary.dao.impl.PersonnelInfoDAO;
import org.jsoft.salary.service.impl.SearchPayRollService;
import org.jsoft.salary.vo.PayRollResult;

public class SearchPayRollServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	public String main(HttpServletRequest req,HttpServletResponse resp){
		String workid=req.getParameter("id");
		PersonnelInfoDAO pd=new PersonnelInfoDAO();
		Personnelinfo person=pd.queryPersonnelInfoFromWorkId(workid);
		req.setAttribute("person", person);	
		if(person!=null){
			SearchPayRollService sprs=new SearchPayRollService();
			List<PayRollResult>payroll=sprs.searchPayRoll(workid);
			req.setAttribute("payroll",payroll);
		}
		System.out.println("Search payroll successfully");
		return "jsps/salary/SearchPayRoll/SearchPayRoll.jsp";
	}
	
	
	public String specific(HttpServletRequest req,HttpServletResponse resp){
		String workid=req.getParameter("workid");
		String year=req.getParameter("year");
		String month=req.getParameter("month");
		PersonnelInfoDAO pd=new PersonnelInfoDAO();
		Personnelinfo person=null;
		if(workid!=null){
			person=pd.queryPersonnelInfoFromWorkId(workid);
		}
		req.setAttribute("person", person);
		if(person!=null){
			SearchPayRollService sprs=new SearchPayRollService();
			List<PayRollResult> lprr=null;
			PayRollResult prr=null;
			if(month==null||month==""){
				lprr=sprs.searchPayRoll(workid, year);
			}else{
				prr=sprs.searchPayRoll(workid, year, month);		
			}
			req.setAttribute("payrolllist",lprr);
			req.setAttribute("payrollone",prr);
		}
		System.out.println("Search specific payroll successfully");
		return "jsps/salary/SearchPayRoll/SearchPayRollSpecific.jsp";
	}
	
	public String detailed(HttpServletRequest req,HttpServletResponse resp){
		String workid=req.getParameter("workid");
		String year=req.getParameter("year");
		String month=req.getParameter("month");
		PersonnelInfoDAO pd=new PersonnelInfoDAO();
		Personnelinfo person=null;
		if(workid!=null){
			person=pd.queryPersonnelInfoFromWorkId(workid);
		}
		req.setAttribute("person", person);
		if(person!=null){
			SearchPayRollService sprs=new SearchPayRollService();
			PayRollResult prr=null;
			prr=sprs.searchPayRoll(workid, year, month);	
			req.setAttribute("payrollone",prr);
		}
		System.out.println("Search detailed payroll successfully");
		return "jsps/salary/SearchPayRoll/SearchPayRollDetailed.jsp";
	}
}
