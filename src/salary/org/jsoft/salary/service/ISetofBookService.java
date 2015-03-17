package org.jsoft.salary.service;
import java.util.List;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.PageDivid;
public interface ISetofBookService
{
	public List<DeptJobRel> queryDeptJobwithoutSalary(PageDivid pageDivid);
	public List<DeptJobRel> queryNpage(String page) ;



}
