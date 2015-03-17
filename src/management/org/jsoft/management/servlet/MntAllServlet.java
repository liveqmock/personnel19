package org.jsoft.management.servlet;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.management.service.impl.MntAllService;

public class MntAllServlet extends BaseServlet{
	
	private MntAllService gservice=new MntAllService();
	private List<Personnelinfo> persons=new ArrayList();
	
	public String searchAll(HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("succeed");
		persons=gservice.packAll();
		req.getSession().setAttribute("persons1", persons);
		req.getSession().setAttribute("stateGeneral", "ok");
		req.getSession().setAttribute("total",persons.size()-1);
		req.getSession().setAttribute("i",0);
		return "jsps/management/mntAll.jsp";
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
		return "jsps/management/mntAll.jsp";
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
		req.getSession().setAttribute("persons1", persons);
		req.getSession().setAttribute("stateGeneral", "ok");
		req.getSession().setAttribute("total",persons.size()-1);
		req.getSession().setAttribute("i",0);
		return "jsps/management/mntAll.jsp";
	}
	public String pickUpBackup(HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("succeed");
		Map<String,String> m1=new HashMap<String,String>();
		Map<String,String> m2=new HashMap<String,String>();
		String birthday1=req.getParameter("birthday1");
		String birthday2=req.getParameter("birthday2");
		String pId=req.getParameter("pId");
		String pName=req.getParameter("pName");
		String sex=req.getParameter("sex");
		String pID=req.getParameter("pID");
		String race=req.getParameter("race");
		String nativePlace=req.getParameter("nativePlace");
		String EMail=req.getParameter("EMail");
		String phone=req.getParameter("phone");
		String address=req.getParameter("address");
		String engageForm=req.getParameter("engageForm");
		String tipTopDegree=req.getParameter("tipTopDegree");
		String spacialty=req.getParameter("spacialty");
		String school=req.getParameter("school");
		String beginWorkDate1=req.getParameter("beginWorkDate1");
		String beginWorkDate2=req.getParameter("beginWorkDate2");
		String workId=req.getParameter("workId");
		String beFormDate1=req.getParameter("beFormDate1");
		String beFormDate2=req.getParameter("beFormDate2");
		String workAge=req.getParameter("workAge");
		String score=req.getParameter("score");
		String politic=req.getParameter("politic");
		String wedLock=req.getParameter("wedLock");
		String workState=req.getParameter("workState");
		System.out.println("here it is.");
		if(birthday1.isEmpty()==false)
			m2.put("birthday1", birthday1);
		if(birthday2.isEmpty()==false)
			m2.put("birthday2", birthday2);
		if(pId.isEmpty()==false)
			m1.put("personnelId",pId);
		if(pName.isEmpty()==false)
			m1.put("personnelName",pName);
		if(sex!=null)
			m1.put("personnelSex",sex);
		if(pID.isEmpty()==false)
			m1.put("identityId",pID);
		if(race.isEmpty()==false)
			m1.put("race",race);
		if(nativePlace.isEmpty()==false)
			m1.put("nativePlace",nativePlace);
		if(EMail.isEmpty()==false)
			m1.put("EMail",EMail);
		if(phone.isEmpty()==false)
			m1.put("phone",phone);
		if(address.isEmpty()==false)
			m1.put("address",address);
		if(engageForm.isEmpty()==false)
			m1.put("engageForm",engageForm);
		if(tipTopDegree.isEmpty()==false)
			m1.put("tipTopDegree",tipTopDegree);
		if(spacialty.isEmpty()==false)
			m1.put("spacialty",spacialty);
		if(school.isEmpty()==false)
			m1.put("school",school);
		if(beginWorkDate1.isEmpty()==false)
			m2.put("beginWorkDate1",beginWorkDate1);
		if(beginWorkDate2.isEmpty()==false)
			m2.put("beginWorkDate2",beginWorkDate2);
		if(workId.isEmpty()==false)
			m1.put("workId",workId);
		if(beFormDate1.isEmpty()==false)
			m2.put("beFormDate1",beFormDate1);
		if(beFormDate2.isEmpty()==false)
			m2.put("beFormDate2",beFormDate2);
		if(workAge.isEmpty()==false)
			m1.put("workAge",workAge);
		if(score.isEmpty()==false)
			m1.put("score",score);
		if(politic.isEmpty()==false)
			m1.put("politic",politic);
		if(wedLock.isEmpty()==false)
			m1.put("wedLock",wedLock);
		if(workState.isEmpty()==false)
			m1.put("workState",workState);
		persons=gservice.packSome(m1,m2);
		req.getSession().setAttribute("persons1", persons);
		req.getSession().setAttribute("stateGeneral", "ok");
		return "jsps/management/mntAll.jsp";
	}


}
