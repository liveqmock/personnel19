package org.jsoft.person.servlet;


import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.Operater;
import org.jsoft.comm.vo.Personnelappraise;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.person.dao.impl.PersonInfoDAO;
import org.jsoft.person.service.impl.PersonAppraiseService;
import org.jsoft.person.service.impl.PersonInfoService;
import org.jsoft.system.service.IOperateLogService;
import org.jsoft.system.service.IOperaterService;
import org.jsoft.system.service.impl.OperateLogService;
import org.jsoft.system.service.impl.OperaterService;

/**
 * Servlet implementation class PersonAppraiseServlet
 */
public class PersonAppraiseServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private static String departmentName="";
	private static String jobName="";
	private PersonAppraiseService pas=new PersonAppraiseService();
	private Personnelappraise pa=new Personnelappraise();
//	private IOperaterService operaterService = new OperaterService();
//	private IOperateLogService operateLogService = new OperateLogService();
	
	public String findAll(HttpServletRequest req, HttpServletResponse resp) {
//		System.out.println("findAll");
		String state=req.getParameter("state");
		String currentPage=req.getParameter("currentPage");
		PersonInfoService pis=new PersonInfoService();
		if("0".equals(state)){
			int allPage=PersonAppraiseService.getPageDivid().getAllPage();//这里得改，不同方法传的allPage不同
			req.setAttribute("currentPage", currentPage);
			req.setAttribute("allPage", allPage);
			
			List<Personnelappraise> ls = pas.findAll(currentPage);
			req.setAttribute("ls", ls);
			
			List<Personnelinfo> ls1=pis.queryPersonsAll();
			req.setAttribute("ls1", ls1);
//			/*日志*/
//			String info="执行了查找所有考评过人员的操作";
//			operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
//			/*日志*/
			
			System.err.println(ls.size());
			return "jsps/person/personAppraise/personAppraise.jsp";
		}
		
		if("1".equals(state)){
			int allPage=PersonAppraiseService.getPageDivid1().getAllPage();
			req.setAttribute("currentPage", currentPage);
			req.setAttribute("allPage", allPage);
			String tempdepartmentName="";
			try {
				tempdepartmentName = new String(req.getParameter("departmentName").getBytes("ISO-8859-1"),"UTF-8");
				if(!"".equals(tempdepartmentName)){
					departmentName=tempdepartmentName;
				}//这样做是为了让js里getPage函数好使
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			List<Personnelappraise> ls = pas.findByDepartment(departmentName,currentPage);
			req.setAttribute("ls", ls);
			req.setAttribute("departmentName", departmentName);
			List<Personnelinfo> ls1=pis.queryPersonsAll();
			req.setAttribute("ls1", ls1);
			return "jsps/person/personAppraise/personAppraiseByDept.jsp";
		}
		if("2".equals(state)){
			int allPage=PersonAppraiseService.getPageDivid2().getAllPage();
			req.setAttribute("currentPage", currentPage);
			req.setAttribute("allPage", allPage);
			String tempjobName="";
			try {
				tempjobName = new String(req.getParameter("jobName").getBytes("ISO-8859-1"),"UTF-8");
				if(!"".equals(tempjobName)){
					jobName=tempjobName;
				}//这样做是为了让js里getPage函数好使
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			List<Personnelappraise> ls = pas.findByJob(jobName,currentPage);
			req.setAttribute("ls", ls);
			req.setAttribute("jobName", jobName);
			List<Personnelinfo> ls1=pis.queryPersonsAll();
			req.setAttribute("ls1", ls1);
			return "jsps/person/personAppraise/personAppraiseByJob.jsp";
		}
		return "";
		
	}

	public String save(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("Servlet save");
		String personnelNo = req.getParameter("input1");
		String personnelAppraiseContent = req.getParameter("input2");
		String ptdTemp = req.getParameter("input3");
		String personnelAppraiseResult = req.getParameter("input4");
		String personnelAppraiseRemark = req.getParameter("input5");
//		System.out.println(personnelNo);
//		System.out.println(personnelAppraiseContent);
//		System.out.println(ptdTemp);
//		System.out.println(personnelAppraiseResult);
//		System.out.println(personnelAppraiseRemark);
		PersonInfoDAO piDAO = new PersonInfoDAO();
		Personnelinfo pi = piDAO.queryNo(personnelNo);
		String personnelId = pi.getPersonnelId();
//		System.out.println(personnelId);
		pas.add(personnelId, personnelAppraiseContent, ptdTemp,personnelAppraiseResult,
				personnelAppraiseRemark);
//		/*日志*/
//		String info="执行了对员工考评表增加编号为"+personnelNo+"考评人的操作";
//		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
//		/*日志*/
		return redirPath + "personAppraise.per?method=findAll&state=0&currentPage=1";
	}

	public String update(HttpServletRequest req, HttpServletResponse resp) {
		String state = req.getParameter("state");
		String personnelAppraiseId = req.getParameter("personnelAppraiseId");
		String personnelName = req.getParameter("personnelName");
		String personnelAppraiseContent = req.getParameter("personnelAppraiseContent");
		String ptdTemp = req.getParameter("personnelAppraiseDate");
		String personnelAppraiseResult=req.getParameter("personnelAppraiseResult");
		String personnelAppraiseRemark = req.getParameter("personnelAppraiseRemark");
		
		if ("0".equals(state)) {
			String personnelNo = req.getParameter("personnelNo");
//			System.out.println(personnelNo);
			pas.update(personnelAppraiseId, personnelAppraiseContent, ptdTemp,personnelAppraiseResult,
					personnelAppraiseRemark,0);
//			System.out.println("Servlet里update执行完了");
//			/*日志*/
//			String info="执行了对员工考评表修改考评人："+personnelName+"的操作";
//			operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
//			/*日志*/
		}else{
			pas.update(personnelAppraiseId, personnelAppraiseContent, ptdTemp,personnelAppraiseResult, personnelAppraiseRemark, 1);
//			/*日志*/
//			String info="执行了对员工考评表删除考评人："+personnelName+"的操作";
//			operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
//			/*日志*/
		}
		
		return redirPath + "personAppraise.per?method=findAll&state=0&currentPage=1";// Servlet互相跳
	}

	public String findSingle(HttpServletRequest req, HttpServletResponse resp) {
		String personnelAppraiseId = req.getParameter("personnelAppraiseId");
		String personnelName=req.getParameter("personnelName");
		String personnelAppraiseContent = req.getParameter("personnelAppraiseContent");
		String ptdTemp = req.getParameter("personnelAppraiseDate");
		String personnelAppraiseResult=req.getParameter("personnelAppraiseResult");
		String personnelAppraiseRemark = req.getParameter("personnelAppraiseRemark");
		String state = req.getParameter("state");
//		System.out.println(personnelAppraiseId);
		pa = pas.findSingle(personnelAppraiseId);

		req.setAttribute("pa", pa);
		if ("0".equals(state)) {//调用修改
//			/*日志*/
//			String info="执行了对员工考评表查找并即将修改考评人："+personnelName+"的操作";
//			operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
//			/*日志*/
			return "jsps/person/personAppraise/rePersonAppraise.jsp";
		} else {//调用删除
//			/*日志*/
//			String info="执行了对员工考评表查找并即将删除考评人："+personnelName+"的操作";
//			operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
//			/*日志*/
			return redirPath + "personAppraise.per?method=update&state=1&personnelAppraiseId="+personnelAppraiseId+"&personnelName="+personnelName+"&personnelAppraiseContent="+personnelAppraiseContent+"&personnelAppraiseDate="+ptdTemp+"&personnelAppraiseResult="+personnelAppraiseResult+"&personnelAppraiseRemark="+personnelAppraiseRemark+"";
		}
	}
	
//	public String readExcle(HttpServletRequest req, HttpServletResponse resp){
//		String path=req.getParameter("");
//		String tableName=req.getParameter("");
//		pas.readExcle();
//		
//		return "";
//	}
	


}
