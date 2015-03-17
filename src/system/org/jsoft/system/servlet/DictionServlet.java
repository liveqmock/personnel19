package org.jsoft.system.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.DictionLog;
import org.jsoft.comm.vo.Operater;
import org.jsoft.system.dao.impl.DictionDAO;
import org.jsoft.system.service.IOperateLogService;
import org.jsoft.system.service.IOperaterService;
import org.jsoft.system.service.impl.DictionService;
import org.jsoft.system.service.impl.OperateLogService;
import org.jsoft.system.service.impl.OperaterService;


public class DictionServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private IOperaterService operaterService = new OperaterService();
	private IOperateLogService operateLogService = new OperateLogService();
 
    public DictionServlet() {
        super();
       
    }

	
	public String dictionMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DictionService ds=new DictionService();
		List<DictionLog> fathers=new ArrayList<DictionLog>();
    	List<DictionLog> sons=new ArrayList<DictionLog>(); 
		fathers=ds.getAllFathers();
		sons=ds.getAllSons();
		request.setAttribute("fathers", fathers); //fathers是list
		request.setAttribute("sons", sons);     //sons是list
		/*日志*/
		String info="查询了所有父项和子项";
		operateLogService.add(operaterService.getById(((Operater)request.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/

		return "jsps/system/diction/diction.jsp";
	}

	
	public String operateFather(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          
	    String operation=request.getParameter("operation");
    	if("update".equals(operation)){
    		String sid=request.getParameter("sid");
    		DictionService ds=new DictionService();	
        	DictionLog dl=new DictionLog();
        	dl=ds.getOneItem(sid);
        	request.setAttribute("dl", dl);
        	
    	}
    	request.setAttribute("operation", operation);
		return "jsps/system/diction/fatherOperation.jsp";
	}
	
public String addOrUpdateAFather(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String operation=request.getParameter("operation");
	DictionService ds=new DictionService();	
	String name=request.getParameter("name");
	String remark=request.getParameter("remark");
	if("update".equals(operation)){
		String sid=request.getParameter("sid");
		ds.updateAFather(sid,name,remark);
		/*日志*/
		String info="更新了一个父项内容";
		operateLogService.add(operaterService.getById(((Operater)request.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return "jsps/system/diction/prompt2.jsp";
	}else{
		DictionLog dl=new DictionLog();
		dl.setName(name);
		dl.setDictionLogRemark(remark);
		ds.addAFather(dl);
		/*日志*/
		String info="增加了一个父项";
		operateLogService.add(operaterService.getById(((Operater)request.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		
	}
		request.setAttribute("fatherName", name);
		return "jsps/system/diction/prompt.jsp";
	}

public String addSons(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String FatherName=request.getParameter("fatherName");
	String fatherId=request.getParameter("fatherSid");
	DictionService ds=new DictionService();	
	if(fatherId==null){
		request.setAttribute("FatherName", FatherName);
	}else{
		DictionLog dl=new DictionLog();
		dl=ds.getOneItem(fatherId);
		request.setAttribute("FatherName", dl.getName());
		
	}
	return "jsps/system/diction/addSons.jsp";
	
}
public String addSonsInDB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String fatherName=request.getParameter("fatherName");
	DictionService ds=new DictionService();	
	System.out.println("????????"+fatherName);
	List<DictionLog> sons=new ArrayList<DictionLog>();
	String sn1=request.getParameter("sn1");
	String sr1=request.getParameter("sr1");
	DictionLog s1=new DictionLog();
	s1.setName(sn1);
	s1.setDictionLogRemark(sr1);
	sons.add(s1);
	String sn2=request.getParameter("sn2");
	String sr2=request.getParameter("sr2");
	DictionLog s2=new DictionLog();
	s2.setName(sn2);
	s2.setDictionLogRemark(sr2);
	sons.add(s2);
	String sn3=request.getParameter("sn3");
	String sr3=request.getParameter("sr3");
	DictionLog s3=new DictionLog();
	s3.setName(sn3);
	s3.setDictionLogRemark(sr3);
	sons.add(s3);
	String sn4=request.getParameter("sn4");
	String sr4=request.getParameter("sr4");
	DictionLog s4=new DictionLog();
	s4.setName(sn4);
	s4.setDictionLogRemark(sr4);
	sons.add(s4);
	String sn5=request.getParameter("sn5");
	String sr5=request.getParameter("sr5");
	DictionLog s5=new DictionLog();
	s5.setName(sn5);
	s5.setDictionLogRemark(sr5);
	sons.add(s5);
	String sn6=request.getParameter("sn6");
	String sr6=request.getParameter("sr6");
	DictionLog s6=new DictionLog();
	s6.setName(sn6);
	s6.setDictionLogRemark(sr6);
	sons.add(s6);
	ds.addsons(sons,fatherName);
	/*日志*/
	String info="为相应父项增加了若干子项";
	operateLogService.add(operaterService.getById(((Operater)request.getSession().getAttribute("operater")).getOpId()), info);
	/*日志*/
	return "jsps/system/diction/prompt2.jsp";
}
public String fatherDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String sid=request.getParameter("sid");
	DictionService ds=new DictionService();	
	ds.fatherDelete(sid);
	List<DictionLog> fathers=new ArrayList<DictionLog>();
	List<DictionLog> sons=new ArrayList<DictionLog>();
	fathers=ds.getAllFathers();
	sons=ds.getAllSons();
	request.setAttribute("fathers", fathers); 
	request.setAttribute("sons", sons); 
	/*日志*/
	String info="删除了一个父项";
	operateLogService.add(operaterService.getById(((Operater)request.getSession().getAttribute("operater")).getOpId()), info);
	/*日志*/
	return "jsps/system/diction/diction.jsp";

}
public String delSon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	DictionService ds=new DictionService();	
	String sid=request.getParameter("sid");
	ds.delSon(sid);
	List<DictionLog> fathers=new ArrayList<DictionLog>();
	List<DictionLog> sons=new ArrayList<DictionLog>();
	fathers=ds.getAllFathers();
	sons=ds.getAllSons();
	request.setAttribute("fathers", fathers); 
	request.setAttribute("sons", sons); 
	/*日志*/
	String info="删除了一个子项";
	operateLogService.add(operaterService.getById(((Operater)request.getSession().getAttribute("operater")).getOpId()), info);
	/*日志*/
	return "jsps/system/diction/diction.jsp";
}
public String toModSon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String sid=request.getParameter("sid");
	DictionService ds=new DictionService();	
	DictionLog dl=new DictionLog();
	dl=ds.getOneItem(sid);
	request.setAttribute("son", dl);
	return "jsps/system/diction/modson.jsp";
}
public String modSon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	DictionService ds=new DictionService();	
	DictionLog dl=new DictionLog();
	String name=request.getParameter("name");
	String remark=request.getParameter("remark");
	String sid=request.getParameter("sid");
	ds.modSon(sid,name,remark);
	/*日志*/
	String info="修改了一个子项";
	operateLogService.add(operaterService.getById(((Operater)request.getSession().getAttribute("operater")).getOpId()), info);
	/*日志*/
	return "jsps/system/diction/prompt2.jsp";
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
