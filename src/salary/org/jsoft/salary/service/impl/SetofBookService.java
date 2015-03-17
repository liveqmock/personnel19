package org.jsoft.salary.service.impl;

import java.util.List;

import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.salary.dao.impl.SalaryDAO;
import org.jsoft.salary.dao.impl.SetofBookDAO;
import org.jsoft.salary.service.ISetofBookService;

public class SetofBookService implements ISetofBookService
{

	private SalaryDAO sal =new SalaryDAO();
	@Override
	public List<DeptJobRel> queryDeptJobwithoutSalary(PageDivid pageDivid)
	{
		SetofBookDAO setofbook=new SetofBookDAO();
		return setofbook.queryDeptJobWithoutSalary(pageDivid);
	}
	
	public List<DeptJobRel> queryNpage(String page) {
		// TODO Auto-generated method stub
		PageDivid pageDivid = new PageDivid();
		pageDivid =getPageDivid(page);
		List<DeptJobRel> deptJobRels =queryDeptJobwithoutSalary(pageDivid);
		return deptJobRels;
	}

	public PageDivid getPageDivid(String page) {
		// TODO Auto-generated method stub
		PageDivid pageDivid = new PageDivid();
		int all =  sal.AllCount2();
		pageDivid.setNum(all);
		pageDivid.setAllPage((all-1)/pageDivid.getEachPageNum()+1);
		int currentpage = 1;
		System.err.println(page);
		if(page!=null&&page!=""&&!("null".equals(page))){
			System.err.println(page);
			currentpage=Integer.parseInt(page);
		}
		pageDivid.setCurrentPage(currentpage);
		return pageDivid;
	}

	
//	public static void main(String[] args)
//	{
//		SetofBookService s=new SetofBookService();
//		List<DeptJobRel> list=s.queryDeptJobwithoutSalary();
//		for (DeptJobRel deptJobRel : list)
//		{System.out.println(deptJobRel.getJob().getJobName());
//			
//		}
		
	}


