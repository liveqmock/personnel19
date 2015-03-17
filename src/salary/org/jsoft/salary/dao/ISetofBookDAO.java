package org.jsoft.salary.dao;
import java.util.List;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.PageDivid;

public interface ISetofBookDAO
{
	public List<DeptJobRel> queryDeptJobWithoutSalary(PageDivid pageDivid);

}
