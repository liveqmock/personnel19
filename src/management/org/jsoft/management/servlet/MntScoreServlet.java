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
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.management.service.impl.MntScoreService;

/**
 * Servlet implementation class ScoreServlet
 */
public class MntScoreServlet extends BaseServlet {
	private MntScoreService gservice=new MntScoreService();
	private List<Personnelinfo> persons=new ArrayList();
	
	public String searchAll(HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("succeed");
		persons=gservice.packAll();
		req.getSession().setAttribute("persons2", persons);
		req.getSession().setAttribute("stateScore", "ok");
		req.getSession().setAttribute("total",persons.size()-1);
		req.getSession().setAttribute("i",0);
		return "jsps/management/mntScore.jsp";
	}
	public String turnPage(HttpServletRequest req,HttpServletResponse resp) {
		String num=req.getParameter("num");
		int total=Integer.parseInt(req.getSession().getAttribute("total").toString());
		int i=Integer.parseInt(req.getSession().getAttribute("i").toString());
		if(num.equals("first"))
			req.getSession().setAttribute("i",0);
		if(num.equals("up")&&i!=0)
			req.getSession().setAttribute("i",i-10);
		if(num.equals("down")&&i!=total/10*10)
			req.getSession().setAttribute("i",i+10);
		if(num.equals("last")){
			int j=total/10;
			req.getSession().setAttribute("i",j*10);
		}	
		if(num.equals("jump")){
			int page=Integer.parseInt(req.getParameter("page"));
			req.getSession().setAttribute("i",(page-1)*10);
		}			
		return "jsps/management/mntScore.jsp";
	}
	public String pickUp(HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("succeed");
		Map<String,String> m1=new HashMap<String,String>();
		Map<String,String> m2=new HashMap<String,String>();
		String pNo=req.getParameter("pNo");
		String pName=req.getParameter("pName");
		String engageForm=req.getParameter("engageForm");
		String beginWorkDate1=req.getParameter("beginWorkDate1");
		String beginWorkDate2=req.getParameter("beginWorkDate2");
		String workState=req.getParameter("workState");
		if(pNo.isEmpty()==false)
			m1.put("personnelId",pNo);
		if(pName.isEmpty()==false)
			m1.put("personnelName",pName);
		if(engageForm.isEmpty()==false)
			m1.put("engageForm",engageForm);
		if(beginWorkDate1.isEmpty()==false)
			m2.put("beginWorkDate1",beginWorkDate1);
		if(beginWorkDate2.isEmpty()==false)
			m2.put("beginWorkDate2",beginWorkDate2);
		if(workState.isEmpty()==false)
			m1.put("workState",workState);
		persons=gservice.packSome(m1,m2);
		req.getSession().setAttribute("persons2", persons);
		req.getSession().setAttribute("stateScore", "ok");
		req.getSession().setAttribute("total",persons.size()-1);
		req.getSession().setAttribute("i",0);
		return "jsps/management/mntScore.jsp";
	}
	
}
