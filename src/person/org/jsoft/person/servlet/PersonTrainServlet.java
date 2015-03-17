package org.jsoft.person.servlet;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.comm.vo.Personneltrain;
import org.jsoft.comm.vo.Operater;

import org.jsoft.person.dao.impl.PersonInfoDAO;
import org.jsoft.person.service.impl.PersonInfoService;
import org.jsoft.person.service.impl.PersonTrainService;
import org.jsoft.system.service.IOperateLogService;
import org.jsoft.system.service.IOperaterService;
import org.jsoft.system.service.impl.OperateLogService;
import org.jsoft.system.service.impl.OperaterService;

/**
 * Servlet implementation class PersonTrainServlet
 */
public class PersonTrainServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private static String departmentName="";
	private static String jobName="";
	private PersonTrainService pts = new PersonTrainService();
//	private IOperaterService operaterService = new OperaterService();
//	private IOperateLogService operateLogService = new OperateLogService();
	public String findAll(HttpServletRequest req, HttpServletResponse resp) {
		
		String currentPage=req.getParameter("currentPage");
		String state =req.getParameter("state");
		PersonInfoService pis=new PersonInfoService();
		
		if("0".equals(state)){
			int allPage=PersonTrainService.getPageDivid().getAllPage();
			req.setAttribute("currentPage", currentPage);
			req.setAttribute("allPage", allPage);
			List<Personneltrain> ls = pts.findAll(currentPage);
			req.setAttribute("ls", ls);
			List<Personnelinfo> ls1=pis.queryPersonsAll();
			req.setAttribute("ls1", ls1);
//			/*日志*/
//			String info="执行了查找所有培训过人员的操作";
//			operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
//			/*日志*/
			return "jsps/person/personTrain/personTrain.jsp";// 不加jsps/person/这么跳只能跳到WEB-INF中吗？？
		}
		
		if("1".equals(state)){
			int allPage=PersonTrainService.getPageDivid1().getAllPage();
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
			List<Personneltrain> ls = pts.findByDepartment(departmentName,currentPage);
			req.setAttribute("ls", ls);
			req.setAttribute("departmentName", departmentName);
			List<Personnelinfo> ls1=pis.queryPersonsAll();
			req.setAttribute("ls1", ls1);
			return "jsps/person/personTrain/personTrainByDept.jsp";
		}
		if("2".equals(state)){
			int allPage=PersonTrainService.getPageDivid2().getAllPage();
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
			List<Personneltrain> ls = pts.findByJob(jobName,currentPage);
			req.setAttribute("ls", ls);
			req.setAttribute("jobName", jobName);
			List<Personnelinfo> ls1=pis.queryPersonsAll();
			req.setAttribute("ls1", ls1);
			return "jsps/person/personTrain/personTrainByJob.jsp";
		}
		
		
		return "";
	}

	public String save(HttpServletRequest req, HttpServletResponse resp) {
//		System.out.println("Servlet save");
		String personnelNo = req.getParameter("input1");
		String personnelTrainConten = req.getParameter("input2");
		String ptdTemp = req.getParameter("input3");
		String personnelTrainRemark = req.getParameter("input4");
//		System.out.println(personnelNo);
//		System.out.println(personnelTrainConten);
//		System.out.println(ptdTemp);
//		System.out.println(personnelTrainRemark);
		PersonInfoDAO piDAO = new PersonInfoDAO();
		Personnelinfo pi = piDAO.queryNo(personnelNo);
		String personnelId = pi.getPersonnelId();
//		System.out.println(personnelId);
		pts.add(personnelId, personnelTrainConten, ptdTemp,
				personnelTrainRemark);
//		/*日志*/
//		String info="执行了对员工培训表增加编号为"+personnelNo+"培训人的操作";
//		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
//		/*日志*/
		return redirPath + "personTrain.per?method=findAll&state=0&currentPage=1";

	}

	public String update(HttpServletRequest req, HttpServletResponse resp) {

		String state = req.getParameter("state");
		String personnelTrainId = req.getParameter("personnelTrainId");
		String personnelName = req.getParameter("personnelName");
		String personnelTrainConten = req.getParameter("personnelTrainConten");
		String ptdTemp = req.getParameter("personnelTrainDate");
		String personnelTrainRemark = req.getParameter("personnelTrainRemark");
		
		if ("0".equals(state)) {
			String personnelNo = req.getParameter("personnelNo");
//			System.out.println(personnelNo);
			pts.update(personnelTrainId, personnelTrainConten, ptdTemp,
					personnelTrainRemark,0);
			System.out.println("Servlet里update执行完了");
//			/*日志*/
//			String info="执行了对员工培训表修改培训人："+personnelName+"的操作";
//			operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
//			/*日志*/
		}else{
			pts.update(personnelTrainId, personnelTrainConten, ptdTemp, personnelTrainRemark, 1);
//			/*日志*/
//			String info="执行了对员工培训表删除培训人："+personnelName+"的操作";
//			operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
//			/*日志*/
		}
		
		return redirPath + "personTrain.per?method=findAll&state=0&currentPage=1";// Servlet互相跳
	}

	public String findSingle(HttpServletRequest req, HttpServletResponse resp) {
		String personnelTrainId = req.getParameter("personnelTrainId");
		String personnelName=req.getParameter("personnelName");
		String personnelTrainConten = req.getParameter("personnelTrainConten");
		String ptdTemp = req.getParameter("personnelTrainDate");
		String personnelTrainRemark = req.getParameter("personnelTrainRemark");
		String state = req.getParameter("state");
//		System.out.println(personnelTrainId);
		Personneltrain pt = pts.findSingle(personnelTrainId);

		req.setAttribute("pt", pt);
		if ("0".equals(state)) {//调用修改
//			/*日志*/
//			String info="执行了对员工培训表查找并即将修改培训人："+personnelName+"的操作";
//			operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
//			/*日志*/
			return "jsps/person/personTrain/rePersonTrain.jsp";
		} else {//调用删除
//			/*日志*/
//			String info="执行了对员工培训表查找并即将删除培训人："+personnelName+"的操作";
//			operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
//			/*日志*/
			return redirPath + "personTrain.per?method=update&state=1&personnelTrainId="+personnelTrainId+"&personnelName="+personnelName+"&personnelTrainConten="+personnelTrainConten+"&personnelTrainDate="+ptdTemp+"&personnelTrainRemark="+personnelTrainRemark+"";
		}

	}

}
